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
        sh 'docker build -t example-api .'
      }
    }
  }
}
