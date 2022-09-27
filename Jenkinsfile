pipeline {
    agent {label "windows"}
    stages {
        stage('build') {
            steps {
                bat 'gradlew clean build -x test'
            }
        }
        stage('test') {
            steps {
                bat "gradlew test"
            }
        }
        stage('coverage') {
            steps {
                bat 'gradlew jacocoTestReport'
            }
        }
        stage('Analisis de SonarQube') {
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
    }
}
