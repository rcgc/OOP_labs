
public class Nomina {
	private int indice;
	private Empleado empleados[]; //Tipo de datos Empleado, no String
	private int noEmpleados;
	
	
	public Nomina(){
		int i;
		indice=0;
		noEmpleados=50;
		
		empleados=new Empleado[50];
		for(i=0; i<noEmpleados;i++) {
			empleados[i]=null;
		}
	}
	
	public Nomina(Empleado [] e, int ne, int ind) {
		empleados=e;
		noEmpleados=ne;
		indice=ind;
	}

	public Empleado[] getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleado[] empleados) {
		this.empleados = empleados;
	}

	public int getNoEmpleados() {
		return noEmpleados;
	}

	public void setNoEmpleados(int noEmpleados) {
		this.noEmpleados = noEmpleados;
	}
	
	
	
	public boolean agregarEmpleado(Empleado e) {
		if(indice<49) {
			empleados[indice]=e;
			indice++;
			return true;
		}
		else {
			System.out.println("Base de datos llena, no se puede agregar: "+empleados[indice].getNombre());
			return false;
		}
	}
	
	public void borrarEmpleado(int id) {
		int i, j;
		boolean bandera=false;
		i=0;
		j=0;
		
		while((!bandera)&&(i<50)) {
			if(empleados[i]==null) {
				System.out.println("No existen coincidencias\n");
				return;
			}
			bandera=(empleados[i].getId()==id);
			
			if(bandera) {
				j=i;
			}i++;
		}//while
		System.out.println("Eliminado: "+empleados[j].getNombre()+"\n");
		
		if(!bandera) {
			System.out.println("Not found");
			//return; debería que retornar
		}
		else {
			for(i=j;i<49;i++) {
				empleados[i]=empleados[i+1];
			}//for
			empleados[indice]=null;
			indice--;//Para que baje de la posición null
					 //a una posición ocupada
		}//else
	}
	
	public double nominaMensual() {
		double nomina=0; //Todo lo que se debe que pagar por los salarios de los trabajadores,
						 // todos ganan mensual aquí se contempla
		
		for(int i=0; i<49; i++) {
			
			if(empleados[i] instanceof Planta) {
				Planta aux1 = (Planta)empleados[i];
				nomina+=aux1.pagoMensual(); //Mando a llamar al método pago mensual
			}
			if(empleados[i] instanceof Porhora) {
				Porhora aux2 = (Porhora)empleados[i];
				nomina+=aux2.pagoMensual(); //Mando a llamar al método pago mensual
			}
			 
		}
		
		return nomina;
	}
	
	
	public void incremento(double porcentaje) {// Este método incrementa el salario x % a todos los empleados de planta.
		int i;								   //El porcentaje ya me lo dan
		double nuevoSalario;
		
		for(i=0;i<50;i++) {
			if(empleados[i] instanceof Planta) {
				Planta aux1=(Planta)empleados[i];
				nuevoSalario=aux1.getSalario()+aux1.getSalario()*porcentaje/100;
				aux1.setSalario(nuevoSalario);
			}
		}
	}
	
	
	
	public int horasExtra() { //Este método regresará cuantos empleados en la nomina trabajaron más de 40 horas .
		int total=0;
		int i=0;
		int contador=0;
		
		for(i=0; i<50;i++) {
			if(empleados[i] instanceof Porhora) {
				Porhora aux =(Porhora)empleados[i];
					contador++;
				if(aux.getHorasTrabajadas()>40) {
					System.out.println(aux.toString()+"\n"+"Horas/semana: "+aux.getHorasTrabajadas()+"\nPago/hora: $"+aux.getPagoHora()+"\nPago mensual: $"+aux.pagoMensual());
					total++;
				}
			}
		}
		
		if(contador==0) {
			System.out.println("No hay empleados trabajando del tipo: por hora");
		}
		System.out.println("\nEmpleados con horas extra: ");
		return total;
		
	}
	
	public String toString() { //Este método regresará la información de todos los empleados en la nómina.
		int i;
		String msj= "\n";
		
		for(i=0; i<50;i++) {
			if(empleados[i] instanceof Planta) {
				Planta aux=(Planta)empleados[i];
				
				msj+="#"+i+" "+aux.toString()+"\nSalario: $"+aux.getSalario()+"\nTipo: Planta\n\n";
			}
			
			else if(empleados[i] instanceof Porhora) {
				Porhora aux1 = (Porhora)empleados[i];
				msj+="#"+i+" "+aux1.toString()+"\nPago/hora: $"+aux1.getPagoHora()+
					 "\nHoras/semana: "+aux1.getHorasTrabajadas()+"\nPago mensual: $"+aux1.pagoMensual()+"\nTipo: por hora\n\n";
			}
		}
		
		return msj;
	}
}
