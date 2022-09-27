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
                withSonarQubeEnv(installationName: 'SonarCloud' ,credentialsId: 'token-sonarcloud') {
                    bat "gradlew sonarqube -Dsonar.branch.targe=${env.BRANCH_NAME} -Dsonar.branch.name=${env.BRANCH_NAME}"
                }
            }
        }
    }
}