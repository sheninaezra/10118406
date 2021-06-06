package com.example.uts_10118406;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    FragmentProfile Fragmentprofile;
    Fragmentnote Fragmentnote;
    Fragmentinformation Fragmentinformation;

    MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.pager);
        setupViewPager(viewPager);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.note:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.information:
                        viewPager.setCurrentItem(2);
                        break;

                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                menuItem = bottomNavigationView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        Fragmentprofile = new FragmentProfile();
        Fragmentnote = new Fragmentnote();
        Fragmentinformation = new Fragmentinformation();


        adapter.addFragment(Fragmentprofile);
        adapter.addFragment(Fragmentnote);
        adapter.addFragment(Fragmentinformation);
        viewPager.setAdapter(adapter);
    }
}