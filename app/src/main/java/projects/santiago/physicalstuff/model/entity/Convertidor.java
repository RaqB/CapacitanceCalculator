package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;
import java.math.MathContext;

import javax.measure.converter.UnitConverter;

import projects.santiago.physicalstuff.model.entity.unit.UArea;
import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;
import projects.santiago.physicalstuff.model.entity.unit.ULongitud;

import static javax.measure.unit.SI.FARAD;
import static javax.measure.unit.SI.METRE;
import static javax.measure.unit.SI.SQUARE_METRE;

/**
 * Created by santiago on 06/05/17.
 */

public class Convertidor {

    private Convertidor() {

    }

    public static Area toSquareMeters(Area area) {
        UnitConverter toSquareMeters = area.getUnidad().getConverterTo(SQUARE_METRE);
        Area resultado = new Area();
        resultado.setUnidad(UArea.METRO_CUADRARO);
        resultado.setValor(toSquareMeters.convert(area.getValor(), MathContext.DECIMAL64));
        return resultado;
    }

    public static Longitud toSquareMeters(Longitud longitud) {
        UnitConverter toMeters = longitud.getUnidad().getConverterTo(METRE);
        Longitud resultado = new Longitud();
        resultado.setUnidad(ULongitud.METRO);
        resultado.setValor(toMeters.convert(longitud.getValor(), MathContext.DECIMAL64));
        return resultado;
    }

    public static Capacitancia toFaradio(Capacitancia capacitancia) {
        UnitConverter toFarad = capacitancia.getUnidad().getConverterTo(FARAD);
        Capacitancia resultado = new Capacitancia();
        resultado.setUnidad(UCapacitancia.FARADIO);
        resultado.setValor(toFarad.convert(capacitancia.getValor(), MathContext.DECIMAL64));
        return resultado;
    }
}
