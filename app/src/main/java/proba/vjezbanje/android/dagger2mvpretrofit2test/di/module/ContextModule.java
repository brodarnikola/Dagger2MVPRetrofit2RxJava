package proba.vjezbanje.android.dagger2mvpretrofit2test.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.qualifier.ApplicationContext;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.scopes.ApplicationScope;


@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
