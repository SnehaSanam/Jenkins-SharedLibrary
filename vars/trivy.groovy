def call() {
   stage("Trivy: Filesystem scan"){
            steps{
                sh "trivy fs ."
            }
        }
