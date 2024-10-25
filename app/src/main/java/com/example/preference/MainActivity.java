package com.example.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText ed1,ed2,ed3,ed4;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sharedPreferences =getSharedPreferences("dataInfo",MODE_PRIVATE);
        AnhXa();
        loadData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = ed1.getText().toString().trim();
                String Ma = ed2.getText().toString().trim();
                String Email = ed3.getText().toString().trim();
                String Phone = ed4.getText().toString().trim();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", Name);
                editor.putString("ma", Ma);
                editor.putString("email", Email);
                editor.putString("phone", Phone);
                editor.apply(); // Hoặc commit()
                if(Name.equals("Thanh")&&Ma.equals("22115053122339")&&Email.equals("Thanh@gmail.com")&&Phone.equals("0898337722")){
                    Toast.makeText(MainActivity.this,"Lưu thanh công",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"Lỗi",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        button= (Button) findViewById(R.id.btnSave);
        ed1 = (EditText) findViewById(R.id.etName);
        ed2 = (EditText) findViewById(R.id.etMa);
        ed3 = (EditText) findViewById(R.id.etEmail);
        ed4 = (EditText) findViewById(R.id.etPhone);
    }
    private void loadData() {
        String savedName = sharedPreferences.getString("name", "");
        String savedMa = sharedPreferences.getString("ma", "");
        String savedEmail = sharedPreferences.getString("email", "");
        String savedPhone = sharedPreferences.getString("phone", "");

        ed1.setText(savedName);
        ed2.setText(savedMa);
        ed3.setText(savedEmail);
        ed4.setText(savedPhone);
    }


    @Override
    protected void onResume() {
        super.onResume();
        loadData();
}
}