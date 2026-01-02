pipeline {
    agent any

    tools {
        // Must match Jenkins Global Tool Configuration
        jdk 'jdk-21'
        maven 'maven-3.8'
    }

    environment {
        APP_NAME = 'demo'
        APP_PORT = '9090'
        JAR_PATH = 'target'
        DEPLOY_DIR = '/home/wolf'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Builds executable Spring Boot JAR
                sh 'mvn clean package'
            }
        }

        stage('Load Env') {
            steps {
                script {
                    def envVars = readProperties file: '.env'
                    env.JWT_SECRET = envVars.JWT_SECRET
                    env.JWT_EXPIRATION = envVars.JWT_EXPIRATION
                }
            }
        }

        stage('TEST Env') {
            steps {
                sh '''
                    echo "*************"
                    echo $JWT_SECRET
                    echo $JWT_EXPIRATION
                    echo "*************"
                    '''
            }
        }

        stage('Deploy JAR') {
            steps {
                sh '''

        echo "Deploying new JAR..."
        mkdir -p $DEPLOY_DIR
        cp target/${APP_NAME}-*.jar $DEPLOY_DIR/$APP_NAME.jar

        echo "Starting application..."
        sudo -n systemctl restart demo

        sleep 5
        tail -n 100 $DEPLOY_DIR/app.log
        systemctl is-active demo

                '''
            }
        }
    }

    post {
        success {
            echo '✅ Spring Boot JAR deployed successfully'
        }
        failure {
            echo '❌ Build or deployment failed'
        }
        always {
            cleanWs()
        }
    }
}
