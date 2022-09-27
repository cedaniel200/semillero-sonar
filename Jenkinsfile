pipeline {
    agent {label "windows"}
    parameters {
        string(name: 'BRANCH', defaultValue: 'main', description: 'Branch')
    }
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
                withSonarQubeEnv(credentialsId: 'token-sonarcloud') {
                    bat 'gradlew sonarqube -Dsonar.branch.targe=${params.BRANCH} -Dsonar.branch.name=${params.BRANCH}'
                }
            }
        }
    }
}