pipeline {
    agent any

    stages {
        stage('Package') {
			steps {
			   echo 'Compile...'
                sh 'mvn clean compile'
            }
        }
    }
}