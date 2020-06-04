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
            environment {
                BITBUCKET_COMMON_CREDS_USR = credentials('docker-repository-username')
                BITBUCKET_COMMON_CREDS_PSW = credentials('docker-repository-password')
            }
             steps{
                 sh  'echo $pwd'
                 sh  'echo ${NODE_NAME}'
                 sh  'echo ${BUILD_TAG}'
                 sh  'docker build -t ccr.ccs.tencentyun.com/zhangsanmu/api-blog:dev-${BUILD_NUMBER} .'
                 sh  'docker login --username=$BITBUCKET_COMMON_CREDS_USR ccr.ccs.tencentyun.com --password $BITBUCKET_COMMON_CREDS_PSW'
                 sh  'docker push ccr.ccs.tencentyun.com/zhangsanmu/api-blog:dev-${BUILD_NUMBER}'
                 sh  'docker rmi ccr.ccs.tencentyun.com/zhangsanmu/api-blog:dev-${BUILD_NUMBER}'
             }
        }
    }
}