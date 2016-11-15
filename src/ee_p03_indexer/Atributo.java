package ee_p03_indexer;

/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * TDA para almacenar la informaci�n.
 * @param <T>
 */
public class Atributo<T> implements Comparable<Atributo<T>>{
	/**
	 * Atributo de la clase que ser� de tipo String.
	 */
	private String dato;
	
	/**
	 * Constructor que recibe de par�metro el dato.
	 * @param dato
	 */
	public Atributo(String dato){
		this.dato = dato;
	}

	/**
	 * M�todo get que permite devolver el dato.
	 * @return
	 */
	public String getDato() {
		return dato;
	}

	/**
	 * M�todo set que permite modificar el dato.
	 * @param dato
	 */
	public void setDato(String dato) {
		this.dato = dato;
	}
		
	/**
	 * M�todo sobreecrito de la clase Comparable<T>.
	 * @return
	 */
	@Override
	public int compareTo(Atributo<T> o) {
		return this.dato.compareTo(o.getDato());
	}
	
	/**
	 * M�todo toString() sobreescrito de la clase Object.
	 * @return
	 */
	public String toString(){
		String s = "";
		s += dato;
		return s;
	}	
}