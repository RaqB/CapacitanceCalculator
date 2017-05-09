package projects.santiago.physicalstuff.model.entity;

import org.jscience.physics.amount.Amount;

import java.math.BigDecimal;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;

import projects.santiago.physicalstuff.model.entity.unit.ULongitud;

/**
 * Created by santiago on 06/05/17.
 */

public class Longitud {
    private Amount<Length> valor;
    private ULongitud unidad;

    public Longitud(Double valor, ULongitud unidad) {
        this.valor = Amount.valueOf(valor, unidad.getUnidad());
        this.unidad = unidad;
    }

    public Longitud() {
    }

    public Amount<Length> getValor() {
        return valor;
    }

    public void setValor(Amount<Length> valor) {
        this.valor = valor;
    }

    public Unit<Length> getUnidad() {
        return unidad.getUnidad();
    }

    public void setUnidad(ULongitud unidad) {
        this.unidad = unidad;
    }
}
