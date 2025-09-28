// vars/prepare_env_frontend.groovy
def call() {
    def frontendEnv = """
REACT_APP_API_URL=https://chattingo-app.duckdns.org/api
REACT_APP_WS_URL=https://chattingo-app.duckdns.org/ws
"""
    writeFile file: 'frontend/.env.production', text: frontendEnv
    echo 'Frontend .env.production created'
}

