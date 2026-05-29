pipeline {
 
    agent any
 
    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }
 
    stages {
 
        stage('Git Checkout') {
            steps {
                git 'https://github.com/anku2308/Amazon.git'
            }
        }
 
        stage('Clean Project') {
            steps {
                bat 'mvn clean'
            }
        }
 
        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }
 
        stage('Generate Reports') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'reports',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Report'
                ])
            }
        }

        // --- Your New Stage Added Here ---
        stage('Publish Cucumber Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber.html',
                    reportName: 'Amazon Cucumber Report'
                ])
            }
        }
    }
 
    post {
        always {
            // Updated to archive both your Extent reports folder and Cucumber reports folder
            archiveArtifacts artifacts: 'reports/*, target/cucumber-reports/*'
        }
 
        success {
            echo 'Pipeline Executed Successfully'
        }
 
        failure {
            echo 'Pipeline Failed'
        }
    }
}