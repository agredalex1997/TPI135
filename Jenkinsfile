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
         withSonarQubeEnv('My SonarQube Server') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
      }
   }
}
