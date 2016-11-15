package ee_p03_indexer;

import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.*;
import ArbolAVL.*;
/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase Interfaz que permite mostrar una ventana accionada por la ventana principal.
 */
public class Interfaz extends JFrame implements ActionListener{
	/**
	 * Atributos de la clase.
	 */
	private static final long serialVersionUID = 1L;
	JPanel jpanel = (JPanel) this.getContentPane();
	JPanel jpanel2 = (JPanel) this.getContentPane();
	JPanel jpanel3 = (JPanel) this.getContentPane();
	JPanel jpanel4 = (JPanel) this.getContentPane();
	JLabel jlabel = new JLabel(), jlabel2 = new JLabel(), jlabel3 = new JLabel(), jlabel4 = new JLabel();
	JButton jb, jb2;
	JTextField jtextfield = new JTextField();  
	Archivo ar = new Archivo();
	NodoAVL<Atributo<String>> navl;

	/**
	 * Constructor que recibe como parámetro un NodoAVL<T>.
	 * @param navl
	 */
	public Interfaz(NodoAVL<Atributo<String>> navl){
		this.navl = navl;
		setSize(300,220);        
		setTitle("Indexador");        
		setVisible(true);
		jpanel.setLayout(null);
		jpanel2.setLayout(null);
		jpanel3.setLayout(null);
		jpanel4.setLayout(null);
		jb = new JButton("Buscar");
		jb.addActionListener(this);
		jb2 = new JButton("Aceptar");
		jb2.addActionListener(this);
	          
		jlabel.setBounds(new Rectangle(5, 15, 220, 21));
		jlabel.setText("Dato a buscar");
		jtextfield.setBounds(new Rectangle(90, 15, 80, 21));
		jb.setBounds(180,15,80,21);
		jb2.setBounds(10,150,80,21);
     
		jpanel.add(jlabel, null);
		jpanel.add(jtextfield, null);
		jpanel.add(jb,null);
	     
		jlabel2.setBounds(new Rectangle(5, 45, 220, 40));
		jlabel2.setText("Resultados");
		
		jlabel3.setBounds(new Rectangle(5, 80, 220, 40));
		jlabel3.setText("");
		
		jlabel4.setBounds(new Rectangle(5, 110, 220, 40));
		jlabel4.setText("");
		
		jpanel2.add(jlabel2, null);
		jpanel3.add(jlabel3, null);
		jpanel3.add(jlabel4, null);
		jpanel4.add(jb2, null);
	}
	
	/**
	 * Método que permite hacer una acción sobre un botón.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jb2)
			System.exit(0);
		else
			if(e.getSource() == jb){				
				long TInicio, TFin, tiempo; 
				TInicio = System.currentTimeMillis();
				String s = ar.buscar2(navl, jtextfield.getText());	
				TFin = System.currentTimeMillis(); 
				tiempo = TFin - TInicio;
				String cad = "Tiempo de ejecución: " + tiempo + " milisegundos.";
				jlabel3.setText(s);
				jlabel4.setText(cad);
			}
	}
}