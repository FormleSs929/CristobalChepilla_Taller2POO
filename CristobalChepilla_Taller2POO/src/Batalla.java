
// ================================
// Batalla.java
// ================================

public class Batalla {

    public static boolean pelear(Pokemon jugador, Pokemon rival){

        int statsJugador = jugador.getStatsTotales();
        int statsRival = rival.getStatsTotales();

        System.out.println(jugador.getNombre() + " -> " + statsJugador + " puntos");
        System.out.println(rival.getNombre() + " -> " + statsRival + " puntos");

        double efectividad =
                TablaTipos.obtenerEfectividad(
                        jugador.getTipo(),
                        rival.getTipo()
                );

        if(efectividad == 2){

            statsJugador *= 2;

            System.out.println(jugador.getNombre() + " es super efectivo!");

        }else if(efectividad == 0.5){

            statsJugador /= 2;

            System.out.println(jugador.getNombre() + " no es muy efectivo!");

        }

        System.out.println("Nuevo puntaje:");
        System.out.println(jugador.getNombre() + " -> " + statsJugador);
        System.out.println(rival.getNombre() + " -> " + statsRival);

        if(statsJugador >= statsRival){

            System.out.println("Ha ganado " + jugador.getNombre());

            rival.debilitar();

            return true;

        }else{

            System.out.println("Ha ganado " + rival.getNombre());

            jugador.debilitar();

            return false;

        }

    }

}