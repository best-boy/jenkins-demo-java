pipeline {
    agent {
        docker {
            image 'maven:3.6.1'
            args '-v /root/.m2:/root/.m2 -v /usr/bin/docker:/usr/bin/docker -v /var/run/docker.sock:/var/run/docker.sock'
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
                 sh 'echo $pwd; ls;docker images;docker build -t ccr.ccs.tencentyun.com/zhangsanmu/api-blog:test .;docker push ccr.ccs.tencentyun.com/zhangsanmu/api-blog:test'
             }
        }
    }
}