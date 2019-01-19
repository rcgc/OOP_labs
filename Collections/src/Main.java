import java.util.Scanner;

public class Main {
	
	public  static void menu() {
		System.out.println("\nMenú");
		System.out.println("1) Añadir artículo ");
		System.out.println("2) Borrar artículo");
		System.out.println("3) Total de artículos en catálogo");
		System.out.println("4) Precio total del catálogo");
		System.out.println("5) Imprimir catálogo");
	}
	
	public static void main (String args[]) {
		Scanner teclado = new Scanner (System.in);
		
		int id;
		String nombre;
		double precio;
		int opc;
		
		Articulo miLibro = new Articulo(0,"El gran libro de android", 520);
		Articulo miCancion = new Articulo(1, "Until the last moment",18);
		Articulo miCel = new Articulo (2, "Moto Maxx", 9999);
		Articulo miLap = new Articulo(3, "HP Omen", 31500);
		
		Catalogo miCatalogo = new Catalogo();
		
		miCatalogo.agrega(miLibro);
		miCatalogo.agrega(miCancion);
		miCatalogo.agrega(miCel);
		miCatalogo.agrega(miLap);
				
		do {
			menu();
			opc=teclado.nextInt();
			teclado.nextLine();
			
			switch(opc) {
				case 1:
					System.out.println("Id: ");
					id=teclado.nextInt();
					teclado.nextLine();
					
					System.out.println("Nombre: ");
					nombre=teclado.nextLine();
					
					System.out.println("Precio: ");
					precio=teclado.nextDouble();
					teclado.nextLine();
					
					Articulo miArticulo = new Articulo(id,nombre,precio);
					miCatalogo.agrega(miArticulo);
					break;
					
				case 2:
					System.out.println("Id: ");
					id=teclado.nextInt();
					
					Articulo tuArticulo = new Articulo(id, "", 0);
					
					miCatalogo.borrar(tuArticulo);
					
					break;
				case 3:
					System.out.println("Total de artículos en catálogo: "+miCatalogo.numeroArticulos()+"\n");
					break;
				
				case 4:
					System.out.println("Precio total del catálogo: $"+miCatalogo.costoTotal()+"\n");
					break;
				
				case 5:
					System.out.println(miCatalogo.toString());
					break;
				case 6:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Opción fuera de rango");
					break;
					
				
			}
		}while(opc!=6);
		teclado.close();
	}
}
