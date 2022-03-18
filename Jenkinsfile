pipeline {
    agent any
    tools {
      maven "Maven"
    }
    stages {
        stage('Clone sources') {
            steps {
                checkout scm
            }
        }
    stage('Maven Build') {
         steps {
             script {
                 sh "mvn package"
                     }
               }
     }
     stage('SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package sonar:sonar'
                }
            }
        }
     stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
    }
}