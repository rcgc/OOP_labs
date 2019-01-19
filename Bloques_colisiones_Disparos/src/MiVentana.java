import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MiVentana extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MiCanvas lienzo;
	
	public MiVentana() {
		lienzo= new MiCanvas();
		
		add(lienzo, BorderLayout.CENTER);
	}
	
}
