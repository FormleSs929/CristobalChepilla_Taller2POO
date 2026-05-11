
// ================================
// Pokemon.java
// ================================

public class Pokemon {

    private String nombre;
    private String tipo;

    private int vida;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;

    private String estado;

    public Pokemon(String nombre,
                   String tipo,
                   int vida,
                   int ataque,
                   int defensa,
                   int ataqueEspecial,
                   int defensaEspecial,
                   int velocidad) {

        this.nombre = nombre;
        this.tipo = tipo;

        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.ataqueEspecial = ataqueEspecial;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;

        estado = "Vivo";

    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean estaVivo(){

        return estado.equalsIgnoreCase("Vivo");

    }

    public void debilitar(){

        estado = "Debilitado";

    }

    public void curar(){

        estado = "Vivo";

    }

    public int getStatsTotales(){

        return vida
                + ataque
                + defensa
                + ataqueEspecial
                + defensaEspecial
                + velocidad;

    }
    
    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

}