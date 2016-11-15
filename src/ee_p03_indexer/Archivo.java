package ee_p03_indexer;

import java.io.*;
import javax.swing.JOptionPane;
import ArbolAVL.*;

/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase Archivo que permite la lectura de un archivo cualquiera.
 */

public class Archivo {
	/**
	 * Atributos de la clase.
	 * Contendrá un ArbolAVL<T> para guardar la información leída.
	 * Arreglo de String para obtener los atributos.
	 */
	ArbolAVL<Atributo<String>> avl;
	String[] atributos;
		
	/**
	 * Constructor de la clase Archivo.
	 */
	public Archivo(){
		avl = new ArbolAVL<Atributo<String>>();
	}
	/**
	 * Método que permite obtener los atributos del archivo.
	 * @param archivo
	 */
	public void obtenerAtributos(String archivo){
	      String cadena = "";
	      try{
	    	  File file = new File(archivo);
	    	  BufferedReader br = new BufferedReader(new FileReader(file));
	    	  cadena = br.readLine(); 
	    	  atributos = cadena.split("\\|");
	    	  br.close();
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
	      }
	}
		
	/**
	 * Método que lee la información del archivo y la posición por la cuál se va a ordenar.
	 * @param archivo
	 * @param pos
	 */
	public void leerArchivo(String archivo, Integer pos){
	      String cadena = "";
	      String[] prueba = null;
	      try{
	    	  File file = new File(archivo);
	    	  BufferedReader br = new BufferedReader(new FileReader(file));
	    	  cadena = br.readLine(); 
	    	  while((cadena = br.readLine())!=null) {
	    		  prueba = cadena.split("\\|");	 
	    		  for(int i = 0; i < prueba.length; i++)
	    			  System.out.println(prueba[i]);
  			  avl.insertar(new Atributo<String>(prueba[pos]));
	    	  }
	    	  br.close();
	    	  BTreePrinter.printNode(avl.getRaiz());
	      } catch (IOException e) {
	    	  JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo.");
	      }
	}
		
	/**
	 * Método get que permite obtener el arreglo de atributos.
	 * @return
	 */
	public String[] getAtributos(){
		return atributos;
	}
		
	/**
	 * Método get para retornar el árbol AVL generado.
	 * @return
	 */
	public ArbolAVL<Atributo<String>> getAVL(){
		return avl;
	}
		
	/**
	 * Método buscar que invoca el método buscar de la clase ArbolAVL<T>.
	 * @param navl
	 * @param dato
	 * @return
	 */
	public String buscar2(NodoAVL<Atributo<String>> navl, String dato){
		return avl.buscar(navl, new Atributo<String>(dato));
	}	
}