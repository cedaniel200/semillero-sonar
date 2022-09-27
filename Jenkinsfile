pipeline {
    agent {label "windows"}
    stages {
        stage('Build') {
            steps {
                echo "TAG_NAME = ${TAG_NAME}"
                bat 'gradlew clean build -x test'
            }
        }
        stage('Test') {
            steps {
                bat "gradlew test"
            }
        }
        stage('Coverage') {
            steps {
                bat 'gradlew jacocoTestReport'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv(installationName: 'SonarCloud') {
                    script {
                        bat "gradlew sonarqube -Dsonar.branch.name=${BRANCH_NAME}"
                    }
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(5) {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
        stage("Generate and Publish Artifact") {
            when {
                allOf {
                    branch "main"
                    tag "v*.*.*"
                }
            }
            steps {
                echo "Generate Artifact ..."
                echo "Publish Artifact ..."
            }
        }
    }
}
