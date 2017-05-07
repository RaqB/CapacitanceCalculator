package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

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

    public UCapacitancia getUnidad() {
        return unidad;
    }

    public void setUnidad(UCapacitancia unidad) {
        this.unidad = unidad;
    }
}
