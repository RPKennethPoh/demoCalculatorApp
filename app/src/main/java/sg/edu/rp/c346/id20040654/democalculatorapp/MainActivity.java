package sg.edu.rp.c346.id20040654.democalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etCount;
    Button btnCreate;
    LinearLayout linearDynamic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCount = findViewById(R.id.editTextCount);
        btnCreate = findViewById(R.id.buttonCreate);
        linearDynamic = findViewById(R.id.linearLayoutDynamic);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etCount.getText().toString().trim().length() > 0) {
                    int count = Integer.parseInt(etCount.getText().toString());
                    if(count > 0 && count <= 10) {
                        for(int i = 0; i < count; i++) {
                            EditText editText = new EditText(MainActivity.this);
                            editText.setId(i+1);
                            editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                            editText.setHint("Number "+(i+1));
                            linearDynamic.addView(editText);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

    }
}