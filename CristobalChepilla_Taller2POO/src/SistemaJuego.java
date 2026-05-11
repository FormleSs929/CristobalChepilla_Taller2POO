
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class SistemaJuego {

    private Jugador jugador;

    private ArrayList<Pokemon> pokedex;

    private Scanner scanner;

    public SistemaJuego(){

        scanner = new Scanner(System.in);

        pokedex = new ArrayList<>();

    }
    
    public void menuInicial(){

        int opcion;

        do{

            System.out.println("1) Continuar");
            System.out.println("2) Nueva Partida");
            System.out.println("3) Salir");

            opcion = scanner.nextInt();

            switch(opcion){

                case 1:
                    continuarPartida();
                    break;

                case 2:
                    nuevaPartida();
                    break;

                case 3:
                    System.out.println("Adios entrenador");
                    break;

                default:
                    System.out.println("Opcion invalida");

            }

        }while(opcion != 3);

    }

    public void cargarPokedexArchivo(){

        try{

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("Pokedex.txt")
                    );

            String linea;

            while((linea = br.readLine()) != null){

                String[] datos = linea.split(";");

                String nombre = datos[0];

                String tipo = datos[9];

                int vida = Integer.parseInt(datos[3]);

                int ataque = Integer.parseInt(datos[4]);

                int defensa = Integer.parseInt(datos[5]);

                int ataqueEspecial = Integer.parseInt(datos[6]);

                int defensaEspecial = Integer.parseInt(datos[7]);

                int velocidad = Integer.parseInt(datos[8]);

                Pokemon p = new Pokemon(
                        nombre,
                        tipo,
                        vida,
                        ataque,
                        defensa,
                        ataqueEspecial,
                        defensaEspecial,
                        velocidad
                );

                pokedex.add(p);

            }

            br.close();

        }catch(Exception e){

            System.out.println("Error leyendo pokedex");

        }

    }

    public void nuevaPartida(){

        scanner.nextLine();

        System.out.println("Ingrese Apodo:");

        String nombre = scanner.nextLine();

        jugador = new Jugador(nombre);

        System.out.println(
                "Bienvenido " + nombre + "!!"
        );

        menuJuego();

    }

    public void continuarPartida(){

        try{

            BufferedReader br =
                    new BufferedReader(
                            new FileReader("Registros.txt")
                    );

            String linea = br.readLine();

            if(linea == null){

                System.out.println("Archivo vacio");

                br.close();

                return;

            }

            String[] datos = linea.split(";");

            jugador = new Jugador(datos[0]);

            jugador.setMedallas(Integer.parseInt(datos[1]));

            while((linea = br.readLine()) != null){

                String[] poke = linea.split(";");

                String nombre = poke[0];

                String estado = poke[1];

                for(Pokemon p : pokedex){

                    if(p.getNombre().equalsIgnoreCase(nombre)){

                        Pokemon copia =
                                new Pokemon(
                                        p.getNombre(),
                                        p.getTipo(),
                                        p.getVida(),
                                        p.getAtaque(),
                                        p.getDefensa(),
                                        p.getAtaqueEspecial(),
                                        p.getDefensaEspecial(),
                                        p.getVelocidad()
                                );

                        copia.setEstado(estado);

                        jugador.agregarPokemon(copia);

                    }

                }

            }

            br.close();

            System.out.println(
                    "Bienvenido de nuevo "
                    + jugador.getNombre()
            );

            menuJuego();

        }catch(Exception e){

            System.out.println(
                    "No existe partida guardada"
            );

        }

    }

    public void menuJuego(){

        int opcion;

        do{

            System.out.println(
                    "\n"
                    + jugador.getNombre()
                    + ", que deseas hacer?"
            );

            System.out.println("1 Revisar equipo");
            System.out.println("2 Salir a capturar");
            System.out.println("3 Acceso al PC");
            System.out.println("4 Retar gimnasio");
            System.out.println("5 Alto mando");
            System.out.println("6 Curar Pokemon");
            System.out.println("7 Guardar");
            System.out.println("8 Guardar y salir");

            opcion = scanner.nextInt();

            switch(opcion){

                case 1:

                    jugador.mostrarEquipo();

                    break;

                case 2:

                    capturarPokemon();

                    break;

                case 3:

                    accesoPC();

                    break;

                case 4:

                    retarGimnasio();

                    break;

                case 5:

                    altoMando();

                    break;

                case 6:

                    jugador.curarEquipo();

                    break;

                case 7:

                    guardarPartida();

                    break;

                case 8:

                    guardarPartida();

                    System.out.println(
                            "Nos vemos entrenador..."
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion invalida"
                    );

            }

        }while(opcion != 8);

    }

    public void capturarPokemon(){

        if(pokedex.isEmpty()){

            System.out.println(
                    "No hay pokemon cargados"
            );

            return;

        }

        Random r = new Random();

        Pokemon encontrado =
                pokedex.get(
                        r.nextInt(pokedex.size())
                );

        System.out.println(
                "Ha aparecido "
                + encontrado.getNombre()
        );

        System.out.println("1 Capturar");
        System.out.println("2 Huir");

        int opcion = scanner.nextInt();

        if(opcion == 1){

            Pokemon nuevo =
                    new Pokemon(
                            encontrado.getNombre(),
                            encontrado.getTipo(),
                            encontrado.getVida(),
                            encontrado.getAtaque(),
                            encontrado.getDefensa(),
                            encontrado.getAtaqueEspecial(),
                            encontrado.getDefensaEspecial(),
                            encontrado.getVelocidad()
                    );

            jugador.agregarPokemon(nuevo);

            System.out.println(
                    "Pokemon capturado!"
            );

        }

    }

    public void accesoPC(){

        ArrayList<Pokemon> lista =
                jugador.getPokemons();

        if(lista.size() < 2){

            System.out.println(
                    "No tienes suficientes pokemon"
            );

            return;

        }

        for(int i=0;i<lista.size();i++){

            System.out.println(
                    (i+1)
                    + ") "
                    + lista.get(i).getNombre()
            );

        }

        System.out.println("Pokemon 1");

        int p1 = scanner.nextInt() - 1;

        System.out.println("Pokemon 2");

        int p2 = scanner.nextInt() - 1;

        if(
                p1 < 0 ||
                p2 < 0 ||
                p1 >= lista.size() ||
                p2 >= lista.size()
        ){

            System.out.println("Posicion invalida");

            return;

        }

        Pokemon temp = lista.get(p1);

        lista.set(p1, lista.get(p2));

        lista.set(p2, temp);

        System.out.println(
                "Pokemons intercambiados!"
        );

    }

    public void retarGimnasio(){

        if(jugador.getPokemons().isEmpty()){

            System.out.println(
                    "No tienes pokemon"
            );

            return;

        }

        Pokemon mio =
                jugador.getPokemons().get(0);

        if(!mio.estaVivo()){

            System.out.println(
                    "Tu pokemon esta debilitado"
            );

            return;

        }

        Random r = new Random();

        Pokemon rival =
                pokedex.get(
                        r.nextInt(pokedex.size())
                );

        System.out.println(
                "Batalla contra "
                + rival.getNombre()
        );

        Batalla.pelear(mio, rival);

    }

    public void altoMando(){

        System.out.println(
                "Funcion aun no implementada"
        );

    }

    public void guardarPartida(){

        try{

            BufferedWriter bw =
                    new BufferedWriter(
                            new FileWriter("Registros.txt")
                    );

            bw.write(
                    jugador.getNombre()
                    + ";"
                    + jugador.getMedallas()
            );

            bw.newLine();

            for(Pokemon p : jugador.getPokemons()){

                bw.write(
                        p.getNombre()
                        + ";"
                        + p.getEstado()
                );

                bw.newLine();

            }

            bw.close();

            System.out.println(
                    "Partida guardada!"
            );

        }catch(Exception e){

            System.out.println(
                    "Error guardando"
            );

        }

    }
    
    public void cargarPokedex(ArrayList<Pokemon> lista){

        pokedex = lista;

    }

}