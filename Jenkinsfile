pipeline {
    agent any
    tools{
        maven 'Maven 3.2.5'
    }
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