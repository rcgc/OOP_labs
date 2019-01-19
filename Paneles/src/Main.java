import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		MiVentana ventana = new MiVentana();
		ventana.setSize(200,200);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
	}
}
