#!groovy

pipeline {

    agent {
        docker {
            image "maven:3.6.0-jdk-13"
            label "master"
        }
    }

    stages {
        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
