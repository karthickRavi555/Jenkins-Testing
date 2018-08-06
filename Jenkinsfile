def workspace;
node {
    
    stage ('Checkout')
    {
     checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'd12dfe77-f776-4a6c-93c5-664de10f630d', url: 'https://github.com/karthickRavi555/Jenkins-Testing.git']]])
    workspace =pwd()
    }
    stage('Static Code Anaylsis')
    {
        echo "static code anylsis"
    }
    stage('Build')
    {
        echo "build the code"
    }
    stage('Unit Testing')
    {
        echo "unite testing the code"
    }
    stage('Deilvery')
    {
        echo "delivery the code"
    }
}
