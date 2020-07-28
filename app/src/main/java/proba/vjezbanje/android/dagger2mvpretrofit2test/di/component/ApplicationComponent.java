package proba.vjezbanje.android.dagger2mvpretrofit2test.di.component;

import android.content.Context;

import dagger.Component;
import proba.vjezbanje.android.dagger2mvpretrofit2test.MyApplication;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.module.ContextModule;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.module.RetrofitModule;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.qualifier.ApplicationContext;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.scopes.ApplicationScope;
import proba.vjezbanje.android.dagger2mvpretrofit2test.retrofit.APIInterface;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
