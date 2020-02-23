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
            echo 'Build...'
            sh "mvn clean package"

         }
      }
      stage('Test'){
        steps{
            echo 'Test...'
            sh "mvn checkstyle:checkstyle"
        }
      }
   }
   post {
      success {
         junit '**/target/surefire-reports/*.xml'
         archiveArtifacts 'target/*.jar'
         archiveArtifacts 'target/*.xml'
      }
      always{
        junit '**/target/surefire-reports/*.xml'
        recordIssues enabledForFailure : true, tools: [mavenConsole(), java(), javadoc()]
        recordIssues enabledForFailure : true, tool: checkstyle()

      }
   }

}