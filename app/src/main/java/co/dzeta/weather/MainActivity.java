package co.dzeta.weather;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import co.dzeta.weather.Model.Current;
import co.dzeta.weather.Model.Location;
import co.dzeta.weather.Presenter.CarousalPresenter;
import co.dzeta.weather.View.CarousalView;

public class MainActivity extends AppCompatActivity implements CarousalView.View{

    private String API_KEY = "bc90b4d5a6c248c2879104637190503";

    ViewPager mPager;
    ViewGroup mFrameLayout;
    CustomPagerAdapter mAdapter;
    CarousalPresenter presenter;
    private String[] city = new String[]{"New york","Bangalore","Chennai"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        mFrameLayout = (ViewGroup) findViewById(R.id.pagesContainer);

        presenter = new CarousalPresenter(this, API_KEY);
        for (int i=0; i<city.length; i++) {
            presenter.getApiResponse(city[i]);
        }

    }

    @Override
    public void setupView(Current cnt, Location loca) {


        mAdapter = new CustomPagerAdapter(getSupportFragmentManager(), cnt, loca);
        mPager.setAdapter(mAdapter);

    }
}
