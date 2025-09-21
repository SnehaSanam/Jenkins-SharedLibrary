def call() {
    withCredentials([
        string(credentialsId: 'SPRING_DATASOURCE_PASSWORD', variable: 'J_SPRING_DB_PWD'),
        string(credentialsId: 'jwt_secret',                variable: 'J_JWT_SECRET'),
        string(credentialsId: 'mysql-root-password',       variable: 'J_MYSQL_ROOT_PWD'),
        string(credentialsId: 'SERVER_PORT',               variable: 'J_SERVER_PORT'),
        string(credentialsId: 'WEBSOCKET_ENDPOINT',        variable: 'J_WS_EP')
    ]) {

        def envContent = """
JWT_SECRET=${J_JWT_SECRET}
SPRING_DATASOURCE_PASSWORD=${J_SPRING_DB_PWD}
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/chattingo_db?createDatabaseIfNotExist=true
SPRING_PROFILES_ACTIVE=production
SERVER_PORT=${J_SERVER_PORT}
WEBSOCKET_ENDPOINT=${J_WS_EP}
MYSQL_ROOT_PASSWORD=${J_MYSQL_ROOT_PWD}
MYSQL_DATABASE=chattingo_db

CORS_ALLOWED_ORIGINS=http://chattingo-app.duckdns.org, https://chattingo-app.duckdns.org
CORS_ALLOWED_METHODS=GET,POST,PUT,DELETE,OPTIONS,PATCH
CORS_ALLOWED_HEADERS=*
""".stripIndent().trim()

        // Write .env file
        writeFile file: '.env', text: envContent
        echo '.env file created in workspace'
    }
}
