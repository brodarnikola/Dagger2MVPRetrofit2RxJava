package proba.vjezbanje.android.dagger2mvpretrofit2test;

import android.app.Activity;
import android.app.Application;

import proba.vjezbanje.android.dagger2mvpretrofit2test.di.component.ApplicationComponent;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.component.DaggerApplicationComponent;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.module.ContextModule;


public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder().contextModule(new ContextModule(this)).build();
        applicationComponent.injectApplication(this);

    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}

