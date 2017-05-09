package projects.santiago.physicalstuff.contract;

import projects.santiago.physicalstuff.model.entity.Area;
import projects.santiago.physicalstuff.model.entity.Dielectrico;
import projects.santiago.physicalstuff.model.entity.Longitud;
import projects.santiago.physicalstuff.model.entity.unit.UCapacitancia;

/**
 * Created by santiago on 06/05/17.
 */

public interface IMainPresenter {
    void loadAllAreaUnitAsPretty();
    void loadAllLengthUnitAsPretty();
    void loadAllDielecticosAsPretty();
    void loadAllCapacitaciaUnitAsPretty();
    void calcularCapacitancia(Area area, Longitud longitud, Dielectrico dielectrico, UCapacitancia unidadRespuesta);
}
