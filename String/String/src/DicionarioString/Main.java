package DicionarioString;

import java.io.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Metodos String y Informacion sobre el metodo\n");
        System.out.println("Este método devuelve el carácter situado en el índice especificado de la cadena. Los índices de cadenas empiezan desde cero.");
        String1(args);
        System.out.println("\nEste método compara esta Cadena a otro objeto.");
        String2(args);
        System.out.println("\nEste método compara dos cadenas lexicográficamente.");
        String3(args);
        System.out.println("\nEste método compara dos cadenas lexicográfico, ignorando las diferencias de casos.");
        String4(args);
        System.out.println("\nEste método añade una cadena al final de otro. El método devuelve una cadena con el valor de la cadena que se pasa en el método,"
                + "\nanclado al final de la cadena, que se utiliza para invocar este método.");
        String5(args);
        System.out.println("\nEste método devuelve verdadero si y sólo si esta cadena representa la misma secuencia de caracteres como se especifica en StringBuffer.");
        String6(args);
        System.out.println("\n Este método devuelve una cadena que representa la secuencia de caracteres en la matriz especificada.");
        String7(args);
        System.out.println("\nEsto devuelve una cadena que representa la secuencia de caracteres en la matriz especificada.");
        String8(args);
        System.out.println("\nEste método prueba si esta cadena termina con el sufijo especificado.");
        String9(args);
        System.out.println("\nEste método compara esta cadena al objeto especificado. "
                + "\nEl resultado es verdadero si y sólo si el argumento no es nulo y es un objeto String que representa la misma secuencia de caracteres como este objeto");
        String10(args);
        System.out.println("\nEste método compara esta cadena a otra cadena, haciendo caso omiso de las consideraciones de caso."
                + "\n Dos cadenas se consideran iguales caso ignorando, "
                + "\nsi son de la misma longitud, y los correspondientes caracteres de las dos cadenas son iguales ignorando caso.");
        String11(args);
        System.out.println("\n Este método codifica esta cadena en una secuencia de bytes utilizando charset por defecto de la plataforma,"
                + "\n almacenar el resultado en una nueva matriz de bytes.");
        String12(args);
        System.out.println("\nEste método codifica esta cadena en una secuencia de bytes utilizando el juego de caracteres llamado,"
                + "\n almacenar el resultado en una nueva matriz de bytes.");
        String13(args);
        System.out.println("\nEste método copia los caracteres de esta cadena en la matriz de caracteres de destino.");
        String14(args);
        System.out.println("\nEste método devuelve un código hash de esta cadena. El código hash de un objeto String se calcula como -\n"
                + "\n" + "s[0]*31^(n - 1) + s[1]*31^(n - 2) + ... + s[n - 1]\n"
                + "Usando int aritmética, donde s [i] es el carácter i de la cadena, n es la longitud de la cadena, y ^ indica exponenciación. "
                + "\n(El valor hash de la cadena vacía es cero.)");
        String15(args);
        System.out.println("\nEste método devuelve el índice dentro de esta serie de la primera ocurrencia del carácter especificado o -1, si el personaje no se produce.");
        String16(args);
        System.out.println("\nEste método devuelve el índice dentro de esta cadena de la primera ocurrencia del carácter especificado,\n "
                + "a partir de la búsqueda en el índice especificado o -1, si el personaje no se produce. ");
        String17(args);
        System.out.println("\nEste método devuelve el índice dentro de esta cadena de la primera ocurrencia de la subcadena especificada.\n "
                + "Si no se produce como una subcadena, se devuelve -1.\n");
        String18(args);
        System.out.println("\nEste método devuelve el índice dentro de esta cadena de la primera ocurrencia de la subcadena especificada,\n"
                + " comenzando en el índice especificado. Si esto no ocurre, se devuelve -1.\n");
        String19(args);
        System.out.println("\nEste método devuelve una representación canónica para el objeto de cadena.\n"
                + " De ello se desprende que para dos cadenas de s y t , s.intern (==) t.intern () es verdadero si y sólo si s.equals (t) es verdadera.");
        String20(args);
        System.out.println("\nEste método devuelve el índice de la última ocurrencia del carácter en la secuencia de caracteres\n"
                + " representada por el objeto que es menor que o igual a fromIndex, o -1 si el personaje no se produce antes de ese punto.");
        String21(args);
        System.out.println("\nEste método devuelve el índice de la última ocurrencia del carácter\n"
                + " en la secuencia de caracteres representada por el objeto que es menor que o igual a fromIndex, o -1 si el personaje no se produce antes de ese punto.");
        String22(args);
        System.out.println("\nEste método acepta una cadena como un argumento, si el argumento de cadena se produce una o más veces como una subcadena dentro de este objeto,"
                + "\n entonces se devuelve el índice del primer carácter del último de estos subcadena se devuelve. Si no se produce como una subcadena, se devuelve -1.");
        String23(args);
        System.out.println("\nEste método devuelve el índice dentro de esta cadena de la última aparición de la subcadena especificada, buscando hacia atrás empezando en el índice especificado.");
        String24(args);
        System.out.println("\nEste método devuelve la longitud de esta cadena. La longitud es igual al número de caracteres Unicode de 16 bits en la cadena.");
        String25(args);
        System.out.println("\nCuerdas, que son ampliamente utilizados en la programación Java, son una secuencia de caracteres. En el lenguaje de programación Java, las cadenas son tratados como objetos.\n" +
                           "\nLa plataforma Java proporciona la clase String para crear y manipular cadenas");
        String25(args);
        System.out.println("\nEste método tiene dos variantes que se pueden utilizar para probar si dos regiones de cadena son iguales.");
        String26(args);
        System.out.println("\nEste método tiene dos variantes que se pueden utilizar para probar si dos regiones de cadena son iguales.");
        String27(args);
        System.out.println("\nEste método tiene dos variantes que se pueden utilizar para probar si dos regiones de cadena son iguales.");
        String28(args);
        System.out.println("\nEste método tiene dos variantes que se pueden utilizar para probar si dos regiones de cadena diferente iguales.");
        String29(args);
        System.out.println("\nEste método devuelve una nueva cadena resultante de la sustitución de todas las ocurrencias de oldChar en esta cadena con Newchar.");
        String30(args);
        System.out.println("\nEste método reemplaza cada subcadena de esta cadena que coincide con la expresión regular dada con el reemplazo dado.\n");
        STRING31(args);
        System.out.println("\nEste método reemplaza la primera subcadena de esta cadena que coincide con la expresión regular dada con el reemplazo dado.");
        String32(args);
        System.out.println("\nEste método tiene dos variantes y se divide esta cadena alrededor de coincidencias de la expresión regular dada.");
        String33(args);
        System.out.println("\nEste método tiene dos variantes y pruebas si una cadena comienza con el prefijo especificado a partir de un índice especificado o por defecto al principio.");
        String34(args);
        System.out.println("\nEste método tiene dos variantes y pruebas si una cadena comienza con el prefijo especificado a partir de un índice especificado o por defecto al principio.");
        string35(args);
        System.out.println("\nEste método devuelve una nueva secuencia de caracteres que es una subsecuencia de esta secuencia.");
        string36(args);
        System.out.println("\nEste método tiene dos variantes y devuelve una nueva cadena que es una subcadena de esta cadena.\n La subcadena comienza con el"
                + "carácter en el índice especificado y se extiende hasta el final de esta cadena o hasta endIndex - 1, si se da el segundo argumento.");
        sTRING37(args);
        System.out.println("\nEste método tiene dos variantes y devuelve una nueva cadena que es una subcadena de esta cadena.\n"
                + " La subcadena comienza con el carácter en el índice especificado y se extiende hasta el final de esta cadena o hasta endIndex - 1, si se da el segundo argumento.");
        String38(args);
        System.out.println("\nEste método convierte esta cadena en un nuevo arreglo de caracteres.");
        String39(args);
        System.out.println("\nEste método tiene dos variantes. La primera variante convierte todos los caracteres de esta cadena a minúsculas utilizando las reglas de la localización dada. Esto es equivalente a llamar toLowerCase (Locale.getDefault ()).\n" +
                           "\nLa segunda variante toma locale como un argumento para ser utilizado mientras que la conversión en minúsculas.");
        String40(args);
        System.out.println("\nEste método tiene dos variantes. La primera variante convierte todos los caracteres de esta cadena a minúsculas utilizando las reglas de la localización dada. Esto es equivalente a llamar toLowerCase (Locale.getDefault ()).\n" +
                           "\nLa segunda variante toma locale como un argumento para ser utilizado mientras que la conversión en minúsculas.");
        String41(args);
        System.out.println("\nEste método devuelve una cadena en sí.");
        String42(args);
        System.out.println("\nEste método tiene dos variantes. La primera variante convierte todos los caracteres en esta cadena a mayúsculas utilizando las reglas de la localización dada. Esto es equivalente a llamar toUpperCase (Locale.getDefault ()).\n" +
"\nLa segunda variante toma locale como un argumento para ser utilizado mientras que la conversión en mayúsculas.");
        String43(args);
        System.out.println("\nEste método tiene dos variantes. La primera variante convierte todos los caracteres en esta cadena a mayúsculas utilizando las reglas de la localización dada. Esto es equivalente a llamar toUpperCase (Locale.getDefault ()).\n" +
"\nLa segunda variante toma locale como un argumento para ser utilizado mientras que la conversión en mayúsculas.");
        String44(args);
        System.out.println("\nEste método devuelve una copia de la cadena, con el espacio inicial y final omite.");
        String45(args);
        System.out.println("\n Este método tiene las siguientes variantes, que dependen de los parámetros pasados. Este método devuelve la representación de cadena del argumento pasado.\n" +
"\n" +
"valueOf (boolean b) - Devuelve la representación de cadena del argumento booleano.\n" +
"\n" +
"valueOf (char c) - Devuelve la representación de cadena del argumento carbón.\n" +
"\n" +
"valueOf (char [] datos) - Devuelve la representación de cadena del argumento matriz de caracteres.\n" +
"\n" +
"valueOf ([] Los datos de char, int desplazamiento, int count) - Devuelve la representación de cadena de un subconjunto específico del argumento matriz de caracteres.\n" +
"\n" +
"valueOf (double d) - Devuelve la representación de cadena de la doble argumento.\n" +
"\n" +
"valueOf (float f) - Devuelve la representación de cadena del argumento flotador.\n" +
"\n" +
"valueOf (int i) - Devuelve la representación de cadena del argumento int.\n" +
"\n" +
"valueOf (l de largo) - Devuelve la representación de cadena de la larga discusión.\n" +
"\n" +
"valueOf (Object obj) - Devuelve la representación de cadena del argumento de objetos");
        String46(args);
        System.out.println("\nsacado de :https://www.tutorialspoint.com/java/java_strings.htm");
        System.out.println("\n---------------------Metodos String-------------------------------");
        
    }
    public static void String46(String args[]) {
      double d = 102939939.939;
      boolean b = true;
      long l = 1232874;
      char[] arr = {'a', 'b', 'c', 'd', 'e', 'f','g' };

      System.out.println("Return Value : " + String.valueOf(d) );
      System.out.println("Return Value : " + String.valueOf(b) );
      System.out.println("Return Value : " + String.valueOf(l) );
      System.out.println("Return Value : " + String.valueOf(arr) );
   }
     public static void String45(String args[]) {
      String Str = new String("   Welcome to Tutorialspoint.com   ");

      System.out.print("Return Value :" );
      System.out.println(Str.trim() );
   }
     public static void String44(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.toUpperCase() );
   }
    public static void String43(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.toUpperCase() );
   }
    public static void String42(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :");
      System.out.println(Str.toString());}
    public static void String41(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :");
      System.out.println(Str.toLowerCase());}
    public static void String40(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :");
      System.out.println(Str.toLowerCase());
   }
    public static void String39(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.toCharArray() );
   }
    public static void String38(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.substring(10, 15) );
   }
    public static void sTRING37(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.substring(10) );}
    public static void string36(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.subSequence(0, 10) );

      System.out.print("Return Value :" );
      System.out.println(Str.subSequence(10, 15) );}
    public static void string35(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.startsWith("Tutorials", 11) );
   }
    public static void String34(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.startsWith("Welcome") );

      System.out.print("Return Value :" );
      System.out.println(Str.startsWith("Tutorials") );
   }
    public static void String33(String args[]) {
      String Str = new String("Welcome-to-Tutorialspoint.com");
      System.out.println("Return Value :" );
      
      for (String retval: Str.split("-", 2)) {
         System.out.println(retval);
      }
      System.out.println("");
      System.out.println("Return Value :" );
      
      for (String retval: Str.split("-", 3)) {
         System.out.println(retval);
      }
      System.out.println("");
      System.out.println("Return Value :" );
      
      for (String retval: Str.split("-", 0)) {
         System.out.println(retval);
      }
      System.out.println("");
   }
    public static void String32(String args[]) {
      String Str = new String("Welcome-to-Tutorialspoint.com");
      System.out.println("Return Value :" );      
      
      for (String retval: Str.split("-")) {
         System.out.println(retval);}}
    public static void STRING31(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.replaceFirst("(.*)Tutorials(.*)", "AMROOD"));

      System.out.print("Return Value :" );
      System.out.println(Str.replaceFirst("Tutorials", "AMROOD"));
    }
   
    public static void String30 (String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.replaceAll("(.*)Tutorials(.*)", "AMROOD"));
   }
    
    public static void String29(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");

      System.out.print("Return Value :" );
      System.out.println(Str.replace('o', 'T'));

      System.out.print("Return Value :" );
      System.out.println(Str.replace('l', 'D'));
   }

     public static void String28(String args[]) {
      String Str1 = new String("Welcome to Tutorialspoint.com");
      String Str2 = "Tutorials";
      String Str3 = new String("TUTORIALS");

      System.out.print("Return Value :" );
      System.out.println(Str1.regionMatches(11, Str2, 0, 9));

      System.out.print("Return Value :" );
      System.out.println(Str1.regionMatches(11, Str3, 0, 9));}
    
   public static void String27(String args[]) {
        String Str1 = new String("Welcome to Tutorialspoint.com");
      String Str2 = new String("Tutorials");
      String Str3 = new String("TUTORIALS");

      System.out.print("Return Value :" );
      System.out.println(Str1.regionMatches(11, Str2, 0, 9));

      System.out.print("Return Value :" );
      System.out.println(Str1.regionMatches(11, Str3, 0, 9));
      }
   public static void String26 (String args[]) {
      String Str1 = new String("Welcome to Tutorialspoint.com");
      String Str2 = new String("TUTORIALS");

      System.out.print("Return Value :" );
      System.out.println(Str1.regionMatches(true, 11, Str2, 0, 9));}
     public static void String25(String args[]) {
      String Str1 = new String("Welcome to Tutorialspoint.com");
      String Str2 = new String("Tutorials" );

      System.out.print("String Length :" );
      System.out.println(Str1.length());

      System.out.print("String Length :" );
      System.out.println(Str2.length());
   }
    public static void String24(String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");
      String SubStr1 = new String("Tutorials" );
      System.out.print("Found Last Index :" );
      System.out.println( Str.lastIndexOf( SubStr1, 15 ));
   }
    public static void String23 (String args[]) {
      String Str = new String("Welcome to Tutorialspoint.com");
      String SubStr1 = new String("Tutorials" );
      System.out.print("Found Last Index :" );
      System.out.println( Str.lastIndexOf( SubStr1 ));
   }

    public static void String22(String args[]) {
        String Str = new String("Welcome to Tutorialspoint.com");
        System.out.print("Found Last Index :");
        System.out.println(Str.lastIndexOf('o', 5));
    }

    public static void String21(String args[]) {
        String Str = new String("Welcome to Tutorialspoint.com");
        System.out.print("Found Last Index :");
        System.out.println(Str.lastIndexOf('o'));
    }

    public static void String20(String args[]) {
        String Str1 = new String("Welcome to Tutorialspoint.com");
        String Str2 = new String("WELCOME TO SUTORIALSPOINT.COM");

        System.out.print("Canonical representation:");
        System.out.println(Str1.intern());

        System.out.print("Canonical representation:");
        System.out.println(Str2.intern());
    }

    public static void String19(String args[]) {
        String Str = new String("Welcome to Tutorialspoint.com");
        String SubStr1 = new String("Tutorials");
        System.out.print("Found Index :");
        System.out.println(Str.indexOf(SubStr1, 15));
    }

    public static void String18(String args[]) {
        String Str = new String("Welcome to Tutorialspoint.com");
        String SubStr1 = new String("Tutorials");
        System.out.println("Found Index :" + Str.indexOf(SubStr1));
    }

    public static void String17(String args[]) {
        String Str = new String("Welcome to Tutorialspoint.com");
        System.out.print("Found Index :");
        System.out.println(Str.indexOf('o', 5));
    }

    public static void String16(String args[]) {
        String Str = new String("Welcome to Tutorialspoint.com");
        System.out.print("Found Index :");
        System.out.println(Str.indexOf('o'));
    }

    public static void String15(String args[]) {
        String Str = new String("Welcome to Tutorialspoint.com");
        System.out.println("Hashcode for Str :" + Str.hashCode());
    }

    public static void String14(String args[]) {
        String Str1 = new String("Welcome to Tutorialspoint.com");
        char[] Str2 = new char[7];
        try {
            Str1.getChars(2, 9, Str2, 0);
            System.out.print("Copied Value = ");
            System.out.println(Str2);
        } catch (Exception ex) {
            System.out.println("Raised exception...");
        }
    }

    public static void String13(String args[]) {
        String Str1 = new String("Welcome to Tutorialspoint.com");
        try {
            String Str2 = new String(Str1.getBytes("UTF-8"));
            System.out.println("Returned Value " + Str2);
            Str2 = new String(Str1.getBytes("ISO-8859-1"));
            System.out.println("Returned Value " + Str2);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported character set");
        }
    }

    public static void String1(String args[]) {
        String s = "Las cadenas son inmutables";//Este método devuelve el carácter situado en el índice especificado de la cadena. Los índices de cadenas empiezan desde cero.
        char result = s.charAt(8);
        System.out.println(result);
    }

    public static void String2(String args[]) {
        String str1 = "Strings are immutable";//Este método compara esta Cadena a otro objeto.
        String str2 = new String("Strings are immutable");
        String str3 = new String("Integers are not immutable");

        int result = str1.compareTo(str2);
        System.out.println(result);

        result = str2.compareTo(str3);
        System.out.println(result);
    }

    public static void String3(String args[]) {//Este método compara dos cadenas lexicográficamente.
        String str1 = "Strings are immutable";
        String str2 = "Strings are immutable";
        String str3 = "Integers are not immutable";

        int result = str1.compareTo(str2);
        System.out.println(result);

        result = str2.compareTo(str3);
        System.out.println(result);

        result = str3.compareTo(str1);
        System.out.println(result);
    }

    public static void String4(String args[]) {//Este método compara dos cadenas lexicográfico, ignorando las diferencias de casos.
        String str1 = "Strings are immutable";
        String str2 = "Strings are immutable";
        String str3 = "Integers are not immutable";

        int result = str1.compareToIgnoreCase(str2);
        System.out.println(result);

        result = str2.compareToIgnoreCase(str3);
        System.out.println(result);

        result = str3.compareToIgnoreCase(str1);
        System.out.println(result);
    }

    public static void String5(String args[]) {
        String s = "Strings are immutable";//s - la cadena que se concatena con el final de esta cadena.
        s = s.concat(" all the time");
        System.out.println(s);
    }

    public static void String6(String args[]) {
        String str1 = "Not immutable";
        String str2 = "Strings are immutable";//Este método devuelve verdadero si y sólo si esta cadena representa la misma secuencia de caracteres como se especifica en StringBuffer.
        StringBuffer str3 = new StringBuffer("Not immutable");

        boolean result = str1.contentEquals(str3);
        System.out.println(result);

        result = str2.contentEquals(str3);
        System.out.println(result);
    }

    public static void String7(String args[]) {
        char[] Str1 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};//Este método devuelve una cadena que representa la secuencia de caracteres en la matriz especificada.
        String Str2 = "";
        Str2 = Str2.copyValueOf(Str1);
        System.out.println("Returned String: " + Str2);
    }

    public static void String8(String args[]) {
        char[] Str1 = {'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd'};//Esto devuelve una cadena que representa la secuencia de caracteres en la matriz especificada.
        String Str2 = "";
        Str2 = Str2.copyValueOf(Str1, 2, 6);
        System.out.println("Returned String: " + Str2);
    }

    public static void String9(String args[]) {
        String Str = new String("This is really not immutable!!");//Este método prueba si esta cadena termina con el sufijo especificado.
        boolean retVal;

        retVal = Str.endsWith("immutable!!");
        System.out.println("Returned Value = " + retVal);

        retVal = Str.endsWith("immu");
        System.out.println("Returned Value = " + retVal);
    }

    public static void String10(String args[]) {//Este método compara esta cadena al objeto especificado. El resultado es verdadero si y sólo si el argumento no es nulo y es un objeto String que representa la misma secuencia de caracteres como este objeto
        String Str1 = new String("This is really not immutable!!");
        String Str2 = Str1;
        String Str3 = new String("This is really not immutable!!");
        boolean retVal;

        retVal = Str1.equals(Str2);
        System.out.println("Returned Value = " + retVal);

        retVal = Str1.equals(Str3);
        System.out.println("Returned Value = " + retVal);

    }
    //Este método compara esta cadena a otra cadena, haciendo caso omiso de las consideraciones de caso. Dos cadenas se consideran iguales caso ignorando, si son de la misma longitud, y los correspondientes caracteres de las dos cadenas son iguales ignorando caso.

    public static void String11(String args[]) {
        String Str1 = new String("This is really not immutable!!");
        String Str2 = Str1;
        String Str3 = new String("This is really not immutable!!");
        String Str4 = new String("This IS REALLY NOT IMMUTABLE!!");
        boolean retVal;

        retVal = Str1.equals(Str2);
        System.out.println("Returned Value = " + retVal);

        retVal = Str1.equals(Str3);
        System.out.println("Returned Value = " + retVal);

        retVal = Str1.equalsIgnoreCase(Str4);
        System.out.println("Returned Value = " + retVal);
    }

    public static void String12(String args[]) {
        String Str1 = new String("Welcome to Tutorialspoint.com");

        try {
            String Str2 = new String(Str1.getBytes("UTF-8"));
            System.out.println("Returned Value " + Str2);
            Str2 = new String(Str1.getBytes("ISO-8859-1"));
            System.out.println("Returned Value " + Str2);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported character set");
        }

    }
}
