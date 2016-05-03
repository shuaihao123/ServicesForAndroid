package org.freecoding.servicesmanager.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.freecoding.servicesmanager.BaseActivity;
import org.freecoding.servicesmanager.R;
import org.freecoding.servicesmanager.model.ServicesItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Wowser on 2016/5/3.
 */

public class ServiceAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private Context context;
    private List<ServicesItem> list;
    private ServicesItem servicesItem;

    @Override
    public int getCount() {
        if (list != null)
            return list.size();
        return 0;
    }

    public void setData(List<ServicesItem> data) {
        list = data;
        notifyDataSetChanged();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        ServicesItem info = list.get(position);
        if (view == null) {
            view = layoutInflater.inflate(R.layout.service_item, null, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //servicetouxiang.
        viewHolder.servicename.setText(info.name);
        viewHolder.serviceitemname.setText(info.serviceItem);
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.servicetouxiang)
        ImageView servicetouxiang;
        @Bind(R.id.servicename)
        TextView servicename;
        @Bind(R.id.serviceitemname)
        TextView serviceitemname;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}



