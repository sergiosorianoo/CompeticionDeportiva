# Competicion_Deportiva
 DAW. Programación. Tema 8. Ejercicio evaluación 6

Proyecto Competición Deportiva
Una empresa dedicada a realizar software para gestión de eventos deportivos para niveles
deportivos no profesionales (benjamines, mini, juveniles y cadetes) nos realiza el encargo
de un prototipo, mediante una aplicación JAVA que cumpla con los siguientes requisitos:
- Gestionará los equipos y jugadores de una competición determinada. En nuestro
prototipo, sólo crearemos en cada ejecución UNA SOLA COMPETICIÓN. Para ello
le tenemos que proporcionar los datos de la competición: código de competición (se
trata de un String que se conforma con las iniciales del deporte y un número
asignado por la federación deportiva correspondiente, por ejemplo, fu356 sería para
futbol, ba10 sería baloncesto, esto lo define el usuario una vez consultada la
federación oportuna), descripción y provincia de realización.
- El programa nos permitirá añadir, eliminar, buscar y listar los equipos de la
competición. Se entiende que añadir, eliminar, actualizar es de un único único equipo
mientras que buscar o listar (todos) nos dan 0 a muchos equipos. Para buscar un
equipo buscaremos proporcionando la ciudad de origen (es decir, buscar obtiene el
listado de equipos de esa ciudad). Para listar, no es necesario proporcionar ningún
dato pues da como resultado un listado con todos los equipos. Permitiremos borrar
un equipo si no tiene jugadores, si tiene jugadores, no podemos dejar que se
elimine.
- Si proporcionamos el código de equipo (String con 5 caracteres) se puede dar de
alta un jugador, dar de baja un jugador, poner un jugador como no disponible
(lesionado o enfermo) o poner un jugador como disponible (recuperado de una
enfermedad o lesión).
- Para dar de alta un equipo necesitamos su código (lo proporciona la federación, 5
caracteres), su descripción, el nombre y apellidos del responsable del equipo, la
ciudad de origen, un email y un teléfono de contacto. Para dar de alta un jugador/a
en un equipo necesitamos su nombre, sus apellidos, su dorsal (número entre 0 y
100), su dni (es obligatorio aunque sea menor de edad), un email y un teléfono de
contacto. Inicialmente un jugador/a estará activo, pero si a lo largo del tiempo se
lesiona o cae enfermo, se pondrá como “no disponible”. Eso sí, cuando se recupere,
se pondrá disponible de nuevo.
- Si al programa le damos el código de un equipo, será capaz de darnos en pantalla
un listado de los jugadores activos que tiene, o un listado de los inactivos
(lesionados y enfermos).

- Almacenaremos los equipos en una lista, y los jugadores dentro de un equipo en un
mapa donde usaremos el dni como clave.
- En el menú principal, en modo texto (consola), tendremos las opciones:

A. Proporcionar datos de la competición.
B. Añadir un nuevo equipo
C. Eliminar un equipo existente
D. Buscar equipos de una localidad.
E. Listar todos los equipos.
F. Dar de alta un nuevo jugador en un equipo
G. Eliminar un jugador en un equipo
H. Cambiar estado/disponibilidad de un jugador de un equipo.
Nota: Cuando se añade un jugador a un equipo, tenemos que comprobar que el
jugador no existe ya en ese equipo. Igual con los equipos en la competición, se
añaden nuevos equipos si no hay ningún equipo con el mismo código previamente
dado de alta.
Además, en papel, hay que realizar previamente el método de la opción H, con esta
definición:
//Dentro de la clase Equipo, teniendo un mapa Map<String,Jugador> misJugadores
public boolean cambiarDisponibilidad(String dniJugador, boolean disponible) {
...
}
Donde el método devolverá true si existe el jugador y false si no existe. En el caso de que
exista, cambia mediante el método que estimes oportuno la disponibilidad del jugador
(disponible = true -> está perfecto, disponible = false -> está enfermo o lesionado)
Al finalizar, tenemos que tener las clases: Main (menú de texto, vista de la aplicación),
Competicion, Equipo y Jugador. Exceptuando la opción H, eres libre de escoger los
nombres de los atributos, métodos, etc.
