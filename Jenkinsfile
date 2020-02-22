pipeline {
   agent any

   tools {
      // Install the Maven version configured as "maven_3_6_3" and add it to the path.
      maven "maven_3_6_3"
   }

   stages {
      stage('Build') {
         steps {
            git 'https://github.com/VGreg62/Poin_Eatsy.git'
            sh "mvn clean package"

         }
      }
   }
   post {
      success {
         junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar
      }
   }

}