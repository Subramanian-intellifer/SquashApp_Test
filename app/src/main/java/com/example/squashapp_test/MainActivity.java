package com.example.squashapp_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    MaterialTextView profileIdTextView;
    MaterialButton followButton;
    ImageView followIconImageView;

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolBarLayoutId);
        setSupportActionBar(toolbar);

        profileIdTextView=findViewById(R.id.profileIdTextView);
        profileIdTextView.setText("@eleanor233");

        followButton=findViewById(R.id.followButton);
        followIconImageView=findViewById(R.id.followIconButton);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Follow Button Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        followIconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Follow Icon Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        viewPager=findViewById(R.id.viewPagerMainActivity);
        setUpViewPager(viewPager);

        tabLayout=findViewById(R.id.tabLayoutMainActivity);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void setUpViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),getApplicationContext());
        viewPagerAdapter.AddFragment(new VideosFragment(),"Videos");
        viewPagerAdapter.AddFragment(new LikedFragment(),"Liked");
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId=item.getItemId();
        if (itemId==0)
        {
            Toast.makeText(getApplicationContext(),"Share Option Clicked",Toast.LENGTH_SHORT).show();
        }
        else if (itemId==1)
        {
            Toast.makeText(getApplicationContext(),"Report Option Clicked",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}