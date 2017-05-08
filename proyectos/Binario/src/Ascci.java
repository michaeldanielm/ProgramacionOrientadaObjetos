
import java.util.Scanner;

public class Ascci {

    private int binario;
    private char ascci;
    private int recorrerizq;
    private int recorrerder;
    public int derecha;
    public int izquierda;
    public int decimal;
    public int decimalbase;
    public String bin;

    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }

    public char getAscci() {
        return ascci;
    }

    public void setAscci(char ascci) {
        this.ascci = ascci;
    }

    public int getRecorrerizq() {
        return recorrerizq;
    }

    public void setRecorrerizq(int recorrerizq) {
        this.recorrerizq = recorrerizq;
    }

    public int getRecorrerder() {
        return recorrerder;
    }

    public void setRecorrerder(int recorrerder) {
        this.recorrerder = recorrerder;
    }

    public int getDerecha() {
        return derecha;
    }

    public void setDerecha(int derecha) {
        this.derecha = derecha;
    }

    public int getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(int izquierda) {
        this.izquierda = izquierda;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public int getDecimalbase() {
        return decimalbase;
    }

    public void setDecimalbase(int decimalbase) {
        this.decimalbase = decimalbase;
    }

    public String getBin() {
        return bin;
    }

    public void setBin(String bin) {
        this.bin = bin;
    }

    public void AsignarDatos() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un número binario:");
        binario = leer.nextInt();
        System.out.println("Ingrese un valor para correr a la izquierda:");
        recorrerizq = leer.nextInt();
        System.out.println("Ingrese un valor para correr a la derecha:");
        recorrerder = leer.nextInt();

    }

    public void ImprimirBin1() {
        System.out.println("__________________________");
        System.out.println("Binario: " + binario);
        System.out.println("Decimal: " + decimal);
        System.out.println("Ascci: " + ascci);
        System.out.println("__________________________");
    }

    public void ImprimirBin2() {
        System.out.println("__________________________");
        System.out.println("Binario << " + recorrerizq + ": " + bin);
        System.out.println("Decimal: " + izquierda);
        System.out.println("Ascci: " + ascci);
        System.out.println("__________________________");
    }

    public void ImprimirBin3() {
        System.out.println("__________________________");
        System.out.println("Binario >> " + recorrerder + ": " + bin);
        System.out.println("Decimal: " + derecha);
        System.out.println("Ascci: " + ascci);
        System.out.println("__________________________");
    }

    public int CorrerDerecha() {
        int der = decimal;
        derecha = der >> recorrerder;
        ascci = (char) derecha;
        return derecha;

    }

    public int CorrerIzquierda() {
        int izq = decimal;
        izquierda = izq << recorrerizq;
        ascci = (char) izquierda;
        return izquierda;
    }

    public void BinarioDecimal(int bina) {
        int e = 1, dec = 0, z = 0;
        if (bina == 0) {
            decimal = 0;
        } else {
            while (bina > 0) {
                z = bina % 10;
                bina = bina / 10;
                decimal = decimal + (z * e);
                e = 2 * e;
            }
        }
    }

    public void decimalBinario(int decimal) {
        int r = 0;
        bin = "";
        if (decimal == 0) {
            bin = "0";
        } else {
            while (decimal > 0) {
                r = decimal % 2;
                decimal = decimal / 2;
                bin = r + bin;
            }
        }

    }

    public void ascci() {
        ascci = (char) decimal;
    }
}
