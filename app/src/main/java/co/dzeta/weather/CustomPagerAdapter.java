package co.dzeta.weather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import co.dzeta.weather.Model.Current;
import co.dzeta.weather.Model.Location;

public class CustomPagerAdapter extends FragmentPagerAdapter {

    final int MAX = 3;
    Current current;
    Location location;

    public CustomPagerAdapter(FragmentManager fm, Current cnt, Location loca) {
        super(fm);
        this.current = cnt;
        this.location = loca;
    }

    @Override
    public Fragment getItem(int position) {
        int index = position%MAX;
        Log.e("Tag",""+index);
        switch (index) {
            case 0:
                return CityFragment.newInstance(current, location);
            case 1:
                return CityFragment.newInstance(current, location);
            case 2:
                return CityFragment.newInstance(current, location);
        }
        return null;
    }

    @Override
    public int getCount() {
        return MAX;
    }
}