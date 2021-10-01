pipeline {
  agent { label "master" }
  environment {
    registry = "abdullahcsjmi/demoapi2"
    registryCredential = 'docker-cred'
  }
  stages {
    stage("build") {     
      steps {       
        sh 'mvn clean install -DskipTests=true '
      }
    }
    
   stage('Create Docker Image') {
     steps {       
      docker.build("abdullahcsjmi/docker-jenkins-pipeline:${env.BUILD_NUMBER}")
     }
  }
  }
}
