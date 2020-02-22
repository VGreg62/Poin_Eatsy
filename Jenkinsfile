pipeline {
    agent any

    environment{
        PATH = ""
    }
    stages {
        stage('Package') {
			steps {
			   echo 'Package...'
			   withMaven(maven: 'maven_3_6_3'){
                sh 'mvn clean package'
               }
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