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
        
       stage ('docker image build'){
            steps {
                   
                        sh 'mvn dockerfile:build'
                         
                  }
          }
    }        

    post {
        always {
            cleanWs()
        }
    }
}
