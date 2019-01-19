import java.util.Scanner;
public class Main {
	
	public static void menu() {
		System.out.println("1) Agregar un número");
		System.out.println("2) Mostrar un número");
		System.out.println("3) Imprimir lista de números");
		System.out.println("4) Salir");
	}
	
	public static void main (String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		
		
		Stack miPila = new Stack();
						
		int opc;
		Integer numero;
		
		do {
			menu();
			opc=teclado.nextInt();
			teclado.nextLine();
			
			switch(opc) {
				case 1:
					System.out.println("Número");
					numero=teclado.nextInt();
					teclado.nextLine();
					
						miPila.push(numero);
					
					break;
				case 2:
					
					try {
						System.out.println(miPila.pop());
					}catch(EmptyStackException fe){
						System.out.println(fe.getMessage());
					}
					
					break;
				case 3:
						System.out.println(miPila.toString());
					break;
				case 4:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Opción fuera de rango");
					break;					
			}
			
		}while(opc!=4);	
		teclado.close();
	}
}
