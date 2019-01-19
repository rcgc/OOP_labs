import java.util.Scanner;


public class Main {
	
	public static void menu() {
		System.out.println("Menu");
		System.out.println("1.Cambiar carrera");
		System.out.println("2.Cambiar semestre");
		System.out.println("3.Cambiar promedio");
		System.out.println("3.Cambiar domicilio");
		System.out.println("5.Cambiar telefono");
		System.out.println("6.Mostrar alumnos");
		System.out.println("7.Salir");
	}
	
	public static boolean validarCarrera(String carrera) {
		if(carrera.equals("ISC")||carrera.equals("ISD")||carrera.equals("IMT")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int opc;
		
		String carrera;
		String domicilio;
		long telefono;
		int promedio;
		int semestre;
		
		Scanner teclado = new Scanner (System.in);
		Alumnos yo= new Alumnos("Roberto","A01702388","ISC",6,90,"Conocido", 'M', 2351085964L); //Con una "L" al final desaparece el error, la L indica que es de tipo long
		Alumnos tu=new Alumnos();
		

		do {
			menu();
			opc=teclado.nextInt();
			teclado.nextLine();
			switch(opc) {				
				case 1:
					System.out.println("Carrera: ");
					carrera=teclado.next();
					teclado.nextLine();
					
					if(validarCarrera(carrera)) { 
						tu.setCarrera(carrera);
					}
					break;
					
				case 2:
					System.out.println("1.Capturar semestre ");
					System.out.println("2.Incrementar semestre ");
					opc=teclado.nextInt();
					teclado.nextLine();
					
					if(opc==1) {
						System.out.println("Semestre: ");
						semestre=teclado.nextInt();
						teclado.nextLine();
						tu.setSemestre(semestre);
					}
					if(opc==2) {
						tu.incrementarSemestre();
						System.out.println("Nuevo semestre: "+tu.getSemestre());
					}
					
					break;
					
				case 3:
					System.out.println("Promedio: ");
					promedio=teclado.nextInt();
					tu.setPromedio(promedio);
					break;
					
				case 4:
					System.out.println("Domicilio: ");
					domicilio=teclado.nextLine();
					teclado.nextLine();

					tu.setDomicilio(domicilio);
					break;
					
				case 5:
					System.out.println("Teléfono: ");
					telefono=teclado.nextLong();
					teclado.nextLine();
					tu.setTelefono(telefono);
					
					break;
					
				case 6:
					System.out.println("Yo:"+yo.toString());
					System.out.println("Tu:"+tu.toString());
					break;
					
				case 7:
					System.out.println("Goodbye");
					break;

				default:
					System.out.println("Opcion fuera de rango");
					break;
					
			}
		}while(opc!=7);
		
		/* Si quiero multiples alumnos así sería sin embargo se pierden las direcciones físicas de cada objeto
		 * for(i=1;i<=5;i++){
		 * 	Syso("Dame tu id");
		 * 	mat=teclado.nextLine();
		 * 	Alumnos otro = new Alumnos(mat, nombre, 0,carrera,1,domicilio);
		 * }
		 */
		
		teclado.close();
	}

}