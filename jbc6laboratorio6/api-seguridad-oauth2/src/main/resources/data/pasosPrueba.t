https://github.com/irojascorsico/oauth2/blob/main/README.md
https://www.youtube.com/watch?v=oHiIBkSv3nw

Para probar la conexion al cliente y obtener un token valido para consumir el recurso
1.- Ingresar a la URL : https://oauthdebugger.com/
2.- Completar los datos de prueba:
    Authorize URI (required): http://localhost:8080/oauth2/authorize
    Redirect URI (required): https://oauthdebugger.com/debug
    Client ID (required): admin
    Scope (required): openid
3.- Al ejecutar esto en la pagina nos devolvera un "Authorization code" el cual copiaremos 
4.- Luego usaremos en el postman "generarToken"  y remplazando el valor de "code"
4.- Al ejecutar si esto es valido nos devolvera un "access_token" el cual copiaremos
5.- Luego usaremos en el postman "probarToken" el "access_token" en la Authorization de tipo Bearer Token
6.- Listo tenemos el resultado 