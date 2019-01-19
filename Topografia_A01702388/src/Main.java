import java.util.Scanner;

public class Main {
	
	public static void menu() {
		System.out.println("1.Establecer precio por metro cuadrado y datos del terreno");
		System.out.println("2.Mostrar detalles del patio default");
		System.out.println("3.Salir");
	}
	
	public static void main(String args[]) {
		float cost;
		int vertices;
		int i;
		int equi[];
		int ye[];

		int opc;
		
		Scanner teclado= new Scanner (System.in);
		Terreno miPatio= new Terreno();
		
		
		do {
			menu();
			opc=teclado.nextInt();
			
			switch(opc) {
				case 1:
					System.out.println("Precio de limpieza por metro cuadrado: ");
					cost=teclado.nextFloat();
					teclado.nextLine();

					System.out.println("Número de vértices del terreno: ");
					vertices=teclado.nextInt();
					teclado.nextLine();
					
					equi= new int[vertices]; //Arreglos dinámicos
					ye=new int [vertices]; 	 //Arreglos dinámicos
					

					Terreno tuPatio= new Terreno(vertices,equi,ye);//Constructor no-default
					tuPatio.setNoVert(vertices);


					for (i=0; i<=vertices-1; i++) {
						System.out.println("x"+(i+1));
						equi[i]=teclado.nextInt();
						teclado.nextLine();
												
						System.out.println("y"+(i+1));
						ye[i]=teclado.nextInt();
						teclado.nextLine();
					}
					
					tuPatio.setX(equi);
					tuPatio.setY(ye);
	
					System.out.println("Area :  "+tuPatio.area()+" [m2]");
					System.out.println("Coste: $"+cost);
					System.out.println("Total: $"+tuPatio.area()*(double)cost+"\n");
					System.out.println("Datos \n"+tuPatio.toString());						
					break;
				case 2:
					System.out.println("Datos \n"+miPatio.toString());						
					break;
				case 3:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Opcion fuera de rango");
					break;
			}
		}while(opc!=3);
		teclado.close();		
	}
}