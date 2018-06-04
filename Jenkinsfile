   pipeline{
   agent any
   stages{
       stage('obtener repositorio'){
           steps{
               git'https://github.com/airmind97/TPI135'
           }
       }
       stage('Realizar Pruebas'){
           steps{
               sh"$MAVEN test"
           }
       }
       stage('Construir'){
           steps{
               sh"$MAVEN install"
           }
           
       }
      stage('verificar covertura'){
        steps{
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
      }
   }
}
