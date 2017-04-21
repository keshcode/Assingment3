package com.example.keshav.assignment3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keshav.assignment3.R;
import com.example.keshav.assignment3.adaptor.RecycleViewAdaptor;
import com.example.keshav.assignment3.constants.Constants;
import com.example.keshav.assignment3.model.Items;

import java.util.ArrayList;

/**
 * Created by keshav on 20/4/17.
 */

public class SubEventFragment extends Fragment implements Constants {
    private int mode;
    //    private TextView tvsample;
    private ArrayList<Items> itemList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sub_event, container, false);
        Bundle bundle = getArguments();
        mode = bundle.getInt(KEY_MODE);
//        setFragmentView(view, mode);
        addToList();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvSubEventList);
        RecycleViewAdaptor recycleViewAdaptor = new RecycleViewAdaptor(itemList, getContext(), mode);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recycleViewAdaptor);
        return view;
    }

    /**
     * adds elements to display
     */
    private void addToList() {
        Items mItem = new Items("item1", "val");
        itemList.add(mItem);
        mItem = new Items("item2", "val2");
        itemList.add(mItem);
        mItem = new Items("item2", "val2");
        itemList.add(mItem);
        mItem = new Items("it", "dem");
        itemList.add(mItem);
        mItem = new Items("item2", "val2");
        itemList.add(mItem);
        mItem = new Items("item2", "val2");
        itemList.add(mItem);
        mItem = new Items("item2", "val2");
        itemList.add(mItem);
        mItem = new Items("item2", "val2");
        itemList.add(mItem);
    }

//    public void setFragmentView(View view, int mode) {
//        tvsample = (TextView) view.findViewById(R.id.tvsample);
//        switch (mode) {
//            case KEY_ACCEPTED:
//                tvsample.setText("accepted");
//                break;
//            case KEY_CANCEL:
//                tvsample.setText("cancel");
//                break;
//            case KEY_COMPLETED:
//                tvsample.setText("completed");
//                break;
//            case KEY_PENDING:
//                tvsample.setText("Pending");
//                break;
//            default:
//                tvsample.setText("default case running");
//                break;
//        }
//    }

    @Override
    public Void init() {
        return null;
    }
}
