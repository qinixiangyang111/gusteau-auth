pipeline {
  agent {
    node {
      label 'maven'
    }
  }
    environment {
        DOCKER_CREDENTIAL_ID = 'dockerhub-id'
        GITHUB_CREDENTIAL_ID = 'jenkins-id'
        KUBECONFIG_CREDENTIAL_ID = 'kubeconfig-dev'
        REGISTRY = 'harbor.xinhuaapp.com'
        DOCKERHUB_NAMESPACE = 'gusteau'
        GITHUB_ACCOUNT = 'kubesphere'
        APP_NAME = 'gusteau-auth'
        PROJECT_NAME = 'gusteau'
        DIR = 'gusteau-auth'
        MAVEN_ARGS_APPEND = ''
        ARTIFACT_COPY_ARGS = 'gusteau-auth-*-SNAPSHOT.jar'
        ARTIFACT_DIR = 'gusteau-auth-war/target'
    }

    stages {
        stage ('checkout scm') {
            steps {
                checkout(scm)
            }
        }


        stage ('build & push') {
            steps {
                container ('maven') {
                    sh 'mvn -Dmaven.test.skip=true clean package'
                    withCredentials([usernamePassword(passwordVariable : 'DOCKER_PASSWORD' ,usernameVariable : 'DOCKER_USERNAME' ,credentialsId : "$DOCKER_CREDENTIAL_ID" ,)]) {
                        sh 'echo "$DOCKER_PASSWORD" | docker login https://$REGISTRY -u "$DOCKER_USERNAME" --password-stdin'
                        sh 'docker build -f Dockerfile --build-arg JAR_FILE=$ARTIFACT_COPY_ARGS  -t $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER  ./$ARTIFACT_DIR'
                        sh 'docker push  $REGISTRY/$DOCKERHUB_NAMESPACE/$APP_NAME:SNAPSHOT-$BRANCH_NAME-$BUILD_NUMBER'
                    }
                }
            }
        }



        stage('deploy to dev') {
          steps {
            kubernetesDeploy(configs: "deploy/dev/**", enableConfigSubstitution: true, kubeconfigId: "$KUBECONFIG_CREDENTIAL_ID")
          }
        }
    }
}