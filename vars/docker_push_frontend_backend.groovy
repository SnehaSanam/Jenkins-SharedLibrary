def call(String FRONTEND_IMAGE, String BACKEND_IMAGE, String DOCKER_TAG, String DOCKER_HUB_USER)
                withCredentials([usernamePassword(
                    credentialsId: "dockerhub_creds",
                    usernameVariable: "DOCKER_HUB_USER",
                    passwordVariable: "DOCKER_HUB_PASS"
                 )]) {
                sh """
                    echo $DOCKER_HUB_PASS | docker login -u $DOCKER_HUB_USER --password-stdin
                    docker tag ${FRONTEND_IMAGE}:${DOCKER_TAG} $DOCKER_HUB_USER/${FRONTEND_IMAGE}:${DOCKER_TAG}
                    docker tag ${BACKEND_IMAGE}:${DOCKER_TAG} $DOCKER_HUB_USER/${BACKEND_IMAGE}:${DOCKER_TAG}
                    docker push $DOCKER_HUB_USER/${FRONTEND_IMAGE}:${DOCKER_TAG}
                    docker push $DOCKER_HUB_USER/${BACKEND_IMAGE}:${DOCKER_TAG}
                """
            }

  
