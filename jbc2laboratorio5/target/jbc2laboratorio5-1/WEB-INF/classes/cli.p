#PARA MOSTRAR EL PID DEL PUERTO 80 
netstat -aon | findstr ":80" 
#Eliminar el puerto activo 
taskkill /F /PID [numero del pid]

#Compilar en consola
mvn clean install