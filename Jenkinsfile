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
                // catchError flags the build as unstable/failed but lets the pipeline keep moving forward
                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    bat 'mvn test'
                }
            }
 
     stage('Generate Reports') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output', // 👈 Change this to match your Eclipse folder
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
                    reportDir: 'target', // 👈 Change this to match your exact folder path
                    reportFiles: 'cucumber.html',
                    reportName: 'Amazon Cucumber Report'
                ])
            }
        }
    }
 
    post {
        always {
            // Updated to look inside your actual project output folders
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