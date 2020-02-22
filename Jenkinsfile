pipeline {
    agent any

    environment{
        PATH = ""
    }
    stages {
        stage('SCM Checkout'){
            steps{
                git 'https://github.com/VGreg62/Poin_Eatsy'
            }
        }
        stage('Package') {
			steps {
			   echo 'Package...'
                bat "mvn clean package"
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