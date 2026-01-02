pipeline {
    agent any

    tools {
        // Must match Jenkins Global Tool Configuration
        jdk 'jdk-21'
        maven 'maven-3.8'
    }

    environment {
        APP_NAME = 'demo'
        APP_PORT = '9999'
        JAR_PATH = 'target'
        DEPLOY_DIR = '~/apps/'
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

        stage('Deploy JAR') {
            steps {
                sh '''
                    echo "Stopping existing application..."

                    PID=$(lsof -t -i:$APP_PORT || true)
                    if [ -n "$PID" ]; then
                        kill -9 $PID
                    fi

                    echo "Deploying new JAR..."
                    mkdir -p $DEPLOY_DIR
                    cp $JAR_PATH/*.jar $DEPLOY_DIR/$APP_NAME.jar

                    echo "Starting application..."
                    nohup java -jar $DEPLOY_DIR/$APP_NAME.jar \
                        > $DEPLOY_DIR/app.log 2>&1 &
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
