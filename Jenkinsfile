def workspace;
node {
    
    stage ('Checkout')
    {
     checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'd12dfe77-f776-4a6c-93c5-664de10f630d', url: 'https://github.com/karthickRavi555/Jenkins-Testing.git']]])
    workspace =pwd()
    }
     stage('Build') {
            sh 'mvn clean install'

            def pom = readMavenPom file:'pom.xml'
            print pom.version
            env.version = pom.version
        }

       
}
