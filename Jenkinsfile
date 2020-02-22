pipeline {
    agent any

    stages {
        stage('Package') {
			steps {
			   bat 'mvn clean'
			   echo 'Package...'
			   bat 'mvn package'
            }
        }
    }
}