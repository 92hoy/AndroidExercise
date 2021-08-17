//package com.example.settingview;
//
//import android.app.Fragment;
//import android.content.Context;
//import android.os.TestLooperManager;
//import android.util.Log;
//import android.view.View;
//import android.view.animation.Animation;
//import android.view.animation.AnimationUtils;
//import android.widget.AdapterView;
//import android.widget.Toast;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.TextView;
//
//class DogsDropdownOnItemClickListener implements OnItemClickListener {
//
//    String TAG = "DogsDropdownOnItemClickListener.java";
//
//    @Override
//    public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
//
////
//        Fragment3 fragment3 = new Fragment3();
//
//        Log.d(TAG, "onItemClick: v"+v);
//        Log.d(TAG, "onItemClick: textFragment"+fragment3.popupView);
//        Log.d(TAG, "onItemClick: 123123");
//        // get the context and main activity to access variables
//        Context mContext = v.getContext();
//        Log.d(TAG, "onItemClick: mContext"+mContext);
//
//
//
//
//        // add some animation when a list item was clicked
//        Animation fadeInAnimation = AnimationUtils.loadAnimation(v.getContext(), android.R.anim.fade_in);
//        fadeInAnimation.setDuration(10);
//        v.startAnimation(fadeInAnimation);
//
//        // dismiss the pop up
//        //        fragment3.popupWindowDogs.dismiss();
//        if (fragment3.popupWindowDogs != null && fragment3.popupWindowDogs.isShowing()) {
//            fragment3.popupWindowDogs.dismiss();
//        }
//
//
////        if(((TextView) v).getText().toString() ==null){
////            Log.i("지수버튼클릭", "v=" + v);
////        }
////        else {
////            String selectedItemText = ((TextView) v).getText().toString();
////            fragment3.textShowDropDown1.setText(selectedItemText);
////        }
//
//
////        MainActivity mainActivity = ((MainActivity) mContext);
////        MainActivity activity = (MainActivity)getActivity();
////        mainActivity.textShowDropDown1.setText(selectedItemText);
//
//
////        textShowDropDown.setText(selectedItemText);
//        String selectedItemText = ((TextView) v).getText().toString();
//        Log.i("지수버튼클릭1", "+"+fragment3.textShowDropDown1);
//        Log.i("지수버튼클릭2", "=======" +selectedItemText );
//        // get the text and set it as the button text
////        String selectedItemText = ((TextView) v).getText().toString();
//
////        TextView mTextView;
//
////        mTextView = (TextView)findViewById(R.id.textViewId); // 이부분이 없다면 위와 같은 오류가 발생한다.
//
////        mTextView.setText("Hello World 안드로이드");
//
//
//
////        fragment3.textShowDropDown1.setText(selectedItemText);
//
//        // get the id
//        String selectedItemTag = ((TextView) v).getTag().toString();
//        Toast.makeText(mContext, "선택값: " + selectedItemTag, Toast.LENGTH_SHORT).show();
//
//    }
//
//}