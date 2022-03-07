package edu.temple.assigment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
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

        //Sets header
        setTitle(getString(R.string.display));

        //this just goes through ands sets the text and image
        //to the selected bean
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        Resources res = getResources();
        String[] bean_array = res.getStringArray(R.array.beans);
        int[] bean_res_id = new int[]{R.drawable.bean, R.drawable.black_bean, R.drawable.green_bean, R.drawable.mung_bean, R.drawable.pinto};
        
        Intent intent = getIntent();
        int position = intent.getIntExtra("EXTRA_POSITION", 0);

        textView.setText(bean_array[position]);
        imageView.setImageResource(bean_res_id[position]);




    }
}