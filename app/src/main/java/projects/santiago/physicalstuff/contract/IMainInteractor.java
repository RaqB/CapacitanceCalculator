package projects.santiago.physicalstuff.contract;

import java.util.ArrayList;
import java.util.List;

import projects.santiago.physicalstuff.model.entity.Area;
import projects.santiago.physicalstuff.model.entity.Capacitancia;
import projects.santiago.physicalstuff.model.entity.Dielectrico;
import projects.santiago.physicalstuff.model.entity.Longitud;

/**
 * Created by santiago on 06/05/17.
 */

public interface IMainInteractor {
    List<String> getAllAreaUnitsAsPretty();
    List<String> getAllLengthUnitAsPretty();
    List<String> getAllDielecticosAsPretty();
    Capacitancia getCapacitancia(Area area, Longitud longitud, Dielectrico dielectrico);
}
