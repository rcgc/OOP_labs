
public class Stack {
	
	private int top;
	private int max;
	private int pila[];
	
	public Stack() {
		top =0;
		max=3;
		pila=new int[max];
	}
	
	public void setTop(int t) {
		this.top=t;
	}
	
	public int getTop() {
		return this.top;
	}
	
	public void setMax(int m) {
		this.max=m;
	}
	
	public int getMax() {
		return this.max;
	}
	
	
	
	public void push(int n) {//puedo indicar aqui throws FullStackException y no poner catch
		try {
			if(top <max) {
				pila[top]=n;
				top++;
			}else {
				
				throw new FullStackException("Stack exception");
			}
		}catch(FullStackException e) {//Captura mi tipo de excepción
			System.out.println(e.getMessage());
		}
	}
	
	public int pop() throws EmptyStackException { //Esta forma me obliga a lanzar la excepción en el main
		
		if(top>0) {
			top--;
					//No se puede borrar la posición como tal
			return pila[top];
		}
		else {
			throw new EmptyStackException("Está vacío\n");
		}
		//Si se usase try catch deberíamos usar en el catch return 0 
	}
	
	public String toString() {
		String msj="";
		int i=0;
		int c=1;
		
		for(i=0; i<3;i++) {
			msj+="\n#"+c+")"+pila[i];
		}
		
		
					
		return msj+"\n";
	}
}
