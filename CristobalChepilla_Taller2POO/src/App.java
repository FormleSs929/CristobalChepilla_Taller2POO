
// ================================
// App.java
// ================================

import java.util.ArrayList;
import java.io.*;

public class App {

    public static void main(String[] args) {

        SistemaJuego sistema = new SistemaJuego();

        ArrayList<Pokemon> pokedex = cargarPokedex();

        sistema.cargarPokedex(pokedex);

        sistema.menuInicial();

    }

    
    
    public static ArrayList<Pokemon> cargarPokedex(){

        ArrayList<Pokemon> lista = new ArrayList<>();

        try{

            BufferedReader br =
                    new BufferedReader(new FileReader("Pokedex.txt"));

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

                lista.add(p);

            }

            br.close();

        }catch(Exception e){

            System.out.println("Error al cargar pokedex");

        }

        return lista;

    }

}