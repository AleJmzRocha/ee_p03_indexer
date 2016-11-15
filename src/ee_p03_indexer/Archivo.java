package ee_p03_indexer;

import java.io.*;
import javax.swing.JOptionPane;
import ArbolAVL.*;

/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase Archivo que permite la lectura de un archivo cualquiera.
 */

public class Archivo {
	/**
	 * Atributos de la clase.
	 * Contendr� un ArbolAVL<T> para guardar la informaci�n le�da.
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
	 * M�todo que permite obtener los atributos del archivo.
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
	    	  JOptionPane.showMessageDialog(null, "Ocurri� un error al leer el archivo.");
	      }
	}
		
	/**
	 * M�todo que lee la informaci�n del archivo y la posici�n por la cu�l se va a ordenar.
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
	    	  JOptionPane.showMessageDialog(null, "Ocurri� un error al leer el archivo.");
	      }
	}
		
	/**
	 * M�todo get que permite obtener el arreglo de atributos.
	 * @return
	 */
	public String[] getAtributos(){
		return atributos;
	}
		
	/**
	 * M�todo get para retornar el �rbol AVL generado.
	 * @return
	 */
	public ArbolAVL<Atributo<String>> getAVL(){
		return avl;
	}
		
	/**
	 * M�todo buscar que invoca el m�todo buscar de la clase ArbolAVL<T>.
	 * @param navl
	 * @param dato
	 * @return
	 */
	public String buscar2(NodoAVL<Atributo<String>> navl, String dato){
		return avl.buscar(navl, new Atributo<String>(dato));
	}	
}