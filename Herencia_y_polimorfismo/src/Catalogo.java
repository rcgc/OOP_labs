
public class Catalogo {
	private int indice;
	private Articulo articulos[];
	
	public Catalogo() {
		int i;
		indice=0;
		articulos = new Articulo[50];
		for(i=0; i<50; i++) {
			articulos[i]=null;
		}
	}
	
	public Catalogo(int ind, Articulo arts[]) { //Asigno el arreglo de golpe
		indice=ind;
		articulos=arts;
		//for(i=0;i<ind; i++){
		//	articulos[i]=arts[i];
		//} ESTA ES OTRA FORMA DE HACERLO
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Articulo[] getArticulos() {
		return articulos;
	}

	public void setArticulos(Articulo[] articulos) {
		this.articulos = articulos;
	}
	//Aqui no hay equals
	
	public void agregarArticulo(Articulo art) {
		if(indice<=49) {
			articulos[indice]=art;
			indice++;
		}
		else if (indice>49) {
			System.out.println("El catálogo ya está lleno, no se puede agregar: "+art.getTitulo()+"\n");
		}
	}
	
	public void borrarArticulo(String cod) {
		int i,j;
		boolean enc=false;
		j=0;
		i=0;
		while((!enc)&&(i<50)) { 
			
			if(articulos[i]==null) { //Este funciona al no encontrar el artículo
				System.out.println("Artículo no encontrado\n"); //Mi catalogo hace recorrimiento, al encontrarse un null en la 
				return ;									//búsqueda, parará de buscar y retornará indicando que no encontró 
			}												//nada
			
			enc=articulos[i].getCodigo().equals(cod); //No se debe aplicar ignore case debido a que un código ID se debe que
			if(enc) {								  //mapear como tal, aplicando case sensitive
				j=i;
			}
			i++;
		}//while
		System.out.println("Eliminado: "+articulos[j].getTitulo());
		
		if(!enc) { //Este no funciona al no encontrar el artículo
			System.out.println("Articulo no encontrado");
		}
		else {
			//Recorrer articulos
			for(i=j;i<49;i++) {
				
				articulos[i]=articulos[i+1];
			}//for
			articulos[indice]=null;//vacío la última
			indice--;
		}//else
	}
	
	public void listaLibros(String aut) {
		int i;
		int contador=0;
		for(i=0; i<indice;i++) {
			if(articulos[i] instanceof Libro) {
				Libro aux = (Libro)articulos[i];
				if(aux.getAutor().equalsIgnoreCase(aut)) {
					System.out.println(aut+": "+articulos[i].getTitulo()+"\n");
					contador++;
				}
			}
		}
		if(contador==0) {
			System.out.println("No hay coincidencias\n");
		}
	}
		
	
	public void listaMusica(String title) {
		int i;
		int contador=0;
		for(i=0;i<indice;i++) {
			if(articulos[i] instanceof Musica) {
				Musica aux=(Musica)articulos[i];
				if(aux.getTitulo().equalsIgnoreCase(title)) {
					System.out.println(articulos[i].getTitulo()+": "+ articulos[i].getCodigo()+"\n");
					contador++;
				}
			}
		}
		if(contador==0) {
			System.out.println("No hay coincidencias\n");
		}
	}
	
	
	public void muestraLibros() {
		int i;
		for(i=0; i<50;i++) {
			if(articulos[i] instanceof Libro) {
				Libro aux1 = (Libro)articulos[i];
				System.out.println("\n "+(i+1)+" "+aux1.toString());
			}
			else {
				//Si no es libro no debe mostrar nada
			}
		}
	}
	
	public void muestraMusica() {
		int k;
		for(k=0; k<50;k++) {
			if(articulos[k] instanceof Musica) {
				Musica aux1=(Musica)articulos[k];
				System.out.println("\n "+(k+1)+" "+aux1.toString());
			}
			else {
				//Si no es musica no debe mostrar nada
			}
		}
	}
	
	
	
	public void muestraCat() {
		int i=0, cuantos=0;
		
		for(i=0; i<50; i++) {
			if(articulos[i] instanceof Libro) {
				Libro aux1= (Libro)articulos[i];
				System.out.println("\n "+(i+1)+" "+aux1.toString());
				cuantos++;
			}
			else if(articulos[i] instanceof Musica) {
				Musica aux1=(Musica)articulos[i];
				System.out.println("\n "+(i+1)+" "+aux1.toString());
				cuantos++;
			}
			else if(cuantos==0) {
				System.out.println("\nNo hay artículos en el catálogo");
			}
		}
	}
	
	public String toString(){ //Lo puedo usar para ver como es mi arreglo, que contiene
		int i;
		String cad="";
		
		for(i=0; i<50;i++) {
			cad+= articulos[i]+"\n";
		}
		
		return cad;
	}
}
