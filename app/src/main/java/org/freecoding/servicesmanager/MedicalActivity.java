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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResultList;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.RoundLinearLayout;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 医疗
 */
public class MedicalActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.serviceitemid)
    ListView serviceitemid;
    ServiceAdapter serviceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical);
        ButterKnife.bind(this);
        serviceAdapter = new ServiceAdapter(MedicalActivity.this);
        serviceitemid.setAdapter(serviceAdapter);
        serviceitemid.setOnItemClickListener(this);
        init();
        HttpUtils.getAllYiLiaoItem(new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
            }

            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResultList<ServicesItem> info = gson.fromJson(response,
                        new TypeToken<HttpResultList<ServicesItem>>() {
                        }.getType());
                if (info != null && info.totalCount > 0) {
                    List<ServicesItem> list = info.rows;
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
    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ServicesItem info = serviceAdapter.getData().get(position);
        switch (info.type) {
            case 1:
                Intent intent = new Intent(this, MedicaladviceActivity.class);
                intent.putExtra("info", info);
                startActivity(intent);
                break;
            case 2:
                Intent inten = new Intent(this, MedicalInjectionActivity.class);
                inten.putExtra("info", info);
                startActivity(inten);
                break;
            case 3:
                Intent inte = new Intent(this, MedicalRegistrActivity.class);
                inte.putExtra("info", info);
                startActivity(inte);
                break;
            case 4:
                Intent inc = new Intent(this, MedicalAccomPanyActivity.class);
                inc.putExtra("info", info);
                startActivity(inc);
                break;
            case 5:
                Intent in = new Intent(this, MedicalTreatmentActivity.class);
                in.putExtra("info", info);
                startActivity(in);
                break;
        }

    }

    public class ServiceAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private Context context;
        private List<ServicesItem> list;
        private ServicesItem servicesItem;

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

        public List<ServicesItem> getData() {
            return list;
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
                view = layoutInflater.inflate(R.layout.service_item, null);
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

        class ViewHolder {
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
}
