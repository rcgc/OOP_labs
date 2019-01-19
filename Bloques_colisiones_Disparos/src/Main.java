import javax.swing.JFrame;

public class Main {

	
	public static void main(String [] args) {
		
		MiVentana ventana = new MiVentana();
		ventana.setTitle("Colisiones/Disparos");
		ventana.setSize(400,400);
		ventana.setVisible(true);
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setFocusableWindowState(true);
		
		
	}
}
