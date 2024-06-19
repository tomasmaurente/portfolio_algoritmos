package ta5;

import java.util.LinkedList;

import ta5.grafos.TAdyacencia;
import ta5.grafos.TVertice;

public class TVerticeBacon extends TVertice implements IVerticeKevinBacon {

    public TVerticeBacon(Comparable unaEtiqueta) {
        super(unaEtiqueta);
    }

    @Override
    public int getBacon(){
        int bacon = 0;
        LinkedList<TVertice> juanes = new LinkedList<TVertice>();
        LinkedList<TVertice> colaDeJuanes = new LinkedList<TVertice>();
        LinkedList<TVertice> listaDeAdyasentesAJuan = new LinkedList<TVertice>();
  
        TVertice juan1;
        TVertice juan2 = null;
        Comparable kevin = "Kevin_Bacon";

        this.setVisitado(true);
        colaDeJuanes.add(this);
        juanes.add(this);
        Comparable check = "BaconCheck";
        while (!colaDeJuanes.isEmpty()) {

            juan1 = colaDeJuanes.poll();

            if (juan1.getEtiqueta().equals(check)){
                bacon++;
                juan1 = colaDeJuanes.poll();
            }

            for (TAdyacencia adyacenciaAJuan : (LinkedList<TAdyacencia>) juan1.getAdyacentes()) {
                juan2 = adyacenciaAJuan.getDestino();
                if (!juan2.getVisitado()) {
                    juan2.setVisitado(true);
                    colaDeJuanes.add(juan2);
                    juanes.add(juan2);
                    if (kevin.equals(juan2.getEtiqueta())){

                    }

                }
            }
            colaDeJuanes.add(new TVertice(check));
        }

        return bacon;
    }

    @Override
    public void setBacon(int newBacon) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBacon'");
    }
    
}
