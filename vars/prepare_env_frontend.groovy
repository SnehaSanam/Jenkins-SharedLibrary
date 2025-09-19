def frontendEnv = """
REACT_APP_API_URL=https://chattingo-app.duckdns.org
"""
      writeFile file: 'frontend/.env.production', text: frontendEnv
      echo 'Frontend .env.production created'
