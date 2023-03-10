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
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    echo 'test'
                    bat "mvn test"
                    //  junit '**/target/*.xml'
                }
            }
        }
        stage('Deploy') {
            when {
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps {
                echo 'deploy'
                // bat 'mvn deploy'
            }
        }
        stage('Example') {
            steps {
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                echo "${env.BUILD_ID} and ${env.JOB_NAME}"
            }
        }
        stage('report') {
            steps {
                cucumber fileIncludePattern: '**/cucumber.json'

            }
        }
    }
    post{
        success {   emailext attachmentsPattern: '**/test-output.html', body: 'test', subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS', to: 'nchaour6@gmail.com'}
        failure {   emailext attachmentsPattern: '**/test-output.html', body: 'test', subject: 'j$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS', to: 'nchaour6@gmail.com'}
    }
}
