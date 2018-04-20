Compilar la imagen 
        docker build  -t mariadbtpi:IR13002 .

Ver errores del contenedor
        docker logs -f cointername


VOLUMENES

Procederemos a crear dos contenedores uno para DATOS(nunca se debe de borrar y no es necesario estar corriendo) y
otro para EJECUCION(Este se puede borrar)

contenedor DATOS
 
	docker run -d -v /var/lib/mysql --name data-mariadb --entrypoint /bin/echo mariadbtpi:IR13002

contenedor en EJECUCION
	
	docker run --rm -it --name mdbtpi -p 3300:3306 -d --volumes-from data-mariadb mariadbtpi:IR13002
