package org.freecoding.servicesmanager;

import android.content.Context;
import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.os.Message;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.HttpResultList;
import org.freecoding.servicesmanager.model.JiaZhengOrder;
import org.freecoding.servicesmanager.model.Order;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;


/**
 * 家政服务/保姆订单
 */
public class HomeNurseOrderActivity extends AppCompatActivity{
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.serviceorderitemid)
    ListView serviceorderitemid;

    ServiceorderAdapter serviceorderAdapter;
    Handler hd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nurse_order);
        ButterKnife.bind(this);

        hd = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    msg("提交成功");
                } else if (msg.what == 1) {
                    msg("提交失败");
                } else {
                    msg("请检查网络");
                }
            }
        };
        HttpUtils.getOrderJiaZhengByTypeAndPhone("13691731023", "1", new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                hd.sendEmptyMessage(2);
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                List<JiaZhengOrder> list = gson.fromJson(response, new TypeToken<List<JiaZhengOrder>>() {
                }.getType());
                serviceorderAdapter.setData(list);
            }
        });

        serviceorderAdapter = new ServiceorderAdapter(HomeNurseOrderActivity.this);
        serviceorderitemid.setAdapter(serviceorderAdapter);

        serviceorderitemid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                JiaZhengOrder order = serviceorderAdapter.getData().get(position);
                Intent it = new Intent(HomeNurseOrderActivity.this, HomeNurseActivity.class);
                it.putExtra("order", order);
                startActivity(it);
            }
        });
    }

    void msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
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

   /* @OnClick(R.id.baomuorder)
    void onClick() {
        HttpUtils.getMemberOrderByNo("13691731023", "1462291776957", new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                hd.sendEmptyMessage(2);
            }
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                JiaZhengOrder order = gson.fromJson(response, JiaZhengOrder.class);
                if (order.message == null) {
                    Intent it = new Intent(HomeNurseOrderActivity.this, HomeNurseActivity.class);
                    it.putExtra("order", order);
                    startActivity(it);
                }
            }
        });
    }*/

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
            //servicetouxiang.
            viewHolder.baomuriqiorder.setText(order.orderTime);
            viewHolder.baomutimeorder.setText(order.serviceTime);
            viewHolder.baomubeizhuorder.setText(String.valueOf(order.remark));
            viewHolder.baomudizhiorder.setText(order.address);

            return view;
        }

        class ViewHolder {
            @Bind(R.id.baomuriqiorder)
            TextView baomuriqiorder;
            @Bind(R.id.baomutimeorder)
            TextView baomutimeorder;
            @Bind(R.id.baomubeizhuorder)
            TextView baomubeizhuorder;
            @Bind(R.id.baomudizhiorder)
            TextView baomudizhiorder;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
