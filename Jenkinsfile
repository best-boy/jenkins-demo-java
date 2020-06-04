node{
    agent {
        docker {
            image 'maven:3.6.1'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('test') {
             steps{
                 sh 'mvn test'
             }
        }
        stage('deploy'){
             steps{
                 sh 'echo $pwd;ls'
                 def customImage = docker.build("ccr.ccs.tencentyun.com/zhangsanmu/api-blog:test")
                 customImage.push()
             }
        }
    }
}