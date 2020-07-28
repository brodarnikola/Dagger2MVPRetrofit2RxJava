package proba.vjezbanje.android.dagger2mvpretrofit2test.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import proba.vjezbanje.android.dagger2mvpretrofit2test.MainActivity;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.qualifier.ActivityContext;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.scopes.ActivityScope;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}
