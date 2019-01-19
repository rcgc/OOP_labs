
public class Main {

	public static void main(String[] args) {
		int i=0;
		// Se crea este Main para tener una programación más modular
		
		
									//Creamos el objeto, instanciamos la clase
									//Perros doggie=new Perros();
		Perros doggie= new Perros("doberman",1,"poker");
		Perros cancan =new Perros ("Collie",2,"CanCan");
		
		doggie.ladra();
		cancan.ladra();
		
		while(i<=1) {
			doggie.muevelaCola();
			i++;
		}
		System.out.println(doggie.getNombre());//Se necesitan setters and getters para evitar error
		System.out.println(cancan.getNombre());
	}

}
