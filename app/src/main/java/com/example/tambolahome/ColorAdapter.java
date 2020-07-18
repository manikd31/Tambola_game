package com.example.tambolahome;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import java.util.List;

public class ColorAdapter extends BaseAdapter {

    int[] colors = {R.drawable.color_red, R.drawable.color_blue, R.drawable.color_green,
            R.drawable.color_orange, R.drawable.color_pink, R.drawable.color_purple};
    Context context;
    LayoutInflater inflater;

    public ColorAdapter(Context appContext) {
        this.context = appContext;
        inflater = LayoutInflater.from(appContext);
//        colors = context.getResources().getIntArray(R.array.pen_colors);
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.color_list_item, null);
        Button color = view.findViewById(R.id.color_image);
        color.setBackgroundResource(colors[i]);
        return view;
    }
}
