def call(String deploymentFile, String kubeconfigCredId, String branchName ) {
    
    withCredentials([file(credentialsId: kubeconfigCredId , variable: 'KUBECONFIG')]) {
        
	echo "___deploy-function___"
	sh "sed -i 's|image:.*|image: ${IMAGE_NAME}:v${BUILD_NUMBER}|' ${deploymentFile}"	
	sh "kubectl --kubeconfig=$KUBECONFIG apply -f ${deploymentFile} -n ${branchName} "
    }
}
