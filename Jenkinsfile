
def app

pipeline {
    agent any
    stages {
        stage('Clone repository'){
            steps{
            checkout scm
            }
        }
        stage('Build image') {
            steps {
                echo 'Building image..'
                sh 'docker build -t stiefff/node-application .'
                
            }
        }
        // stage('Test image'){
        //     steps{
        //         script{
        //     app.inside {
        //         sh 'echo "Test has passed'
        //     }
        //         }
        //     }
        // }
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