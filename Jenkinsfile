pipeline{
   agent any
   stages{
       stage('obtener repositorio'){
           steps{
               git'https://github.com/airmind97/TPI135'
           }
       }
       stage('Pruebas de unidad'){
           steps{
               sh"$MAVEN test"
           }
       }
       stage('verificar covertura'){
        steps{
           sh"$MAVEN clean org.jacoco:jacoco-maven-plugin:prepare-agent install"
           sh"$MAVEN sonar:sonar -Dsonar.host.url=http://172.17.0.2:9000"
    }
      }
       stage('Construir'){
           steps{
               sh"$MAVEN -B -DskipTests clean package"
           }
       }
       stage('copiar artifact'){
         steps{
             step([$class: 'ArtifactArchiver', artifacts: 'SistemaTPI135-web/Payaramicro/*.war'])
              }
      }
      
       stage('Construir & enviar al registry'){
            steps{
                script {
                    echo "Build in server"
                    withDockerServer([uri:"tcp://172.17.0.1:2376"]) { s->
                            def app = docker.build('127.0.0.1:5000/mariadbtpi:latest', 'SistemaTPI135-web/MariaDB/.')
                        withDockerRegistry([url:'https://127.0.0.1:5000']) { r->
                                app.push("latest")
                        }
                    }
                }
            }
        }
   
   }
}
