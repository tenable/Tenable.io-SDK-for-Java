#!/usr/bin/env groovy

@Library('tenable.common@feature/MATT_CHANGES')

def projectProperties = [
  [$class: 'BuildDiscarderProperty',strategy: [$class: 'LogRotator', numToKeepStr: '5']],disableConcurrentBuilds(),
  [$class: 'ParametersDefinitionProperty', parameterDefinitions: [[$class: 'StringParameterDefinition', defaultValue: 'qa-staging', description: '', name: 'CAT_SITE']]]
]

properties(projectProperties)

import com.tenable.jenkins.Slack
import com.tenable.jenkins.common.Common
import com.tenable.jenkins.Constants

Constants global = new Constants()
Common common = new Common()
Slack slack  = new Slack()
def fmt = slack.helper()

try {
    node(global.DOCKERNODE) {
        common.cleanup()

        // Pull the automation framework from develop
        stage('scm auto') {
            dir("automation") {
                git branch: 'develop', changelog: false, credentialsId: 'bitbucket-checkout', poll: false, url: 'ssh://git@stash.corp.tenablesecurity.com:7999/aut/automation-tenableio.git'
           }
        }

        docker.withRegistry(global.AWS_DOCKER_REGISTRY) {
            docker.image('ci-vulnautomation-base:1.0.9').inside("-u root") {
                stage('build auto') {
                    timeout(time: 10, unit: 'MINUTES') {
                        common.prepareGit()

                        sshagent([global.BITBUCKETUSER]) {  
                            sh """
cd automation
python3 autosetup.py catium --all --no-venv 2>&1
export PYTHONHASHSEED=0 
export PYTHONPATH=. 
export CAT_LOG_LEVEL_CONSOLE=INFO
export CAT_SITE=${params.CAT_SITE}

pwd

mkdir ../tenableio-sdk
python3 tenableio/commandline/sdk_test_container.py --create_container --raw

chmod -R 777 ../tenableio-sdk
"""
                            stash includes: '**/tenableio-sdk/tio_config.txt', name: 'Config'
                        }
                    }
                }
            }
        } 

        common.cleanup()
        deleteDir()

        stage('scm java') {
            checkout scm
            unstash 'Config'
        }

        docker.withRegistry(global.AWS_DOCKER_REGISTRY) {
            docker.image('ci-java-base:2.0.18').inside {
                stage('build java') {
                    try {
                        timeout(time: 30, unit: 'MINUTES') {
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

        hipchatSend room: "T.io SDK", message: "Build Successfully: <a href=\"${env.JOB_URL}\">${env.JOB_NAME} ${env.BUILD_NUMBER}</a>", color: "GREEN", token: "584f28c72ae1648f179c4716b37dfd", notify: true
    }
}
catch (exc) {
    echo "caught exception: ${exc}"
    currentBuild.result = 'FAILURE'
    hipchatSend room: "T.io SDK", message: "Build Failed: <a href=\"${env.JOB_URL}\">${env.JOB_NAME} ${env.BUILD_NUMBER}</a>", color: "RED", token: "584f28c72ae1648f179c4716b37dfd", notify: true
}
finally {
    String tests = common.jenkinsTestResults()
    String took  = '\nTook: ' + common.jenkinsDuration()

    currentBuild.result = currentBuild.result ?: 'FAILURE'

    messageAttachment = fmt.getDecoratedFinishMsg(this,
        'Tenable SDK Java build finished with result: ',
        "Built off branch ${env.BRANCH_NAME}" + tests + took)

    messageAttachment.channel = "@rboerger"
    slack.postMessage(this, messageAttachment)
}
