pipeline {
    agent any

    stages {
        stage('build') {
            steps {
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
            }
        }
    }
}