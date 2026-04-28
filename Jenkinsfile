pipeline {
    agent any

    tools {
        maven 'maven' 
    }

    stages {
        stage('Récupération du code') {
            steps {
                echo 'Clonage du dépôt depuis GitHub...'
                checkout scm
            }
        }

        stage('Compilation & Tests') {
            steps {
                echo 'Exécution de Maven...'
                // Si Jenkins tourne sous Windows, utilisez 'bat' au lieu de 'sh'
                sh 'mvn clean package'
            }
        }

        stage('Build Image Docker') {
            steps {
                echo 'Création du conteneur Docker...'
                script {
                    // Construction de l'image avec un tag dynamique basé sur le numéro de build
                    docker.build("hicham-javapipeline:${env.BUILD_ID}")
                }
            }
        }
    }
}