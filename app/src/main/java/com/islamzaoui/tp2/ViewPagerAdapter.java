package com.islamzaoui.tp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.islamzaoui.tp2.fragments.conversion.ConversionFragment;
import com.islamzaoui.tp2.fragments.memo.MemoFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private List<Fragment> fragments;

    public ViewPagerAdapter(@NonNull ConversionFragment fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    public ViewPagerAdapter(@NonNull MemoFragment fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    public ViewPagerAdapter(@NonNull AppCompatActivity Activity, List<Fragment> fragments) {
        super(Activity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (fragments.isEmpty())
            return null;

        return fragments.get(position % fragments.size());
    }

    @Override
    public long getItemId(int position) {
        return (position % fragments.size());
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getCenterPage(int position) {
        return Integer.MAX_VALUE / 2 + position;
    }
}
