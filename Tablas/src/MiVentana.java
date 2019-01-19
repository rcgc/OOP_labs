import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class MiVentana extends JFrame{
	
	private JPanel panel;
	private JTable table;
	private JScrollPane scroll;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MiVentana() {
		super();
		panel   = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		
		 
		TableModel dataModel = new AbstractTableModel() {
	          public int getColumnCount() { return 11; }
	          public int getRowCount() { return 11;}
	          public Object getValueAt(int row, int col) { return new Integer(row*col); }
	          
	     };
	     
	      
	    table = new JTable(dataModel);
	    table.setBackground(Color.WHITE);
	    table.setTableHeader(null);
	    scroll = new JScrollPane(table);
		
		
		
		add(panel, BorderLayout.CENTER);
		panel.add(scroll);
		
	}
}
