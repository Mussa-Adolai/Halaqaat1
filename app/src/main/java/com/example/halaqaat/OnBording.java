package com.example.halaqaat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class OnBording extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabIndicator;
    Button nxtBtn;
    int postion=0;
    int girlImage[]={R.drawable.girl1,R.drawable.girl2,R.drawable.girl3};
    String heading[]={"Heading1","Heading2","Heading3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabIndicator=findViewById(R.id.tIndicator);
        viewPager=findViewById(R.id.viewpager);


        Adapter_onBording  adapter =  new Adapter_onBording(OnBording.this,heading,girlImage);
        viewPager.setAdapter(adapter);
        tabIndicator.setupWithViewPager(viewPager);

        nxtBtn=findViewById(R.id.nextBtn);

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postion = viewPager.getCurrentItem();
                if (postion < heading.length) {
                    postion++;
                    viewPager.setCurrentItem(postion);
                }
                if (postion == 3) {
                    intentTosplash();
                }
                if (postion == heading.length-1) {
                    nxtBtn.setText("Start");
                }

            }

        private void intentTosplash() {
            Intent splashIntent = new Intent(OnBording.this,Splash.class);
            startActivity(splashIntent);
            finish();
        }


      });
           viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (postion==2)
        {
            nxtBtn.setText("Start");
        }
        else
            {
            nxtBtn.setText("Next");
            }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});

}
}

