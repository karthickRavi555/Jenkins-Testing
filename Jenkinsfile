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

         stage('Image') {
            dir ('AccountManagement') {
                def app = docker.build "localhost:5000/AccountManagement:${env.version}"
                app.push()
            }
        }

        stage ('Run') {
            docker.image("localhost:5000/AccountManagement:${env.version}").run('-p 8761:8761 -h discovery --name account')
        }

        stage ('Final') {
            build job: 'AccountManagement', wait: false
        }      

    }
}
