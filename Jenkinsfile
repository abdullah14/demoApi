#!groovy

pipeline {

    agent {
        dockerfile {
            label "master"
        }
    }

    stages {
        stage("Build") {
            steps {
                
                dockerImage = docker.build demoapi
                
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
