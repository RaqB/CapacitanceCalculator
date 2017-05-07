package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

/**
 * Created by santiago on 06/05/17.
 */

public class Convertidor {
    private Convertidor() {

    }

    private static BigDecimal toMeters(BigDecimal valor, ULongitud fromUnit) {
        BigDecimal factorDeConversion = new BigDecimal(10).pow(fromUnit.getConvertExp());
        return valor.multiply(factorDeConversion);
    }

    private static BigDecimal toFaradio(BigDecimal valor, UCapacitancia fromUnit) {
        BigDecimal factorDeConversion = new BigDecimal(10).pow(fromUnit.getConvertExtp());
        return valor.multiply(factorDeConversion);
    }

    public static Area toMeters(Area area) {
        Area resultado = new Area();
        resultado.setUnidad(ULongitud.METRO);
        resultado.setValor(toMeters(area.getValor(), area.getUnidad()));
        return resultado;
    }

    public static Longitud toMeters(Longitud longitud) {
        Longitud resultado = new Longitud();
        resultado.setUnidad(ULongitud.METRO);
        resultado.setValor(toMeters(longitud.getValor(), longitud.getUnidad()));
        return resultado;
    }

    public static Capacitancia toFaradio(Capacitancia capacitancia) {
        Capacitancia resultado = new Capacitancia();
        resultado.setUnidad(UCapacitancia.FARADIO);
        resultado.setValor(toFaradio(capacitancia.getValor(), capacitancia.getUnidad()));
        return resultado;
    }
}
