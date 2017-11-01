#!/usr/bin/env groovy

//library 'sayHello'

// this is a scripted (not declarative) pipeline
// https://jenkins.io/doc/book/pipeline/syntax/#scripted-pipeline
// https://jenkins.io/doc/book/pipeline/syntax/#compare
// https://jenkins.io/blog/2017/02/03/declarative-pipeline-ga/

def projectProperties = [
  [$class: 'BuildDiscarderProperty',strategy: [$class: 'LogRotator', numToKeepStr: '5']],disableConcurrentBuilds(),
  [$class: 'ParametersDefinitionProperty', parameterDefinitions: [[$class: 'StringParameterDefinition', defaultValue: 'qa-staging', description: '', name: 'CAT_SITE']]]
]

properties(projectProperties)

try {
  node('docker') {

    // Cleanup within the container as we run as root
    docker.withRegistry('https://docker-registry.cloud.aws.tenablesecurity.com:8888/') {
      docker.image('ci-vulnautomation-base:1.0.9').inside("-u root") {
        stage('clean auto') {
          sh 'chown -R 1000:1000 .'
        }
      }
    } 

    deleteDir()

    // Pull the automation framework from develop
    stage('scm auto') {
      dir("automation") {
        git branch: 'develop', changelog: false, credentialsId: 'bitbucket-checkout', poll: false, url: 'ssh://git@stash.corp.tenablesecurity.com:7999/aut/automation-tenableio.git'
      }
    }

    docker.withRegistry('https://docker-registry.cloud.aws.tenablesecurity.com:8888/') {
      docker.image('ci-vulnautomation-base:1.0.9').inside("-u root") {
        stage('build auto') {
          timeout(time: 10, unit: 'MINUTES') {
            sshagent(['buildenginer_public']) {
              // This may need to go back to the image
              // sh 'pip3 install virtualenv'
              sh 'git config --global user.name "buildenginer"'
              sh 'mkdir ~/.ssh && chmod 600 ~/.ssh'
              sh 'ssh-keyscan -H -p 7999 stash.corp.tenablesecurity.com >> ~/.ssh/known_hosts'
              sh 'ssh-keyscan -H -p 7999 172.25.100.131 >> ~/.ssh/known_hosts'
              //sh 'cat ~/.ssh/known_hosts'
              sh 'cd automation && python3 autosetup.py catium --all --no-venv 2>&1'
              sh '''
export PYTHONHASHSEED=0 
export PYTHONPATH=. 
export CAT_LOG_LEVEL_CONSOLE=INFO
export CAT_SITE=qa-milestone

env
cd automation
pwd

mkdir ../tenableio-sdk
python3 tenableio/commandline/sdk_test_container.py --create_container --raw

chmod -R 777 ../tenableio-sdk
'''
              stash includes: '**/tenableio-sdk/tio_config.txt', name: 'Config'
            }
          }
        }
      }
    } 
  }

  node('docker') {

    // Cleanup within the container as we run as root
    docker.withRegistry('https://docker-registry.cloud.aws.tenablesecurity.com:8888/') {
      docker.image('ci-vulnautomation-base:1.0.9').inside("-u root") {
        stage('clean java') {
          sh 'chown -R 1000:1000 .'
        }
      }
    } 

    deleteDir()

    stage('scm java') {
      checkout scm
      unstash 'Config'
      sh 'find tenableio-sdk'
    }

    docker.withRegistry('https://docker-registry.cloud.aws.tenablesecurity.com:8888/') {
      docker.image('ci-java-base:2.0.18').inside {
        stage('build java') {
          try {
            timeout(time: 10, unit: 'MINUTES') {
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
  }
}
catch (exc) {
  echo "caught exception: ${exc}"
  currentBuild.result = 'FAILURE'
}
