
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
       sh 'docker build -t abdullahcsjmi/my-petclinic:latest .'
     }
  }
    
    
    stage("Push docker image") {
     steps {
             sh 'docker -v'
             script {
                 def rtServer = Artifactory.server "artifactory"
                 def rtDocker = Artifactory.docker server: rtServer
                 def buildInfo = rtDocker.push 'https://abbdullahcsjmi.jfrog.io/docker-local/my-petclinic:latest','jfrog-cred'
             }
     }
}
    
  }
}
