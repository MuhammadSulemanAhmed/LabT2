package com.example.suleman.labtask2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by suleman on 04/10/2017.
 */

public class Adapter {
    private ArrayList<DetailsName> list;
    Activity context;

    class ViewHolder {
        TextView tvName;
        TextView tvNumber;
        ImageView info;
        Button btn;
    }

    public Adapter(ArrayList<DetailsName> data, Activity context) {
        super(context, R.layout.activity_main, data);
        this.list = data;
        this.context = context;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DetailsName dataModel = this.list.get(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_main, parent, false);
            viewHolder.tvName = (TextView) convertView.findViewById(R.id.tvcntname);
          //  viewHolder.tvNumber = (TextView) convertView.findViewById(R.id.tvphnnbr);
           // viewHolder.info = (ImageView) convertView.findViewById(R.id.ivContactImage);
            viewHolder.btn =(Button)convertView.findViewById(R.id.callbtn);
            viewHolder.btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MainActivity.this,DetailsName.class);
                    context.startActivity(intent);
//                    Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:03153420690"));
//                   context.startActivity(intent);
//                    Intent callIntent = new Intent(Intent.ACTION_CALL);
//                    callIntent.setData(Uri.parse("tel:03153420690"));
//
//                    if (ActivityCompat.checkSelfPermission(context,
//                            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
//
//                    {
//                        ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE},1001 );
//                        return;
//                    }
                    // if (ContextCompat.checkSelfPermission(context, Manifest.permission. CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //     ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CALL_PHONE} );

//                    context.startActivity(callIntent);
                }
            });
            Intent i=new Intent();
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        lastPosition = position;
        viewHolder.tvName.setText(dataModel.getName());
       // viewHolder.tvNumber.setText(dataModel.getNumber());
        viewHolder.info.setTag(position);
        return convertView;
    }
}
