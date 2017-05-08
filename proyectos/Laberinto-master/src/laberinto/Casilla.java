package laberinto;

/**
 *
 * @author Michael Daniel Murillo López
 */
//cada objeto Casilla es definido por sus 4 paredes, cuyos valores serán 1 si
//existe pared, 0 si no la hay
public class Casilla {

    private final int north;
    private final int east;
    private final int south;
    private final int west;
    public static int dimension = 30;
    
    //constructor que requiere el codigo de 4 bits por parámetro
    public Casilla(int north, int east, int south, int west) {
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;

    }
    
    //getters en forma de booleano, retornan true si existe pared
    public boolean getNorth() {
        return north == 1;
    }

    public boolean getEast() {
        return east == 1;
    }

    public boolean getSouth() {
        return south == 1;
    }

    public boolean getWest() {
        return west == 1;
    }
}
