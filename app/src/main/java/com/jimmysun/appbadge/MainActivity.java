package com.jimmysun.appbadge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mCountEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCountEditText = findViewById(R.id.et_count);
        findViewById(R.id.btn_set).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int count = Integer.parseInt(mCountEditText.getText().toString());
                    if (BadgeUtils.setCount(count, MainActivity.this)) {
                        Toast.makeText(MainActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "设置失败", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "设置失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.btn_notification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int count = Integer.parseInt(mCountEditText.getText().toString());
                    if (BadgeUtils.setNotificationBadge(count, MainActivity.this)) {
                        Toast.makeText(MainActivity.this, "设置成功", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "设置失败", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "设置失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
