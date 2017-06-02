package logica;

import logica.*;


public class Mayor_y_Menor {

    public void Mm(int A[], int tam) {
        
        shell sh = new shell();
        sh.shellMenor_Mayor(A);
        
        int mayor = A[tam-1];
        int menor = A[0];
        System.out.println("el numero menor es: "+menor+"\n"
                + "El numero mayor es: "+mayor);
    }
}
