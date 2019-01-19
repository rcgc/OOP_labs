import java.util.Scanner;


public class Main {
	
	public static void menu() {
		System.out.println("1) Agregar un ejemplar al catálogo");
		System.out.println("2) Quitar un ejemplar del catálogo [código: id]");
		System.out.println("3) Visualizar todos los ejemplares escritos por un autor");
		System.out.println("4) Buscar una canción y retornar su código [id]");
		System.out.println("5) Mostrar todos los libros en el catálago");
		System.out.println("6) Mostrar todas las canciones en el catálogo");
		System.out.println("7) Mostrar el catálogo entrero");
		System.out.println("8) Salir");
	}
	
	public static void main (String args[]) {
		
		Scanner teclado= new Scanner (System.in);
		
		Catalogo tuCatalogo=new Catalogo();
		
		Libro lib1 = new Libro("Lib1","100 años de soledad", 1982,true,"Gabriel García Márquez",464);
		Libro lib2 = new Libro("Lib2", "Programación en C, C++, Java y UML", 2014, true, "Luis Joyanes Aguilar", 800);
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
			System.out.println("Selecciona una opción: ");
			opc=teclado.nextInt();
			teclado.nextLine();
			
			switch(opc) {
				case 1:
					System.out.println("1) Libro");
					System.out.println("2) Musica");
					opc=teclado.nextInt();
					teclado.nextLine();
					
					if(opc==1) {//Libro
						
						System.out.println("Código: ");
						codigo=teclado.next();
						teclado.nextLine();
						
						System.out.println("Título: ");
						titulo=teclado.next();
						teclado.nextLine();
						
						System.out.println("Año: ");
						anio=teclado.nextInt();
						teclado.nextLine();
						
						//Disponible es true por default
						
						System.out.println("Autor: ");
						autor=teclado.nextLine();
						
						System.out.println("Número de páginas: ");
						paginas=teclado.nextInt();
						teclado.nextLine();
						
						Libro miLibro= new Libro(codigo, titulo, anio, disponible, autor, paginas);

						tuCatalogo.agregarArticulo(miLibro);
						
					}
					
					else if(opc==2) {//Música
						
						System.out.println("Código: ");
						codigo=teclado.nextLine();
						
						System.out.println("Título: ");
						titulo=teclado.nextLine();
						
						System.out.println("Año: ");
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
						System.out.println("Opción fuera de rango");
					}
					
					break;
				
				case 2:
					System.out.println("Dame el código [id] del producto a borrar: ");
					codigo=teclado.nextLine();
					tuCatalogo.borrarArticulo(codigo);
					break;
					
				case 3:
					System.out.println("Dame el autor del libro: ");
					autor=teclado.nextLine();
					tuCatalogo.listaLibros(autor);
					break;
				
				case 4:
					System.out.println("Dame el nombre de la canción: ");
					titulo=teclado.nextLine();
					tuCatalogo.listaMusica(titulo);
					
					break;
				
				case 5:
					tuCatalogo.muestraLibros();
					break;
					
				case 6:
					tuCatalogo.muestraMusica();
					break;

				case 7://Debe mostrar todo lo que tiene el catálogo
					tuCatalogo.muestraCat();
					break;
					
				case 8:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Opción fuera de rango");
					break;
			}

		}while(opc!=8);
		
		teclado.close();
	}
}

