package uy.edu.ucu.aed;

import java.util.LinkedList;

import uy.edu.ucu.aed.clases.Alumno;
import uy.edu.ucu.aed.clases.TArbolBB;
import uy.edu.ucu.aed.interfaces.IElementoAB;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    public void armarSubgrupos(TArbolBB<T> grupoImpares, TArbolBB<T> grupoPares, int nivel) {
        if (nivel % 2 == 0){
            grupoPares.insertar(this);
        } else {
            grupoImpares.insertar(this);
        } 
        if( hijoIzq != null){
            hijoIzq.armarSubgrupos(grupoImpares, grupoPares, nivel + 1);
        }
        
        if( hijoDer != null){
            hijoDer.armarSubgrupos(grupoImpares, grupoPares, nivel + 1);
        }        
    }

    public void armarIndiceCurso(int cursoIdentificador, TArbolBBAlumnos alumnosCurso){
      try {
        Alumno alumno = (Alumno) datos;
        
        for (int curso : alumno.getCursos()){
            if (curso == cursoIdentificador){
                TElementoAB<Alumno> nuevoAlumno = new TElementoAB<Alumno>(
                    (Comparable) alumno.getApellido() + alumno.getApellido(),
                    alumno
                    );
                alumnosCurso.insertar(nuevoAlumno);
            }
        }
        
        if (hijoIzq != null) {
            hijoIzq.armarIndiceCurso(cursoIdentificador, alumnosCurso);
        }
        if (hijoDer != null) {
            hijoDer.armarIndiceCurso(cursoIdentificador, alumnosCurso);
        }
      } catch (Exception e) {
        return;
      }
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */

    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    
    public void inOrden(LinkedList<T> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getDatos());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public TElementoAB<T>eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.getEtiqueta()) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.getEtiqueta()) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = hijoDer.eliminar(unaEtiqueta);

            }
            return this;
        }

        return quitaElNodo();
    }

    private TElementoAB<T> quitaElNodo() {
        if (hijoIzq == null) {    // solo tiene un hijo o es hoja
            return hijoDer;
        }

        if (hijoDer == null) { // solo tiene un hijo o es hoja
            return hijoIzq;
        }
// tiene los dos hijos, buscamos el lexicograficamente anterior
        TElementoAB<T> elHijo = hijoIzq;
        TElementoAB<T> elPadre = this;

        while (elHijo.getHijoDer() != null) {
            elPadre = elHijo;
            elHijo = elHijo.getHijoDer();
        }

        if (elPadre != this) {
            elPadre.setHijoDer(elHijo.getHijoIzq());
            elHijo.setHijoIzq(hijoIzq);
        }

        elHijo.setHijoDer(hijoDer);
        setHijoIzq(null);  // para que no queden referencias y ayudar al collector
        setHijoDer(null);
        return elHijo;
    }

    @Override
    public int obtenerTamanio() {
        int tam = 1;
        if (this.getHijoIzq() != null) {
            tam += this.getHijoIzq().obtenerTamanio();
        }
        if (this.getHijoDer() != null) {
            tam += this.getHijoDer().obtenerTamanio();
        }
        return tam;
    }

    @Override
    public void preOrden(LinkedList<T> unaLista) {
        unaLista.add(this.getDatos());
        if (hijoIzq != null) {
            hijoIzq.preOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.preOrden(unaLista);
        }

    }

    @Override
    public void postOrden(LinkedList<T> unaLista) {

        if (hijoIzq != null) {
            hijoIzq.postOrden(unaLista);
        }

        if (hijoDer != null) {
            hijoDer.postOrden(unaLista);
        }
        unaLista.add(this.getDatos());
    }

}
