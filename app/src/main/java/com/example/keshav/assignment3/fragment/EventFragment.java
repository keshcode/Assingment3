package com.example.keshav.assignment3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.keshav.assignment3.R;
import com.example.keshav.assignment3.constants.Constants;

/**
 * Created by keshav on 20/4/17.
 */

public class EventFragment extends Fragment implements Constants {
    private int mode;
    private Button btnRightFrag, btnLeftFrag;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container, false);
        init(view);
        Bundle bundle = getArguments();
        mode = bundle.getInt(KEY_MODE);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mode == KEY_UP_COMMING) {
            btnLeftFrag.setText(R.string.pending);
            btnRightFrag.setText(R.string.accepted);
        } else if (mode == KEY_PAST) {
            btnLeftFrag.setText(R.string.cancel);
            btnRightFrag.setText(R.string.completed);
        }
        addViewPager();
    }

    /**
     * @param view refernce to the pager view
     * @return returns nothing
     */
    public Void init(final View view) {
        btnLeftFrag = (Button) view.findViewById(R.id.btnLeftFrag);
        btnRightFrag = (Button) view.findViewById(R.id.btnRightFrag);
        viewPager = (ViewPager) view.findViewById(R.id.vpSubScreenC);
        return null;
    }

    /**
     * @param key mode to be passed for adaptor to identify
     * @return fragment inflated in pager
     */
    private Fragment getInstance(final int key) {
        SubEventFragment subEventFragment = new SubEventFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MODE, key);
        subEventFragment.setArguments(bundle);
        return subEventFragment;
    }

    /**
     * adds view pager to fragment
     */
    private void addViewPager() {

        FragmentStatePagerAdapter fragmentStatePagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(final int position) {
                if (mode == KEY_UP_COMMING) {
                    Log.d(TAG, "up_comming sub pager");
                    if (position == 0) {
                        return getInstance(KEY_PENDING);
                    }
                    return getInstance(KEY_ACCEPTED);
                }
                Log.d(TAG, "past sub pager");
                if (position == 0) {
                    return getInstance(KEY_CANCEL);
                }
                return getInstance(KEY_COMPLETED);
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
        viewPager.setAdapter(fragmentStatePagerAdapter);

    }

    @Override
    public Void init() {
        return null;
    }
}
