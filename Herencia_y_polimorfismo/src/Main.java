import java.util.Scanner;


public class Main {
	
	public static void menu() {
		System.out.println("1) Agregar un ejemplar al cat�logo");
		System.out.println("2) Quitar un ejemplar del cat�logo [c�digo: id]");
		System.out.println("3) Visualizar todos los ejemplares escritos por un autor");
		System.out.println("4) Buscar una canci�n y retornar su c�digo [id]");
		System.out.println("5) Mostrar todos los libros en el cat�lago");
		System.out.println("6) Mostrar todas las canciones en el cat�logo");
		System.out.println("7) Mostrar el cat�logo entrero");
		System.out.println("8) Salir");
	}
	
	public static void main (String args[]) {
		
		Scanner teclado= new Scanner (System.in);
		
		Catalogo tuCatalogo=new Catalogo();
		
		Libro lib1 = new Libro("Lib1","100 a�os de soledad", 1982,true,"Gabriel Garc�a M�rquez",464);
		Libro lib2 = new Libro("Lib2", "Programaci�n en C, C++, Java y UML", 2014, true, "Luis Joyanes Aguilar", 800);
		Musica can1 = new Musica("C1","Detalles", 1985, true, "Roberto Carlos", "mp3");
		
		tuCatalogo.agregarArticulo(lib1);
		tuCatalogo.agregarArticulo(lib2);
		tuCatalogo.agregarArticulo(can1);
		
		
		int opc;
		String codigo;
		String titulo;
		int anio;
		boolean disponible=true;
		
		
		String autor;
		String interprete;
		int paginas;
		String formato;
		
		do {
			menu();
			System.out.println("Selecciona una opci�n: ");
			opc=teclado.nextInt();
			teclado.nextLine();
			
			switch(opc) {
				case 1:
					System.out.println("1) Libro");
					System.out.println("2) Musica");
					opc=teclado.nextInt();
					teclado.nextLine();
					
					if(opc==1) {//Libro
						
						System.out.println("C�digo: ");
						codigo=teclado.next();
						teclado.nextLine();
						
						System.out.println("T�tulo: ");
						titulo=teclado.next();
						teclado.nextLine();
						
						System.out.println("A�o: ");
						anio=teclado.nextInt();
						teclado.nextLine();
						
						//Disponible es true por default
						
						System.out.println("Autor: ");
						autor=teclado.nextLine();
						
						System.out.println("N�mero de p�ginas: ");
						paginas=teclado.nextInt();
						teclado.nextLine();
						
						Libro miLibro= new Libro(codigo, titulo, anio, disponible, autor, paginas);

						tuCatalogo.agregarArticulo(miLibro);
						
					}
					
					else if(opc==2) {//M�sica
						
						System.out.println("C�digo: ");
						codigo=teclado.nextLine();
						
						System.out.println("T�tulo: ");
						titulo=teclado.nextLine();
						
						System.out.println("A�o: ");
						anio=teclado.nextInt();
						teclado.nextLine();
						
						System.out.println("Interprete: ");
						interprete=teclado.nextLine();
						
						
						System.out.println("Formato: ");
						formato=teclado.nextLine();
						
						Musica miMusica=new Musica(codigo, titulo,anio, disponible, interprete, formato);
						
						tuCatalogo.agregarArticulo(miMusica);
						
					}
					
					else {
						System.out.println("Opci�n fuera de rango");
					}
					
					break;
				
				case 2:
					System.out.println("Dame el c�digo [id] del producto a borrar: ");
					codigo=teclado.nextLine();
					tuCatalogo.borrarArticulo(codigo);
					break;
					
				case 3:
					System.out.println("Dame el autor del libro: ");
					autor=teclado.nextLine();
					tuCatalogo.listaLibros(autor);
					break;
				
				case 4:
					System.out.println("Dame el nombre de la canci�n: ");
					titulo=teclado.nextLine();
					tuCatalogo.listaMusica(titulo);
					
					break;
				
				case 5:
					tuCatalogo.muestraLibros();
					break;
					
				case 6:
					tuCatalogo.muestraMusica();
					break;

				case 7://Debe mostrar todo lo que tiene el cat�logo
					tuCatalogo.muestraCat();
					break;
					
				case 8:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Opci�n fuera de rango");
					break;
			}

		}while(opc!=8);
		
		teclado.close();
	}
}

