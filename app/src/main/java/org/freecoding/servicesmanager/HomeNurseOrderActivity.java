package org.freecoding.servicesmanager;

import android.content.Intent;
import android.net.http.HttpResponseCache;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.JiaZhengOrder;
import org.freecoding.servicesmanager.model.Order;
import org.freecoding.servicesmanager.utils.HttpUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;


/**
 * 家政服务/保姆订单
 */
public class HomeNurseOrderActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.baomuriqiorder)
    TextView baomuriqiorder;
    @Bind(R.id.baomutimeorder)
    TextView baomutimeorder;
    @Bind(R.id.baomudizhiorder)
    TextView baomudizhiorder;
    @Bind(R.id.baomubeizhuorder)
    TextView baomubeizhuorder;
    @Bind(R.id.baomuorder)
    LinearLayout baomuorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nurse_order);
        ButterKnife.bind(this);
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

    @OnClick(R.id.baomuorder)
    void onClick() {
        HttpUtils.getMemberOrderByNo("13691731023", "1462291776957", new StringCallback() {

            @Override
            public void onError(Call call, Exception e) {

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

    }
}
