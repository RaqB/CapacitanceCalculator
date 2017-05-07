package projects.santiago.physicalstuff.model.interactor;

import android.content.Context;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import projects.santiago.physicalstuff.contract.IMainInteractor;
import projects.santiago.physicalstuff.model.entity.Area;
import projects.santiago.physicalstuff.model.entity.Capacitancia;
import projects.santiago.physicalstuff.model.entity.Dielectrico;
import projects.santiago.physicalstuff.model.entity.Longitud;
import projects.santiago.physicalstuff.model.entity.Solucionador;
import projects.santiago.physicalstuff.model.entity.ULongitud;

/**
 * Created by santiago on 06/05/17.
 */

public class MainInteractor implements IMainInteractor {
    private Context context;

    public MainInteractor(Context context) {
        this.context = context;
    }

    @Override
    public List<String> getAllAreaUnitsAsPretty() {
        List<String> unitsAsPretty = new ArrayList<>();
        for (ULongitud uLongitud : ULongitud.values()) {
            String pretty = context.getString(uLongitud.getPretty());
            String simbolo = context.getString(uLongitud.getSimbolo());
            unitsAsPretty.add(String.format("%s (%s^2)", pretty, simbolo));
        }
        return unitsAsPretty;
    }

    @Override
    public List<String> getAllLengthUnitAsPretty() {
        List<String> unitsAsPretty = new ArrayList<>();
        for (ULongitud uLongitud : ULongitud.values()) {
            String pretty = context.getString(uLongitud.getPretty());
            String simbolo = context.getString(uLongitud.getSimbolo());
            unitsAsPretty.add(String.format("%s (%s)", pretty, simbolo));
        }
        return unitsAsPretty;
    }

    @Override
    public List<String> getAllDielecticosAsPretty() {
        try {
            List<String> dielecticosAsPretty = new ArrayList<>();
            for (Dielectrico dielectrico : Dielectrico.values()) {
                String nombre = context.getString(dielectrico.getNombre());
                if (dielectrico.isRange()) {
                    dielecticosAsPretty.add(String.format(Locale.getDefault(), "%s (De %.1f a %.1f %s)",
                            nombre,
                            dielectrico.getFrom().doubleValue(),
                            dielectrico.getTop().doubleValue(),
                            dielectrico.getUnidadAsString()));
                } else {
                    dielecticosAsPretty.add(String.format(Locale.getDefault(), "%s (%.1f %s)",
                            nombre,
                            dielectrico.getPermitividad().doubleValue(),
                            dielectrico.getUnidadAsString()));
                }

            }
            return dielecticosAsPretty;
        }catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Capacitancia getCapacitancia(Area area, Longitud longitud, Dielectrico dielectrico) {
        Solucionador solucionador = Solucionador.getInstance(area, longitud, dielectrico);
        return solucionador.calcularCapacitancia();
    }
}
