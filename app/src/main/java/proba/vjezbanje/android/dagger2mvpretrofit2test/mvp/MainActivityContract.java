package proba.vjezbanje.android.dagger2mvpretrofit2test.mvp;


import java.util.List;

import proba.vjezbanje.android.dagger2mvpretrofit2test.pojo.CountryData;

public interface MainActivityContract {
    interface View {
        void showData(List<CountryData> data);

        void showError(String message);

        void showComplete();

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void loadData();
    }
}
