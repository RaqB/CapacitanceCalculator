package projects.santiago.physicalstuff.model.entity.unit;

import android.support.annotation.StringRes;
import projects.santiago.physicalstuff.R;

import javax.measure.quantity.Area;
import javax.measure.unit.Unit;
import static javax.measure.unit.SI.*;



/**
 * Created by santiago on 08/05/17.
 */

public enum UArea {
    KILOMETRO_CUADRARO(R.string.simbolo_kilometro_cuadrado, R.string.unidad_kilometro, MetricPrefix.KILO(SQUARE_METRE)),
    METRO_CUADRARO(R.string.simbolo_metro_cuadrado, R.string.unidad_metro, SQUARE_METRE),
    DECIMETRO_CUADRARO(R.string.simbolo_decimetro_cuadrado, R.string.unidad_decimetro, MetricPrefix.DECI(SQUARE_METRE)),
    CENTIMETRO_CUADRARO(R.string.simbolo_centimetro_cuadrado, R.string.unidad_centimetro, MetricPrefix.CENTI(SQUARE_METRE)),
    MIILIMETRO_CUADRARO(R.string.simbolo_milimetro_cuadrado, R.string.unidad_milimetro, MetricPrefix.MILLI(SQUARE_METRE)),
    MICROMETRO_CUADRARO(R.string.simbolo_micrometro_cuadrado, R.string.unidad_micrometro, MetricPrefix.MICRO(SQUARE_METRE)),
    NANOMETRO_CUADRARO(R.string.simbolo_nanometro_cuadrado, R.string.unidad_nanometro, MetricPrefix.NANO(SQUARE_METRE)),
    PICOMETRO_CUADRARO(R.string.simbolo_picometro_cuadrado, R.string.unidad_picometro, MetricPrefix.PICO(SQUARE_METRE));

    @StringRes
    private final int simbolo;

    @StringRes
    private final int name;

    private final Unit<Area> unidad;

    UArea(@StringRes int simbolo, @StringRes int name, Unit<Area> unidad) {
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

    public Unit<Area> getUnidad() {
        return unidad;
    }
}
