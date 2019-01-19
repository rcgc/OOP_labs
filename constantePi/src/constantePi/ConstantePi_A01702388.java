package constantePi;
import java.util.Scanner;

public class ConstantePi_A01702388 {
	
	public static void main (String args[]){
		Scanner teclado = new Scanner(System.in);
		int n,i,m;
		double acum;
		boolean bandera=true;
		
		System.out.println("Dame el limite del algoritmo de PI: ");
		n=teclado.nextInt();
		teclado.nextLine();
		acum=0;
		m=1;
		
		for(i=1;i<=n;i++) {
			
			if(bandera) {
				acum=acum+(1/(double)m); //Es necesario hacer el cast para esta operación
				bandera=false;
			}
			else {
				acum=acum-(1/(double)m); //Es necesario hacer el cast para esta operación
				bandera=true;
			}
			m+=2;
		}
		acum=4*acum;
		
		System.out.print("Pi = "+acum);
		teclado.close();
	}
}
