def call( String imageName, String buildNumber ) {
    
    echo "___Build-And-Push___"
    sh """
        docker build -t ${imageName}:v${buildNumber} .
        docker push ${imageName}:v${buildNumber}
    """
}
