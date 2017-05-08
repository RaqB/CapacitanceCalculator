package projects.santiago.physicalstuff.model.entity.unit;

import android.support.annotation.StringRes;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;
import static javax.measure.unit.SI.*;

import projects.santiago.physicalstuff.R;

/**
 * Created by santiago on 06/05/17.
 */

public enum ULongitud {
    KILOMETRO(R.string.simbolo_kilometro, R.string.unidad_kilometro, KILOMETRE),
    METRO(R.string.simbolo_metro, R.string.unidad_metro, METRE),
    DECIMETRO(R.string.simbolo_decimetro, R.string.unidad_decimetro, MetricPrefix.DECI(METRE)),
    CENTIMETRO(R.string.simbolo_centimetro, R.string.unidad_centimetro, CENTIMETRE),
    MIILIMETRO(R.string.simbolo_milimetro, R.string.unidad_milimetro, MILLIMETRE),
    MICROMETRO(R.string.simbolo_micrometro, R.string.unidad_micrometro, MetricPrefix.MICRO(METRE)),
    NANOMETRO(R.string.simbolo_nanometro, R.string.unidad_nanometro, MetricPrefix.NANO(METRE)),
    PICOMETRO(R.string.simbolo_picometro, R.string.unidad_picometro, MetricPrefix.PICO(METRE));

    @StringRes
    private final int simbolo;

    @StringRes
    private final int name;

    private final Unit<Length> unidad;

    ULongitud(@StringRes int simbolo, @StringRes int name, Unit<Length> unidad) {
        this.simbolo = simbolo;
        this.name = name;
        this.unidad = unidad;
    }

    public int getSimbolo() {
        return simbolo;
    }

    public int getName() {
        return name;
    }

    public Unit<Length> getUnidad() {
        return unidad;
    }
}
