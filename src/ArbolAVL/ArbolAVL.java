package ArbolAVL;

/**
 * @authors Le�n Felipe Villavicencio Fern�ndez
 * 
 * Clase que permite crear un �rbol balanceado AVL(Adelson-Velskii-Landis).
 * @param <T>
 */
public class ArbolAVL<T extends Comparable<T>>{
	/**
	 * Atributo de la clase.
	 */
    NodoAVL<T> raiz;
    
    /**
     * Constructor del �rbol AVL.
     */
    public ArbolAVL() {
    	this.raiz = null;
	}
    
    /**
     * M�todo que retorna la ra�z del �rbol AVL.
     * @return
     */
    public NodoAVL<T> getRaiz() {
		return raiz;
	}

    /**
     * M�todo que modifica la ra�z del �rbol AVL.
     * @param raiz
     */
	public void setRaiz(NodoAVL<T> raiz) {
		this.raiz = raiz;
	}

	/**
	 * M�todo que permite revisar la rama izquierda del �rbol.
	 * @param nodo
	 * @param direccion
	 */
	public void revisarI(NodoAVL<T> nodo, Integer direccion){
        NodoAVL<T> nodo1, nodo2, nodo3;
        if (direccion ==-1){
          nodo1=(NodoAVL<T>) nodo.getIzquierda();
          nodo2=(NodoAVL<T>) nodo1.getIzquierda();
        }else{
          nodo1=(NodoAVL<T>) nodo.getDerecha();
          nodo2=(NodoAVL<T>) nodo1.getIzquierda();    
        }
        if(nodo2.getFe() == -1){// Rotacion II
            nodo1.setIzquierda(nodo2.getDerecha());
            nodo2.setDerecha(nodo1);
            nodo1.setFe(0);
            if (direccion == -1){
                nodo.setIzquierda(nodo2);
            }else{
                nodo.setDerecha(nodo2); 
            }
        }else{ // Rotacion ID
            nodo3 = (NodoAVL<T>) nodo2.getDerecha();
            nodo1.setIzquierda(nodo3.getDerecha());
            nodo3.setDerecha(nodo1);
            nodo2.setDerecha(nodo3.getIzquierda());
            nodo3.setIzquierda(nodo2);
            if(nodo3.getFe() == -1){
                nodo1.setFe(1);
            }else{
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == 1){
                nodo2.setFe(-1);
            }else{
                nodo2.setFe(0);
            }
            if (direccion == -1){
                nodo.setIzquierda(nodo3);
            }else{
                nodo.setDerecha(nodo3); 
            }
            
        }
        nodo1.setFe(0);
    }
    
	/**
	 * M�todo que permite revisar la rama derecha del �rbol.
	 * @param nodo
	 * @param direccion
	 */
    public void revisarD(NodoAVL<T> nodo, Integer direccion){
        NodoAVL<T> nodo1, nodo2, nodo3;
        if (direccion ==-1){
            nodo1=  nodo.getIzquierda();
            nodo2=  nodo1.getDerecha();
        }else{
            nodo1=  nodo.getDerecha();
            nodo2=  nodo1.getDerecha();
        }
        if(nodo2.getFe() == 1){// Rotacion DD
            nodo1.setDerecha(nodo2.getIzquierda());
            nodo2.setIzquierda(nodo1);
            nodo1.setFe(0);
            if (direccion == -1){
                nodo.setIzquierda(nodo2);
            }else{
                nodo.setDerecha(nodo2); 
            }
            
            
        }else{ // Rotacion DI
            nodo3 = (NodoAVL<T>) nodo2.getIzquierda();
            nodo1.setDerecha(nodo3.getIzquierda());
            nodo3.setIzquierda(nodo1);
            nodo2.setIzquierda(nodo3.getDerecha());
            nodo3.setDerecha(nodo2);
            if(nodo3.getFe() == 1){
                nodo1.setFe(-1);
            }else{
                nodo1.setFe(0);
            }
            if (nodo3.getFe() == -1){
                nodo2.setFe(1);
            }else{
                nodo2.setFe(0);
            }
            if (direccion == -1){
                nodo.setIzquierda(nodo3);
            }else{
                nodo.setDerecha(nodo3); 
            }
            
        }
        nodo1.setFe(0);
    }
    
    /**
     * M�todo auxiliar de inserci�n.
     * @param nodo
     * @param dato
     * @return
     */
    private Integer _insertar(NodoAVL<T> nodo, T dato){
        Integer resultado = 0;
        if (dato.compareTo(nodo.getDato()) < 0){
            if (nodo.getIzquierda() == null){
                nodo.setIzquierda(new NodoAVL<T>(dato));
                switch ( (nodo).getFe()){
                case 1: // El arbol se balance�
                     (nodo).setFe(0);
                    resultado = 0;
                    break;
                case 0: // Se carg� del lado izquierdo
                     (nodo).setFe(-1);
                    resultado = 1;
                    break;              
                }
                //resultado = 1;
                
            }else{
                switch (_insertar(nodo.getIzquierda(),dato)){
                case 1: // Se insrt� un dato nuevo, revisar.
                    switch ( (nodo).getFe()){
                    case 1: // El arbol se balance�
                         (nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se carg� del lado izquierdo
                         (nodo).setFe(-1);
                        resultado = 1;
                        break;  
                    case -1: // Reestructuracion del arbol
                        //if (nodo == raiz){
                            resultado = -1;
                        //}else{                        
                            
                            
                            
                        //}
                        break;
                    }
                    break;
                case -1:
                    revisarI( (nodo),-1);
                    break;
                case -2:
                    revisarD( (nodo),-1);
                    break;
                    
            
                    
                }
                
                
            }
        }else{
            if (dato.compareTo(nodo.getDato()) > 0){
                if (nodo.getDerecha() == null){
                    nodo.setDerecha(new NodoAVL<T>(dato));
                    switch ( (nodo).getFe()){
                    case -1: // El arbol se balance�
                         (nodo).setFe(0);
                        resultado = 0;
                        break;
                    case 0: // Se carg� del lado izquierdo
                         (nodo).setFe(1);
                        resultado = 1;
                        break;              
                    }
                }else{
                    switch (_insertar(nodo.getDerecha(),dato)){
                    case 1: // Se insrt� un dato nuevo, revisar.
                        switch ( (nodo).getFe()){
                        case -1: // El arbol se balance�
                             (nodo).setFe(0);
                            resultado = 0;
                            break;
                        case 0: // Se carg� del lado der
                             (nodo).setFe(1);
                            resultado = 1;
                            break;  
                        case 1: // Reestructuracion del arbol
                                resultado = -2;
                            }
                            break;
                    case -1:
                        revisarI( (nodo),1);
                        break;
                    case -2:
                        revisarD( (nodo),1);
                    break;
                    
                        }                       
                        
                    }
                }
            }
        
        
        return resultado;
     
   }
    
   /**
    * M�todo que permite insertar valores en el �rbol AVL.   
    * @param dato
    * @return
    */
    public Integer insertar(T dato) {
        if (raiz == null){
            raiz = new NodoAVL<T>(dato);
        }else{
            Integer result = _insertar(raiz, dato);
            if (result == -1){
            
                // Reestructuraci�n del arbol
                    NodoAVL<T> nodo1, nodo2;
                    nodo1=  raiz.getIzquierda();
                    
                    if(nodo1.getFe() == -1){// Rotacion II
                        raiz.setIzquierda(nodo1.getDerecha());
                        nodo1.setDerecha(raiz);
                         (raiz).setFe(0);
                        raiz = nodo1;
                    }else{ // Rotacion ID
                        nodo2 = (NodoAVL<T>) nodo1.getDerecha();
                        raiz.setIzquierda(nodo2.getDerecha());
                        nodo2.setDerecha(raiz);
                        nodo1.setDerecha(nodo2.getIzquierda());
                        nodo2.setIzquierda(nodo1);
                        if(nodo2.getFe() == -1){
                             (raiz).setFe(1);
                        }else{
                             (raiz).setFe(0);
                        }
                        if (nodo2.getFe() == 1){
                            nodo1.setFe(-1);
                        }else{
                            nodo1.setFe(0);
                        }
                        raiz = nodo2;
                    }
                     (raiz).setFe(0);
            
                
                         
            }else if (result == -2){
                // Reestructuraci�n del arbol
                NodoAVL<T> nodo1, nodo2;
                nodo1=  raiz.getDerecha();
                
                if(nodo1.getFe() == 1){// Rotacion DD
                    raiz.setDerecha(nodo1.getIzquierda());
                    nodo1.setIzquierda(raiz);
                     (raiz).setFe(0);
                    raiz = nodo1;
                }else{ // Rotacion DI
                    nodo2 = (NodoAVL<T>) nodo1.getIzquierda();
                    raiz.setDerecha(nodo2.getIzquierda());
                    nodo2.setIzquierda(raiz);
                    nodo1.setIzquierda(nodo2.getDerecha());
                    nodo2.setDerecha(nodo1);
                    if(nodo2.getFe() == 1){
                         (raiz).setFe(-1);
                    }else{
                         (raiz).setFe(0);
                    }
                    if (nodo2.getFe() == -1){
                        nodo1.setFe(1);
                    }else{
                        nodo1.setFe(0);
                    }
                    raiz = nodo2;
                    
                }
                
                 (raiz).setFe(0);
        
            }
        }
        return 0;
    }
	
    /**
     * M�todo toString() sobreescrito de la clase Object.
     */
	@Override
	public String toString() {
		String s = "";
		s += raiz.getDato();
		return s;
	}
	
	/**
	 * M�todo que permite buscar un dato en el �rbol AVL.
	 * @param raiz
	 * @param dato
	 * @return
	 */
	public String buscar(NodoAVL<T> raiz, T dato){
		String s = "";
        if (raiz != null){
            if (dato.compareTo(raiz.getDato()) < 0){ // Vamos por la izquierda
                s = buscar(raiz.getIzquierda(), dato);
            }else if (dato.compareTo(raiz.getDato()) > 0){ // Vamos por la derecha
                s = buscar(raiz.getDerecha(), dato);
            }else{
                s = "El objeto se encontr� en el �rbol.";
            }
        }else{
        	s = "No se encontr� el objeto.";
        }
        
        return s;
    }	
}