package projects.santiago.physicalstuff.model.entity;

import projects.santiago.physicalstuff.R;

/**
 * Created by santiago on 06/05/17.
 */

public enum ULongitud {
    KILOMETRO(R.string.simbolo_kilometro, 3, R.string.unidad_kilometro),
    METRO(R.string.simbolo_metro, 0, R.string.unidad_metro),
    DECIMETRO(R.string.simbolo_decimetro, -1, R.string.unidad_decimetro),
    CENTIMETRO(R.string.simbolo_centimetro, -2, R.string.unidad_centimetro),
    MIILIMETRO(R.string.simbolo_milimetro, -3, R.string.unidad_milimetro),
    MICROMETRO(R.string.simbolo_micrometro, -6, R.string.unidad_micrometro),
    NANOMETRO(R.string.simbolo_nanometro, -9, R.string.unidad_nanometro),
    PICOMETRO(R.string.simbolo_picometro, -12, R.string.unidad_picometro);

    private int simbolo;
    private Integer convertExp;
    private int pretty;

    ULongitud(int simbolo, Integer convertExp, int pretty) {
        this.simbolo = simbolo;
        this.convertExp = convertExp;
        this.pretty = pretty;
    }

    public int getSimbolo() {
        return simbolo;
    }

    public Integer getConvertExp() {
        return convertExp;
    }

    public int getPretty() {
        return pretty;
    }
}
