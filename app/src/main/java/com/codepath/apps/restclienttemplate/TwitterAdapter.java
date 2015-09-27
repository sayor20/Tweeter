package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.apps.restclienttemplate.models.Tweet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TwitterAdapter extends ArrayAdapter<Tweet>{
    public TwitterAdapter(Context context, ArrayList<Tweet> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Tweet tweet = getItem(position);

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.items_tweet, parent, false);

        TextView tvName;
        TextView tvHandle;
        TextView tvBody;
        ImageView ivProfilePhoto;

        tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvBody = (TextView) convertView.findViewById(R.id.tvBody);
        tvHandle = (TextView) convertView.findViewById(R.id.tvHandle);
        ivProfilePhoto = (ImageView) convertView.findViewById(R.id.ivProfilePhoto);

        tvName.setText(tweet.getUser().getName());
        tvBody.setText(Html.fromHtml(tweet.getBody()));

        tvHandle.setText("@"+tweet.getUser().getScreenname());
        ivProfilePhoto.setImageResource(R.color.abc_color_highlight_material);
        Picasso.with(getContext()).load(tweet.getUser().getProfile_url()).into(ivProfilePhoto);

        return convertView;
    }
}
