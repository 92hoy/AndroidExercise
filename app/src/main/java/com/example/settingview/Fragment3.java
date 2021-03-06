package com.example.settingview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.WindowManager.LayoutParams;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends Fragment implements View.OnClickListener {
    ListView custom_listview;
    TextView textView;
    private ListView m_oListView = null;
    private PopupWindow mPopupWindow;

    String IndexContents[];
    String PriceContents[];
    PopupWindow popupWindowDogs;

    TextView textShowDropDown1;
    TextView textShowDropDown2;

    TextView activeTextList;


    View popupView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment3, container, false);
        popupView = inflater.inflate(R.layout.popup_window, container, false);
        textShowDropDown1 = (TextView) popupView.findViewById(R.id.textShowDropDown1);
        textShowDropDown2 = (TextView) popupView.findViewById(R.id.textShowDropDown2);

//        textShowDropDown1.setOnClickListener(handler);
        // initialize pop up window items list

        // add items on the array dynamically
        // format is name : ID
        List<String> IndexList = new ArrayList<String>();
        IndexList.add("??????::1");
        IndexList.add("??????::2");
        IndexList.add("??????::3");

        List<String> PriceList = new ArrayList<String>();
        PriceList.add("??????::1");
        PriceList.add("??????::2");
        PriceList.add("??????::3");
        PriceList.add("??????::4");

        // convert to simple array
        IndexContents = new String[IndexList.size()];
        IndexList.toArray(IndexContents);

        PriceContents = new String[PriceList.size()];
        PriceList.toArray(PriceContents);


        // initialize pop up window
        popupWindowDogs = popupWindowDogs();

        // button on click listener
        custom_listview = fragmentView.findViewById(R.id.custom_listview);

        String[] cValue = getResources().getStringArray(R.array.custom_values);
        int clength = cValue.length;

        ArrayList<ItemData> oData = new ArrayList<>();
        for (int i = 0; i < clength; ++i) {
            ItemData oItem = new ItemData();
            oItem.strTitle = cValue[i];
            oItem.onClickListener = (View.OnClickListener) this;
            oData.add(oItem);

        }

        // ListView, Adapter ?????? ??? ?????? ------------------------
        m_oListView = (ListView) fragmentView.findViewById(R.id.custom_listview);
        ListAdapter oAdapter = new ListAdapter(oData);

        m_oListView.setAdapter(oAdapter);

        return fragmentView;
    }

    @Override

    public void onClick(View v) {
        Log.i("btnclick view1", "v=" + v.getResources().getResourceName(v.getId()));
        Log.i("btnclick view2", "v=" + v.getId());


//        View popupView = getLayoutInflater().inflate(R.layout.popup_window, null);

        /**
         * LayoutParams WRAP_CONTENT??? ?????? inflate??? View??? ????????? ?????????
         * PopupWinidow??? ????????????.
         */
        mPopupWindow = new PopupWindow(popupView,
                RelativeLayout.LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        /**
         * showAsDropDown(anchor, xoff, yoff)
         * @View anchor : anchor View??? ???????????? ?????? ?????? ????????? ??????.
         * @?????? : ????????? anchor View??? ????????? ?????? ?????? View?????? ????????????
         * ???????????? ???????????? ???????????? ??????.
         * xoff, yoff : anchor View??? ???????????? PopupWindow??? xoff??? x??????,
         * yoff??? y?????? ?????? ????????? ????????? ???????????? ??????.
         * @int xoff : -??????(?????? ???????????? ??????), +??????(?????? ??????????????? ??????)
         * @int yoff : -??????(?????? ???????????? ??????), +??????(?????? ??????????????? ??????)
         * achor View ??? ?????? ?????? ??????.
         * ???????????? ??????, ???????????? ?????? ??????. (?????? ????????? ?????????)
         */
        mPopupWindow.setAnimationStyle(-1); // ??????????????? ??????(-1:??????, 0:????????????)
//			mPopupWindow.showAsDropDown(btn_Popup, 50, 50);

        /**
         * showAtLocation(parent, gravity, x, y)
         * @praent : PopupWindow??? ????????? parent View ??????
         * View v = (View) findViewById(R.id.btn_click)??? ????????? parent ??????
         * @gravity : parent View??? Gravity ?????? ?????? Popupwindow ????????? ????????? ???.
         * @x : PopupWindow??? (-x, +x) ?????? ???,??? ????????? ????????? ??????
         * @y : PopupWindow??? (-y, +y) ?????? ???,??? ????????? ????????? ??????
         */
//			mPopupWindow.showAtLocation(popupView, Gravity.NO_GRAVITY, 0, 0);
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, -100);


        //????????????
        Button button6 = (Button) popupView.findViewById(R.id.button6);
        button6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                if (mPopupWindow != null && mPopupWindow.isShowing()) {
                    mPopupWindow.dismiss();
                }
            }
        });


        textShowDropDown1.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                Log.i("??????????????????11", "v=" + view.getResources().getResourceName(view.getId()));
//                popupWindowDogs = popupWindowDogs();
                activeTextList = textShowDropDown1;
                popupWindowDogs.showAsDropDown(view, 0, 0);

            }
        });

        textShowDropDown2.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                Log.i("??????????????????22", "v=" + view.getResources().getResourceName(view.getId()));
//                popupWindowDogs = popupWindowDogs();
                activeTextList = textShowDropDown2;

                popupWindowDogs.showAsDropDown(view, 0, 0);

            }
        });
//
//        }
        Log.i("activeTextList", "activeTextList" + activeTextList);

//        fragment3_1 = new Fragment3_1();
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
////        transaction.replace(R.id.container2, fragment3_1).commit();
//
//
//        View oParentView = (View) v.getParent(); // ????????? View??? ????????????. ???, ????????? View???.
//        int nViewTag = Integer.parseInt((String) v.getTag());
//        String strViewName = "";
//        switch (nViewTag) {
//            case 1: // ??????
//                strViewName = "??????";
//                break;
//            case 2: // ?????????
//                strViewName = "?????????";
//                oParentView = (View) oParentView.getParent();
//                break;
//        }
//
//        TextView oTextTitle = (TextView) oParentView.findViewById(R.id.textTitle);
//        String position = (String) oParentView.getTag();
//
//        AlertDialog.Builder oDialog = new AlertDialog.Builder(getActivity(),
//                android.R.style.Theme_DeviceDefault_Light_Dialog);
//
//        String strMsg = strViewName + " - ????????? ???????????? position ??? " + position +
//                " ?????????.\nTitle ????????? :" + oTextTitle.getText();
//
//        oDialog.setMessage(strMsg)
//                .setPositiveButton("??????", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                })
//                .setCancelable(true) // ??????????????? ???????????? ????????? ????????? ??????.
//                .show();
    }

    public PopupWindow popupWindowDogs() {

        // initialize a pop up window type
        PopupWindow popupWindow = new PopupWindow(getActivity());

        // the drop down list is a list view
        ListView listViewDogs = new ListView(getActivity());

        // set our adapter and pass our pop up window contents
        listViewDogs.setAdapter(dogsAdapter(IndexContents));
        Log.d("listViewDogs", "IndexContents" + listViewDogs);
        listViewDogs.setAdapter(dogsAdapter(PriceContents));
        Log.d("listViewDogs", "PriceContents" + listViewDogs);

        // set the item click listener
        listViewDogs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int arg2, long arg3) {
                Log.d("OnItemClickListener", "onItemClick: v" + v);
//                Log.d("OnItemClickListener", "onItemClick: textFragment"+fragment3.popupView);
                Log.d("OnItemClickListener", "onItemClick: 123123");
                // get the context and main activity to access variables
                Context mContext = v.getContext();
                Log.d("OnItemClickListener", "onItemClick: getId" + v);


                // add some animation when a list item was clicked
                Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
                fadeInAnimation.setDuration(10);
                v.startAnimation(fadeInAnimation);


                String selectedItemText = ((TextView) v).getText().toString();
                activeTextList.setText(selectedItemText);

                // get the id
                String selectedItemTag = ((TextView) v).getTag().toString();
                Toast.makeText(mContext, "?????????: " + selectedItemTag, Toast.LENGTH_SHORT).show();
            }
        });

        // set the item click listener
//        listViewDogs.setOnItemClickListener(new DogsDropdownOnItemClickListener());

        // some other visual settings
        popupWindow.setFocusable(true);
        popupWindow.setWidth(250);
        popupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);

        // set the list view as pop up window content
        popupWindow.setContentView(listViewDogs);

        return popupWindow;
    }


    /*
     * adapter where the list values will be set
     */
    private ArrayAdapter<String> dogsAdapter(String dogsArray[]) {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, dogsArray) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Log.i("position", getItem(position));
                // setting the ID and text for every items in the list
                String item = getItem(position);
                String[] itemArr = item.split("::");
                String text = itemArr[0];
                String id = itemArr[1];

                // visual settings for the list item
                TextView listItem = new TextView(getActivity());
                listItem.setText(text);
                listItem.setTag(id);
                listItem.setTextSize(22);
                listItem.setPadding(10, 10, 10, 10);
                listItem.setTextColor(Color.WHITE);

                return listItem;
            }
        };

        return adapter;
    }

}