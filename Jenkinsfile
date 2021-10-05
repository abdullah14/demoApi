
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
          script {
              def server = Artifactory.newServer url: 'https://abbdullahcsjmi.jfrog.io/artifactory', credentialsId: "jfrog-cred"
             def rtDocker = Artifactory.docker server: server
            def buildInfo = rtDocker.push 'hello-world:latest', 'docker-local'
            server.publishBuildInfo buildInfo
              println "jfrog cred... "+server.credentialsId
          }
          
        }
    }
        
    
  }
}
