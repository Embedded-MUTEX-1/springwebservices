pipeline {
    agent any
    environment {
        PATH = "/usr/lib/jvm/jdk-19/bin:$PATH"
        JAVA_HOME="/usr/lib/jvm/jdk-19/"

        registry = "lennyisaac14/repository_test"
        registryCredential = 'jenkinsdockerhub'
        dockerImage = ''

    }
        stages {
            stage('recuperation du projet'){
                steps {
                    git branch: 'master',
                    credentialsId: 'jenkinsgithub',
                    url :'git@github.com:lenny1411/springwebservices.git'
                }
            }
            stage("Compile") {
                steps {
                    sh "bash ./gradlew compileJava"
                }
            }
            stage("test") {
                steps {
                    sh "bash ./gradlew test"
                }
            }
            stage("package") {
                steps {
                    sh "bash ./gradlew build"
                }
            }
            stage("Docker build") {
                steps{
                    sh "docker build -t 172.17.0.3:5000/imagesspring ."
                }
            }
            stage("Docker push") {
                steps{
                    sh "docker push 172.17.0.3:5000/imagesspring"
                }
            }
        }
}