package com.islamzaoui.tp2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.islamzaoui.tp2.fragments.conversion.ConversionFragment;
import com.islamzaoui.tp2.fragments.memo.MemoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private final List<Fragment> fragments = new ArrayList<>();
    private static MemoFragment memoFragment;
    private static ConversionFragment conversionFragment;
    public static int selectedFragmentID;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragments.add(memoFragment = new MemoFragment());
        fragments.add(conversionFragment = new ConversionFragment());

        viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, fragments);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setUserInputEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu.getItem(0).getSubMenu();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        selectedFragmentID = item.getItemId();
        if (item.getItemId() == R.id.memo) {
            viewPager.setCurrentItem(0, false);
            item.setIcon(R.drawable.baseline_arrow);
            menu.getItem(1).setIcon(null);
            return true;
        } else if (item.getItemId() == R.id.conversion) {
            viewPager.setCurrentItem(1, false);
            item.setIcon(R.drawable.baseline_arrow);
            menu.getItem(0).setIcon(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static MemoFragment getMemoFragment() {
        return memoFragment;
    }

    public static ConversionFragment getConversionFragment() {
        return conversionFragment;
    }
}
