package aMayusculas;

import java.util.Scanner;

public class AMayusculas_A01702388 {
	public static void main(String args[]) {
		Scanner teclado= new Scanner (System.in);
		
		String s1;
		
		System.out.println("Ingresa una palabra: ");
		s1=teclado.next();
		teclado.nextLine();
		
		System.out.println(s1+" <---> "+s1.toUpperCase());
		teclado.close();
	}
}
