package android.serry.weatherapplication.viewsActivities;

import android.os.Bundle;
import android.serry.weatherapplication.R;
import android.serry.weatherapplication.adapters.MyFragmentPagerAdapter;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewPager viewPager = findViewById(R.id.viewpager);
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
