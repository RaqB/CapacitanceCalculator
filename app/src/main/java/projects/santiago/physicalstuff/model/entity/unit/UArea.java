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
    KILOMETRO_CUADRARO(R.string.simbolo_kilometro_cuadrado, R.string.unidad_kilometro_cuadrado, KILO(KILO(SQUARE_METRE))),
    METRO_CUADRARO(R.string.simbolo_metro_cuadrado, R.string.unidad_metro_cuadrado, SQUARE_METRE),
    DECIMETRO_CUADRARO(R.string.simbolo_decimetro_cuadrado, R.string.unidad_decimetro_cuadrado, DECI(DECI(SQUARE_METRE))),
    CENTIMETRO_CUADRARO(R.string.simbolo_centimetro_cuadrado, R.string.unidad_centimetro_cuadrado, CENTI(CENTI(SQUARE_METRE))),
    MIILIMETRO_CUADRARO(R.string.simbolo_milimetro_cuadrado, R.string.unidad_milimetro_cuadrado, MILLI(MILLI(SQUARE_METRE))),
    MICROMETRO_CUADRARO(R.string.simbolo_micrometro_cuadrado, R.string.unidad_micrometro_cuadrado, MICRO(MICRO(SQUARE_METRE))),
    NANOMETRO_CUADRARO(R.string.simbolo_nanometro_cuadrado, R.string.unidad_nanometro_cuadrado, NANO(NANO(SQUARE_METRE))),
    PICOMETRO_CUADRARO(R.string.simbolo_picometro_cuadrado, R.string.unidad_picometro_cuadrado, PICO(PICO(SQUARE_METRE)));

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
