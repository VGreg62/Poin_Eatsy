pipeline {
    agent any

    stages {
        stage('Package') {
			steps {
				echo 'Package...'
                sh 'mvn clean package'
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