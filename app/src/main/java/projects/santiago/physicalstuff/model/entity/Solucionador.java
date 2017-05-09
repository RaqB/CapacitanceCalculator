package projects.santiago.physicalstuff.model.entity;

import android.util.Log;

import org.jscience.physics.amount.Amount;

import javax.measure.quantity.ElectricCapacitance;
import static javax.measure.unit.SI.FARAD;

import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;

/**
 * Created by santiago on 06/05/17.
 */

public class Solucionador {
    private static final String TAG = Solucionador.class.getSimpleName();

    private Solucionador() {
    }

    public static Capacitancia calcularCapacitancia(Area area, Longitud longitud, Dielectrico dielectrico, UCapacitancia unidadRespuesta) throws Exception {
        try {
            Capacitancia resultado = new Capacitancia();
            resultado.setUnidad(unidadRespuesta);

            area = Convertidor.toSquareMeters(area);
            longitud = Convertidor.toMeters(longitud);

            Log.i(TAG, "MyInfo: area en metros " + area.getValor().toText());
            Log.i(TAG, "MyInfo: longitud en metros " + longitud.getValor().toText());

            Amount<ElectricCapacitance> capacitancia = Amount.valueOf(Dielectrico.VACIO.getPermitividad()
                    .times(dielectrico.getPermitividad()).times(area.getValor().divide(longitud.getValor())).getEstimatedValue(), FARAD);

            resultado.setValor(capacitancia.to(unidadRespuesta.getUnidad()));
            return resultado;
        }catch (Exception e) {
            Log.e(TAG, "MyError:calcularCapacitancia", e);
            throw e;
        }
    }
}
