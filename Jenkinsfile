pipeline {
    agent any
    stages {
        stage ('Compile') {
            steps {
                sh 'mvn -B compile'
            }
        }
        stage ('Unit Tests') {
            steps {
                sh 'mvn -B test'
            }
            post {
                always {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }
    }
}