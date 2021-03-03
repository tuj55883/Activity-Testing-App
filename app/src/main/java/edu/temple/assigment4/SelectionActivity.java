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
    int[] bean_res_id;
    CustomAdapter adapter;
    String[] bean_array;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets the view to their id
        spinner = findViewById(R.id.spinner);


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
                    //When something is selected it launches the image activity
                    launchIntent.putExtra("EXTRA_POSITION", position);
                    startActivity(launchIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void onResume() {
        super.onResume();
        //When the user exits the image activity this just resets the spinner
        String[] bean_array = new String[]{"Please Pick A Bean","Kidney Bean", "Black Bean", "Green Bean", "Mung Bean", "Pinto Bean"};
        bean_res_id = new int[]{R.drawable.empty,R.drawable.bean,R.drawable.black_bean,R.drawable.green_bean,R.drawable.mung_bean,R.drawable.pinto};
        CustomAdapter adapter = new CustomAdapter(this, bean_array,bean_res_id);
        spinner.setAdapter(adapter);
    }



}
