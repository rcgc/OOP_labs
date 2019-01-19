import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] args) {
		MiVentana ventana = new MiVentana();
		ventana.setSize(300,300);
		ventana.setTitle("Dibujando...");
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
	}
}
