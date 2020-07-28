package proba.vjezbanje.android.dagger2mvpretrofit2test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hr.sil.android.dagger2mvpretrofit2test.R;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.component.ApplicationComponent;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.component.DaggerMainActivityComponent;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.component.MainActivityComponent;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.module.MainActivityContextModule;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.module.MainActivityMvpModule;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.qualifier.ActivityContext;
import proba.vjezbanje.android.dagger2mvpretrofit2test.di.qualifier.ApplicationContext;
import proba.vjezbanje.android.dagger2mvpretrofit2test.mvp.MainActivityContract;
import proba.vjezbanje.android.dagger2mvpretrofit2test.mvp.PresenterImpl;
import proba.vjezbanje.android.dagger2mvpretrofit2test.pojo.CountryData;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View, RecyclerViewAdapter.ClickListener {

    /* Primjer objasnjenja za koristenje contexta
    // Imamo dva nacina koristenja Context:
    // 1) da se prvo inicijalizira context i zatim se moze nesto s njim raditi
    // 2) da uz pomoc dagger 2 ( dependecy injection ) ubacimo ili injectamo context koji je kreiran izvana u activity

    // Prvo je bio dagger 1, koji je bio sporiji zbog reflection, sad dagger2 nema vise reflection

    // anotacije koje se koriste u dagger2 su:
    // 1) @module -> anotacija koja se pise iznad classe i vraca dependency
    // 2) @provider -> metode unutar @module classe koja vraca objekt od navedene @module class
    // 3) @component -> ona je kao brige izmedu @module i @inject..
    //                  unutar @component mozemo staviti jedan ili vise @modula.. takoder mozemo staviti i dependecies, ako ta componnenta o necemu ovisi
    //                  @component zapravo izvrsava dependency injection
    // 4) @inject -> on zahtijeva dependecy.. koristi se unutar constructora, method ili kao field unutar activity ili fragmenta
    // 5) @singleton -> omogucuje nam da napravimo samo jednu instaciju objekta iz @module class,,
    //               to je dobro, jer nema potrebe za neke stvari da se vise puta instaciraju i bezveze da se pune u memoriju od mobitela
    // 6) @PerApp -> mozemo kreirati vise instanci od context dependecy objekta i tak dugo bude zivjela ta instanca dok je i aplikacija ziva
    // 7) @PerActivity -> mozemo kreirati vise instanci od context dependecy objekta i tak dugo bude zivjela ta instanca dok je i taj activity ziv
    // 8) @Qualifier -> da se odredi identitet dependecy objekta. Npr aplikacija za majce, gdje svaka majca ima jednu od 3 razlicitih boja

    // da bi instacirali context unutar neke druge class, npr MainActivity, moramo proslijediti trenutni context @componenti
    // @componenta prima trenutni context i proslijeduje ga u @module i nakon toga @module vraca trenutni context i dependecy objekt od context natrag @component
    // na kraju onda @component onda radi dependecy injection od context u MainActivity

    // tko sve smije korisiti @component i njezine @module? obicno se kreira metoda @inject
    // i onda se unutar te metode stavi koji svi fragmenti, activity ili servisi smiju koristiti

    // kad se smije poceti koristiti context dependecy objekt?
    // nakon metode koja se nalazi unutar @componente.. ta se metoda obicno zove inject() */

    /* Primjer objasnjenja za koristenje SharedPrefenrece

    // Imamo dva nacina dohvacanja podataka iz SharedPreference:
    // 1) da se prvo inicijalizira shared preference, zatim se mogu dohvatiti podatke iz shared preference ili spremiti
    // 2) da uz pomoc dagger 2 ( dependecy injection ) ubacimo ili injectamo shared preference koji je kreiran izvana u activity

    // Prvo je bio dagger 1, koji je bio sporiji zbog reflection, sad dagger2 nema vise reflection

    // anotacije koje se koriste u dagger2 su:
    // 1) @module -> anotacija koja se pise iznad classe i vraca dependency
    // 2) @provider -> metode unutar @module classe koja vraca objekt od navedene @module class
    // 3) @component -> ona je kao brige izmedu @module i @inject..
    //                  unutar @component mozemo staviti jedan ili vise @modula.. takoder mozemo staviti i dependecies, ako ta componnenta o necemu ovisi
    //                  @component zapravo izvrsava dependency injection
    // 4) @inject -> on zahtijeva dependecy.. koristi se unutar constructora, method ili kao field unutar activity ili fragmenta
    // 5) @singleton -> omogucuje nam da napravimo samo jednu instaciju objekta iz @module class,,
    //               to je dobro, jer nema potrebe za neke stvari da se vise puta instaciraju i bezveze da se pune u memoriju od mobitela
    // 6) @PerApp -> mozemo kreirati vise instanci od shared preference dependecy objekta i tak dugo bude zivjela ta instanca dok je i aplikacija ziva
    // 7) @PerActivity -> mozemo kreirati vise instanci od shared preference dependecy objekta i tak dugo bude zivjela ta instanca dok je i taj activity ziv
    // 8) @Qualifier -> da se odredi identitet dependecy objekta. Npr aplikacija za majce, gdje svaka majca ima jednu od 3 razlicitih boja

    // da bi instacirali shared preference unutar neke druge class, npr MainActivity, moramo proslijediti trenutni context @componenti
    // @componenta prima trenutni context i proslijeduje ga u @module i nakon toga @module vraca trenutni context i dependecy objekt od shared preference natrag @component
    // na kraju onda @component onda radi dependecy injection od shared preference u MainActivity

    // tko sve smije korisiti @component i njezine @module? obicno se kreira metoda @inject
    // i onda se unutar te metode stavi koji svi fragmenti, activity ili servisi smiju koristiti

    // kad se smije poceti koristiti shared preference dependecy objekt?
    // nakon metode koja se nalazi unutar @componente.. ta se metoda obicno zove inject() */

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;


    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    PresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .mainActivityMvpModule(new MainActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
        recyclerView.setAdapter(recyclerViewAdapter);
        progressBar = findViewById(R.id.progressBar);

        presenter.loadData();


    }

    @Override
    public void launchIntent(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
        // startActivity(new Intent(activityContext, DetailActivity.class).putExtra("name", name));
    }

    @Override
    public void showData(List<CountryData> data) {
        recyclerViewAdapter.setData(data);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
