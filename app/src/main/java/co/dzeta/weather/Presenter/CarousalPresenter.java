package co.dzeta.weather.Presenter;

import android.util.Log;

import co.dzeta.weather.MainActivity;
import co.dzeta.weather.Model.Apixu;
import co.dzeta.weather.Model.Current;
import co.dzeta.weather.Model.Location;
import co.dzeta.weather.Rest.ApiClient;
import co.dzeta.weather.Rest.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarousalPresenter {

    private MainActivity mActivity;
    private String TAG = "login";
    private String API_KEY = "";

    public CarousalPresenter(MainActivity mActivity, String apiKey) {
        this.mActivity = mActivity;
        this.API_KEY = apiKey;
    }

    public void getApiResponse(String cities){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Apixu> call = apiService.getWeather(API_KEY,cities);
        call.enqueue(new Callback<Apixu>() {
            @Override
            public void onResponse(Call<Apixu> call, Response<Apixu> response) {
                int statusCode = response.code();

                if (response.isSuccessful()) {
                    Current cnt = response.body().getCurrent();
                    Location loca = response.body().getLocation();
                    mActivity.setupView(cnt, loca);
                    Log.e(TAG, "<<<==========>>Response<<<==========>>>>" + cnt.getTempF() +" , Loc "+loca.getName());

                } else {
                    Log.e(TAG, "<<<==========>>Exception<<<==========>>>>");
                }
            }

            @Override
            public void onFailure(Call<Apixu> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
}
