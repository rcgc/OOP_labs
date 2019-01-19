import java.util.Scanner;
public class Main {
	
	public static void menu() {
		System.out.println("Menu");
		System.out.println("1) Agregar un empleado");
		System.out.println("2) Borrar un empleado");
		System.out.println("3) Nomina mensual total");
		System.out.println("4) Incremento para empleados de planta [0 - 100]");
		System.out.println("5) Mostrar empleados con horas extra");
		System.out.println("6) Mostrar lista de empleados");
		System.out.println("7) Salir");
		
		
	}
	
	public static void main (String args[]) {
		
		Scanner teclado= new Scanner(System.in);
		
		int id;
		String name;
		int hours;
		double salary;
		double incremento;
		
		int opc;
		
		Porhora emp0=new Porhora(0,"Honda",60,150);
		Planta emp1 =new Planta (1, "Paco", 150);
		Porhora emp2=new Porhora(2,"Lucio",41,250);
		Planta emp3 =new Planta (3,"Juan", 1000);
		Porhora emp4=new Porhora(4,"John",60,150);
		
		Nomina miLista=new Nomina();
		
		miLista.agregarEmpleado(emp0);
		miLista.agregarEmpleado(emp1);
		miLista.agregarEmpleado(emp2);
		miLista.agregarEmpleado(emp3);
		miLista.agregarEmpleado(emp4);
		
		do {
			menu();
			opc=teclado.nextInt();
			teclado.hasNextLine();
			switch(opc) {
				case 1:
					System.out.println("1) Planta");
					System.out.println("2) Por hora");
					opc=teclado.nextInt();
					teclado.nextLine();
					
					if(opc==1) {
						System.out.println("Id: ");
						id=teclado.nextInt();
						teclado.nextLine();
						
						System.out.println("Nombre: ");
						name=teclado.nextLine();
						
						System.out.println("Salario mensual: ");
						salary=teclado.nextDouble();
						teclado.nextLine();
						
						Planta worker1=new Planta(id,name,salary);
						miLista.agregarEmpleado(worker1);
						
					}
					else if(opc==2) {
						System.out.println("Id: ");
						id=teclado.nextInt();
						teclado.nextLine();
						
						System.out.println("Nombre: ");
						name=teclado.nextLine();
						
						System.out.println("Pago/hora: ");
						salary=teclado.nextDouble();
						teclado.nextLine();
						
						System.out.println("Horas a la semana");
						hours=teclado.nextInt();
						teclado.nextLine();
						
						Porhora worker2=new Porhora(id,name,salary,hours);
						miLista.agregarEmpleado(worker2);
						
					}
					else {
						System.out.println("Opcion fuera de rango");
					}
					
					
					break;
				
				case 2:
					System.out.println("Id: ");
					id=teclado.nextInt();
					teclado.nextLine();
					
					miLista.borrarEmpleado(id);
					break;
				
				case 3:
					System.out.println("Nómina total a pagar/mes: $"+miLista.nominaMensual()+"\n");
					break;
				
				case 4:
					System.out.println("Incremento: %");
					incremento=teclado.nextDouble();
					teclado.nextLine();
					
					if(incremento>0) {
						miLista.incremento(incremento);
					}
					
					else if(incremento<0 && incremento>-100) {
						System.out.println("¿Desea descontar el salario a todos los trabajadores de planta?");
						System.out.println("1) Si \n2) No");
						opc=teclado.nextInt();
						
						if(opc==1) {
							System.out.println("Descuento a trabajadores de planta: %"+incremento);
							miLista.incremento(incremento);
						}
						
						else if(opc==2) {
							System.out.println("No habrá incremento o descuento a los salarios de los trabajadores de planta");
						}
						else {
							System.out.println("Opción fuera de rango");
						}
					}
					else {
						System.out.println("Operación no válida");
					}
					
					break;
					
				case 5:
					System.out.println(miLista.horasExtra()+"\n");
					break;
				
				case 6:
					System.out.println(miLista.toString());
					break;
				case 7:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("Opción fuera de rango");
					break;
			}
			
		}while(opc!=7);
		
		teclado.close();
	}
}

