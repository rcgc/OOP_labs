import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * Clase Faro sirve para generar la imagen del enemigo, aparte de darle atributos tales como su campo de vision, junto con sus puntos
 * @author Roberto Guzmán
 * @author Rodrigo Gutiérrez
 * esta clase sirve para poder ejecutar el programa
 * @ version 1.0
 */


public class Main{

	
    public static void main(String[] args){
    	
    	Home ventanaHome= new Home();
    	
    	
    	
        //ventanaHome.setSize(400,400);
        ventanaHome.setVisible(true);
        ventanaHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaHome.setResizable(false);	        
        
        //Image icon = Toolkit.getDefaultToolkit().getImage("");
        //ventanaHome.setIconImage(icon);
    	
	}
}
