import java.util.Scanner;

public class Potencia_A01702388 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int base, exponente,i;
		double res;
		Scanner teclado=new Scanner (System.in);
		
		System.out.println("Dame la base: ");
		base=teclado.nextInt();
		teclado.nextLine(); //Elimina el espacio, que se guarda por el enter en el buffer
		
		System.out.println("Dame el exponente: ");
		exponente=teclado.nextInt();
		teclado.nextLine(); 
		i=0;
		res=1;
		while(i<exponente) {
			res=res*base;
			i++;
		}
		System.out.println(base+" elevado a "+ exponente+ " igual " +res);
		teclado.close();//Cerrar el buffer del teclado
	}

}
