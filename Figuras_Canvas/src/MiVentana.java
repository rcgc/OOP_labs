import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class MiVentana extends JFrame implements ActionListener{
	private MiCanvas lienzo;
	
	public MiVentana() {
		super();
		lienzo=new MiCanvas();
		add(lienzo, BorderLayout.CENTER);
		
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		lienzo.repaint();
		
	}
	
	
	

}
