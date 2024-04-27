package com.islamzaoui.tp2.fragments.conversion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.islamzaoui.tp2.MainActivity;
import com.islamzaoui.tp2.R;
import com.islamzaoui.tp2.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConversionFragment extends Fragment {
    private final List<Fragment> fragments = new ArrayList<>();
    private ViewPager2 conversionViewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conversion, container, false);

        fragments.add(new DistanceFragment());
        fragments.add(new EnergyFragment());
        fragments.add(new MassFragment());
        fragments.add(new VolumeFragment());
        fragments.add(new TemperatureFragment());
        fragments.add(new PowerFragment());

        conversionViewPager = view.findViewById(R.id.quantityViewPager);
        ViewPagerAdapter quantityPagerAdapter = new ViewPagerAdapter(this, fragments);
        conversionViewPager.setAdapter(quantityPagerAdapter);
        conversionViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                try{
                    boolean isMemoSelected = MainActivity.selectedFragmentID == R.id.memo;
                    MainActivity.getMemoFragment().getMemoViewPager().setCurrentItem(position, isMemoSelected);
                }
                catch (Exception ignored){}
            }
        });

        return view;
    }

    public ViewPager2 getConversionViewPager() {
        return conversionViewPager;
    }
}