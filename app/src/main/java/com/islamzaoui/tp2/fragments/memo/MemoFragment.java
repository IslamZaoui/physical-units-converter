package com.islamzaoui.tp2.fragments.memo;

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

public class MemoFragment extends Fragment {

    private final List<Fragment> fragments = new ArrayList<>();
    private ViewPager2 memoViewPager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memo, container, false);

        fragments.add(new DistanceFragment());
        fragments.add(new EnergyFragment());
        fragments.add(new MassFragment());
        fragments.add(new VolumeFragment());
        fragments.add(new TemperatureFragment());
        fragments.add(new PowerFragment());

        memoViewPager = view.findViewById(R.id.quantityViewPager);
        ViewPagerAdapter quantityPagerAdapter = new ViewPagerAdapter(this, fragments);
        memoViewPager.setAdapter(quantityPagerAdapter);
        memoViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                try{
                    boolean isConversionSelected = MainActivity.selectedFragmentID == R.id.conversion;
                    setMemoViewPagerIndex(position, isConversionSelected);
                }
                catch (Exception ignored){

                }
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(memoViewPager != null){
            memoViewPager.unregisterOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                @Override
                public void onPageSelected(int position) {
                    super.onPageSelected(position);
                }
            });
        }
    }

    private void setMemoViewPagerIndex(int position, boolean isConversionSelected){
        if(MainActivity.getConversionFragment() != null && MainActivity.getConversionFragment().getConversionViewPager() != null){
            MainActivity.getConversionFragment().getConversionViewPager().setCurrentItem(position, isConversionSelected);
        }
    }

    public ViewPager2 getMemoViewPager() {
        return memoViewPager;
    }
}