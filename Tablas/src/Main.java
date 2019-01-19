import javax.swing.JFrame;

public class Main  {

	public static void main(String args[]) {
		
		MiVentana vent= new MiVentana();
		vent.setTitle("Tabla 1");
		vent.setSize(400,400);
		vent.setVisible(true);
		vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}		
	
}
