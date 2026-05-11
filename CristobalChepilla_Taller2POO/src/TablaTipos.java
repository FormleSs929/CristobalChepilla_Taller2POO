
// ================================
// TablaTipos.java
// ================================

public class TablaTipos {

    private static final String[] TIPOS = {
            "Normal","Fuego","Agua","Planta","Electrico",
            "Hielo","Lucha","Veneno","Tierra","Volador",
            "Psiquico","Bicho","Roca","Fantasma",
            "Dragon","Acero","Siniestro","Hada"
    };

    private static final double[][] EFECTIVIDAD = {

            {1,1,1,1,1,1,1,1,1,1,1,1,0.5,0,1,0.5,1,1},
            {1,0.5,0.5,2,1,2,1,1,1,1,1,2,0.5,1,0.5,2,1,1},
            {1,2,0.5,0.5,1,1,1,1,2,1,1,1,2,1,0.5,1,1,1},
            {1,0.5,2,0.5,1,1,1,0.5,2,0.5,1,0.5,2,1,0.5,0.5,1,1},
            {1,1,2,0.5,0.5,1,1,1,0,2,1,1,1,1,0.5,1,1,1},
            {1,0.5,0.5,2,1,0.5,1,1,2,2,1,1,1,1,2,0.5,1,1},
            {2,1,1,1,1,2,1,0.5,1,0.5,0.5,0.5,2,0,1,2,2,0.5},
            {1,1,1,2,1,1,1,0.5,0.5,1,1,1,0.5,0.5,1,0,1,2},
            {1,2,1,0.5,2,1,1,2,1,0,1,0.5,2,1,1,2,1,1},
            {1,1,1,2,0.5,1,2,1,1,1,1,2,0.5,1,1,0.5,1,1},
            {1,1,1,1,1,1,2,2,1,1,0.5,1,1,1,1,0.5,0,1},
            {1,0.5,1,2,1,1,0.5,0.5,1,0.5,2,1,1,0.5,1,0.5,2,0.5},
            {1,2,1,1,1,2,0.5,1,0.5,2,1,2,1,1,1,0.5,1,1},
            {0,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,0.5,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,0.5,1,0},
            {1,0.5,0.5,1,0.5,2,1,1,1,1,1,1,2,1,1,0.5,1,2},
            {1,1,1,1,1,1,0.5,1,1,1,2,1,1,2,1,1,0.5,0.5},
            {1,0.5,1,1,1,1,2,0.5,1,1,1,1,1,1,2,0.5,2,1}

    };

    public static double obtenerEfectividad(String atacante, String defensor){

        int fila = buscarTipo(atacante);
        int columna = buscarTipo(defensor);

        if(fila == -1 || columna == -1){
            return 1;
        }

        return EFECTIVIDAD[fila][columna];

    }

    public static int buscarTipo(String tipo){

        for(int i=0;i<TIPOS.length;i++){

            if(TIPOS[i].equalsIgnoreCase(tipo)){
                return i;
            }

        }

        return -1;

    }

}