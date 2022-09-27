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
                withSonarQubeEnv(installationName: 'SonarCloud', credentialsId: 'token-sonarcloud') {
                    script {
                        bat 'gradlew sonarqube -Dsonar.branch.targe=feature/counter -Dsonar.branch.name=feature/counter'
                    }
                }
            }
        }
    }
}