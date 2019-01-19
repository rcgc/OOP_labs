import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultCaret;

/**
 * en esta clase se genera la ventana de instruciones la cual tiene el maual de uso, todas las intrucoiones estan en HTML
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * @version 2.0
 */

public class Instructions extends JFrame implements ActionListener{

	private JLabel etiqueta1;
	private JPanel panel1;

	private JEditorPane parrafo;
	private JScrollPane barraV;
	//private InputStream indexStream;
	
    private Image image;
    private ImageIcon ico;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @author HP
	 */
	
	public Instructions() {
		super("Instrucciones");
//-------------------------------------------------------Instanciación-------------------------------------------------------------
		etiqueta1=new JLabel();
		panel1   =new JPanel();
		parrafo  =new JEditorPane();

		
//-------------------------------------------------------Para JScrollPanel---------------------------------------------------------
		barraV   =new JScrollPane(parrafo);
		barraV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


//-------------------------------------------------------Agregando al JPanel-------------------------------------------------------
		panel1.add(barraV);
		panel1.add(etiqueta1);
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(new Color(82,130,242));
		
		add(panel1, BorderLayout.NORTH);
		//add(parrafo, BorderLayout.CENTER); //Creo que no es necesario esto gracias al JScrollPanel
		add(barraV, BorderLayout.CENTER);
		pack();		//Para qué sirve esto?-El método pack() hace que la ventana coja el tamaño más pequeño posible
					//que permita ver todos los componentes.

		
//-------------------------------------------------------Para JLabel--------------------------------------------------------------
		etiqueta1.setText("Typhoon 2.0");
		etiqueta1.setFont(new java.awt.Font("",Font.BOLD,22));
		
		
//-------------------------------------------------------Para JTextArea-----------------------------------------------------------
		DefaultCaret caret = (DefaultCaret) parrafo.getCaret();		//Para que el scroll se localice al inicio
		caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		
		parrafo.setEditable(false);
		parrafo.setBackground(null);
		parrafo.setAlignmentY(CENTER_ALIGNMENT);
		

		
		try {
			//Quitandole C: aun funciona
			//File file = new File("C:\\Users\\HP\\eclipse-workspace\\Proyecto\\src\\images\\index.html");
			
			//parrafo.setPage(file.toURI().toURL());
			
			
			
			
			//indexStream= Instructions.class.getResourceAsStream("images/index.html");
			
			//File file;
			
			
			
			parrafo.setContentType("text/html");			
			parrafo.setText(instructivo_html());
			
			
		}catch(Exception e) {
			parrafo.setText(instructivo_txt());
		}
		
	       
		
		//CENTRAR 
		this.setSize(400,400);
		
		
//----------------------------------------------------------Center window----------------------------------------------------------
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
	
//---------------------------------------------------------------------------------------------------------------------------------
		
		
	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public String instructivo_txt() {
		String msj=  "\t.........................................................................................\n"+
				  	 "\tMovimientos:......................................................................\n"+
				  	 "Para hacer que el personaje logre moverse	hay que usar las flechas del teclado y con ello el personaje"+
				  	 "\tse moverá en la respectiva dirección de la flecha presionada............................\n"+
				  	 "\t.........................................................................................\n"+
				  	 "\tAtaques:										\n"+
				  	 "\tPara hacer que el personaje despare				\n"+
				  	 "\tuna bala deberás presionar la barra espaciadora.\n"+
				  	 "\t												\n"+
				  	 "\tPersonajes:										\n"+
				  	 "\t¿Cómo Jugar?					\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaagjgjgaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n"+
				  	 "\tAaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n";
		
		return msj;
	}
	
	public String instructivo_html(){
		String msj="<html>"										+
				"<center><h1> ¿Cómo Jugar? </h1></center><hr>"	+
				"<meta charset=\"UTF-8\">"						+ 
				"<head>"										+ 
				"<title>Instructions</title>"					+ 
				"</head>"										+ 
				"<body>"										+ 
				
					"<h3>Movimientos:</h3>" 											+
						"<div align=\"justify\">Para hacer que el personaje logre " 	+ 
						"moverse hay que usar las flechas del teclado y con ello "  	+ 
						"el personaje se moverá en la respectiva " 						+ 
						"dirección de la flecha presionada. Para saltar basta con " 	+
						"presionar la letra X."											+ 
						"</div>" 		 												+
						"<br>"															+
						"" +//Debe ir imagen   
						"" +//debe ir "<br>" 
						
					"<h3>Ataques:</h3>" 												+ 
						"<div align=\"justify\">Para hacer que el personaje dispare "	+ 
						"una bala deberás presionar la letra Z."						+
						"</div>"		 												+
						"<br>"															+
						""+ //Debe ir imagen
						"" +//debe ir "<br>" 
						
					"<h3>Personajes:</h3>"												+ 
						"<div align=\"justify\">Los personajes que podrás " 			+ 
						"encontrar durante el juego son los siguientes: "				+
						"</div>"												 		+ 
						"<br>" 															+
						
						"<h3>Typhoon:</h3>"												+
							"<div align=\"justify\">Es el personaje principal, " 		+ 
							"su misión es derrotar al jefe \"Magnum\" quien ha "		+
							"quebrantado la paz en el mundo de Typhoon."				+
							"</div>"										 			+
							"<br>" 														+
						
						"<h3>Trooper:</h3>"												+ 
							"<div align=\"justify\">Es uno de los enemigos más " 		+ 
							"comunes a lo largo del juego, sólo avanza de forma "		+
							"terrestre, su velocidad es baja y disparará cuando "		+
							"Typhoon se halle a una cierta distancia. Matarlo te "		+
							"dará 100 puntos."											+
							"</div>"													+
							"<br>" 														+
	
						"<h3>Magnum:</h3>" 												+
							"<div align=\"justify\">Es el enemigo más poderoso y " 		+ 
							"último de los enemigos a derrotar, se gana el juego "		+
							"al derrotarlo, además de que te dará 1000 puntos."			+
							"</div>" 													+
							"<br>"	 													+
						
					"<h3>Niveles:</h3>" 												+
						"<div align=\"justify\">He aquí un breve resumen de los  "		+ 
						"niveles de este juego:"										+
						"</div>"													 	+
						"<br>"	 														+
					
						"<h3>Nivel 1:</h3>" 											+
							"<div align=\"justify\">El nivel uno es un recorrido por "	+
							"el mundo de los trooper, los cuáles deberás derrotar para "+
							"posteriormente pelear con magnum y derrotarlo para poder"  +
							"ganar el juego."											+
							"</div>"													+
							"<br>" 														+
						""																+
				"</body>"										+
				"</html>"										;
		
		return msj;
	}
}
