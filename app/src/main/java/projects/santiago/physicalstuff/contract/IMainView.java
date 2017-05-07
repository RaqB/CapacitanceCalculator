package projects.santiago.physicalstuff.contract;

import java.util.List;

import projects.santiago.physicalstuff.model.entity.Capacitancia;

/**
 * Created by santiago on 06/05/17.
 */

public interface IMainView {
    void setAllAreaUnitAsPretty(List<String> unitAsPretty);
    void setAllLengthUnitAsPretty(List<String> unitAsPretty);
    void setAllDielecticosAsPretty(List<String> dielecticosAsPretty);
    void setResultado(Capacitancia capacitancia);
}
