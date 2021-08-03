package com.example.settingview;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    TextView textView;
    ListView indicator_listview;
    Spinner dropdown, overlay_dropdown;
//    String[] items = {"캔들", "바", "라인", "P&F", "삼선전환도", "스윙", "렌코", "Heikin_Ashi"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View fragmentView = inflater.inflate(R.layout.fragment1, container, false);
//        카테고리 dropdown
        dropdown = fragmentView.findViewById(R.id.chart_category);
//        오버레이 dropdown
        overlay_dropdown = fragmentView.findViewById(R.id.overlay_spinner);
//       보조지표 ListView
        indicator_listview = fragmentView.findViewById(R.id.indicator_listview);
        initspinnerfooter();
        setOverlay_dropdown();
        setIndicator_listview();

//      TextView 클릭 시 클릭이벤트
        textView = (TextView) fragmentView.findViewById(R.id.sub_indicator);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextView 클릭될 시 할 코드작성

                if (indicator_listview.getVisibility() == View.VISIBLE) {
                    indicator_listview.setVisibility(View.GONE);
                } else {
                    indicator_listview.setVisibility(View.VISIBLE);
                }
            }
        });
        return fragmentView;

    }


    private void initspinnerfooter() {
        String[] items = new String[]{
                "캔들", "바", "라인", "P&F", "삼선전환도", "스윙", "렌코", "Heikin_Ashi"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
        // adapter 로 선언한 ArrayAdapter 를
        // setDropDownViewResource 를 이용하여 select_dialog_singlechoice 를 적용해주면
        // 해당 adapter 에 싱글로만 작동이 가능한 라디오 버튼이 생성된다
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.v("item", (String) parent.getItemAtPosition(position));

//                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void setOverlay_dropdown() {
        String[] items = getResources().getStringArray(R.array.overlay);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, items);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        overlay_dropdown.setAdapter(adapter);
        overlay_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void setIndicator_listview() {
        String[] items = getResources().getStringArray(R.array.sub_indicator);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_multiple_choice, items);

//        adapter.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        indicator_listview.setAdapter(adapter);
//        overlay_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
////                Log.v("item", (String) parent.getItemAtPosition(position));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//            }
//        });
    }

};