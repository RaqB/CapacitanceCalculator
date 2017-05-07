package projects.santiago.physicalstuff;

import android.app.Application;
import android.content.Context;

import projects.santiago.physicalstuff.di.component.ApplicationComponent;
import projects.santiago.physicalstuff.di.component.DaggerApplicationComponent;
import projects.santiago.physicalstuff.di.module.ApplicationModule;

/**
 * Created by santiago on 06/05/17.
 */

public class App extends Application {
    protected ApplicationComponent component;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
