def call(String deploymentFile, String kubeconfigCredId ) {
    
    withCredentials([file(credentialsId: kubeconfigCredId , variable: 'KUBECONFIG')]) {
        
	echo "___deploy-function___"
	sh "kubectl --kubeconfig=$KUBECONFIG apply -f ${deploymentFile}"
    }
}
