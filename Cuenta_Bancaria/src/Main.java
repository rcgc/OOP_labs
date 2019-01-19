import java.util.Scanner;
public class Main {
	
	public static void menu() {
		System.out.println();
		System.out.println("Menu");
		System.out.println("1.Realizar depósito");
		System.out.println("2.Consultar saldo");
		System.out.println("3.Realizar retiro");
		System.out.println("4.Datos de cuenta: ");
		System.out.println("5.Cambiar password");
		System.out.println("6.Salir");
		
	}
	
	public static void main(String args[]) {
		int opc;
		long id;
		
		double dep;
		double ret;
		int pwd;
		
		Scanner teclado = new Scanner (System.in);
		Cuenta_Bancaria Roberto=new Cuenta_Bancaria(0,0,"Roberto",0,"");//No debería tener paraámetros
													//long id, int p, String n, double s, String b
		Cuenta_Bancaria cliente=new Cuenta_Bancaria(1234567890123456L,1234, "Cliente 1", 1500, "Santander");
		
		
		do {
			menu();
			opc=teclado.nextInt();
			teclado.nextLine();
			switch(opc) {
				case 1:
					System.out.println("Cuenta a depositar: ");
					id=teclado.nextLong();
					if(id==Roberto.getId()) {
						System.out.println("Monto a depositar: ");
						dep=teclado.nextDouble();
						teclado.nextLine();
						Roberto.depositar(dep);
						
					}
					else if(id==cliente.getId()) {
						System.out.println("Monto a depositar: ");
						dep=teclado.nextDouble();
						teclado.nextLine();
						cliente.depositar(dep);
						
					}
					else {
						System.out.println("Numero de cuenta erróneo");
					}
					
					break;
				case 2:
					
					System.out.println("Cuenta: ");
					id=teclado.nextLong();
					teclado.nextLine();
					
					System.out.println("Password: ");
					pwd=teclado.nextInt();
					teclado.nextLine();
					
					if(id==Roberto.getId() && pwd==Roberto.getPin()) {
						System.out.println("Saldo: "+Roberto.getSaldo());
					}
					
					else if(id==cliente.getId() && pwd==cliente.getPin()) {
						System.out.println("Saldo: "+cliente.getSaldo());
					}
					
					else {
						System.out.println("Datos incorrectos");
					}
					
					
					
					break;
				case 3:
					System.out.println("Cuenta: ");
					id=teclado.nextLong();
					teclado.nextLine();
					
					System.out.println("Password: ");
					pwd=teclado.nextInt();
					teclado.nextLine();
										
					if(id==Roberto.getId() && pwd==Roberto.getPin()) {
						System.out.println("Monto a retirar: ");
						ret=teclado.nextDouble();
						if(ret<=Roberto.getSaldo()) {
							Roberto.retirar(ret);
						}
						else {
							System.out.println("Sin fondos suficientes");
						}
					}
					
					else if(id==cliente.getId() && pwd==cliente.getPin()) {
						System.out.println("Monto a retirar: ");
						ret=teclado.nextDouble();
						if(ret<=Roberto.getSaldo()) {
							Roberto.retirar(ret);
						}
						else {
							System.out.println("Sin fondos suficientes");
						}
					}
					
					else {
						System.out.println("Datos incorrectos");
					}
					
					
					
					break;
			
				case 4:
					System.out.println("Cuenta: ");
					id=teclado.nextLong();
					teclado.nextLine();
					
					System.out.println("Password: ");
					pwd=teclado.nextInt();
					teclado.nextLine();
										
					if(id==Roberto.getId() && pwd==Roberto.getPin()) {
						System.out.println("\n"+Roberto.toString());
					}
					
					else if(id==cliente.getId() && pwd==cliente.getPin()) {
						System.out.println("\n"+cliente.toString());
					}
					
					else {
						System.out.println("Datos incorrectos");
					}
					break;
				
				case 5:
					System.out.println("Cuenta: ");
					id=teclado.nextLong();
					teclado.nextLine();
					
					System.out.println("Password: ");
					pwd=teclado.nextInt();
					teclado.nextLine();
										
					if(id==Roberto.getId() && pwd==Roberto.getPin()) {
						System.out.println("Nuevo password: ");
						pwd=teclado.nextInt();
						teclado.nextLine();
						Roberto.setPin(pwd);
					}
					
					else if(id==cliente.getId() && pwd==cliente.getPin()) {
						System.out.println("Nuevo password: ");
						pwd=teclado.nextInt();
						teclado.nextLine();
						cliente.setPin(pwd);
					}
					
					else {
						System.out.println("Datos incorrectos");
					}
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
