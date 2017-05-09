package projects.santiago.physicalstuff.model.entity;

import org.jscience.physics.amount.Amount;

import java.math.BigDecimal;

import javax.measure.quantity.ElectricCapacitance;
import javax.measure.unit.Unit;

import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;

/**
 * Created by santiago on 06/05/17.
 */

public class Capacitancia {
    private Amount<ElectricCapacitance> valor;
    private UCapacitancia unidad;

    public Capacitancia(Double valor, UCapacitancia unidad) {
        this.valor = Amount.valueOf(valor, unidad.getUnidad());
        this.unidad = unidad;
    }

    public Capacitancia() {
    }

    public Amount<ElectricCapacitance> getValor() {
        return valor;
    }

    public void setValor(Amount<ElectricCapacitance> valor) {
        this.valor = valor;
    }

    public Unit<ElectricCapacitance> getUnidad() {
        return unidad.getUnidad();
    }

    public void setUnidad(UCapacitancia unidad) {
        this.unidad = unidad;
    }
}
