package org.freecoding.servicesmanager;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResultList;
import org.freecoding.servicesmanager.model.JiaZhengOrder;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 我的家政订单
 */
public class HomeOrderActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    JiaZhengOrder info;
    @Bind(R.id.homejiazhengorderitemid)
    ListView homeorderitemid;
    ServiceAdapter serviceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_order);
        ButterKnife.bind(this);
        serviceAdapter = new ServiceAdapter(HomeOrderActivity.this);
        homeorderitemid.setAdapter(serviceAdapter);
        homeorderitemid.setOnItemClickListener(this);

        HttpUtils.getOrderJiaZhengByTypeAndPhone("13691731023","",new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {

            }
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResultList<JiaZhengOrder> info = gson.fromJson(response,
                        new TypeToken<HttpResultList<JiaZhengOrder>>() {
                        }.getType());
                if (info != null && info.totalCount > 0) {
                    List<JiaZhengOrder> list = info.rows;
                    serviceAdapter.setData(list);
                }
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        JiaZhengOrder info = serviceAdapter.getData().get(position);
        switch (info.type) {
            case 1:
                Intent intent = new Intent(this, HomeNurseOrderActivity.class);
                intent.putExtra("info", info);
                startActivity(intent);
                break;
            case 2:
                Intent inte = new Intent(this, HomeDetailOrderActivity.class);
                inte.putExtra("info", info);
                startActivity(inte);
                break;
            case 3:
                Intent inten = new Intent(this, HomeCleaningOrderActivity.class);
                inten.putExtra("info", info);
                startActivity(inten);
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
