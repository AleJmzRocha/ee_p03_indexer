package ee_p03_indexer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 * 
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase Buttons que permite la visualización de la primera ventana de la interfaz.
 */
public class Buttons extends JFrame implements ActionListener{
	/**
	 * Atributos de la clase.
	 */
	private static final long serialVersionUID = 1L;
	JPanel jpanel = (JPanel) this.getContentPane();
	JPanel jpanel2 = (JPanel) this.getContentPane();
	JPanel jpanel3 = (JPanel) this.getContentPane();
	JLabel jlabel = new JLabel(), jlabel2 = new JLabel();
	JTextField jtextfield = new JTextField();    
	JButton jb, jb2;
	JFileChooser fileChooser = new JFileChooser();
	File f;
	Interfaz v;
	Archivo archivo = new Archivo();
	JRadioButton[] botones;
	ButtonGroup grupo = new ButtonGroup();
	
	/**
	 * Constructor de la interfaz.
	 */
	public Buttons() {		    
		setSize(300,320);        
		setTitle("Indexador");        
		setVisible(true);
		jpanel.setLayout(null);
		jpanel2.setLayout(null);
		jpanel3.setLayout(null);
		jb = new JButton("Abrir");
		jb.addActionListener(this);
	          
		jlabel.setBounds(new Rectangle(5, 15, 220, 21));
		jlabel.setText("Abrir archivo");
		jtextfield.setBounds(new Rectangle(90, 15, 80, 21));
		jb.setBounds(180,15,80,21);
		
		jpanel.add(jlabel, null);
		jpanel.add(jtextfield, null);
		jpanel.add(jb,null);
	     
		jlabel2.setBounds(new Rectangle(5, 30, 220, 40));
		jlabel2.setText("Indexador Datos");
				
		jpanel2.add(jlabel2, null);
	}
	
	/**
	 * Método que permite una acción de un botón.
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() ==  jb){
			fileChooser.showOpenDialog(null);
			f = fileChooser.getSelectedFile();
			jtextfield.setText(f.getName());
			archivo.obtenerAtributos(f.getAbsolutePath());
			botones = new JRadioButton[archivo.atributos.length];
			jpanel2.setLayout(new GridLayout(5,1));
	        pack();
			jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));			
	        setVisible(true);
			Integer j = 0;
			for(int i = 0; i < botones.length; i++){
				botones[i] = new JRadioButton(archivo.atributos[j]);
				j++;
			}
			
			for(int s = 0; s < botones.length; s++)
				grupo.add(botones[s]);
			
			for(int x = 0; x < botones.length; x++)
				jpanel2.add(botones[x]);
			
			jb2 = new JButton("Aceptar");
			jb2.addActionListener(this);
			jb2.setBounds(10,250,80,21);
			jpanel3.add(jb2,null);
			pack();
		}else
			if(e.getSource() == jb2){			
				for(int k = 0; k < botones.length; k++)
					if(botones[k].isSelected() == true){
						archivo.leerArchivo(f.getAbsolutePath(), k);
						v = new Interfaz(archivo.avl.getRaiz());
					}
			}				
	}
	
	/**
	 * Método main que permite accionar la ventana Buttons.
	 * @param arg
	 */
	public static void main(String arg[]) { 
		new Buttons();  
	}
}
