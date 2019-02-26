package com.example.kadir.intagramcloneparse;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {
    private final ArrayList<String> username;
    private final ArrayList<String> usercommend;
    private final ArrayList<Bitmap> userImage;
    private final Activity context;

    public  PostClass(ArrayList<String> username, ArrayList<String> usercommend, ArrayList<Bitmap> userImage, Activity context){
        super(context,R.layout.custom_view,username);
        this.username=username;
        this.usercommend=usercommend;
        this.userImage=userImage;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);
        TextView userNameText = customView.findViewById(R.id.custom_view_username_text);
        TextView commandText = customView.findViewById(R.id.customView_commandText);
        ImageView imageView = customView.findViewById(R.id.custom_view_imageview);

        userNameText.setText(username.get(position));
        imageView.setImageBitmap(userImage.get(position));
        commandText.setText(usercommend.get(position));
        return customView;
    }
}
