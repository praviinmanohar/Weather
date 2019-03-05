package co.dzeta.weather.View;

import co.dzeta.weather.Model.Current;
import co.dzeta.weather.Model.Location;

public class CarousalView {

    public interface View{

        void setupView(Current cnt, Location loca);
    }
}
