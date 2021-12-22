pipeline {
    agent any

    stages {
        stage('Build image') {
            steps {
                echo 'Building image..'
                sh 'docker build -t stiefff/node-application .'
            }
        }
        stage('Push image to Docker Hub') {
            steps {
                echo 'Pushing image....'
                sh 'docker push stiefff/node-application'
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                echo 'Deploying....'
                sh 'kubectl set image deployments/node-application node-application=stiefff/node-application:latest'
            }
        }
    }
}