#!/usr/bin/env groovy

//library 'sayHello'

// this is a scripted (not declarative) pipeline
// https://jenkins.io/doc/book/pipeline/syntax/#scripted-pipeline
// https://jenkins.io/doc/book/pipeline/syntax/#compare
// https://jenkins.io/blog/2017/02/03/declarative-pipeline-ga/

def projectProperties = [
  [$class: 'BuildDiscarderProperty',strategy: [$class: 'LogRotator', numToKeepStr: '5']],disableConcurrentBuilds()
]

properties(projectProperties)

try {
  node('docker') {
    deleteDir()

    stage('Get Automation') {
      dir("automation") {
        git branch: 'develop', changelog: false, credentialsId: 'bitbucket-checkout', poll: false, url: 'ssh://git@stash.corp.tenablesecurity.com:7999/aut/automation-tenableio.git'
      }
    }
    docker.withRegistry('https://docker-registry.cloud.aws.tenablesecurity.com:8888/') {
      docker.image('ci-vulnautomation-base:1.0.9').inside {
        sshagent(['buildenginer-checkout']) {
          stage('build automation') {
            timeout(time: 10, unit: 'MINUTES') {
              ss 'id'
              sh 'cd automation && python3 autosetup.py catium --all'
            }
          }
        }
      }
    } 
  }

//  node('docker') {
//    deleteDir()
//    stage('git checkout') {
//      checkout scm
//    }
//
//    docker.withRegistry('https://docker-registry.cloud.aws.tenablesecurity.com:8888/') {
//      docker.image('ci-java-base:2.0.18').inside {
//        stage('build') {
//          try {
//            timeout(time: 10, unit: 'MINUTES') {
//              sh 'chmod +x gradlew'
//              sh './gradlew build'
//            }
//          }
//          finally {
//	    step([$class: 'JUnitResultArchiver', testResults: 'build/test-results/test/*.xml'])
//          }
//        }
//      }
//    }
//  }
}
catch (exc) {
  echo "caught exception: ${exc}"
  currentBuild.result = 'FAILURE'
}
