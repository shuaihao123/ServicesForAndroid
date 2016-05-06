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
import android.widget.SeekBar;
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
import org.freecoding.servicesmanager.view.SeekBarPressure;
import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 医疗/上门诊疗
 */
public class MedicalTreatmentActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.shangmenriqi)
    LinearLayout shangmenriqi;
    @Bind(R.id.shangmenshijian)
    SeekBarPressure shangmenshijian;
    @Bind(R.id.shangmenshowshijian)
    TextView shangmenshowshijian;
    @Bind(R.id.shangmenbeizhu)
    MultiLineEditText shangmenbeizhu;
    @Bind(R.id.shangmenname)
    EditText shangmenname;
    @Bind(R.id.shangmenphone)
    EditText shangmenphone;
    @Bind(R.id.shangmendizhi)
    EditText shangmendizhi;
    @Bind(R.id.shangmenzhiliaofuwu)
    CheckBox shangmenzhiliaofuwu;
    Handler hd;
    ServicesItem info;
    JiaZhengOrder jiaZhengOrder;
    StringBuffer sb;
    String shijian;
    String name;
    String dizhi;
    String phone;
    String bz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_treatment);
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
        shangmenshijian.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                shangmenshowshijian.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow)/2+":00"), String.valueOf((int) (12 + progressHigh)/2+":00")));
            }

            @Override
            public void onProgressAfter() {

            }
        });
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
            shangmenzhiliaofuwu.setChecked(true);
        }
        String date = jiaZhengOrder.serviceTime;
        String[] dates = date.split("---");
        int kaishi = Integer.parseInt(dates[0].split(":")[0]);
        int end = Integer.parseInt(dates[1].split(":")[0]);
        shangmenshijian.setProgressLow(kaishi);
        shangmenshijian.setProgressHigh(end);
        shangmenshowshijian.setText(kaishi + ":00-" + end + ":00");
        shangmenname.setText(jiaZhengOrder.customerName);
        shangmenphone.setText(jiaZhengOrder.custmerPhone);
        shangmendizhi.setText(jiaZhengOrder.address);
        shangmenbeizhu.setText(jiaZhengOrder.remark);
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
         name = shangmenname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            shangmenname.requestFocus();
            return;
        }
         phone = shangmenphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            shangmenphone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            shangmenphone.requestFocus();
            return;
        }
         dizhi = shangmendizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            shangmendizhi.requestFocus();
            return;
        }
        bz = shangmenbeizhu.getText().toString().trim();
        sb = new StringBuffer();
        if (shangmenzhiliaofuwu.isChecked()) {
            sb.append("1:" + shangmenzhiliaofuwu.getText().toString().trim() + ";");
        }
         shijian=shangmenshowshijian.getText().toString().trim();
        HttpUtils.saveServiceItemYiLiao(info.type, "2016-5-5",shijian,sb.toString(),bz,name,dizhi,phone, new StringCallback() {
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
    @OnClick(R.id.shangmenadd)
    void btntijiao() {
        String name = shangmenname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            shangmenname.requestFocus();
            return;
        }
        String phone = shangmenphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            shangmenphone.requestFocus();
            return;
    }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            shangmenphone.requestFocus();
            return;
        }
        String dizhi = shangmendizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            shangmendizhi.requestFocus();
            return;
        }
        bz = shangmenbeizhu.getText().toString().trim();
        sb = new StringBuffer();
        if (shangmenzhiliaofuwu.isChecked()) {
            sb.append("1:" + shangmenzhiliaofuwu.getText().toString().trim() + ";");
        }
        shijian=shangmenshowshijian.getText().toString().trim();
        HttpUtils.saveServiceItemYiLiao(info.type, "2016-5-5",shijian,sb.toString(),bz,name,dizhi,phone, new StringCallback() {
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
    @OnClick(R.id.shangmenfinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}



