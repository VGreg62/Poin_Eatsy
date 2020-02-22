pipeline {
    agent any

    stages {
        stage('SCM Checkout'){
            steps{
                git 'https://github.com/VGreg62/Poin_Eatsy'
            }
        }
        stage('Package') {
			steps {
			    def mvnHome = tool name: 'Maven_3_6_3', type: 'maven'
				echo 'Package...'
                sh "${mvnHome}/bin/mvn clean package"
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