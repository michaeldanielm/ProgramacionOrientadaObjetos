
public class Main {

    public static void main(String[] args) {
        Ascci a = new Ascci();
        System.out.println("Estudiante: Michael Daniel Murillo López\nID: 534830");
        a.AsignarDatos();
        a.BinarioDecimal(a.getBinario());
        a.ascci();
        a.ImprimirBin1();
        a.decimalBinario(a.CorrerIzquierda());
        a.ImprimirBin2();
        a.decimalBinario(a.CorrerDerecha());
        a.ImprimirBin3();
    }

}
