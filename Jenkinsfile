#!/usr/bin/env groovy

library 'sayHello'

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

    stage('git checkout') {
      checkout scm
    }

    docker.withRegistry('https://docker-registry.cloud.aws.tenablesecurity.com:8888/') {
      docker.image('ci-java-base:2.0.18').inside {
        stage('build') {
          timeout(time: 10, unit: 'MINUTES') {
            sh 'chmod +x gradlew'
            sh './gradlew build'
          }
        }
      }
    }
  }
}
catch (exc) {
  echo "caught exception: ${exc}"
//  messageSlack("sc-jenkins", "Build Failed", "danger", true)
  currentBuild.result = 'FAILURE'
}
