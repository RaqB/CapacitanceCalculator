package projects.santiago.physicalstuff.model.interactor;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import projects.santiago.physicalstuff.contract.IMainInteractor;
import projects.santiago.physicalstuff.model.entity.Area;
import projects.santiago.physicalstuff.model.entity.Capacitancia;
import projects.santiago.physicalstuff.model.entity.Dielectrico;
import projects.santiago.physicalstuff.model.entity.Longitud;
import projects.santiago.physicalstuff.model.entity.Solucionador;
import projects.santiago.physicalstuff.model.entity.unit.UArea;
import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;
import projects.santiago.physicalstuff.model.entity.unit.ULongitud;

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
        try {
            List<String> unitsAsPretty = new ArrayList<>();
            for (UArea uArea : UArea.values()) {
                String name = context.getString(uArea.getName());
                String simbolo = context.getString(uArea.getSimbolo());
                unitsAsPretty.add(String.format("%s (%s)", name, simbolo));
            }
            return unitsAsPretty;
        }catch (Throwable e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<String> getAllLengthUnitAsPretty() {
        try {
            List<String> unitsAsPretty = new ArrayList<>();
            for (ULongitud uLongitud : ULongitud.values()) {
                String nombre = context.getString(uLongitud.getName());
                String simbolo = context.getString(uLongitud.getSimbolo());
                unitsAsPretty.add(String.format("%s (%s)", nombre, simbolo));
            }
            return unitsAsPretty;
        }catch (Throwable e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
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
                            dielectrico.getDesde().getEstimatedValue(),
                            dielectrico.getHasta().getEstimatedValue(),
                            dielectrico.getUnidadAsString()));
                } else {
                    dielecticosAsPretty.add(String.format(Locale.getDefault(), "%s (%.1f %s)",
                            nombre,
                            dielectrico.getPermitividad().getEstimatedValue(),
                            dielectrico.getUnidadAsString()));
                }

            }
            return dielecticosAsPretty;
        }catch (Throwable e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<String> getAllCapacitanciaUnitAsPretty() {
        try {
            List<String> unitsAsPretty = new ArrayList<>();
            for (UCapacitancia uCapacitancia : UCapacitancia.values()) {
                String nombre = context.getString(uCapacitancia.getNombre());
                String simbolo = context.getString(uCapacitancia.getSimbolo());
                unitsAsPretty.add(String.format("%s (%s)", nombre, simbolo));
            }
            return unitsAsPretty;
        }catch (Throwable e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Capacitancia getCapacitancia(Area area, Longitud longitud, Dielectrico dielectrico, UCapacitancia unidadRespuesta) throws Exception {
        return Solucionador.calcularCapacitancia(area, longitud, dielectrico, unidadRespuesta);
    }
}
