def call() {
   stage("Trivy: Filesystem scan"){
                sh "trivy fs ."
            }
        }
