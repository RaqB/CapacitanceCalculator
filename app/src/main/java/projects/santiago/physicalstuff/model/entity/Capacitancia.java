package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

import javax.measure.quantity.ElectricCapacitance;
import javax.measure.unit.Unit;

import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;

/**
 * Created by santiago on 06/05/17.
 */

public class Capacitancia {
    private BigDecimal valor;
    private UCapacitancia unidad;

    public Capacitancia(BigDecimal valor, UCapacitancia unidad) {
        this.valor = valor;
        this.unidad = unidad;
    }

    public Capacitancia() {
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Unit<ElectricCapacitance> getUnidad() {
        return unidad.getUnidad();
    }

    public void setUnidad(UCapacitancia unidad) {
        this.unidad = unidad;
    }
}
