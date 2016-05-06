package org.freecoding.servicesmanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.freecoding.servicesmanager.model.JiaZhengOrder;
import org.freecoding.servicesmanager.utils.HttpUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的护理订单
 */
public class NursingOrderActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.homehuliorderitemid)
    ListView homehuliorderitemid;
    ServiceAdapter serviceAdapter;
     JiaZhengOrder info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nursing_order);
        ButterKnife.bind(this);
        serviceAdapter = new ServiceAdapter(NursingOrderActivity.this);
        homehuliorderitemid.setAdapter(serviceAdapter);
        homehuliorderitemid.setOnItemClickListener(this);
    }
    /**
     * 返回
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        JiaZhengOrder info = serviceAdapter.getData().get(position);
        switch (info.type) {
            case 1:
                Intent intent = new Intent(this, HomeSpaOrderActivity.class);
                intent.putExtra("info", info);
                startActivity(intent);
                break;
            case 2:
                Intent inten = new Intent(this, HomeChastityOrderActivity.class);
                inten.putExtra("info", info);
                startActivity(inten);
                break;
            case 3:
                Intent inte = new Intent(this, HomeScalingOrderActivity.class);
                inte.putExtra("info", info);
                startActivity(inte);
                break;
            case 4:
                Intent in = new Intent(this, HomeSkincareOrderActivity.class);
                in.putExtra("info", info);
                startActivity(in);
                break;
        }
    }

    public class ServiceAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private Context context;
        private List<JiaZhengOrder> list;
        private JiaZhengOrder servicesItem;

        public ServiceAdapter(Context context) {
            this.context = context;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            if (list != null)
                return list.size();
            return 0;
        }

        public List<JiaZhengOrder> getData() {
            return list;
        }

        public void setData(List<JiaZhengOrder> data) {
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
            JiaZhengOrder info = list.get(position);
            if (view == null) {
                view = layoutInflater.inflate(R.layout.order_item, null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.serverorderid.setText(info.orderName);
            return view;
        }
        class ViewHolder {
            @Bind(R.id.serverorderid)
            TextView serverorderid;
            @Bind(R.id.Noserverorder)
            TextView Noserverorder;
            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
