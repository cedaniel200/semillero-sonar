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
                        bat "gradlew sonarqube -Dsonar.branch.targe=${BRANCH_NAME} -Dsonar.branch.name=${BRANCH_NAME}"
                    }
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
