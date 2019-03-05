package co.dzeta.weather.Rest;

import co.dzeta.weather.Model.Apixu;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
//http://api.apixu.com/v1/current.json?key=bc90b4d5a6c248c2879104637190503&q=New%20york
    @GET("current.json?")
    Call<Apixu> getWeather(@Query("key") String apiKey, @Query("q") String search);

}
