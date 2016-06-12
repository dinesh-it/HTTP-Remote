package com.mukilan.smartapps.httpremote;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dinesh on 12/6/16.
 */
public class ButtonsAdapter extends RecyclerView.Adapter<ButtonsAdapter.CustomViewHolder>  {
    private ArrayList<JSONObject> buttons_data_set;

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View button_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.button_ui,null);

        CustomViewHolder viewHolder = new CustomViewHolder(button_view);

        return viewHolder;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ButtonsAdapter(ArrayList<JSONObject> myDataset) {
        Log.e("HTTP Remote", "Buttons UI adapter called");
        buttons_data_set = myDataset;
    }

    public void onBindViewHolder(CustomViewHolder holder, int position) {

        final JSONObject exp = buttons_data_set.get(position);

        try {
            holder.btn.setText(exp.get("title").toString());

            holder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // On click action, should be http request - POST/GET
                }
            });
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public int getItemCount() {
        return Common.ButtonsCount;
    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public Button btn;

        public CustomViewHolder(View view) {
            super(view);

            btn = (Button) view.findViewById(R.id.my_button);
        }
    }
}
