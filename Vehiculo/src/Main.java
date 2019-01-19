import java.util.Scanner;
public class Main {
	
	
	public static void menu() {
		System.out.println("Menu");
		System.out.println("1) Agregar un carro");
		System.out.println("2) Borrar un carro");
		System.out.println("3) Verificar existencia");
		System.out.println("4) Carro con mejor rendimiento");
		System.out.println("5) Carros vs presupuesto");
		System.out.println("6) Imprimir todos los carros Pickup con rendimiento vs carga");
		System.out.println("7) Imprimir todo el inventario");
		System.out.println("8) Salir");
	}
	
	
	public static void menuTipos() {
		System.out.println("Tipos de carros: ");
		System.out.println("1) Compacto-Gasolina");
		System.out.println("2) Compacto-Eléctrico");
		System.out.println("3) Familiar");
		System.out.println("4) Pickup");
	}
	
	
	public static void main (String[] args) {
	
		
		Scanner teclado= new Scanner(System.in);
		
		
		Familiar miCarro = new Familiar ("Trendline","Volskwagen",55,18.3,203990,true);
		Compacto tuCarro = new Compacto("A3","Audi",50,5.2,450000,1); //1 Gasoline-----2 Electric;
		Pickup miTroca   = new Pickup("Lobo","Chevrolet",98,8.7,538000,2.02,5.89,1.91,816);
		Pickup tuTroca   = new Pickup("Cheyenne","Chevrolet",98,10.2,553700,2.03,5.22,1.87,686);
		
		
		Agencia inventario = new Agencia();
		
		
		inventario.agregarAuto(miCarro);
		inventario.agregarAuto(tuCarro);
		inventario.agregarAuto(miTroca);
		inventario.agregarAuto(tuTroca);
		
		
		int opc;
		
		
		String modelo;
		String fabricante;
		double capacidad;
		double rendimiento;
		double precio;
		
		
		int tipoCombustible;
		boolean dvd=false;
		double ancho;
		double largo;
		double alto;
		double capMax;
		
		int flag;
		double presupuesto;
		double carga;
		
		
		do {
			menu();
			opc=teclado.nextInt();
			teclado.nextLine();
			
			switch(opc) {
				case 1:
					menuTipos();
					opc=teclado.nextInt();
					teclado.nextLine();
					switch(opc) {
					
						case 1:
							
							System.out.println("Modelo: ");
							modelo = teclado.nextLine();
							
							System.out.println("Fabricante: ");
							fabricante = teclado.nextLine();
							
							System.out.println("Capacidad [L]: ");
							capacidad=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Rendimiento [Km/L]: ");
							rendimiento = teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Precio: ");
							precio=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Tipo combustible: Gasolina");
							tipoCombustible=1;
							
							Compacto dasAuto = new Compacto(modelo,fabricante,capacidad,rendimiento,precio,tipoCombustible);
							inventario.agregarAuto(dasAuto);
							
							break;
							
						case 2:
							
							System.out.println("Modelo: ");
							modelo = teclado.nextLine();
							
							System.out.println("Fabricante: ");
							fabricante = teclado.nextLine();
							
							System.out.println("Capacidad [Kw]: ");
							capacidad=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Rendimiento [Kw/k]: ");
							rendimiento = teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Precio: ");
							precio=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Tipo combustible: Electricidad");
							tipoCombustible=2;
							
							Compacto comp = new Compacto(modelo,fabricante,capacidad,rendimiento,precio,tipoCombustible);
							inventario.agregarAuto(comp);
							
							break;
							
						case 3:
							System.out.println("Modelo: ");
							modelo = teclado.nextLine();
							
							System.out.println("Fabricante: ");
							fabricante = teclado.nextLine();
							
							System.out.println("Capacidad [L]: ");
							capacidad=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Rendimiento [Km/L]: ");
							rendimiento = teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Precio: ");
							precio=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Dvd [1) Si, 2) No]: ");
							flag=teclado.nextInt();
							teclado.nextLine();
							
							if(flag==1) {
								dvd=true;
							}
								
							else {
								dvd=false;
							}
								
							Familiar fam= new Familiar(modelo,fabricante,capacidad, rendimiento, precio, dvd);
							inventario.agregarAuto(fam);
							
							break;
						
						case 4:
							
							System.out.println("Modelo: ");
							modelo = teclado.nextLine();
							
							System.out.println("Fabricante: ");
							fabricante = teclado.nextLine();
							
							System.out.println("Capacidad [L]: ");
							capacidad=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Rendimiento [Km/L]: ");
							rendimiento = teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Precio: ");
							precio=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Ancho: ");
							ancho=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Largo: ");
							largo=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Alto: ");
							alto=teclado.nextDouble();
							teclado.nextLine();
							
							System.out.println("Capacidad máxima: ");
							capMax=teclado.nextDouble();
							teclado.nextLine();
							
							Pickup picop = new Pickup(modelo,fabricante, capacidad,rendimiento,precio,ancho,largo,alto,capMax);
							inventario.agregarAuto(picop);
							
							break;
						default:
							System.out.println("Opción fuera de rango");
							break;
					}
					
					break;
				case 2:
					System.out.println("Modelo: ");
					modelo=teclado.nextLine();
					
					Vehiculo vocho = new Vehiculo();
					vocho.setModelo(modelo);
					
					inventario.borrarAuto(vocho);
					break;
				case 3:
					System.out.println("Modelo: ");
					modelo=teclado.nextLine();				
					
					inventario.existencia(modelo);
					break;
				case 4:
					inventario.mejorRendimiento();
					break;
				case 5:
					System.out.println("Presupuesto: ");
					presupuesto=teclado.nextDouble();
					
					inventario.carrosAdquiribles(presupuesto);
					break;
				case 6:
					System.out.println("Peso a cargar: ");
					carga=teclado.nextDouble();
					teclado.nextLine();
					
					inventario.muestraPickup(carga);
					break;
				case 7:
					System.out.println(inventario.toString());
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

