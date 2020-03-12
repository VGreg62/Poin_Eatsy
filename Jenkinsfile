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
            bat "mvn clean package"

         }
      }
      stage('Test'){
        steps{
            echo 'Test...'
            echo 'Checkstyle...'
            bat "mvn checkstyle:checkstyle"
            echo 'PMD Source Coe Analyzer Project...'
            bat "mvn pmd:pmd"
        }
      }
      stage('Deploy'){
        steps{
            echo 'Deploy...'
            //nexusPublisher nexusInstanceId: 'nexus_localhost', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: 'target/eatsy_back.jar']], mavenCoordinate: [artifactId: 'back', groupId: 'fr.eatsyManager', packaging: 'jar', version: '1.1-RELEASE']]]
        }
      }
   }
   post {
      success {
         junit '**/target/surefire-reports/*.xml'
         archiveArtifacts '**/target/*.jar'
         archiveArtifacts '**/target/*.xml'
      }
      always{
        recordIssues enabledForFailure : true, tools: [mavenConsole(), java(), javaDoc()]
        recordIssues enabledForFailure : true, tool: checkStyle()
        recordIssues enabledForFailure : true, tool: pmdParser(pattern: '**/target/pmd.xml')
        recordIssues enabledForFailure : true, tool: cpd(pattern: '**/target/cpd.xml')
      }
   }
}