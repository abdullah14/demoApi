pipeline {
  agent { label "master" }
  stages {
    stage("build") {
      steps {
        
        sh 'mvn clean install -DskipTests=true '
        sh 'docker build -t hello_there .'
      }
    }
    stage("run") {
      steps {
        sh """
          docker run --rm hello_there
        """
      }
    }
  }
}
