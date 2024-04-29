public interface IArbolBB<T> {

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operacián
     */

    public boolean insertar(TElementoAB<T> unElemento);

 

    /**
     * Busca un elemento dentro del árbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String preOrden();

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String inOrden();

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    public String postOrden();

   
       /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta 
     */
    public void eliminar(Comparable unaEtiqueta);

    /**
     * Busca un elemento de menor clave dentro del árbol.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> menorClave();

    /**
     * Busca un elemento de mayor clave dentro del árbol.
     * .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> mayorClave();

    /**
     * Busca el elemento de clave anterior al solicitado.
     * @param clave clave .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public TElementoAB<T> calveAnterior(Comparable clave);

    /**
     * Cuenta la cantidad de nodos en un mismo nivel.
     * .
     * @return Cantidad de nodos de un nivel pasado por paramentro.
     */
    public int cantNodosNivel(int nivel);

    /**
     * Cuenta la cantidad de nodos en un mismo nivel.
     * .
     * @return una lista con todas las hojas del arbol.
     */
    public TElementoAB<T>[] listarHojas();

    /**
     * verifica que el arbol sea de busqueda.
     * 
     * @return Cantidad de nodos de un nivel pasado por paramentro.
     */
    public Boolean esDeBusqueda();
	
	
}

