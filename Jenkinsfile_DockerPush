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
    
    stage('Push image to docker'){
      steps {
               withDockerRegistry([ credentialsId: "docker-cred", url: "" ]) {
      // following commands will be executed within logged docker registry
      sh 'docker push abdullahcsjmi/my-petclinic:latest'
   }
}
    }
  }
}
