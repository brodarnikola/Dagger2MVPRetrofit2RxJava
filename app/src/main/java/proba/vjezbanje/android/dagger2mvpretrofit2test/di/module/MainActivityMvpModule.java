package proba.vjezbanje.android.dagger2mvpretrofit2test.di.module;

import dagger.Module;
import dagger.Provides;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.scopes.ActivityScope;
import proba.vjezbanje.android.dagger2mvpretrofit2test.mvp.MainActivityContract;

@Module
public class MainActivityMvpModule {
    private final MainActivityContract.View mView;


    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainActivityContract.View provideView() {
        return mView;
    }


}
