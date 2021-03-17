package edu.temple.assigment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Spinner;

public class SelectionActivity extends AppCompatActivity {



    //Initializes the views we will use
    GridView gridView;
    int[] bean_res_id;
    CustomAdapter adapter;
    String[] bean_array;
    //this is a test


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets header
        setTitle(getString(R.string.selection_menu));

        //Sets the view to their id
        gridView = findViewById(R.id.gridView);


        //Makes the array of beans we use and the other array are the images
        Resources res = getResources();
        bean_array = res.getStringArray(R.array.beans);
        bean_res_id = new int[]{R.drawable.bean,R.drawable.black_bean,R.drawable.green_bean,R.drawable.mung_bean,R.drawable.pinto};

        //Uses custom image adapter class
        CustomAdapter adapter = new CustomAdapter(this, bean_array,bean_res_id);

        //Sets our spinner to our adapter
        gridView.setAdapter(adapter);




        //When item is selected it sets the name and picture to said item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                launchIntent.putExtra("EXTRA_POSITION", position);
                startActivity(launchIntent);
            }


        });



    }


}
