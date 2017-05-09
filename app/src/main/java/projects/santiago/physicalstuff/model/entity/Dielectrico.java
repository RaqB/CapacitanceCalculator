package projects.santiago.physicalstuff.model.entity;

import android.support.annotation.StringRes;

import org.jscience.physics.amount.Amount;
import org.jscience.physics.amount.Constants;

import java.util.Locale;

import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import projects.santiago.physicalstuff.R;

/**
 * Created by santiago on 06/05/17.
 */

public enum Dielectrico {
    VACIO(Constants.ε0, R.string.dielectrico_vacio),
    ACEITE_MINERAL(2.7, R.string.dielectrico_aceite_mineral),
    ACEITE(2.8, R.string.dielectrico_aceite),
    AGUA_DESTILADA(80.0, R.string.dielectrico_agua_destilada),
//    CAUCHO(2.1, 2.9, R.string.dielectrico_caucho),
    ACETONA(191.0, R.string.dielectrico_acetona),
    AIRE(1.0, R.string.dielectrico_aire),
    PAPEL(1.5, R.string.dielectrico_papel),
    PAPEL_PARAFINADO(3.7, R.string.dielectrico_papel_parafinado),
    PARAFINA(2.1, R.string.dielectrico_parafina),
    CUARZO(4.5, R.string.dielectrico_cuarzo),
//    PVC(30.0, 40.0, R.string.dielectrico_pvc),
    BAQUELITA(5.0, R.string.dielectrico_baquelita),
//    VIDRIO(5.6, 10.0, R.string.dielectrico_vidrio),
    MICA(5.4, R.string.dielectrico_mica);

    @StringRes
    private final int nombre;

    private Amount<?> permitividad;
    private Amount<?> desde;
    private Amount<?> hasta;
    private final Boolean range;

    Dielectrico(Amount<?> permitividad, @StringRes int nombre) {
        this.permitividad = permitividad;
        this.nombre = nombre;
        this.range = false;
        this.desde = this.permitividad;
        this.hasta = this.permitividad;
    }

    Dielectrico(Double permitividad, @StringRes int nombre) {
        this.permitividad = Amount.valueOf(permitividad, SI.FARAD.divide(SI.METER));
        this.nombre = nombre;
        this.range = false;
        this.desde = this.permitividad;
        this.hasta = this.permitividad;
    }

    Dielectrico(Double desde, Double hasta, @StringRes int nombre) {
        this.permitividad = null;
        this.nombre = nombre;
        this.range = true;
        this.desde = Amount.valueOf(desde, SI.FARAD.divide(SI.METER));
        this.hasta = Amount.valueOf(hasta, SI.FARAD.divide(SI.METER));
    }

    public Amount<?> getPermitividad() {
        return permitividad;
    }

    public Amount<?> getDesde() {
        return desde;
    }

    public Amount<?> getHasta() {
        return hasta;
    }

    public int getNombre() {
        return nombre;
    }

    public Boolean isRange() {
        return range;
    }

    public void setPermitividad(Double permitividad) {
        this.permitividad = Amount.valueOf(String.format(Locale.getDefault(), "%.2f", permitividad));
    }

    public String getUnidadAsString() {
        return "F/m";
    }
}
