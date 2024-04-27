package com.islamzaoui.tp2.fragments.memo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.islamzaoui.tp2.R;
import com.islamzaoui.tp2.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MemoFragment extends Fragment {

    private final List<Fragment> fragments = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memo, container, false);

        fragments.add(new DistanceFragment());
        fragments.add(new EnergyFragment());
        fragments.add(new MassFragment());
        fragments.add(new VolumeFragment());
        fragments.add(new TemperatureFragment());
        fragments.add(new PowerFragment());

        ViewPager2 quantityViewPager = view.findViewById(R.id.quantityViewPager);
        ViewPagerAdapter quantityPagerAdapter = new ViewPagerAdapter(this, fragments);
        quantityViewPager.setAdapter(quantityPagerAdapter);

        return view;
    }
}