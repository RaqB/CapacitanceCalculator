package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

/**
 * Created by santiago on 06/05/17.
 */

public class Solucionador {
    private Area area;
    private Longitud longitud;
    private Dielectrico dielectrico;

    private static Solucionador instance;

    private Solucionador(Area area, Longitud longitud, Dielectrico dielectrico) {
        this.area = area;
        this.longitud = longitud;
        this.dielectrico = dielectrico;
    }

    private void updateInstance(Area area, Longitud longitud, Dielectrico dielectrico) {
        this.area = area;
        this.longitud = longitud;
        this.dielectrico = dielectrico;
    }

    public synchronized static Solucionador getInstance(Area area, Longitud longitud, Dielectrico dielectrico){
        if(instance == null) instance = new Solucionador(area, longitud, dielectrico);
        else instance.updateInstance(area, longitud, dielectrico);
        return instance;
    }

    public Capacitancia calcularCapacitancia() {
        Capacitancia resultado = new Capacitancia();
        resultado.setUnidad(UCapacitancia.FARADIO);

        Area areaEnMetros = Convertidor.toMeters(area);
        Longitud longitudEnMetros = Convertidor.toMeters(longitud);

        BigDecimal capacitanciaAlVacio = Dielectrico.VACIO.getPermitividad()
                .multiply(areaEnMetros.getValor().divide(longitudEnMetros.getValor()));

        resultado.setValor(capacitanciaAlVacio.multiply(dielectrico.getPermitividad()));
        return resultado;
    }
}
