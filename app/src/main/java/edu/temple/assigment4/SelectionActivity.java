package edu.temple.assigment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SelectionActivity extends AppCompatActivity {



    //Initializes the views we will use
    Spinner spinner;
    //ImageView image_view;
    int[] bean_res_id;
    CustomAdapter adapter;
    String[] bean_array;

    //TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets the views to their ids
        //image_view = findViewById(R.id.image_view);
        spinner = findViewById(R.id.spinner);
        //textView = findViewById(R.id.textView);

        //Makes the array of beans we use and the other array are the images
        bean_array = new String[]{"Please Pick A Bean","Kidney Bean", "Black Bean", "Green Bean", "Mung Bean", "Pinto Bean"};
        bean_res_id = new int[]{R.drawable.empty,R.drawable.bean,R.drawable.black_bean,R.drawable.green_bean,R.drawable.mung_bean,R.drawable.pinto};

        //Uses custom image adapter class
        CustomAdapter adapter = new CustomAdapter(this, bean_array,bean_res_id);

        //Sets our spinner to our adapter
        spinner.setAdapter(adapter);




        //When item is selected it sets the name and picture to said item
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);

                //show_image(position);
                if(position>0) {//Makes sure something is selected
                    launchIntent.putExtra("EXTRA_POSITION", position);
                    startActivity(launchIntent);
                }
                //else {
                //    textView.setText(" ");
                //}
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }
    //Quick function to set image
    private void show_image(int position) {
        //image_view.setImageResource(bean_res_id[position]);
    }

    public void onResume() {
        super.onResume();

        String[] bean_array = new String[]{"Please Pick A Bean","Kidney Bean", "Black Bean", "Green Bean", "Mung Bean", "Pinto Bean"};
        bean_res_id = new int[]{R.drawable.empty,R.drawable.bean,R.drawable.black_bean,R.drawable.green_bean,R.drawable.mung_bean,R.drawable.pinto};
        CustomAdapter adapter = new CustomAdapter(this, bean_array,bean_res_id);
        spinner.setAdapter(adapter);
    }



}
