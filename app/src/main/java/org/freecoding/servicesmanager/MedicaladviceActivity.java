package org.freecoding.servicesmanager;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.StringCallback;

import org.freecoding.servicesmanager.model.HttpResult;
import org.freecoding.servicesmanager.model.JiaZhengOrder;
import org.freecoding.servicesmanager.model.ServicesItem;
import org.freecoding.servicesmanager.utils.HttpUtils;
import org.freecoding.servicesmanager.view.MultiLineEditText;
import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.RoundTextView;
import org.freecoding.servicesmanager.view.SeekBarPressure;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 医疗/医疗咨询
 */
public class MedicaladviceActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yiliaoriqi)
    LinearLayout yiliaoriqi;
    @Bind(R.id.zixunbeizhu)
    MultiLineEditText zixunbeizhu;
    @Bind(R.id.yiliaoname)
    EditText yiliaoname;
    @Bind(R.id.yiliaophone)
    EditText yiliaophone;
    @Bind(R.id.yiliaodizhi)
    EditText yiliaodizhi;
    @Bind(R.id.yiliaoadd)
    TextView yiliaoadd;
    @Bind(R.id.yiliaofinsh)
    TextView yiliaofinsh;
    @Bind(R.id.zixunfuwu)
    CheckBox zixunfuwu;
    @Bind(R.id.jinjizixun)
    CheckBox jinjizixun;
    Handler hd;
    ServicesItem info;
    JiaZhengOrder jiaZhengOrder;
    String name;
    String phone;
    String dizhi;
    String bz;
    StringBuffer sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicaladvice);
        ButterKnife.bind(this);
        init();
        hd=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0){
                    msg("保存成功");
                }else if(msg.what==1){
                    msg("保存失败");
                }else{
                    msg("请检查网络");
                }
            }
        };
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        if (getIntent() != null && getIntent().getSerializableExtra("info") != null) {
            info = (ServicesItem) getIntent().getSerializableExtra("info");
        } else if (getIntent() != null && getIntent().getSerializableExtra("order") != null) {
            jiaZhengOrder = (JiaZhengOrder) getIntent().getSerializableExtra("order");
            loadOrder();
        }
    }

    private void loadOrder() {
        String serviceItem = jiaZhengOrder.serviceItem;
        if (serviceItem.contains("1")) {
            zixunfuwu.setChecked(true);
        }
        if (serviceItem.contains("2")) {
            jinjizixun.setChecked(true);
        }
        String date = jiaZhengOrder.serviceTime;
        String[] dates = date.split("---");
        int kaishi = Integer.parseInt(dates[0].split(":")[0]);
        int end = Integer.parseInt(dates[1].split(":")[0]);
        yiliaoname.setText(jiaZhengOrder.customerName);
        yiliaophone.setText(jiaZhengOrder.custmerPhone);
        yiliaodizhi.setText(jiaZhengOrder.address);
        zixunbeizhu.setText(jiaZhengOrder.remark);
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
            case R.id.saveButton:
                save();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//保存
    private void save() {
        sb = new StringBuffer();
        if (zixunfuwu.isChecked()) {
            sb.append("1:" + zixunfuwu.getText().toString().trim() + ";");
        }
        if (jinjizixun.isChecked()) {
            sb.append("2:" + jinjizixun.getText().toString().trim() + ";");
        }
         name = yiliaoname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yiliaoname.requestFocus();
            return;
        }
         phone = yiliaophone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yiliaophone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            yiliaophone.requestFocus();
            return;
        }
         dizhi = yiliaodizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yiliaodizhi.requestFocus();
            return;
        }
         bz = zixunbeizhu.getText().toString().trim();

        HttpUtils.saveServiceItemYiLiao(info.type,"2016-5-5", info.serviceItem, "","", "", "", "", new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                hd.sendEmptyMessage(2);
            }
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResult result = gson.fromJson(response, HttpResult.class);
                if (result.success) {
                    hd.sendEmptyMessage(0);
                    finish();
                } else {
                    hd.sendEmptyMessage(1);
                }
            }
        });
    }

    void msg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * 提交
     */
    @OnClick(R.id.yiliaoadd)
    void btntijiao() {
        sb = new StringBuffer();
        if (zixunfuwu.isChecked()) {
            sb.append("1:" + zixunfuwu.getText().toString().trim() + ";");
        }
        if (jinjizixun.isChecked()) {
            sb.append("2:" + jinjizixun.getText().toString().trim() + ";");
        }
        String name = yiliaoname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yiliaoname.requestFocus();
            return;
        }
        String phone = yiliaophone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yiliaophone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            yiliaophone.requestFocus();
            return;
        }
        String dizhi = yiliaodizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yiliaodizhi.requestFocus();
            return;
        }
        bz = zixunbeizhu.getText().toString().trim();
        HttpUtils.saveServiceItemYiLiao(info.type,"2016-5-5", info.serviceItem, "","", "", "", "", new StringCallback() {
            @Override
            public void onError(Call call, Exception e) {
                hd.sendEmptyMessage(2);
            }
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                HttpResult result = gson.fromJson(response, HttpResult.class);
                if (result.success) {
                    hd.sendEmptyMessage(0);
                    finish();
                } else {
                    hd.sendEmptyMessage(1);
                }
            }
        });
    }

    /**
     * 取消
     */
    @OnClick(R.id.yiliaofinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

