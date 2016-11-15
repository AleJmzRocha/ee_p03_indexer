package ee_p03_indexer;

/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * TDA para almacenar la información.
 * @param <T>
 */
public class Atributo<T> implements Comparable<Atributo<T>>{
	/**
	 * Atributo de la clase que será de tipo String.
	 */
	private String dato;
	
	/**
	 * Constructor que recibe de parámetro el dato.
	 * @param dato
	 */
	public Atributo(String dato){
		this.dato = dato;
	}

	/**
	 * Método get que permite devolver el dato.
	 * @return
	 */
	public String getDato() {
		return dato;
	}

	/**
	 * Método set que permite modificar el dato.
	 * @param dato
	 */
	public void setDato(String dato) {
		this.dato = dato;
	}
		
	/**
	 * Método sobreecrito de la clase Comparable<T>.
	 * @return
	 */
	@Override
	public int compareTo(Atributo<T> o) {
		return this.dato.compareTo(o.getDato());
	}
	
	/**
	 * Método toString() sobreescrito de la clase Object.
	 * @return
	 */
	public String toString(){
		String s = "";
		s += dato;
		return s;
	}	
}