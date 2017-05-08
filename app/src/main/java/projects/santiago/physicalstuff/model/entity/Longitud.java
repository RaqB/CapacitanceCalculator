package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

import projects.santiago.physicalstuff.model.entity.unit.ULongitud;

/**
 * Created by santiago on 06/05/17.
 */

public class Longitud {
    private BigDecimal valor;
    private ULongitud unidad;

    public Longitud(BigDecimal valor, ULongitud unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public Longitud() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Unit<Length> getUnidad() {
        return unidad.getUnidad();
    }

    public void setUnidad(ULongitud unidad) {
        this.unidad = unidad;
    }
}
