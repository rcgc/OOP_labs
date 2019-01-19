import java.util.Scanner;

public class Main {
	
	public static void menu_principal(){
		System.out.println("\nMENU");
		System.out.println("1.Inicializar frecuencia");
		System.out.println("2.Inicializar volumen");
		System.out.println("3.Cambiar color");
		System.out.println("4.Cambiar tamaño");
		System.out.println("5.Cambiar banda");
		System.out.println("6.Apagar/Encender");
		System.out.println("7.Mostrar info de radio");
		System.out.println("8.Ajustar frecuencia");
		System.out.println("9.Ajustar volumen");
		System.out.println("0.Salir");
		System.out.println("Selecciona un opción: ");
	}
	public static void menu_frecuencia_volumen() {
		System.out.println("1.Aumentar");
		System.out.println("2.Disminuir");
	}
	public static void mostrar_info() {
		
	}

	public static void main(String[] args) {
		Radio miRadio=new Radio();
		
		Radio tuRadio=new Radio(true,"azul", 10, 540,10,1); //Para usar el constructor que no es
															//default, le asigno valores
		int opc;	
		double frecuencia;
		int volumen;
		String color;
		double tamano;
		int amfm=1;
		boolean e=false;
		Scanner teclado=new Scanner (System.in);
		do {
			menu_principal();
			opc=teclado.nextInt();
			
			
			switch(opc) {
			case 1:
					System.out.println("Frecuencia: ");
					frecuencia=teclado.nextDouble();
					teclado.nextLine();
					miRadio.setFrecuencia(amfm, frecuencia);
				break;
			case 2:
					System.out.println("Volumen: ");
					volumen=teclado.nextInt();
					teclado.nextLine();
					miRadio.setVolumen(volumen);
				break;
			case 3:
					System.out.println("Color: ");
					color=teclado.next();
					teclado.nextLine();
					miRadio.setColor(color);
				break;
			case 4:
					System.out.println("Tamaño: ");
					tamano=teclado.nextDouble();
					teclado.nextLine();
					miRadio.setTamano(tamano);
				break;
			case 5:
					System.out.println("1-am- / 2-fm-");
					amfm=teclado.nextInt();
					teclado.nextLine();
					miRadio.setAmfm(amfm);
				break;
			case 6:
					e=!e;
					miRadio.setEncendido(e);
				break;
			case 7:
					System.out.println("Mi radio");
					System.out.println("Frecuencia: "+miRadio.getFrecuencia());
					System.out.println("Volumen: "+miRadio.getVolumen());
					System.out.println("Color: "+miRadio.getColor());
					System.out.println("Tamaño: "+miRadio.getTamano());
					System.out.println("Banda 1-am/2-fm: "+miRadio.getAmfm());
					System.out.println("Estado de encendido:"+miRadio.getEncendido());
					
					System.out.println("\nTu radio");
					System.out.println("Frecuencia: "+tuRadio.getFrecuencia());
					System.out.println("Volumen: "+tuRadio.getVolumen());
					System.out.println("Color: "+tuRadio.getColor());
					System.out.println("Tamaño: "+tuRadio.getTamano());
					System.out.println("Banda 1-am/2-fm: "+tuRadio.getAmfm());
					System.out.println("Estado de encendido:"+tuRadio.getEncendido());
					
				break;
			case 8:
					menu_frecuencia_volumen();
					opc=teclado.nextInt();
					teclado.nextLine();
					switch(opc) {
					case 1:
							miRadio.incrementarFrecuencia();
						break;
					case 2:
							miRadio.decrementarFrecuencia();
						break;
					default:
						break;
					}
				break;
			case 9:
					menu_frecuencia_volumen();
					opc=teclado.nextInt();
					teclado.nextLine();
					switch(opc) {
					case 1:
							miRadio.incrementarVolumen();
						break;
					case 2:
							miRadio.decrementarVolumen();
						break;
					default:
						break;
					}
				break;
			case 0:
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Opcion fuera de rango");
				break;
			}		
		}while(opc!=0);
		teclado.close();
	}
}