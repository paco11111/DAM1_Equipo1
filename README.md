# DOCUMENTACION
## BASE DE DATOS:

La base de datos consiste en un login el cual compara email y password (md5)
Luego una vez dentro hay Profesores que son Jefes de un departamento,los profesores pueden solicitar las actividades de dos maneras,profesores responsables y profesores participantes
Cuando un profesor hace una solicitud,tiene que indicar que tipo de actividad es,informacion sobre el transporte, fecha de inicio y fin, si tiene alojamiento o no y
comentarios adicionales.
Tambien se almacena el estado de la solicitud y se gestionan los grupos y cursos que van
Las solicitudes aprobadas tienen fotos de la actividad
### DIAGRAMA ENTIDAD/RELACION:
![](https://github.com/paco11111/DAM1_Equipo1/blob/c6135681e80cb1d4b6eb9457ecdeebb26fa9f002/Recursos/ER.png)
### DIAGRAMA RELACIONAL:
![](https://github.com/paco11111/DAM1_Equipo1/blob/af0f0d5bf080ea94b2cd20c9638e1d178b148c28/Recursos/BDR.png)

### [DESCARGAR BASE DE DATOS](https://educantabria.sharepoint.com/sites/RetoDAM1_2324-Equipo1/_layouts/15/download.aspx?UniqueId=fe7c0036%2D0362%2D45c9%2D9cb9%2D66873cc8c9d8)

## PAGINA WEB

Hemos decidido estructurar nuestra página basándonos en diseños de otras páginas de centros reales analizando los factores comunes en todas ellas y eligiendo las partes que más nos han llamado la atención.

La página está planteada de tal manera que puedas acceder a cualquier parte con dos clics como máximo. 

ÍNDICE
1.Paleta de colores

2.Navbar

3.Footer

4.Página de inicio

5.Página de actividades
5.1.Pagina de grandes exitos
5.2.Página de actividades solicitadas
5.3.Página de actividades solicitadas

6.Página de solicitudes

7.Página de contacto

8.Página de fotos
	8.1.Página de fotos anual















NAVBAR
El header es simple y sobrio para que no destaque sobre la información que aparece en la página, pero esa sencillez ayuda al usuario a desplazarse por la página. Al aplicar la paleta de colores de la página (blanco y nego con gradientes de los mismos) se ve una barra negra con letras blancas mayúsculas, al desplazar el raton por encima de los nombres de los apartados se remarcaba el recuadro que ocupa ese apartado en la navbar. Los apartados que tengan subclases contarán con un menú desplegable que se abrirá al pasar por encima, este desplegable será parcialmente transparente hasta que se pasa el ratón por encima, en este caso  el recuadro que ocupa cambiará su color al mismo del de la navbar.

Las opciones de la navbar serán: inició, actividades(que contará con un desplegable de solicitadas y aprobadas), solicitud, fotos(con un desplegable para cada uno de los años disponibles).
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Navbar.PNG)
~~~
.navbar {
    display: flex; 
}

.logo {
    margin-left: 30px;
}

.logo a {
    text-decoration: none;
    color: #fff;
    text-transform: uppercase;
    font-size: 20px;
}

.navbar a {
    display: block;
    padding: 20px 20px;
    color: #fff;
    text-decoration: none;
    text-transform: uppercase;
    font-size: 20px;
}

.navbar a:hover {
    background: #3f3f3f;
}
~~~



FOOTER
Nuestro footer es común en todas las partes de la página. En él aparecen datos de contacto como: teléfono de contacto, dirección del centro, correo de contacto del centro y unos enlaces a las redes sociales del centro (estas son elementos interactivos que cuentan con su propio css con animaciones y efectos).
El footer está diseñado de tal manera que se adapte al tamaño de la página, de tal manera que los datos que están situados a lo ancho del footer se ordenen de manera vertical unas encima de otras manteniendo su formato y diseño.

![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/footer.PNG)
~~~
footer{
    margin-top: auto;
}
*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    list-style: none;/*SIRVE PARA QUITAR LOS PUNTOS DE LAS LISTAS*/
}

.footer{/*LAS PALABRAS QUE ESTEN DESNTRO DE ESTE CONTENEDOR EMPEZARAN SIEMPRE POR MAYUSCULA*/
    text-transform: capitalize;
    
}

.container{
    max-width: 1200px;
    margin: 0 auto;
}

.footer{
    background-color: #24262b;
    padding: 80px 0;
}

.footer-row{
    display: flex;
    flex-wrap: wrap;/*sirve para adaptar a pantalla reducida*/
}

.footer-links{
    width: 25%;
    padding: 0 15px;
}

.footer-links h4{/*sirve para modificar los h4*/
    font-size: 20px;
    color: #FFFFFF;
    margin-bottom: 25px;
    font-weight: 500;
    border-bottom: 2px solid #e2f1f8;/*la rallita de debao de los h4*/
    padding-bottom:5px;/*SEPARA LA RALLITTA DE LA PALABRA*/
    display: inline-block;
}

.footer-links ul li a{
font-size: 18px;
text-decoration: none;
color: #BBBBBB;
display: block;
margin-bottom: 15px;
transition: all .3s ease;/*ANIMACION*/
}
~~~

)

PÁGINA DE INICIO
La página de inicio es simple dividido en bandas horizontales para diferenciar los segmentos y se pueda ver donde esta la informacion o como acceder a ella fácilmente. Cada un a de estas bandas tiene el titulo de la pagina a la que enlaza en grande centrado y con contraste con el fondo(es decir, si el fondo es blanco el titulo es negro y viceversa). Debajo de este título hay un botón con el que podremos acceder a las páginas referenciadas en el título.
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio1.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio2.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio3.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio4.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio5.PNG)

~~~
* {
    border: 0;
    margin: 0;
    padding: 0;
    font-size: 100%;
    vertical-align: baseline;
}
~~~

~~~
section {
    padding: 20px;
    margin:20px auto;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    max-width: 800px;
    border: 1px solid black;
    
}
~~~

PÁGINA DE ACTIVIDADES
Esta página aparece de forma directa en el navegador con el título (“ACTIVIDADES”) del cual se despliegan las opciones aprobadas y solicitadas.

La página actividades cuenta con tres láminas seleccionables con nombre “GRANDES EXITOS”,”SOLICITADAS”,”APROBADAS”, las cuales son seleccionables y al clickar encima te llevarán a la página correspondiente.

Además de fondo hemos puesto la imagen del centro  y un carrusel automático que va enseñando imágenes de las diferentes actividades ya realizadas en el pasado. 
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Actividades.PNG)


PÁGINA ACT. ANUALES
Esta sección nos mostrará las actividades que se realizan anualmente en el centro o  a nivel regional/nacional

El formato en el que se mostraran las actividades así como los datos de las mismas será muy similar al usado en otras secciones de la página, con una distribución laminada en la que aparecerá un recuadro con el título de la actividad y una foto de la misma de fondo. 
La información de la actividad aparecerá maquetada, siendo esta el nombre del profesor a profesores que irán acompañado del rol de estos profesores en el desarrollo de la actividad, el tiempo estimado de la actividad así como el día en el que se realizará y las necesidades del transporte. También aparece una pequeña descripción de la actividad.

PÁGINA ACT.SOLICITADAS
Esta sección nos mostrará las actividades que están solicitudes pero aún no se han aprobado.

El formato en el que se mostraran las actividades así como los datos de las mismas será muy similar al usado en otras secciones de la página, con una distribución laminada en la que aparecerá un recuadro con el título de la actividad y una foto de la misma de fondo.

La información de la actividad aparecerá maquetada, siendo esta el nombre del profesor a profesores que irán acompañado del rol de estos profesores en el desarrollo de la actividad, el tiempo estimado de la actividad así como el día en el que se realizará y las necesidades del transporte. También aparece una pequeña descripción de la actividad.
El formato en el que se mostraran las actividades así como los datos de las mismas será muy similar al usado en otras secciones de la página, con una distribución laminada en la que aparecerá un recuadro con el título de la actividad y una foto de la misma de fondo. 
La información de la actividad aparecerá maquetada, siendo esta el nombre del profesor a profesores que irán acompañado del rol de estos profesores en el desarrollo de la actividad, el tiempo estimado de la actividad así como el día en el que se realizará y las necesidades del transporte. También aparece una pequeña descripción de la actividad.

![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/actv.solicitadas.PNG)

PÁGINA ACT.APROBADAS
Esta sección nos mostrará las actividades que están aprobadas.

El formato en el que se mostraran las actividades así como los datos de las mismas será muy similar al usado en otras secciones de la página, con una distribución laminada en la que aparecerá un recuadro con el título de la actividad y una foto de la misma de fondo. 

La información de la actividad aparecerá maquetada, siendo esta el nombre del profesor a profesores que irán acompañado del rol de estos profesores en el desarrollo de la actividad, el tiempo estimado de la actividad así como el día en el que se realizará y las necesidades del transporte. También aparece una pequeña descripción de la actividad.
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Aprobadas.PNG)


PÁGINA DE SOLICITUD
La página de solicitudes también cuenta con la imagen aérea del instituto de fondo a fin de darle uniformidad a la página y un estilo común que además a golpe de vista permite entender la temática de la página general y de cada una de las secciones de esta.

Para realizar una solicitud habrá que rellenar un formulario del cual algunos campos serán obligatorios y otros opcionales.

El propio formulario está dentro de un recuadro para distinguirlo fácilmente de la imagen de fondo además de proporcionar un diseño minimalista. Los a introducir son: nombre, identificación(ya que el programa distingue entre distintos niveles y permite realizar algunas acciones solo en unos),nombre de la actividad, descripción de la actividad(estos datos se mostrarán en los apartados de actividades), información de transporte, tamaño estimado del grupo, fecha de inicio y de finalización de la actividad y la información sobre el alojamiento si es necesario.

Por ultimo los botones de esta seccion para enviar el formulario cuneta con un diseño distinto, cambiando el color azul por la tonalidad de negro que comparte con el footer y el header.

![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Solicitud.PNG)

PÁGINA DE CONTACTO
Esta sección es la más sencilla de todas ya que parte de la información que debería aparecer en esta está representada en el footer. Por lo exterior hemos decidido conservar la estética simple y minimalista de la página y en esta sección plantear solo un formulario de contacto con un formato idéntico al usado para las solicitudes en el que se pide al usuario un nombre, un correo electrónico y se le da un espacio para escribir su mensaje, el botón de enviar conserva también el formato ovalado y el color que utilizamos en el apartado solicitudes.

![](https://github.com/paco11111/DAM1_Equipo1/blob/f013d38ab6dde2e3e85fc338cd6c013a53270215/Recursos/Formulario%20de%20contacto.PNG)

PÁGINA DE FOTOS
La página de fotos mantiene la estética general de la página con las bandas horizontales en las que se presenta la información, en este caso solo se muestra el año, ya que la idea es que estas láminas al ser pulsadas por el usuario lo redirija a otra sección donde podrá ver todas las fotos de actividades que hay de ese año

![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/fotos.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/CARRUSEL.PNG)

~~~
#carrete {
    display: flex;
    justify-content: center;
    align-items: center;
    overflow-x: auto;
    padding: 20px;
}

#carrete img {
    max-width: 100%;
    max-height: 300px;
    margin-right: 10px;
}
~~~

PÁGINA DE FOTOS POR AÑO
Aquí mostraremos las fotos del año seleccionado mediante tres carruseles con distinto diseño. El primero será automático y pasara las fotos para una visualización rápida, el otro sin embargo será manual y permitirá ver la imagen con más detalle.





## PROGRAMACION
Utilizando el Patron Singleton para comunicarnos con la base de datos y el patron DAO que, implementando una interfaz, se crean una clases diseñadas para la gestion de entrada y salida de datos

Gestionamos el numero de alumnos mediante la tabla grupos, que tiene una columna almacenando el numero de alumnos de la clase

![](https://github.com/paco11111/DAM1_Equipo1/blob/337a269efc7911e054f6b1b60f88cf281e8c57b0/DC.png)
### [DESCARGAR GUIA DE DESPLIEGUE](https://euc-word-edit.officeapps.live.com/we/WordViewer/request.pdf?WOPIsrc=https%3A%2F%2Feducantabria%2Esharepoint%2Ecom%2Fsites%2FRetoDAM1%5F2324%2DEquipo1%2F%5Fvti%5Fbin%2Fwopi%2Eashx%2Ffiles%2F4c0ff03cf8a7489fbca0fd9c0769260f&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IkRhREFmalFRbXB5T1h4MlJyS19XNWx2b0xaNCJ9.eyJhdWQiOiJ3b3BpL2VkdWNhbnRhYnJpYS5zaGFyZXBvaW50LmNvbUBmNzYxMzQ4ZS0xMWQ2LTQzM2MtOWJkMC04NGIzYjg3ODFiY2EiLCJpc3MiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDBAOTAxNDAxMjItODUxNi0xMWUxLThlZmYtNDkzMDQ5MjQwMTliIiwibmJmIjoiMTcxNTg3NDI0NiIsImV4cCI6IjE3MTU5MTAyNDYiLCJuYW1laWQiOiIwIy5mfG1lbWJlcnNoaXB8Y2dhbGFudjAyQGVkdWNhbnRhYnJpYS5lcyIsIm5paSI6Im1pY3Jvc29mdC5zaGFyZXBvaW50IiwiaXN1c2VyIjoidHJ1ZSIsImNhY2hla2V5IjoiMGguZnxtZW1iZXJzaGlwfDEwMDMyMDAwZjE5NTFhMjdAbGl2ZS5jb20iLCJzaWQiOiI2MzEzYTJmZS1kZTY5LTRjYzUtOWQxMC01YWNjMjE3YzJkMDgiLCJzaWduaW5fc3RhdGUiOiJbXCJrbXNpXCJdIiwieG1zX2NjIjoiW1wiQ1AxXCJdIiwieG1zX3NzbSI6IjEiLCJpc2xvb3BiYWNrIjoiVHJ1ZSIsImFwcGN0eCI6IjRjMGZmMDNjZjhhNzQ4OWZiY2EwZmQ5YzA3NjkyNjBmO01NSW9kVHVrMnhacDRTTFIyUlQ3cU9HcTNsTT07RGVmYXVsdDs7MUIwM0M0MzFBRUY7VHJ1ZTs7OzUxMjswMDQ0MjlhMS0yMDc3LTgwMDAtZGI4OS1kZjk2ZjM5ODE1OGYiLCJmaWQiOiIxODk1NDkifQ.wwKcX6Q4WvGoevxrDv5fRhgsY1eNHMKFrCI8taPsSvVxJRSFf1c49xtESFsTG1_g0hyaVtiGlZZpApMsotWnQciKYnqflJJpFZeElaztX_g9X3HZq75WMh7UfUkynxEg5WNAuYAcRdJy1IF1jxBeN_aDuOrTuL5bB5JBFb_fnWgsN4ZaZtCgE-RJPkSaoCLuCUvnNw7pKUq6PJuvuDQsquHcN_WeQp4_-kSJr8BI_N4DYfII1eIKJChXWkgE3PekLlk1wbFgPcEcjbAndnDb52bPftpA5Fome2tpWL3vfzE6fZ6cC8jvCmiFL0PH4-n4Q3LaeHIdRJUsVKpJLQQM4g&access_token_ttl=1715910246940&type=downloadpdfwithoutcomments&rndm=c8417672-dd5c-4977-adc0-1490c285ed52&usid=be5c032e-633e-8809-a0ec-cb8b6da4fb14&build=20240514.6&waccluster=GEU9)
### [DESCARGAR MANUAL DE USUARIO](https://euc-word-edit.officeapps.live.com/we/WordViewer/request.pdf?WOPIsrc=https%3A%2F%2Feducantabria%2Esharepoint%2Ecom%2Fsites%2FRetoDAM1%5F2324%2DEquipo1%2F%5Fvti%5Fbin%2Fwopi%2Eashx%2Ffiles%2Fe5289e0fd50644659d7aee43e47d5ea0&access_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6IkRhREFmalFRbXB5T1h4MlJyS19XNWx2b0xaNCJ9.eyJhdWQiOiJ3b3BpL2VkdWNhbnRhYnJpYS5zaGFyZXBvaW50LmNvbUBmNzYxMzQ4ZS0xMWQ2LTQzM2MtOWJkMC04NGIzYjg3ODFiY2EiLCJpc3MiOiIwMDAwMDAwMy0wMDAwLTBmZjEtY2UwMC0wMDAwMDAwMDAwMDBAOTAxNDAxMjItODUxNi0xMWUxLThlZmYtNDkzMDQ5MjQwMTliIiwibmJmIjoiMTcxNTg4MTM1NSIsImV4cCI6IjE3MTU5MTczNTUiLCJuYW1laWQiOiIwIy5mfG1lbWJlcnNoaXB8Y2dhbGFudjAyQGVkdWNhbnRhYnJpYS5lcyIsIm5paSI6Im1pY3Jvc29mdC5zaGFyZXBvaW50IiwiaXN1c2VyIjoidHJ1ZSIsImNhY2hla2V5IjoiMGguZnxtZW1iZXJzaGlwfDEwMDMyMDAwZjE5NTFhMjdAbGl2ZS5jb20iLCJzaWQiOiI2MzEzYTJmZS1kZTY5LTRjYzUtOWQxMC01YWNjMjE3YzJkMDgiLCJzaWduaW5fc3RhdGUiOiJbXCJrbXNpXCJdIiwieG1zX2NjIjoiW1wiQ1AxXCJdIiwieG1zX3NzbSI6IjEiLCJpc2xvb3BiYWNrIjoiVHJ1ZSIsImFwcGN0eCI6ImU1Mjg5ZTBmZDUwNjQ0NjU5ZDdhZWU0M2U0N2Q1ZWEwO01NSW9kVHVrMnhacDRTTFIyUlQ3cU9HcTNsTT07RGVmYXVsdDs7MUIwM0M0MzFBRUY7VHJ1ZTs7OzUxMjtjODRhMjlhMS03MDE5LTgwMDAtZDI4NC0zNzE3MTU2ZGEyMmMiLCJmaWQiOiIxODk1NDkifQ.snOdWfrPwM_OGot_j9XI_hshXqnzuAjTodur2AQ18okYfSAKP42p54GQwM9-q6LOsP1fwKsJ7vKsJtUBf_NNW9cmcWSFYxxn54jfNyHeuG7BrWzPHIFOav6oOT_oxqeOZ4r5KAyaKYtAzYjnFELm9DrSqVUUX1Yfw5w0RemP4sAWq68CDIVS597frCQCgWyTyip0VRUSdoMHWkNvkuXFx-DKHzG9QQJ426kSFb36ZK3sIlZCJJYE7PrlVd-ihOMNA3rU3ZfBm1pFqGei9qGU1alxRDWgazSChzPjc5XZlgMI2NwkfAJMQTddUuhNQSKKn6-ksopK4FJO9R0YP_sXNw&access_token_ttl=1715917356629&type=downloadpdfwithoutcomments&rndm=5e929d5a-0e5d-4b71-9a09-883d6ab2c31d&usid=bbbec8a2-8007-a3dd-3089-e8830f3deb25&build=20240515.5&waccluster=GEU3)

