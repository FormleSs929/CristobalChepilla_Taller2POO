
// ================================
// Jugador.java
// ================================

import java.util.ArrayList;

public class Jugador {

    private String nombre;

    private int medallas;

    private ArrayList<Pokemon> pokemons;

    public Jugador(String nombre) {

        this.nombre = nombre;

        medallas = 0;

        pokemons = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public int getMedallas() {
        return medallas;
    }

    public void setMedallas(int medallas) {
        this.medallas = medallas;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void agregarPokemon(Pokemon p){

        pokemons.add(p);

    }

    public void mostrarEquipo(){

        if(pokemons.isEmpty()){

            System.out.println("No tienes pokemon.");
            return;

        }

        System.out.println("Equipo actual:");

        for(int i=0;i<pokemons.size();i++){

            Pokemon p = pokemons.get(i);

            System.out.println(
                    (i+1) + ") "
                    + p.getNombre()
                    + " | "
                    + p.getTipo()
                    + " | Stats: "
                    + p.getStatsTotales()
                    + " | Estado: "
                    + p.getEstado()
            );

        }

    }

    public void curarEquipo(){

        for(Pokemon p : pokemons){

            p.curar();

        }

        System.out.println("Todos los pokemon fueron curados!");

    }

}