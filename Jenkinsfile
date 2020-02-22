pipeline {
    agent any

    environment{
        PATH = ""
    }
    stages {
        stage('Package') {
			steps {
			   echo 'Compile...'
			   withMaven(maven: 'maven_3_6_3'){
                sh 'mvn clean compile'
               }
            }
        }
        stage('Test'){
            steps{
                echo 'Test...'
                withMaven(maven: 'maven_3_6_3'){
                 sh 'mvn test'
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