package projects.santiago.physicalstuff.di.module;

import android.app.Application;
import android.content.Context;
import javax.inject.Named;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;


/**
 * Created by santiago on 10/04/17.
 */
@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Named("app_context")
    @Singleton
    Context provideContext() {
        return application;
    }
}