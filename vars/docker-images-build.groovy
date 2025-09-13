 def call(String FRONTEND_IMAGE, String BACKEND_IMAGE, String DOCKER_TAG) {
    stage('Docker Build') {
        echo "Building Docker images..."
         sh """
                    docker build -t ${FRONTEND_IMAGE}:${DOCKER_TAG} -f frontend/Dockerfile ./frontend
                    docker build -t ${BACKEND_IMAGE}:${DOCKER_TAG} -f backend/Dockerfile ./backend
                    docker images
                """
    }
}
