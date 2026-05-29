pipeline {
 
    agent any
 
    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }
 
    stages {
        // ✂️ 'Git Checkout' stage has been removed from here!
 
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

        stage('Publish Cucumber Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/cucumber-reports',
                    reportFiles: 'cucumber.html',
                    reportName: 'Flipkart Cucumber Report'
                ])
            }
        }
    }
 
    post {
        always {
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