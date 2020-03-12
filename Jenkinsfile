def groupId = ''
def artefactId = ''
def filePath = ''
def packaging = ''
def version = ''
def verCode = UUID.randomUUID().toString()

pipeline {
   agent any

   tools {
      // Install the Maven version configured as "maven_3_6_3" and add it to the path.
      maven "maven_3_6_3"
   }

   environment {

        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "http"
        // Where your Nexus is running
        NEXUS_URL = "localhost:8081"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "maven-snapshots"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "nexus_localhost"
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
            script{
                        pom = readMavenPom file: 'pom.xml'
                        groupId = pom.groupId
                        artifactId = pom.artifactId
                        packaging = pom.packaging
                        version = pom.version
                        filepath = "target/${artifactId}-${version}.jar"
            }
            nexusPublisher nexusInstanceId: 'nexus_localhost', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: "${filepath}"]], mavenCoordinate: [artifactId: "${artifactId}", groupId: "${groupId}", packaging: "${packaging}", version: "${version}-${verCode}"]]]
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