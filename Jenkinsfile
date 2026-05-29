pipeline {
    agent any
 
    tools {
        jdk 'JAVA_HOME'
        maven 'MAVEN_HOME'
    }
 
    stages {
        stage('Clean Project') {
            steps {
                bat 'mvn clean'
            }
        }
 
        stage('Run Tests') {
            steps {
                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    bat 'mvn test'
                }
            }
        }
 
        stage('Generate Reports') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
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
                    reportDir: 'target',
                    reportFiles: 'cucumber-report.html', // 👈 Fixed here (added "-report")
                    reportName: 'Amazon Cucumber Report
                ])
            }
        }
    }
 
    post {
        always {
            archiveArtifacts artifacts: 'test-output/ExtentReport.html, target/cucumber.html', allowEmptyArchive: true
        }
 
        success {
            echo 'Pipeline Executed Successfully'
        }
 
        failure {
            echo 'Pipeline Failed'
        }
    }
}