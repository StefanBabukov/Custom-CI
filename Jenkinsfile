
def app

pipeline {
    agent any
    environment{
        DOCKERHUB_CREDENTIALS = credentials('91f105d7-0350-4090-9680-758f8140de30')
    }
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
        stage('Login to dockerhub'){
            steps{
                echo 'Logging in to dockerhub'
                sh 'docker login -u stiefff -p $DOCKERHUB_CREDENTIALS'
            }
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