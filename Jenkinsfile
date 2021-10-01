pipeline {
  environment {
    registry = "abdullahcsjmi/demoapi2"
    registryCredential = 'd9264b5e-e81a-4cec-969e-2cfa02a3caaf'
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
