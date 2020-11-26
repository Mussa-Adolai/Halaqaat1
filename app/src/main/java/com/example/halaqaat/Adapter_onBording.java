package com.example.halaqaat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter_onBording  extends PagerAdapter {
    OnBording onBording;
    String[] heading;
    int[] girlImage;

    public Adapter_onBording(OnBording onBording, String[] heading, int[] girlImage) {
        this.heading = heading;
        this.onBording = onBording;
        this.girlImage=girlImage;
    }

    @Override
    public int getCount() {
        return girlImage.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(onBording).inflate(R.layout.item_paper, container, false);
        //ConstraintLayout backgroundconstraintlayout;
        TextView headings;
        ImageView viewgirlImage;

        viewgirlImage=view.findViewById(R.id.wallPaper);
      //  backgroundconstraintlayout = view.findViewById(R.id.paper_main_layout);
        headings = view.findViewById(R.id.txt_heading);

        headings.setText(heading[position]);
        viewgirlImage.setImageResource(girlImage[position]);
      //  backgroundconstraintlayout.setBackgroundResource(girlImage[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}