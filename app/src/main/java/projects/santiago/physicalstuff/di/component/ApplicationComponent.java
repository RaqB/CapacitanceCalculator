package projects.santiago.physicalstuff.di.component;

import javax.inject.Singleton;

import dagger.Component;
import projects.santiago.physicalstuff.App;
import projects.santiago.physicalstuff.di.module.ApplicationModule;
import projects.santiago.physicalstuff.di.module.MainModule;

/**
 * Created by santiago on 06/05/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(App application);
    MainComponent create(MainModule module);
}
