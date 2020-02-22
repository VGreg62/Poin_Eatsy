pipeline {
    agent any

    stages {
        stage('Package') {
			steps {
				echo 'Package...'
                bat 'mvn clean package'
            }
        }
    }
	post{
		always{
			archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '/**/*.xml'
		}
	}
}