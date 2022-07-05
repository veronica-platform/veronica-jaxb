pipeline {
    agent {  label 'contabo-vps' }
    options {
        skipDefaultCheckout()
        buildDiscarder(logRotator(numToKeepStr: '20'))
        timeout(time: 10, unit: "MINUTES")
    }
    tools {
        maven "MAVEN_3.8.6"
    }
    stages {
        stage('Preparation') {
            steps {
                script {
                    flow.init()
                    flow.withStage("Build", {
                        flow.build()
                    })
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
