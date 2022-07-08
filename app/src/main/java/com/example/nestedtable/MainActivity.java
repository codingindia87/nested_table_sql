package com.example.nestedtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nestedtable.helper.WorkHelper;
import com.example.nestedtable.helper.WorkersHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkersHelper workersHelper = new WorkersHelper(this);
        workersHelper.addData("ram");

        WorkHelper workHelper = new WorkHelper(this);
        workHelper.addWork("ram","note");

        ArrayList<String> workers = workersHelper.getAllWorkers();

        for (int i = 0 ; i < workers.size(); i++){
            Log.d("name",workers.get(i));

        }

        ArrayList<String> work = workHelper.getAllWork();

        for (int i = 0; i < work.size(); i++){
            Log.d("workse",work.get(i));
        }

    }
}