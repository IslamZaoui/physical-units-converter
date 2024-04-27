package com.islamzaoui.tp2.fragments.memo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.islamzaoui.tp2.R;

import java.util.ArrayList;
import java.util.List;

public class MemoFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memo, container, false);

        ViewPager2 quantityViewPager = view.findViewById(R.id.quantityViewPager);
        QuantityPagerAdapter quantityPagerAdapter = new QuantityPagerAdapter(this);
        quantityViewPager.setAdapter(quantityPagerAdapter);

        return view;
    }

    private static class QuantityPagerAdapter extends FragmentStateAdapter {
        private final List<Fragment> fragments = new ArrayList<>();
        public QuantityPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if(fragments.isEmpty())
                return null;

            return fragments.get(position);
        }

        @Override
        public int getItemCount() {
            return fragments.size();
        }
    }
}