// vars/updateCompose.groovy
def call(String imageTag) {
    echo "Updating docker-compose file with image tag ${imageTag}..."
    sh """
        sed -i 's|:latest|:${imageTag}|g' docker-compose.yml
        cat docker-compose.yml
    """
}
