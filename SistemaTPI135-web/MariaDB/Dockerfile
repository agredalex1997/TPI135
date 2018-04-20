FROM mariadb:10.3.5

MAINTAINER rm13016 rm13016@ues.edu.sv

ENV MYSQL_ROOT_PASSWORD=1234
ENV MYSQL_DATABASE=mantenimientoTpi

ADD mantenimientoTpi.sql /docker-entrypoint-initdb.d/mantenimientoTpi.sql 
CMD ["mysqld"]
EXPOSE 3306


