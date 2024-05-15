# DOCUMENTACION
## BASE DE DATOS:

La base de datos consiste en un login el cual compara email y password (md5)
Luego una vez dentro hay Profesores que son Jefes de un departamento,los profesores pueden solicitar las actividades de dos maneras,profesores responsables y profesores participantes
Cuando un profesor hace una solicitud,tiene que indicar que tipo de actividad es,informacion sobre el transporte, fecha de inicio y fin, si tiene alojamiento o no y
comentarios adicionales.
Tambien se almacena el estado de la solicitud y se gestionan los grupos y cursos que van
Las solicitudes aprobadas tienen fotos de la actividad
![](ER.png)
![](https://github.com/paco11111/DAM1_Equipo1/blob/819450778aa33353f1181a760f5cb26825788a63/Markdown/BDR.png)

## PAGINA WEB

<<<<<<< HEAD
=======
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



FOOTER
Nuestro footer es común en todas las partes de la página. En él aparecen datos de contacto como: teléfono de contacto, dirección del centro, correo de contacto del centro y unos enlaces a las redes sociales del centro (estas son elementos interactivos que cuentan con su propio css con animaciones y efectos).
El footer está diseñado de tal manera que se adapte al tamaño de la página, de tal manera que los datos que están situados a lo ancho del footer se ordenen de manera vertical unas encima de otras manteniendo su formato y diseño.

![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/footer.PNG)

PÁGINA DE INICIO
La página de inicio es simple dividido en bandas horizontales para diferenciar los segmentos y se pueda ver donde esta la informacion o como acceder a ella fácilmente. Cada un a de estas bandas tiene el titulo de la pagina a la que enlaza en grande centrado y con contraste con el fondo(es decir, si el fondo es blanco el titulo es negro y viceversa). Debajo de este título hay un botón con el que podremos acceder a las páginas referenciadas en el título.
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio1.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio2.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio3.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio4.PNG)
![](https://github.com/paco11111/DAM1_Equipo1/blob/340a34f581aa88497dc8941bc88f132de7efa4de/Recursos/Inicio5.PNG)

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
![](https://github.com/paco11111/DAM1_Equipo1/blob/f013d38ab6dde2e3e85fc338cd6c013a53270215/Recursos/CArrete%20de%20imagenes.PNG)

PÁGINA DE FOTOS POR AÑO
Aquí mostraremos las fotos del año seleccionado mediante tres carruseles con distinto diseño. El primero será automático y pasara las fotos para una visualización rápida, el otro sin embargo será manual y permitirá ver la imagen con más detalle.





## PROGRAMACION
![](https://github.com/paco11111/DAM1_Equipo1/blob/337a269efc7911e054f6b1b60f88cf281e8c57b0/DC.png)
[Guia de despliegue](https://educantabria.sharepoint.com/sites/RetoDAM1_2324-Equipo1/_layouts/15/download.aspx?UniqueId=4c0ff03c%2Df8a7%2D489f%2Dbca0%2Dfd9c0769260f)

