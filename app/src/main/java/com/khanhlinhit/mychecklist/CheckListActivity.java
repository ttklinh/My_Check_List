package com.khanhlinhit.mychecklist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileOutputStream;
import java.security.AccessController;
import java.util.ArrayList;

public class CheckListActivity extends AppCompatActivity {
    private ListView obj;
    DBHelper mDBHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_list);

        // read db
        mDBHeader = new DBHelper(this);
        ArrayList listHeader = mDBHeader.getAllHeaders();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, listHeader);
        obj = (ListView)findViewById(R.id.listView1);
        obj.setAdapter(arrayAdapter);
    }
}
