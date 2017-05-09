package projects.santiago.physicalstuff.model.entity;

import android.util.Log;

import java.math.BigDecimal;
import java.math.MathContext;

import javax.measure.converter.UnitConverter;

import projects.santiago.physicalstuff.model.entity.unit.UArea;
import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;
import projects.santiago.physicalstuff.model.entity.unit.ULongitud;

import static javax.measure.unit.SI.FARAD;
import static javax.measure.unit.SI.METRE;
import static javax.measure.unit.SI.SQUARE_METRE;

/**
 * Created by santiago on 06/05/17.
 */

public class Convertidor {
    private static final String TAG = Convertidor.class.getSimpleName();

    private Convertidor() {
    }

    public static Area toSquareMeters(Area area) throws Exception {
        try {
            Area resultado = new Area();
            resultado.setUnidad(UArea.METRO_CUADRARO);
            resultado.setValor(area.getValor().to(SQUARE_METRE));
            return resultado;
        }catch (Exception e) {
            Log.e(TAG, "MyError:toMeters", e);
            throw e;
        }
    }

    public static Longitud toMeters(Longitud longitud) throws Exception {
        try {
            Longitud resultado = new Longitud();
            resultado.setUnidad(ULongitud.METRO);
            resultado.setValor(longitud.getValor().to(METRE));
            return resultado;
        }catch (Exception e) {
            Log.e(TAG, "MyError:toMeters", e);
            throw e;
        }
    }

    public static Capacitancia toFarad(Capacitancia capacitancia) throws Exception {
        try {
            Capacitancia resultado = new Capacitancia();
            resultado.setUnidad(UCapacitancia.FARADIO);
            resultado.setValor(capacitancia.getValor().to(FARAD));
            return resultado;
        }catch (Exception e) {
            Log.e(TAG, "MyError:toFarad", e);
            throw e;
        }
    }
}
