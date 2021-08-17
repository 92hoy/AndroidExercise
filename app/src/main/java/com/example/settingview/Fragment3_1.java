package com.example.settingview;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment3_1 extends Fragment3 {

    private ListView m_oListView = null;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment3_1, container, false);

        custom_listview = fragmentView.findViewById(R.id.custom_listview);
//        fragment3_1 = new Fragment3_1();



//        String[] cValue = getResources().getStringArray(R.array.custom_values);
//        ArrayList<Item> cList = new ArrayList<>();
//        int clength = cValue.length;
//
//        for (int i = 0; i < clength; i++)
//            cList.add(new Item(cValue[i]));
//
//        ((ListView) fragmentView.findViewById(R.id.custom_listview)).setAdapter(new Fragment3.ItemAdapter(getActivity(), R.layout.custom_list_element, cList));

//
//        String[] cValue = getResources().getStringArray(R.array.custom_values);
//        int clength = cValue.length;
//
//        ArrayList<ItemData> oData = new ArrayList<>();
//        for (int i = 0; i < clength; ++i) {
//            ItemData oItem = new ItemData();
//            oItem.strTitle = cValue[i];
//            oItem.onClickListener = (View.OnClickListener) this;
//            oData.add(oItem);
//
//        }
//
//        // ListView, Adapter 생성 및 연결 ------------------------
//        m_oListView = (ListView) fragmentView.findViewById(R.id.custom_listview);
//        ListAdapter oAdapter = new ListAdapter(oData);
//
//        m_oListView.setAdapter(oAdapter);


        return fragmentView;
    }
}
