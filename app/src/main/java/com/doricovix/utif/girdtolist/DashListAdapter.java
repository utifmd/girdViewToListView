package com.doricovix.utif.girdtolist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by utif on 7/23/2017.
 */

public class DashListAdapter extends ArrayAdapter<ItemMhs> {
    public DashListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ItemMhs> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (null == convertView){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.dash_list_item, null);
        }

        ItemMhs mhs = getItem(position);

        ImageView ft_mhs = (ImageView) convertView.findViewById(R.id.ft_mhs);
        TextView nm_mhs = (TextView) convertView.findViewById(R.id.nm_mhs);

        nm_mhs.setText(mhs.getNm_mhs());
        ft_mhs.setImageResource(mhs.getFt_mhs());

        return convertView;
    }
}
