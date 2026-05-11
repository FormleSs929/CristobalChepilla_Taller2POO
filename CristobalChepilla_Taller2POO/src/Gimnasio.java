
import java.util.ArrayList;

public class Gimnasio {

    private int numero;
    private String lider;
    private String estado;

    private ArrayList<Pokemon> pokemons;

    public Gimnasio(int numero, String lider, String estado) {

        this.numero = numero;
        this.lider = lider;
        this.estado = estado;

        pokemons = new ArrayList<>();

    }

    public int getNumero() {
        return numero;
    }

    public String getLider() {
        return lider;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void agregarPokemon(Pokemon p){

        pokemons.add(p);

    }

}