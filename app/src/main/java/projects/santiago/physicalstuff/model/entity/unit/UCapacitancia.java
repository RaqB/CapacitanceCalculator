package projects.santiago.physicalstuff.model.entity.unit;

import android.support.annotation.StringRes;

import projects.santiago.physicalstuff.R;

import javax.measure.quantity.ElectricCapacitance;
import javax.measure.unit.Unit;
import static javax.measure.unit.SI.*;

/**
 * Created by santiago on 06/05/17.
 */

public enum  UCapacitancia {
    FARADIO(R.string.simbolo_faradio, R.string.unidad_faradio, FARAD),
    MILIFARADIO(R.string.simbolo_milifaradio, R.string.unidad_milifaradio, MetricPrefix.MILLI(FARAD)),
    MICROFARADIO(R.string.simbolo_microfaradio, R.string.unidad_microfaradio, MetricPrefix.MICRO(FARAD)),
    NANOFARADIO(R.string.simbolo_nanofaradio, R.string.unidad_nanofaradio, MetricPrefix.NANO(FARAD)),
    PICOFARADIO(R.string.simbolo_picofaradio, R.string.unidad_picofaradio, MetricPrefix.PICO(FARAD));

    @StringRes
    private final int simbolo;
    @StringRes
    private final int nombre;

    private final Unit<ElectricCapacitance> unidad;

    UCapacitancia(@StringRes  int simbolo, @StringRes int nombre, Unit<ElectricCapacitance> unidad) {
        this.simbolo = simbolo;
        this.nombre = nombre;
        this.unidad = unidad;
    }

    public int getSimbolo() {
        return simbolo;
    }

    public int getNombre() {
        return nombre;
    }

    public Unit<ElectricCapacitance> getUnidad() {
        return unidad;
    }
}
