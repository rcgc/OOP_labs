import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MiVentana extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MiCanvas canvas;
	
	public MiVentana() {
		super();
		this.setSize(300,300);
		canvas = new MiCanvas();
		add(canvas, BorderLayout.CENTER);
		
		
		//CENTRAR 
		this.setSize(300,300);
		
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getHeight(); //get the heigth of the frame
        
        int framelocationX=dim.width/2-framewidth/2; 
        int framelocationY=(dim.height)/2-frameheigth/2;
        this.setLocation(framelocationX,framelocationY);
		
	}
	
}
