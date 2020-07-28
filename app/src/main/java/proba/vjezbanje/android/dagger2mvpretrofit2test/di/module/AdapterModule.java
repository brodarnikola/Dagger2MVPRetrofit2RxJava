package proba.vjezbanje.android.dagger2mvpretrofit2test.di.module;

import dagger.Module;
import dagger.Provides;
import proba.vjezbanje.android.dagger2mvpretrofit2test.MainActivity;
import proba.vjezbanje.android.dagger2mvpretrofit2test.RecyclerViewAdapter;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.scopes.ActivityScope;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
