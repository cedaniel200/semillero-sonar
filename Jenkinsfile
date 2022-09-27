pipeline {
    agent {label "windows"}
    def branchName = getCurrentBranch()
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
                    bat "gradlew sonarqube -Dsonar.branch.targe=${branchName} -Dsonar.branch.name=${branchName}"
                }
            }
        }
    }
}

def getCurrentBranch () {
    return bat (script: 'git rev-parse --abbrev-ref HEAD', returnStdout: true).trim()
}