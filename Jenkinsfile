
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
        stage ('Push image to Artifactory') { // take that image and push to artifactory
        steps {
            rtDockerPush(
                serverId: "jfrog-cred",
                image: "https://abbdullahcsjmi.jfrog.io/docker-local/my-petclinic:latest",
                host: 'tcp://localhost:2375',
                targetRepo: 'docker-local', // where to copy to (from docker-virtual)
                // Attach custom properties to the published artifacts:
                properties: 'project-name=docker1;status=stable'
            )
        }
    }
    
    
  }
}
