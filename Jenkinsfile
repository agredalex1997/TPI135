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
               sh"$MAVEN clean install"
           }
           
       }
   
   }
}
