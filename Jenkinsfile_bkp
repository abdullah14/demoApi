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
                
                 sh 'mvn clean install -DskipTests=true '
                
            }
        }
        
       stage ('docker image build'){
            steps {
                        sh 'mvn package dockerfile:build'                         
                  }
          }
    }        

    post {
        always {
            cleanWs()
        }
    }
}
