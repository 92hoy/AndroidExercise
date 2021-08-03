package com.example.settingview;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View fragmentView = inflater.inflate(R.layout.fragment2, container, false);
        //리스트 목록 넣기
        String[] mValue = getResources().getStringArray(R.array.minute);
        String[] tValue = getResources().getStringArray(R.array.tic);
        ArrayList<Item> list1 = new ArrayList<>();
        ArrayList<Item> list2 = new ArrayList<>();


        int mlength = mValue.length;
        int tlength = tValue.length;

        for (int i = 0 ; i < mlength ; i++)
            list1.add(new Item(mValue[i]));
        for (int i = 0 ; i < tlength ; i++)
            list2.add(new Item(tValue[i]));

        ((ListView)fragmentView.findViewById(R.id.ItemListView1)).setAdapter(new ItemAdapter(getActivity(), R.layout.minute, list1));
        ((ListView)fragmentView.findViewById(R.id.ItemListView2)).setAdapter(new ItemAdapter(getActivity(), R.layout.tic, list2));

        return fragmentView;
    }
    //리스트 목록 클래스
    private class Item {
        public String mName, mValue;
        public TextWatcher mTextWatcher;

        public Item(String name) {
            mName = name;
            mValue = "";

            //EditText 변경 리스너 생성
            mTextWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //변경된 값을 저장한다
                    mValue = s.toString();
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            };
        }
    }

    private class ItemAdapter extends ArrayAdapter<Item> {

        private int mResource;

        public ItemAdapter(Context context, int resource, List<Item> list) {
            super(context, resource, list);
            mResource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout itemView;

            if (convertView == null) {
                itemView = new LinearLayout(getContext());

                LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                vi.inflate(mResource, itemView, true);
            }
            else
                itemView = (LinearLayout) convertView;

            Item item = getItem(position);

            ((TextView)itemView.findViewById(R.id.NameTextView)).setText(item.mName);

            EditText editText = (EditText)itemView.findViewById(R.id.ValueEditText);

            //예전 리스너를 삭제한다
            clearTextChangedListener(editText);

            //값을 불려오고 해당 리스너를 적용한다
            editText.setText(item.mValue);
            editText.addTextChangedListener(item.mTextWatcher);

            return itemView;
        }

        private void clearTextChangedListener(EditText editText) {
            //리스트 목록의 모든 리스너를 대상으로 검사하여 삭제해 준다
            int count = getCount();
            for (int i = 0 ; i < count ; i++)
                editText.removeTextChangedListener(getItem(i).mTextWatcher);
        }
    }



}
