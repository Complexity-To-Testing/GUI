# GUI
## Descripcion
Servicio web desarollado para el TFG Complexity to testing que permite aplicar pruebas sobre los mutantes (generados mediante [Pitest](http://pitest.org/) ) de  programas:
 + cuya estructura se ha generado automáticamente (con el [programa generador de programa](https://github.com/Complexity-To-Testing/Programa-generador)).
 + cuya estructura se ha desarollado de forma manual (programa [Math](https://github.com/Complexity-To-Testing/Programas-reales-JAVA/tree/master/ClassMath) o programa [Personaje](https://github.com/Complexity-To-Testing/Programas-reales-JAVA/tree/master/claseNodo)).

## Estructura de los directorios del servicio web
![myimage-alt-tag](https://lh3.googleusercontent.com/PjI9hG26PQLzRR3Ft07ELWd6YX9_jM4R8f0yHaI47Isayr_KyR99rbN8ecPQX3FPuP7_t0cyJJhEFg=w2880-h1564)
**Proyecto Node (GUI-Master)**: directorio que contiene todo el proyecto. Dentro se encuentra el resto de los directorios que veremos a continuación. Además, también almacena los scripts .sh que se encargan de controlar las rutas de los ficheros, modificaciones de cadenas de caracteres y limpieza de proyectos anteriormente cargados y/o ejecutados, así como los ficheros .js encargados de poner en marcha el proyecto y almacenar la configuración de la base de datos.

**controllers**: almacena los ficheros .js que se encargan de llevar a cabo la gestión de peticiones (ya sean tipo GET o POST) que realiza el usuario a través de la interfaz web. Si el usuario introduce parámetros, estos ficheros contienen funciones que los recogen y los tratan como sea necesario. Además, también realizan peticiones a la capa de integración, es decir, son los encargados de llamar a los DAO para obtener datos de la base de datos y subirlos de nuevo a las capas superiores para que finalmente sean mostrados al usuario.

**generadorMutantesJAVA**: contiene el proyecto Java que, a su vez, contiene el código del programa que se ha generado de manera automática.

**generadorProgramasJAVA**: contiene el proyecto Java que, a su vez, contiene el código de la aplicación que permite generar programas Java de manera automática y generar tests para aplicarlos en los programas generados.

**helpers**: contiene algunas funciones programadas en Javascript que permiten facilitar nuestra interacción con la base de datos a la hora de realizar las querys e importar/exportar datos.

**integration**: contiene las funciones que acceden a la base de datos para importar/exportar datos. Estas funciones son llamadas por los controladores que, tal y como hemos visto anteriormente, se encuentra en la carpeta controllers.
