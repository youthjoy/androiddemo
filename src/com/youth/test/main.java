package com.youth.test;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

public class main extends Activity  {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView��xxx����ʾ�����ض��Ĳ����ļ�����view��ʼ��  Activity��Ĭ��ʵ�ַ���
        setContentView(R.layout.absolutew);
        //for grid view
        /*GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        gridview.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(main.this, " " + position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }
    
 
}