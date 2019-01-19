import java.awt.BorderLayout;
import javax.swing.JFrame;

public class MiVentana extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MiCanvas canvas;
	
	public MiVentana() {
		super();
		
		canvas = new MiCanvas();
		add(canvas, BorderLayout.CENTER);
		
		
	}
	
}
