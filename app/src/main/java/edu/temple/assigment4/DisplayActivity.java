package edu.temple.assigment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        //this just goes through ands sets the text and image
        //to the selected bean
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        String[] bean_array = new String[]{"Please Pick A Bean","Kidney Bean", "Black Bean", "Green Bean", "Mung Bean", "Pinto Bean"};
        int[] bean_res_id = new int[]{R.drawable.empty, R.drawable.bean, R.drawable.black_bean, R.drawable.green_bean, R.drawable.mung_bean, R.drawable.pinto};
        
        Intent intent = getIntent();
        int position = intent.getIntExtra("EXTRA_POSITION", 0);

        textView.setText(bean_array[position]);
        imageView.setImageResource(bean_res_id[position]);




    }
}