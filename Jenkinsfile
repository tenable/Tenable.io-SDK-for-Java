#!/usr/bin/env groovy

@Library('tenable.common')

def projectProperties = [
    [$class: 'BuildDiscarderProperty',strategy: [$class: 'LogRotator', numToKeepStr: '5']],
    disableConcurrentBuilds(),
    [$class: 'ParametersDefinitionProperty', parameterDefinitions: 
       [[$class: 'StringParameterDefinition', defaultValue: 'qa-milestone', description: '', name: 'CAT_SITE']]]
]

properties(projectProperties)

import com.tenable.jenkins.Slack
import com.tenable.jenkins.common.Common
import com.tenable.jenkins.builds.*
import com.tenable.jenkins.Constants

Common common = new Common(this)
BuildsCommon buildsCommon = new BuildsCommon(this)
Slack slack  = new Slack()
def fmt = slack.helper()
def auser = ''

try {
    node(Constants.DOCKERNODE) {
        buildsCommon.cleanup()

        // Pull the automation framework from develop
        stage('scm auto') {
            dir('automation') {
                git(branch:'develop', changelog:false, credentialsId:'bitbucket-checkout', 
                    poll:false, url:'ssh://git@stash.corp.tenablesecurity.com:7999/aut/automation-tenableio.git')
           }
        }

        docker.withRegistry(Constants.AWS_DOCKER_REGISTRY) {
            docker.image('ci-vulnautomation-base:1.0.9').inside('-u root') {
                stage('build auto') {
                    timeout(time: 10, unit: 'MINUTES') {
                        buildsCommon.prepareGit()

                        sshagent([Constants.BITBUCKETUSER]) {
                            sh """
cd automation
export JENKINS_NODE_COOKIE=
unset JENKINS_NODE_COOKIE

python3 autosetup.py catium --all --no-venv 2>&1

export PYTHONHASHSEED=0
export PYTHONPATH=.
export CAT_LOG_LEVEL_CONSOLE=INFO
export CAT_SITE=${params.CAT_SITE}

pwd

mkdir ../tenableio-sdk
python3 tenableio/commandline/sdk_test_container.py --create_container --raw --agents 5

chmod -R 777 ../tenableio-sdk
"""
                            stash includes: '**/tenableio-sdk/tio_config.txt', name: 'Config'
                        }
                    }
                }
            }
        }

        buildsCommon.cleanup()
        deleteDir()

        stage('scm java') {
            checkout scm
            unstash 'Config'
        }

        docker.withRegistry(Constants.AWS_DOCKER_REGISTRY) {
            docker.image('ci-java-base:2.0.18').inside {
                stage('build java') {
                    try {
                        timeout(time: 120, unit: 'MINUTES') {
                            sh '''
find .
cat ./tenableio-sdk/tio_config.txt | sed 's/^/systemProp./g' > gradle.properties

cat gradle.properties

chmod +x gradlew
./gradlew build
'''
                        }
                    }
                    finally {
                        step([$class: 'JUnitResultArchiver', testResults: 'build/test-results/test/*.xml'])
                    }
                }
            }
        }

        currentBuild.result = currentBuild.result ?: 'SUCCESS'
    }
}
catch (exc) {
    if (currentBuild.result == null || currentBuild.result == 'ABORTED') {
        // Try to detect if the build was aborted
        if (common.wasAborted()) {
            currentBuild.result = 'ABORTED'
            auser = common.getAbortingUsername()

            if (auser) {
               auser = '\nAborted by ' + auser
            }
        }
        else {
            currentBuild.result = 'FAILURE'
        }
    }
    else {
        currentBuild.result = 'FAILURE'
    }
    throw exc
}
finally {
    String tests = common.getTestResults()
    String took  = '\nTook: ' + common.getDuration()

    currentBuild.result = currentBuild.result ?: 'FAILURE'

    messageAttachment = fmt.getDecoratedFinishMsg(this,
        'Tenable SDK Java build finished with result: ',
        "Built off branch ${env.BRANCH_NAME}" + tests + took + auser)

    messageAttachment.channel = '#sdk'
    slack.postMessage(this, messageAttachment)
}
