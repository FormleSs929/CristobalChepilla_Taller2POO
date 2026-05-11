
import java.util.ArrayList;

public class AltoMando {

    private int numero;

    private String nombre;

    private ArrayList<Pokemon> pokemons;

    public AltoMando(int numero, String nombre) {

        this.numero = numero;
        this.nombre = nombre;

        pokemons = new ArrayList<>();

    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void agregarPokemon(Pokemon p){

        pokemons.add(p);

    }

}