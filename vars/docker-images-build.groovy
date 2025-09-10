 sh """
                docker build -t ${FRONTEND_IMAGE}:${DOCKER_TAG} -f frontend/frontend-dockerfile ./frontend
                docker build -t ${BACKEND_IMAGE}:${DOCKER_TAG} -f backend/backend-dockerfile ./backend
                docker images
                """
