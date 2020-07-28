package proba.vjezbanje.android.dagger2mvpretrofit2test.retrofit;

import java.util.List;

import proba.vjezbanje.android.dagger2mvpretrofit2test.pojo.CountryData;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @GET("region/europe")
    Observable<List<CountryData>> getEuropeCountryData( );
}
