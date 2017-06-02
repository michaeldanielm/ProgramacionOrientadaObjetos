package logica;

import logica.*;

/**
 *
 * @author Michael Daniel Murillo López
 */
public class suma {

    public String suma(int A[], int tam) {
        String imprimible = new String();
        shell sh = new shell();
        sh.shellMayor_Menor(A);
        
        double suma = 0;
        for (int i = 0; i < tam; i++) {
            suma += A[i];
        }
        imprimible = ("la suma de todo es: "+suma);
        return imprimible;
    }
}
