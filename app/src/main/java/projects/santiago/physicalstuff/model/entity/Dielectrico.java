package projects.santiago.physicalstuff.model.entity;

import java.math.BigDecimal;

import projects.santiago.physicalstuff.R;

/**
 * Created by santiago on 06/05/17.
 */

public enum Dielectrico {
    VACIO(new BigDecimal(8.8541878176).movePointRight(-12), R.string.dielectico_vacio),
    ACEITE_MINERAL(2.7, R.string.dielectico_aceite_mineral),
    ACEITE(2.8, R.string.dielectico_aceite),
    AGUA_DESTILADA(80.0, R.string.dielectico_agua_destilada),
    CAUCHO(2.1, 2.9, R.string.dielectico_caucho),
    ACETONA(191.0, R.string.dielectico_acetona),
    AIRE(1.0, R.string.dielectico_aire),
    PAPEL(1.5, R.string.dielectico_papel),
    PAPEL_PARAFINADO(3.7, R.string.dielectico_papel_parafinado),
    PARAFINA(2.1, R.string.dielectico_parafina),
    CUARZO(4.5, R.string.dielectico_cuarzo),
    PVC(30.0, 40.0, R.string.dielectico_pvc),
    BAQUELITA(5.0, R.string.dielectico_baquelita),
    VIDRIO(5.6, 10.0, R.string.dielectico_vidrio),
    MICA(5.4, R.string.dielectico_mica);

    private BigDecimal permitividad;
    private int nombre;
    private Boolean range;
    private BigDecimal from;
    private BigDecimal top;

    Dielectrico(BigDecimal permitividad, int nombre) {
        this.permitividad = permitividad;
        this.nombre = nombre;
        this.range = false;
        this.from = this.permitividad;
        this.top = this.permitividad;
    }

    Dielectrico(Double permitividad, int nombre) {
        this.permitividad = new BigDecimal(permitividad);
        this.nombre = nombre;
        this.range = false;
        this.from = this.permitividad;
        this.top = this.permitividad;
    }

    Dielectrico(Double from, Double top, int nombre) {
        this.permitividad = null;
        this.nombre = nombre;
        this.range = true;
        this.from = new BigDecimal(from);
        this.top = new BigDecimal(top);
    }

    public void setPermitividad(Double permitividad) {
        this.permitividad = new BigDecimal(permitividad);
    }

    public BigDecimal getPermitividad() {
        return permitividad;
    }

    public int getNombre() {
        return nombre;
    }

    public Boolean isRange() {
        return range;
    }

    public BigDecimal getFrom() {
        return from;
    }

    public BigDecimal getTop() {
        return top;
    }

    public String getUnidadAsString() {
        return "C^2/Nm^2";
    }
}
