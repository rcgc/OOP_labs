import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;



/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * en esta clase se genera la ventana para poder reproducir el juego
 */
public class Juego extends JFrame implements WindowListener{
	private Image image;
	private ImageIcon ico;
    
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MiCanvas_Nivel_1 lienzo;
	
	/**
	 * constructor de la clase jeugo
	 */
	public Juego() {
		super();
		
		
		//CENTRAR 
		this.setSize(760,650);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getHeight(); //get the heigth of the frame
        
        int framelocationX=dim.width/2-framewidth/2; 
        int framelocationY=(dim.height)/2-frameheigth/2;
        this.setLocation(framelocationX,framelocationY);
        
        addWindowListener(this);
        
        lienzo	=new MiCanvas_Nivel_1();
        add(lienzo, BorderLayout.CENTER);
        
        ico		= new ImageIcon(getClass().getResource("/images/icon.png"));
    	image	= ico.getImage();
    	this.setIconImage(image);
    	
        
	}
	
	
	/**
	 * Metodo autogenerado por la interfase WindowListener
	 */
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo autogenerado por la interfase WindowListener
	 */
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	/**
	 * este metodo se encarga de cerrar la pestaña del juego en cuanto termina
	 * @param e, este se encarga de revisar por cualquier evento ocurido en la ventana
	 */
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Home ventanaHome = new Home();
		ventanaHome.setVisible(true);
        ventanaHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaHome.setResizable(false);
		
	}

	/**
	 * Metodo autogenerado por la interfase WindowListener
	 */
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo autogenerado por la interfase WindowListener
	 */
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo autogenerado por la interfase WindowListener
	 */
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Metodo autogenerado por la interfase WindowListener
	 */
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}