package com.example.keshav.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keshav.assignment3.adaptor.RecycleViewAdaptor;
import com.example.keshav.assignment3.constants.Constants;
import com.example.keshav.assignment3.model.Items;

import java.util.ArrayList;

/**
 * this is the activity for screen B contains recycler view of items
 */
public class ScreenBActivity extends AppCompatActivity implements Constants {

    private RecycleViewAdaptor recycleViewAdaptor;
    private ArrayList<Items> itemList;
    private RecyclerView recyclerView;
    private TextView tvTitle;
    private ImageView ivForward, ivBackward;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_b);
        init();
        tvTitle.setText("Screen B");
        addToList();
        recycleViewAdaptor = new RecycleViewAdaptor(itemList, this, KEY_NORMAL);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recycleViewAdaptor);
        ivForward.setVisibility(View.INVISIBLE);
        onClick();


    }

    /**
     * contians all on Click functionality
     */
    private void onClick() {
        ivBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });
    }

    @Override
    public Void init() {
        itemList = new ArrayList<Items>();
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        recyclerView = (RecyclerView) findViewById(R.id.rvItem);
        ivForward = (ImageView) findViewById(R.id.ivForward);
        ivBackward = (ImageView) findViewById(R.id.ivBackward);
        return null;
    }

    /**
     * adds Elements to list
     */
    private void addToList() {
        Items mItem = new Items("latop", "precious");
        itemList.add(mItem);
        mItem = new Items("mobile", "precious");
        itemList.add(mItem);
    }
}
