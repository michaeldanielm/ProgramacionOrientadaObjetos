package Main;
import java.io.*;
/**
 *
 * @author Michael daniel Murillo López
 */
public class archivo {
    public void leerArchivo(String arc,int[]vector,int size) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(arc);
        BufferedReader buff = new BufferedReader(reader);
        for(int i=0;i<size;i++){
            vector[i]=Integer.parseInt(buff.readLine());
           int numeros=vector[i];
           //System.out.println(numeros);
        } 
        //System.out.println("Valores del texto añadidos al vector");
        
       
        buff.close();
    }public void escribirArchivo(String arc,int[]vector,int size) throws IOException{
        File comprobar=new File(arc);
        BufferedWriter creador;
        String[] chain=new String[size];
        if(comprobar.exists()){
            creador = new BufferedWriter(new FileWriter(comprobar));
            creador.write("El archivo ya existe");
            System.out.println("El archivo ya existe");
        }else{
            creador = new BufferedWriter(new FileWriter(comprobar));
            for(int i=0;i<size;i++){
                chain[i]=String.valueOf(vector[i]);
                creador.write(chain[i]+"\n");
            }System.out.println("Archivo creado con éxito");
        }creador.close();
    }public void auxiliar(int[]vector,int size){
        for(int i=0;i<size;i++){
            System.out.println(vector[i]);
        }
    }

    public boolean escribirArchivo(int[] V, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
