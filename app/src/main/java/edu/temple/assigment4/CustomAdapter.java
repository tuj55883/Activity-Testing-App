package edu.temple.assigment4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CustomAdapter extends BaseAdapter  {

    Context context;
    String[] items;
    int[] bean_res_id;

    public CustomAdapter(Context context, String[] items, int[] bean_res_id){
        this.context = context;
        this.items = items;
        this.bean_res_id = bean_res_id;
    }

    @Override
    public int getCount() { //Gets the amount of items
        return items.length;
    }

    @Override
    public Object getItem(int position) { //gets a specific item
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //This gets the view when selected
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView =  new TextView(context);
        textView.setText(items[position]);
        textView.setTextSize(22);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setPadding(10,8,0,8);







        //This sets the image to the left of the text
        Drawable img =context.getDrawable(bean_res_id[position]);
        img.setBounds(0, 0, 50, 50);
        textView.setBackgroundResource(bean_res_id[position]);


        return textView;

    }

    @Override
    //This gets the view in the drop down
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView pair = (TextView) super.getDropDownView(position, convertView, parent);


        //This sets the image to the left of the text
        Drawable img =context.getDrawable(bean_res_id[position]);
        img.setBounds(0, 0, 64, 74);
        pair.setCompoundDrawables(img, null, null, null);


        //Sets text
        pair.setText(items[position]);





        return pair;
    }


}
