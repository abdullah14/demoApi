
pipeline {
  agent { label "master" }
  environment {
    registry = "abdullahcsjmi/demoapi2"
    registryCredential = 'docker-cred'
  }
  stages {
    stage("build") {     
      steps {       
        sh 'mvn clean install -P dev -DskipTests=true '
      }
    }
    
   stage('Create Docker Image') {
     steps {       
       sh 'docker build -t abbdullahcsjmi.jfrog.io/docker-local/demo.api:latest .'
     }
  }      
        stage ('Push image to Artifactory') { // take that image and push to artifactory
        steps {
          script {
              def server = Artifactory.newServer url: 'https://abbdullahcsjmi.jfrog.io/artifactory', username: 'abdullahcsjmi@gmail.com', password: 'Altamash876@'
             def rtDocker = Artifactory.docker server: server
            def buildInfo = rtDocker.push 'abbdullahcsjmi.jfrog.io/docker-local/demo.api:latest', 'docker-local'
            server.publishBuildInfo buildInfo
              println "jfrog cred... "+server.credentialsId
          }
          
        }
    }
        
    
  }
}
