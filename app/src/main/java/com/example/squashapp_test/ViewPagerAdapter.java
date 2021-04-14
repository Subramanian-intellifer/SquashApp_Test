package com.example.squashapp_test;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public int[] tab_Icons={
            R.drawable.ic_baseline_videocam_24,R.drawable.heart_icon
    };

    public String[] tab_Titles={
            "Videos","Liked"
    };

    public List<Fragment> fragmentList=new ArrayList<>();
    public List<String> fragmentListTitles=new ArrayList<>();
    Context mContext;

    public ViewPagerAdapter(@NonNull FragmentManager fm,Context context) {
        super(fm);
        this.mContext=context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Drawable tabIconDrawable=mContext.getResources().getDrawable(tab_Icons[position]);
        tabIconDrawable.setBounds(0,0,tabIconDrawable.getIntrinsicWidth(),tabIconDrawable.getIntrinsicHeight());
        SpannableString spannableString=new SpannableString(" "+tab_Titles[position]);
        ImageSpan imageSpan=new ImageSpan(tabIconDrawable,ImageSpan.ALIGN_BOTTOM);
        spannableString.setSpan(imageSpan,0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    public void AddFragment(Fragment fragmentName,String fragmentTitle)
    {
        fragmentList.add(fragmentName);
        fragmentListTitles.add(fragmentTitle);
    }

}
