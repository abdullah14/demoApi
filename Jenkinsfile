pipeline {
  agent { label "master" }
  stages {
    stage("build") {
      steps {
        
        sh 'mvn clean install -DskipTests=true '
        sh 'docker build -t hello_there .'
      }
    }
  }
}
