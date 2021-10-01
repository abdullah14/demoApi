pipeline {
  environment {
    registry = "abdullahcsjmi/demoapi2"
    registryCredential = 'docker-cred'
  }
  agent { label "master" }
  stages {
    stage("build") {     
      steps {       
        sh 'mvn clean install -DskipTests=true '
        sh 'docker build -t example-api .'
      }
    }
  }
}
