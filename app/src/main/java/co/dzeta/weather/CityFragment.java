package co.dzeta.weather;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.dzeta.weather.Model.Current;
import co.dzeta.weather.Model.Location;

public class CityFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CityFragment() {
        // Required empty public constructor
    }

    public static CityFragment newInstance(Current param1, Location location) {
        CityFragment fragment = new CityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, ""+location.getName());
        args.putString(ARG_PARAM2, ""+param1.getTempF());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);;
        TextView text = (TextView) view.findViewById(R.id.text);
        TextView text2 = (TextView) view.findViewById(R.id.text2);
        text.setText(mParam1);
        text2.setText(mParam2);
        return view;
    }

    public String getmParam1() {
        return mParam1;
    }

}