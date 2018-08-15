node {
   def mvnHome
   stage('Preparation') { // for display purposes
checkout([$class: 'SubversionSCM', additionalCredentials: [], excludedCommitMessages: '', excludedRegions: '', excludedRevprop: '', excludedUsers: '', filterChangelog: false, ignoreDirPropChanges: false, includedRegions: '', locations: [[cancelProcessOnExternalsFail: true, credentialsId: '1cb184f4-a300-4da6-ab2b-fa5dc356e372', depthOption: 'infinity', ignoreExternalsOption: true, local: '.', remote: 'http://192.168.18.45/svn/SilveradoStages/trunk/Jenkins/AccountManagement']], quietOperation: true, workspaceUpdater: [$class: 'UpdateUpdater']])
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool name: 'maven', type: 'maven'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      archive 'target/*.jar'
   }
}
