// vars/prepare_env_frontend.groovy
def call() {
    def frontendEnv = """
REACT_APP_API_URL=http://chattingo-app.duckdns.org
"""
    writeFile file: 'frontend/.env.production', text: frontendEnv
    echo 'Frontend .env.production created'
}

