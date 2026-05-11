# Taller 02 – POO

## Descripción del proyecto

Programa desarrollado en Java que simula un juego de Pokémon por consola.  
El jugador puede crear o continuar una partida, capturar Pokémon, combatir contra gimnasios y administrar su equipo mediante distintas mecánicas inspiradas en los juegos originales de Pokémon.

---

## Integrantes

- Cristóbal Nicolás Chepilla Arriagada  
  RUT: 21873055-8  
  GitHub: FormleSs929

---

## Estructura del proyecto

### Clases principales

- `App.java`
  - Clase principal del programa.
  - Inicializa el sistema y carga la Pokédex.

- `SistemaJuego.java`
  - Controla los menús y la lógica principal del juego.

- `Jugador.java`
  - Representa al jugador y su colección de Pokémon.

- `Pokemon.java`
  - Modela los atributos y comportamiento de un Pokémon.

- `Batalla.java`
  - Contiene la lógica de combate entre Pokémon.

- `TablaTipos.java`
  - Maneja la efectividad de tipos mediante una matriz bidimensional.

- `Gimnasio.java`
  - Representa a un líder de gimnasio y su equipo.

- `AltoMando.java`
  - Representa a un integrante del Alto Mando.

---

## Archivos utilizados

- `Pokedex.txt`
- `Registros.txt`
- `Gimnasios.txt`
- `AltoMando.txt`
- `Habitats.txt`

---

## Instrucciones de ejecución

1. Abrir el proyecto en Eclipse.
2. Verificar que los archivos `.txt` estén en la raíz del proyecto.
3. Ejecutar la clase `App.java`.
4. Utilizar la consola para interactuar con el juego.

---

## Funcionalidades implementadas

- Nueva partida
- Continuar partida
- Captura de Pokémon
- Sistema de combate
- Efectividad de tipos
- Revisar equipo
- Acceso al PC
- Curar Pokémon
- Guardado de partida
- Persistencia de datos mediante archivos
