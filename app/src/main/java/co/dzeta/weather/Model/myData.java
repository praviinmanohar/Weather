package co.dzeta.weather.Model;

public class myData {

    String mLocation;
    String mTempF;

    public myData(){

    }

    public myData(String mLocation, String mTempF) {
        this.mLocation = mLocation;
        this.mTempF = mTempF;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmTempF() {
        return mTempF;
    }

    public void setmTempF(String mTempF) {
        this.mTempF = mTempF;
    }
}
