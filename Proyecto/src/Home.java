import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




/**
 * la clase Home sirve como menu principal del juego, de donde se despliega
 * las ventanas correspondientes entre el juego, el instructivo y sus creadores 
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * @version 2.0
 *
 */
public class Home extends JFrame implements ActionListener{	//Me marca error porque cuando se emplean interfaces
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton boton1, boton2, boton3;							//se usan todos los metodos abstractos de la interfaz
	private JPanel panel, panel2;
	private JLabel portada;
	
    private Image image;
    private ImageIcon ico;
	
	/**
	 * construcor de la clase Home
	 */
	public Home() {
		super("Typhoon 2.0");
		setLayout(new BorderLayout());
		boton1  = new JButton("   Jugar  ");
		boton2  = new JButton("Como jugar");
		boton3  = new JButton("Acerca de");
		panel   = new JPanel();
		panel2  = new JPanel();
		portada = new JLabel();
		
		
		
		
		ico = new ImageIcon(getClass().getResource("/images/portada.png"));
		image = ico.getImage();
		
		portada.setIcon(ico);
				
		//Escuchar mis componentes
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
		
		panel.setLayout(new FlowLayout());
		panel2.setLayout(new FlowLayout());
		
		panel.add(boton1);
		panel.add(boton2);
		panel.add(boton3);
		
		panel2.add(portada);
		//this.add(pintado);
		//this.add(panel);
		
		add(panel, BorderLayout.SOUTH);
		add(panel2, BorderLayout.CENTER);
		
		panel.setBackground(new Color (81,46,5));
		panel2.setBackground(new Color(82,130,242));
		//panel2.setBackground(Color.GREEN);
		
		//CENTRAR 
		this.setSize(400,400);
		
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		
        int framewidth=this.getSize().width;//get the width of the frame
        int frameheigth=this.getHeight(); //get the heigth of the frame
        
        int framelocationX=dim.width/2-framewidth/2; 
        int framelocationY=(dim.height)/2-frameheigth/2;
        this.setLocation(framelocationX,framelocationY);
        
        ico = new ImageIcon(getClass().getResource("/images/icon.png"));
    	image = ico.getImage();
    	this.setIconImage(image);
		
		
	}
	
	/**
	 * en este metodo se revisa por eventos para cambiar de ventana
	 * @param e, este sirve para verificar la existencia de algun evento el cual en este caso es el presionar alguno de las opciones
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==boton1) {
			//Me mandara a jugar
			Juego ventanaJuego = new Juego();
			
			//ventanaJuego.setSize(760,650);
			ventanaJuego.setVisible(true);
			//ventanaJuego.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			ventanaJuego.setResizable(false);
			this.dispose();
			
			
		}
		
		if(e.getSource()==boton2) {
			//Debe una nueva ventana con el instructivo
			Instructions ventanaIns = new Instructions();
			
	        //ventanaIns.setSize(400,400);
	        ventanaIns.setVisible(true);
	        ventanaIns.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	        ventanaIns.setResizable(false);
			
		}
		
		if(e.getSource()==boton3) {
			ico = new ImageIcon(getClass().getResource("/images/icon2.png"));
			//Debe mostrar notificación del about
			JOptionPane.showMessageDialog(null, "Desarrollado por: \nRodrigo Gutiérrez     ISD\nRoberto Guzmán       ISC\n\n"+
					"        Curso de POO \n           ITESM QRO \n Agosto-Diciembre 2017 ", 
					"Acerca de", JOptionPane.INFORMATION_MESSAGE, ico);
			//El último parámetro es para un ícono personalizado
		}
	    
	}
}
