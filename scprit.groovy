pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                //   bat "make"
                echo 'clean'
                bat "mvn clean"
            }
        }
        stage('compile') {
            steps {
                echo 'compile'
                bat "mvn compile"


            }
        }
        stage('test') {
            steps {
                echo 'test'
                bat "mvn test"
                //  junit '**/target/*.xml'
            }
        }
        stage('Deploy') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                bat 'make publish'
            }
        }
    }
}
