/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernesto
 */
public class PlantillaMedicos extends TArbolBB<Medico> implements IPlantillaMedicos {

    @Override
    public TArbolBB obtenerDirectorio(String laEspecialidad) {
        TArbolBB<Medico> nuevoArbol = new TArbolBB<Medico>();
        obtenerDirectorio(this.getRaiz(), laEspecialidad, nuevoArbol);
        return nuevoArbol;
    }

    public void obtenerDirectorio(IElementoAB<Medico> medico, String laEspecialidad, TArbolBB<Medico> nuevoArbol) {
        if (medico.getDatos().getEspecialidad().equals(laEspecialidad)){
            IElementoAB<Medico> medicoEspecialidad = 
                new TElementoAB<Medico>(medico.getDatos().getNombre(), medico.getDatos());
            nuevoArbol.insertar(medicoEspecialidad);
        }

        if( medico.getHijoDer() != null){
            obtenerDirectorio(medico.getHijoDer(), laEspecialidad, nuevoArbol);
        }

        if( medico.getHijoIzq() != null){
            obtenerDirectorio(medico.getHijoIzq(), laEspecialidad, nuevoArbol);
        }
    }

  
  
}
