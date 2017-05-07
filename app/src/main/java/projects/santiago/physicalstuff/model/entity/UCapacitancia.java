package projects.santiago.physicalstuff.model.entity;

import projects.santiago.physicalstuff.R;

/**
 * Created by santiago on 06/05/17.
 */

public enum  UCapacitancia {
    FARADIO(R.string.simbolo_faradio, 0, R.string.unidad_faradio),
    MILIFARADIO(R.string.simbolo_milifaradio, -3, R.string.unidad_milifaradio),
    MICROFARADIO(R.string.simbolo_microfaradio, -6, R.string.unidad_microfaradio),
    NANOFARADIO(R.string.simbolo_nanofaradio, -9, R.string.unidad_nanofaradio),
    PICOFARADIO(R.string.simbolo_picofaradio, -12, R.string.unidad_picofaradio);

    private int simbolo;
    private Integer convertExtp;
    private int pretty;

    UCapacitancia(int simbolo, Integer convertExtp, int pretty) {
        this.simbolo = simbolo;
        this.convertExtp = convertExtp;
        this.pretty = pretty;
    }

    public int getSimbolo() {
        return simbolo;
    }

    public Integer getConvertExtp() {
        return convertExtp;
    }

    public int getPretty() {
        return pretty;
    }
}
