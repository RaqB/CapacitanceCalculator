package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

import javax.measure.unit.Unit;

import projects.santiago.physicalstuff.model.entity.unit.UArea;

/**
 * Created by santiago on 06/05/17.
 */

public class Area {
    private BigDecimal valor;
    private UArea unidad;

    public Area(BigDecimal valor, UArea unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public Area() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Unit<javax.measure.quantity.Area> getUnidad() {
        return unidad.getUnidad();
    }

    public void setUnidad(UArea unidad) {
        this.unidad = unidad;
    }
}
