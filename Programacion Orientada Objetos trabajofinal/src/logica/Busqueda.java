
package logica;
import logica.*;
/**
 *
 * @author Michael Daniel Murillo López
 */
public class Busqueda {
  public int busqueda(int A[], int tam, int x,int inf ,int sup){
      
      
      int mitad;
      int indice = -1;
      while(inf != sup){
          mitad = (sup + inf)/2;
          if (A[mitad] == x) {
              indice = mitad;
              break;
          }else{
              if (x < A[mitad]) {
                  sup = mitad;
              }else{
                  inf = mitad;
              }
          }
      }
      if( inf == sup && A[inf] == x){
          indice = inf;
      }
      return indice;
  }  
}
