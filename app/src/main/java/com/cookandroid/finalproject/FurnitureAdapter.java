package com.cookandroid.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//홈 카테고리 가구 어댑터
public class FurnitureAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    String[] arrFurnitureWord;
    int[] arrFurnitureImage;

    public FurnitureAdapter(Context context, String[] arrFurnitureWord, int[] arrFurnitureImage) {

        this.context = context;
        this.arrFurnitureWord = arrFurnitureWord;
        this.arrFurnitureImage = arrFurnitureImage;
    }

    //자식 뷰(어댑터 뷰의 자식 뷰)들의 개수를 리턴하는 메소드
    @Override
    public int getCount() {
        return arrFurnitureWord.length;
    }

    //항목(자식 뷰의 내용을 갖는 객체) 중 하나를 리턴
    //int position은 리턴할 항목의 위치를 의미
    @Override
    public Object getItem(int position) {
        return arrFurnitureWord[position];
    }

    //어댑터가 갖는 항목의 ID를 리턴
    @Override
    public long getItemId(int position) {
        return 0;
    }

    //각 그리드 칸마다 이미지뷰, 텍스트뷰 생성해서 보여줌
    //자식 뷰들 중 하나를 리턴하는 메소드, 값이 null이면, 자식 뷰를 생성
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(inflater == null){
            //LayoutInflater(xml 리소스를 전개하여 뷰 객체를 만듬) 객체 사용할 준비
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null){
            //사전에 미리 선언해뒀던 레이아웃에 작성했던 xml의 메모리 객체가 삽입
            //인수 root는 생성된 뷰의 루트로 사용할 뷰, 리소스 내에 루트가 따로 있어 null 사용
            view = inflater.inflate(R.layout.furniture_layout, null);
        }

        ImageView furnitureImage =  view.findViewById(R.id.furnitureImage);
        TextView furnitureWord = view.findViewById(R.id.furnitureText);

        furnitureImage.setImageResource(arrFurnitureImage[position]);
        furnitureWord.setText(arrFurnitureWord[position]);

        return view;
    }
}