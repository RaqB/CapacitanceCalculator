package projects.santiago.physicalstuff.model.entity;

import org.jscience.physics.amount.Amount;
import javax.measure.unit.Unit;

import projects.santiago.physicalstuff.model.entity.unit.UArea;

/**
 * Created by santiago on 06/05/17.
 */

public class Area {
    private Amount<javax.measure.quantity.Area> valor;
    private UArea unidad;

    public Area(Double valor, UArea unidad) {
        this.valor = Amount.valueOf(valor, unidad.getUnidad());
        this.unidad = unidad;
    }

    public Area() {
    }

    public Amount<javax.measure.quantity.Area> getValor() {
        return valor;
    }

    public void setValor(Amount<javax.measure.quantity.Area> valor) {
        this.valor = valor;
    }

    public Unit<javax.measure.quantity.Area> getUnidad() {
        return unidad.getUnidad();
    }

    public void setUnidad(UArea unidad) {
        this.unidad = unidad;
    }
}
