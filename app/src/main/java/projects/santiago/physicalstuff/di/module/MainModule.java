package projects.santiago.physicalstuff.di.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import projects.santiago.physicalstuff.contract.IMainInteractor;
import projects.santiago.physicalstuff.contract.IMainPresenter;
import projects.santiago.physicalstuff.contract.IMainView;
import projects.santiago.physicalstuff.di.scope.ActivityScope;
import projects.santiago.physicalstuff.model.entity.Convertidor;
import projects.santiago.physicalstuff.model.interactor.MainInteractor;
import projects.santiago.physicalstuff.presenter.MainPresenter;

/**
 * Created by santiago on 06/05/17.
 */
@Module
public class MainModule {
    private final IMainView view;

    public MainModule(IMainView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    IMainPresenter providesPresenter(IMainInteractor interactor) {
        return new MainPresenter(view, interactor);
    }

    @Provides
    @ActivityScope
    IMainInteractor providesInteractor(@Named("app_context") Context context) {
        return new MainInteractor(context);
    }
}
