package proba.vjezbanje.android.dagger2mvpretrofit2test.di.component;

import android.content.Context;

import dagger.Component;
import proba.vjezbanje.android.dagger2mvpretrofit2test.MainActivity;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.module.AdapterModule;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.module.MainActivityMvpModule;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.qualifier.ActivityContext;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.scopes.ActivityScope;


@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}
