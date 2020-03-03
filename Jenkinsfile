@Library('tenable.common')
import com.tenable.jenkins.*
import com.tenable.jenkins.builds.*
import com.tenable.jenkins.builds.checkmarx.*
import com.tenable.jenkins.builds.nexusiq.*
import com.tenable.jenkins.builds.onprem.*
import com.tenable.jenkins.common.*
import com.tenable.jenkins.deployments.*
import com.tenable.jenkins.msg.*
import com.tenable.jenkins.slack2.Slack

def projectProperties = [
        [$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '5']],
        disableConcurrentBuilds(),
        disableResume(),
        [$class: 'ParametersDefinitionProperty', parameterDefinitions:
                [[$class: 'StringParameterDefinition', defaultValue: 'qa-milestone', description: '', name: 'CAT_SITE']]]
]

properties(projectProperties)

Common common = new Common(this)
BuildsCommon buildsCommon = new BuildsCommon(this)

try {
    node(Constants.DOCKERNODE) {
        buildsCommon.cleanup()

        stage('scm auto') {
            dir('automation') {
                git(branch:'master',
                        changelog:false,
                        credentialsId:'githubkey',
                        poll:false,
                        url: 'git@github.eng.tenable.com:Product/catium-tenableio.git')
            }
        }

        docker.withRegistry(Constants.AWS_DOCKER_REGISTRY) {
            docker.image(Constants.DOCKER_CI_VULNAUTOMATION_BASE).inside('-u root') {
                stage('build auto') {
                    timeout(time: 24, unit: Constants.HOURS) {
                        buildsCommon.prepareGit()

                        sshagent([Constants.GITHUBKEY]) {
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
                            """.stripIndent()
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
            docker.image(Constants.DOCKER_CI_JAVA_BASE).inside {
                stage('build java') {
                    try {
                        timeout(time: 24, unit: Constants.HOURS) {
                            sh '''
                            find .
                            cat ./tenableio-sdk/tio_config.txt | sed 's/^/systemProp./g' > gradle.properties

                            cat gradle.properties

                            chmod +x gradlew
                            ./gradlew build
                            '''.stripIndent()
                        }
                    }
                    finally {
                        step([$class: 'JUnitResultArchiver', testResults: 'build/test-results/test/*.xml'])
                    }
                }
            }
        }

        common.setResultIfNotSet(Constants.JSUCCESS)
    }
}
catch (ex) {
    common.logException(ex)
    common.setResultAbortedOrFailure()
}
finally {
    common.setResultIfNotSet(Constants.JFAILURE)

    String auser = common.getAbortingUsername()
    String tests = common.getTestResults()
    String took  = '\nTook: ' + common.getDuration()

    Slack slack = new Slack(this)

    messageAttachment = slack.helper.getDecoratedFinishMsg(
            'Tenable SDK Java build finished with result: ',
            "Built off branch ${env.BRANCH_NAME}" + tests + took + auser)
    messageAttachment.channel = '#sdk'

    slack.postMessage(messageAttachment)
}

