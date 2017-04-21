package com.example.keshav.assignment3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keshav.assignment3.fragment.EventFragment;

/**
 * Contains View Pager and recycler view
 */
public class ScreenCActivity extends BaseActivity {
    private TextView tvTitle;
    private ViewPager viewPager;
    private ImageView ivForward, ivBackward;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_c);
        init();
        tvTitle.setText("Up Comming");
        addViewPager();
        onClick();

    }

    /**
     * handles all onClick functionality
     */
    private void onClick() {
        ivBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (viewPager.getCurrentItem() == 0) {
                    finish();
                } else {
                    viewPager.setCurrentItem(0);
                }

            }
        });
        ivForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                viewPager.setCurrentItem(1);
            }
        });
    }


    @Override
    public Void init() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        ivForward = (ImageView) findViewById(R.id.ivForward);
        ivBackward = (ImageView) findViewById(R.id.ivBackward);
        viewPager = (ViewPager) findViewById(R.id.vpScreenC);
        return null;
    }

    /**
     * @param key mode to be passed
     * @return frangment of instance
     */
    private Fragment getInstance(final int key) {
        EventFragment eventFragment = new EventFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MODE, key);
        eventFragment.setArguments(bundle);
        return eventFragment;
    }

    /**
     * adds View Pager to the view
     */
    private void addViewPager() {

        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (position == 0) {
                    Log.d("debug", "key up comming");
                    return getInstance(KEY_UP_COMMING);
                }
                Log.d("debug", "key past");
                return getInstance(KEY_PAST);
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                if (position == 0) {
                    tvTitle.setText(R.string.up_coming);
                } else {
                    tvTitle.setText(R.string.past);
                }
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });
        viewPager.setAdapter(fragmentStatePagerAdapter);

    }


}
