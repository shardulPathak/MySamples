package com.example.shardulpathak.toastysample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    private String[] mToastTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mToastTypes = new String[]{getString(R.string.info_text), getString(R.string.warn_text),
                getString(R.string.err_text), getString(R.string.success_text),
                getString(R.string.success_without_icon_text)};
    }


    private void initView() {
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mToastTypes);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String type = mToastTypes[position];
                switch (type) {
                    case "Information":
                        showInfo();
                        break;
                    case "Warning":
                        showWarning();
                        break;
                    case "Error":
                        showError();
                        break;
                    case "Success":
                        showSuccess();
                        break;

                    case "Success without Icon":
                        showSuccessWithoutIcon();
                        break;
                }
            }
        });
    }

    private void showInfo() {
        Toasty.info(getApplicationContext(), "Here is some information for you.", Toast.LENGTH_SHORT, true).show();
    }

    private void showWarning() {
        Toasty.warning(getApplicationContext(), "This is a warning.", Toast.LENGTH_SHORT, true).show();
    }

    private void showError() {
        Toasty.error(getApplicationContext(), "This is a error toast.", Toast.LENGTH_SHORT, true).show();
    }

    private void showSuccess() {
        Toasty.success(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
    }

    private void showSuccessWithoutIcon() {
        Toasty.success(getApplicationContext(), "Success without Icon", Toast.LENGTH_SHORT, false).show();
    }
}
