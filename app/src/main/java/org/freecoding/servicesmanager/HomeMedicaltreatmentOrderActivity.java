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
import android.widget.ListView;
import android.widget.TextView;

import org.freecoding.servicesmanager.model.JiaZhengOrder;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 医疗/上门诊疗订单
 */
public class HomeMedicaltreatmentOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.servicdshangmenorderitemid)
    ListView servicdshangmenorderitemid;
    ServiceorderAdapter serviceorderAdapter;
    JiaZhengOrder jiaZhengOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medicaltreatment_order);
        ButterKnife.bind(this);
        serviceorderAdapter = new ServiceorderAdapter(HomeMedicaltreatmentOrderActivity.this);
        servicdshangmenorderitemid.setAdapter(serviceorderAdapter);

      /*  //查询保姆订单列表
        HttpUtils.getOrderJiaZhengByTypeAndPhone(info.custmerPhone,"1", new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
            }
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                List<JiaZhengOrder> list = gson.fromJson(response, new TypeToken<List<JiaZhengOrder>>() {
                }.getType());
                serviceorderAdapter.setData(list);
            }
        });*/

        //listview下item点击事件
        servicdshangmenorderitemid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JiaZhengOrder order = serviceorderAdapter.getData().get(position);
                Intent it = new Intent(HomeMedicaltreatmentOrderActivity.this,MedicalTreatmentActivity.class);
                it.putExtra("order", order);
                startActivity(it);
            }
        });
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
    public class ServiceorderAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<JiaZhengOrder> list;
        public ServiceorderAdapter(Context context) {
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
            JiaZhengOrder order = list.get(position);
            if (view == null) {
                view = layoutInflater.inflate(R.layout.home_order_item, null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.fuwuriqiorder.setText(order.orderTime);
            viewHolder.fuwutimeorder.setText(order.serviceTime);
            viewHolder.fuwubeizhuorder.setText(String.valueOf(order.remark));
            viewHolder.fuwudizhiorder.setText(order.address);

            return view;
        }

        class ViewHolder {
            @Bind(R.id.fuwuriqiorder)
            TextView fuwuriqiorder;
            @Bind(R.id.fuwutimeorder)
            TextView fuwutimeorder;
            @Bind(R.id.fuwudizhiorder)
            TextView fuwudizhiorder;
            @Bind(R.id.fuwubeizhuorder)
            TextView fuwubeizhuorder;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
