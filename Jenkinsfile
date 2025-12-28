pipeline {
    agent any

    // Tools configuration
    tools {
        maven 'Maven'  // Make sure this matches the name in Manage Jenkins → Tools → Maven
    }

    // Environment variables
    environment {
        APP_VERSION = "1.0.0"
    }

    // Parameters
    parameters {
        booleanParam(name: 'RUN_TESTS', defaultValue: true, description: 'Run tests or skip')
    }

    stages {
        // Build stage
        stage('Build') {
            steps {
                echo "Building project version ${APP_VERSION}..."
                // Windows users: use 'bat' instead of 'sh'
                sh 'mvn clean compile'
            }
        }

        // Test stage
        stage('Test') {
            when {
                expression { return params.RUN_TESTS == true }
            }
            steps {
                echo "Running tests..."
                sh 'mvn test'
            }
        }

        // Deploy stage (only if previous stages succeeded)
        stage('Deploy') {
            when {
                allOf {
                    expression { return currentBuild.result == null || currentBuild.result == 'SUCCESS' }
                }
            }
            steps {
                echo "Deploying application version ${APP_VERSION}..."
                // Here you can add real deploy commands
            }
        }
    }

    // Post actions
    post {
        success {
            echo "Pipeline completed SUCCESSFULLY."
        }
        failure {
            echo "Pipeline FAILED. Deployment skipped."
        }
        always {
            echo "Cleaning up workspace..."
        }
    }
}
