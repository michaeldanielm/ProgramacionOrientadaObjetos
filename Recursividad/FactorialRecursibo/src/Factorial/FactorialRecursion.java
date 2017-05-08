import java.util.Scanner;
public class FactorialRecursion {

	public static void main(String[] args) {
		
		int n = readInt();
		System.out.println(factorial(n));

	}

	public static int factorial(int n) {
		
		if(n==0) return 1;
		
		else if(n>=0) {
			return (n * factorial(n-1));
		}
		
		return 0;
	}
	
	public static int readInt() {
		System.out.print("Ingresar número: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		while(n<0) {
			System.out.println("¡El número debe ser positivo!");
			n = readInt();
		}
		
		input.close();
		return n;
	}
}
