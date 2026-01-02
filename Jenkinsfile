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


        stage('Deploy JAR') {
            steps {
                sh '''
        echo "Stopping existing application..."

        PID=$(lsof -t -i:$APP_PORT || true)
        if [ -n "$PID" ]; then
            kill $PID
            sleep 5
        fi

        echo "Deploying new JAR..."
        mkdir -p $DEPLOY_DIR
        cp $JAR_PATH/*.jar $DEPLOY_DIR/$APP_NAME.jar

        echo "Starting application..."
        sudo systemctl restart demo

        sleep 5
        tail -n 100 $DEPLOY_DIR/app.log

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
