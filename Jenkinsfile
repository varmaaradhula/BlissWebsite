pipeline{
    agent any
    tools{
        maven "MAVEN3"
        jdk "OracleJDK11"
    }
    stages{
        stage('Fetch Code'){
            steps{
                git branch: 'parallel', url: 'https://github.com/varmaaradhula/BlissWebsite.git'
            }
        }

        stage('run selenium-hub container'){
        steps{
        docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:latest
        }
        }
        stage('run selenium-node-chrome container'){
        steps{
        docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
            --shm-size="2g" \
            -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
            -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
            selenium/node-chrome:latest
              }
                }
        stage('run selenium-node-edge container'){
                steps{
                docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
                    --shm-size="2g" \
                    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
                    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
                    selenium/node-edge:latest
                      }
                        }
        stage('run selenium-node-edge container'){
                                    steps{
                                        docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
                                            --shm-size="2g" \
                                            -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
                                            -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
                                            selenium/node-firefox:latest
                                              }
                                                }
        stage('UNTITEST'){
            steps{
                sh 'mvn test'
            }
        }


}
}