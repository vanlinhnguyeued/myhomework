package com.vanlinhnguyenued.textcheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbAndroid, cbIos, cbPHP;
    Button btnXacNhan;
    TextView tvThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        cbAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Chọn: "+cbAndroid.getText(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Bỏ chọn: "+cbAndroid.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbPHP.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Chọn: "+cbPHP.getText(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Bỏ chọn: "+cbPHP.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        cbIos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Toast.makeText(MainActivity.this, "Chọn: "+cbIos.getText(), Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Bỏ chọn: "+cbIos.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monHoc = "Bạn đã xác nhận chọn: \n";
                if(cbAndroid.isChecked()){
                    monHoc += cbAndroid.getText()+ "\n";
                }
                if(cbIos.isChecked()){
                    monHoc += cbIos.getText()+ "\n";
                }
                if(cbPHP.isChecked()){
                    monHoc += cbPHP.getText()+ "\n";
                }

                tvThongBao.setText(monHoc);
            }
        });
    }

    private void anhxa() {
        cbAndroid = (CheckBox) findViewById(R.id.checkBoxAndroid);
        cbIos = (CheckBox) findViewById(R.id.checkBoxIos);
        cbPHP = (CheckBox) findViewById(R.id.checkBoxPHP);
        btnXacNhan = (Button) findViewById(R.id.buttonXacNhan);
        tvThongBao = (TextView) findViewById(R.id.textViewThongBao);

    }
}
