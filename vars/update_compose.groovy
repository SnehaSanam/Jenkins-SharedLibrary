def call(String imageTag) {
    stage('Update Compose') {
        echo "Updating docker-compose file..."
        sh """
            sed -i 's|:latest|:${imageTag}|g' docker-compose.yml
            cat docker-compose.yml
        """
    }
}
