import java.util.Arrays;
import java.util.List;
import java.util.Random;
/*
 * Carlos Villacastín
 */
public class YElGanadorEs {
    
    public static final int MAX_RANDOM = 40;
    public static final int PAUSA_TENSION_MILIS = 5000;

    public static void main(String[] args) {

        // Listado de cosas a sortear
        List<Integer> pantallas = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> torresGrandes = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> torresPequeñas = Arrays.asList(1, 2, 3);
        List<Integer> servidores = Arrays.asList(1, 2, 3);

        //Numeros posibles según la excel (hay que quitar en los que no haya nombre y debe acabar por coma)
        String numPantallas = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,";
        String numTorresGrandes = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,29,30,31,32,35,36,37,40,";
        String numTorresPequeñas = "1,2,3,4,5,6,7,8,9,10,11,13,15,16,18,19,20,23,24,26,27,29,31,32,35,36,";
        String numServidores = "1,2,4,8,9,10,11,12,13,20,";

        //hacerSorteoBloque(pantallas, numPantallas, "Pantalla");
        hacerSorteoBloque(torresGrandes, numTorresGrandes, "Torre Grande");
        hacerSorteoBloque(torresPequeñas, numTorresPequeñas, "Torre Pequeña");
        hacerSorteoBloque(servidores, numServidores, "Servidor");

    }

    /*
     * Recorre la lista de objetos para hacer el sorteo de cada cosa y elimina los números que ya han salido. 
     */
    public static void hacerSorteoBloque(List cosasASortear, String numerosPosibles, String descripcion) {
        System.out.println("******************** " + descripcion + " ************************");
        System.out.println("El sorteo da comienzo....esta la bolas en el bombo....");
        pausaDeTension();
        
        for (int p = 0; p < cosasASortear.size(); p++) {
            int num = p + 1;
            int ganador = hacerSorteoIndividual(descripcion + " " + num, numerosPosibles);
            //Quitamos el ganador que ya ha salido para que no le toquen dos cosas del mismo sorteo.
            numerosPosibles = numerosPosibles.replace(ganador + ",", "");
        }
        System.out.println("*****************************************************************");
        System.out.println("");
        System.out.println("Enhorabuena a los premiados!!");
    }

    /*
     * Sortea un unico objeto sobre los numeros posibles.
     */
    public static int hacerSorteoIndividual(String elemento, String numerosPosibles) {

        Random ram = new Random();
        int ganador = ram.nextInt(MAX_RANDOM -1) +1;

        //Hasta que no sea válido no damos un ganador.
        while (!esValidoElResultado(numerosPosibles, ganador)) {
            ganador = ram.nextInt(MAX_RANDOM -1) +1;
        }

        System.out.println("El ganador del sorteo de " + elemento + " es el numero.......... " + ganador);
        
        pausaDeTension();
                
        return ganador;

    }

    /*
     * Indica si el ganador es un numero valido entre los posibles.
     */
    public static boolean esValidoElResultado(String numerosPosibles, int ganador) {

        return numerosPosibles.contains(ganador + ",");

    }
    
    
    /*
     * Pausa para generar tensión entre sorteos
     */
    public static void pausaDeTension() {

        try {
                Thread.sleep(PAUSA_TENSION_MILIS);
        } catch (Exception e){
            
        }

    }

}
