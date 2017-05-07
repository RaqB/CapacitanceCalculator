package projects.santiago.physicalstuff.presenter;

import projects.santiago.physicalstuff.contract.IMainInteractor;
import projects.santiago.physicalstuff.contract.IMainPresenter;
import projects.santiago.physicalstuff.contract.IMainView;
import projects.santiago.physicalstuff.model.entity.Area;
import projects.santiago.physicalstuff.model.entity.Dielectrico;
import projects.santiago.physicalstuff.model.entity.Longitud;

/**
 * Created by santiago on 06/05/17.
 */

public class MainPresenter implements IMainPresenter {
    private IMainView view;
    private IMainInteractor interactor;

    public MainPresenter(IMainView view, IMainInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void loadAllAreaUnitAsPretty() {
        view.setAllAreaUnitAsPretty(interactor.getAllAreaUnitsAsPretty());
    }

    @Override
    public void loadAllLengthUnitAsPretty() {
        view.setAllLengthUnitAsPretty(interactor.getAllLengthUnitAsPretty());
    }

    @Override
    public void loadAllDielecticosAsPretty() {
        view.setAllDielecticosAsPretty(interactor.getAllDielecticosAsPretty());
    }

    @Override
    public void calcularCapacitancia(Area area, Longitud longitud, Dielectrico dielectrico) {
        view.setResultado(interactor.getCapacitancia(area, longitud, dielectrico));
    }
}
