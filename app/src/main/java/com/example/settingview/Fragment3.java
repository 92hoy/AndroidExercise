package com.example.settingview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment implements View.OnClickListener {
    ListView custom_listview;
    TextView textView;
    private ListView m_oListView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment3, container, false);

        custom_listview = fragmentView.findViewById(R.id.custom_listview);


//        String[] cValue = getResources().getStringArray(R.array.custom_values);
//        ArrayList<Item> cList = new ArrayList<>();
//        int clength = cValue.length;
//
//        for (int i = 0; i < clength; i++)
//            cList.add(new Item(cValue[i]));
//
//        ((ListView) fragmentView.findViewById(R.id.custom_listview)).setAdapter(new Fragment3.ItemAdapter(getActivity(), R.layout.custom_list_element, cList));


        String[] cValue = getResources().getStringArray(R.array.custom_values);
        int clength = cValue.length;

        ArrayList<ItemData> oData = new ArrayList<>();
        for (int i = 0; i < clength; ++i) {
            ItemData oItem = new ItemData();
            oItem.strTitle = cValue[i];
            oItem.onClickListener = (View.OnClickListener) this;
            oData.add(oItem);

        }

        // ListView, Adapter 생성 및 연결 ------------------------
        m_oListView = (ListView) fragmentView.findViewById(R.id.custom_listview);
        ListAdapter oAdapter = new ListAdapter(oData);

        m_oListView.setAdapter(oAdapter);


        return fragmentView;
    }

    @Override
    public void onClick(View v) {

        View oParentView = (View) v.getParent(); // 부모의 View를 가져온다. 즉, 아이템 View임.
        int nViewTag = Integer.parseInt((String) v.getTag());
        String strViewName = "";
        switch (nViewTag) {
            case 1: // 버튼
                strViewName = "버튼";
                break;
            case 2: // 타이틀
                strViewName = "타이틀";
                oParentView = (View) oParentView.getParent();
                break;
        }

        TextView oTextTitle = (TextView) oParentView.findViewById(R.id.textTitle);
        String position = (String) oParentView.getTag();

        AlertDialog.Builder oDialog = new AlertDialog.Builder(getActivity(),
                android.R.style.Theme_DeviceDefault_Light_Dialog);

        String strMsg = strViewName + " - 선택한 아이템의 position 은 " + position +
                " 입니다.\nTitle 텍스트 :" + oTextTitle.getText();

        oDialog.setMessage(strMsg)
                .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(true) // 백버튼으로 팝업창이 닫히지 않도록 한다.
                .show();
    }
}