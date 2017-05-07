package projects.santiago.physicalstuff.di.component;

import dagger.Subcomponent;
import projects.santiago.physicalstuff.di.module.MainModule;
import projects.santiago.physicalstuff.di.scope.ActivityScope;
import projects.santiago.physicalstuff.view.MainActivity;

/**
 * Created by santiago on 06/05/17.
 */
@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
