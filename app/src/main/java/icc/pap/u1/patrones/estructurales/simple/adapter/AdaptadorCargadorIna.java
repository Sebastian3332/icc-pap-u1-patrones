package icc.pap.u1.patrones.estructurales.simple.adapter;

public class AdaptadorCargadorIna implements Cargador{

   private final CargadorInalambrico cargadorIna;

   public AdaptadorCargadorIna(CargadorInalambrico cargadorIna) {
       this.cargadorIna = cargadorIna;
   }

   @Override
   public void cargarCelular() {
       cargadorIna.cargarBase();
   }
}