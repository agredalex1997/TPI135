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
   }
}
