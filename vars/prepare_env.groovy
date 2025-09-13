def call() {
    withCredentials([
                        string(credentialsId: 'SPRING_DATASOURCE_PASSWORD', variable: 'J_SPRING_DB_PWD'),
                        string(credentialsId: 'jwt_secret',                variable: 'J_JWT_SECRET'),
                        string(credentialsId: 'mysql-root-password',       variable: 'J_MYSQL_ROOT_PWD'),
                        string(credentialsId: 'SPRING_PROFILES_ACTIVE',     variable: 'J_PROFILES'),
                        string(credentialsId: 'SERVER_PORT',                variable: 'J_SERVER_PORT'),
                        string(credentialsId: 'WEBSOCKET_ENDPOINT',         variable: 'J_WS_EP')
    ]) {
        def envContent = """
 sh '''
                            # Export runtime secrets for docker compose
                            export JWT_SECRET="${J_JWT_SECRET}"
                            export SPRING_DATASOURCE_PASSWORD="${J_SPRING_DB_PWD}"
                            export SPRING_DATASOURCE_USERNAME="root"
                            export SPRING_DATASOURCE_URL="jdbc:mysql://mysql:3306/chattingo_db?createDatabaseIfNotExist=true"
                            export SPRING_PROFILES_ACTIVE="${J_PROFILES}"
                            export SERVER_PORT="${J_SERVER_PORT}"
                            export WEBSOCKET_ENDPOINT="${J_WS_EP}"
                            export MYSQL_ROOT_PASSWORD="${J_MYSQL_ROOT_PWD}"
                            export MYSQL_DATABASE="chattingo_db"

                            export CORS_ALLOWED_ORIGINS="http://72.60.111.26:3000"
                            export CORS_ALLOWED_METHODS="GET,POST,PUT,DELETE,OPTIONS,PATCH"
                            export CORS_ALLOWED_HEADERS="*
""".stripIndent().trim()

        writeFile file: '.env', text: envContent
        echo '.env file created in workspace'
    }
}
