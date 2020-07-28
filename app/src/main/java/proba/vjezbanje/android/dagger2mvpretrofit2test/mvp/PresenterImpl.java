package proba.vjezbanje.android.dagger2mvpretrofit2test.mvp;

import java.util.List;
import javax.inject.Inject;

import proba.vjezbanje.android.dagger2mvpretrofit2test.pojo.CountryData;
import proba.vjezbanje.android.dagger2mvpretrofit2test.retrofit.APIInterface;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PresenterImpl implements MainActivityContract.Presenter {

    APIInterface apiInterface;
    MainActivityContract.View mView;

    @Inject
    public PresenterImpl(APIInterface apiInterface, MainActivityContract.View mView) {
        this.apiInterface = apiInterface;
        this.mView = mView;
    }

    @Override
    public void loadData() {

        mView.showProgress();

        apiInterface.getEuropeCountryData( ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CountryData>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                        mView.hideProgress();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError("Error occurred");
                        mView.hideProgress();
                    }

                    @Override
                    public void onNext(List<CountryData> data) {
                        mView.showData(data);
                    }
                });
    }
}
