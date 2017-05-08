package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;

/**
 * Created by santiago on 06/05/17.
 */

public class Solucionador {
    private Solucionador() {
    }

    public static Capacitancia calcularCapacitancia(Area area, Longitud longitud, Dielectrico dielectrico) {
        Capacitancia resultado = new Capacitancia();
        resultado.setUnidad(UCapacitancia.FARADIO);

        Area areaEnMetros = Convertidor.toSquareMeters(area);
        Longitud longitudEnMetros = Convertidor.toSquareMeters(longitud);


//        BigDecimal capacitanciaAlVacio = Dielectrico.VACIO.getPermitividad()
//                .multiply(areaEnMetros.getValor().divide(longitudEnMetros.getValor()));
//
//        resultado.setValor(capacitanciaAlVacio.multiply(dielectrico.getPermitividad()));
        return resultado;
    }
}
