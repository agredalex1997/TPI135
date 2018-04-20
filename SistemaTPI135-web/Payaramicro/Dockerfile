FROM payara/micro:5.181
MAINTAINER rm13016 rm13016@ues.edu.sv
ADD  SistemaTPI135-web-1.0-SNAPSHOT.war $PAYARA_PATH/deployments/SistemaTPI135-web-1.0-SNAPSHOT.war
ADD mysql-connector-java-5.0.8-bin.jar $PAYARA_PATH
ADD postbootfile.txt $PAYARA_PATH
ENTRYPOINT java -jar $PAYARA_PATH/payara-micro.jar --addlibs $PAYARA_PATH/mysql-connector-java-5.0.8-bin.jar --postbootcommandfile $PAYARA_PATH/postbootfile.txt --deploy $PAYARA_PATH/deployments/SistemaTPI135-web-1.0-SNAPSHOT.war

