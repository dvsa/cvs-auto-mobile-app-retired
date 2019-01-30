def label = "jenkins-node-${UUID.randomUUID().toString()}"
podTemplate(label: label, containers: [
    containerTemplate(name: 'maven', image: '086658912680.dkr.ecr.eu-west-1.amazonaws.com/cvs/maven-builder:latest', ttyEnabled: true, command: 'cat'),])
    {
    node(label) {
        container('maven'){
            
            APP_ID=""

            stage('checkout') {
                checkout scm
            }
            
            stage('install ipa in browserstack') {
                sh "wget -O CVSMobile.ipa ${IPA}"
                withCredentials([usernameColonPassword(credentialsId: 'browserstack-uploader', variable: 'BROWSERSTACK_CREDS')]) {
                   APP_ID=sh(script: 'curl -u $BROWSERSTACK_CREDS -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@CVSMobile.ipa" | jq ".app_url"',returnStdout: true).trim()
                }
            }
            
            stage ("test") { 
                browserstack('browserstack') {	
                    sh "mvn --batch-mode clean install -PCI-Browserstack -DBROWSERSTACK_APP_ID=${APP_ID} -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn"
		}
            }
            
            stage("create report"){
                publishHTML (target: [ allowMissing: false,
                 alwaysLinkToLastBuild: false,
                 keepAll: true,
                 reportDir: 'target/site/serenity',
                 reportFiles: 'index.html',
                 reportName: 'DVSA CVS Mobile Automation',
                 reportTitles: 'DVSA CVS Mobile Automation'
               ])
            }
    	}
    }
}
