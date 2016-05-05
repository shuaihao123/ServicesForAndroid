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
 * 医疗/预约打针
 */
public class MedicalInjectionActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.yuyueriqi)
    LinearLayout yuyueriqi;
    @Bind(R.id.yuyueshijian)
    SeekBarPressure yuyueshijian;
    @Bind(R.id.yuyueshowshijian)
    TextView yuyueshowshijian;
    @Bind(R.id.yuyuebeizhu)
    MultiLineEditText yuyuebeizhu;
    @Bind(R.id.yuyuename)
    EditText yuyuename;
    @Bind(R.id.yuyuephone)
    EditText yuyuephone;
    @Bind(R.id.yuyuedizhi)
    EditText yuyuedizhi;
    @Bind(R.id.yuyueadd)
    TextView yuyueadd;
    @Bind(R.id.yuyuefinsh)
    TextView yuyuefinsh;
    @Bind(R.id.yuyueshuye)
    CheckBox yuyueshuye;
    @Bind(R.id.yuyuedazheng)
    CheckBox yuyuedazheng;
    Handler hd;
    ServicesItem info;
    String shijian;
    String name;
    String phone;
    String dizhi;
    String yuyuebz;
    StringBuffer sb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_injection);
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
        yuyueshijian.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                yuyueshowshijian.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow)/2+":00"), String.valueOf((int) (12 + progressHigh)/2+":00")));
            }

            @Override
            public void onProgressAfter() {

            }
        });
        info = (ServicesItem) getIntent().getSerializableExtra("info");
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

    private void save() {
        sb = new StringBuffer();
        if (yuyueshuye.isChecked()) {
            sb.append("1:" + yuyueshuye.getText().toString().trim() + ";");
        }
        if (yuyuedazheng.isChecked()) {
            sb.append("2:" + yuyuedazheng.getText().toString().trim() + ";");
        }
         shijian=yuyueshowshijian.getText().toString().trim();
         name = yuyuename.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yuyuename.requestFocus();
            return;
        }
         phone = yuyuephone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yuyuephone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            yuyuephone.requestFocus();
            return;
        }
         dizhi = yuyuedizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yuyuedizhi.requestFocus();
            return;
        }
         yuyuebz = yuyuebeizhu.getText().toString().trim();
         HttpUtils.saveServiceItemYiLiao(info.type, "2016-5-5",shijian,sb.toString(),yuyuebz, name, dizhi, phone, new StringCallback() {
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
    @OnClick(R.id.yuyueadd)
    void btntijiao() {
         shijian=yuyueshowshijian.getText().toString().trim();
         name = yuyuename.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            yuyuename.requestFocus();
            return;
        }
         phone = yuyuephone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            yuyuephone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            yuyuephone.requestFocus();
            return;
        }
         dizhi = yuyuedizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            yuyuedizhi.requestFocus();
            return;
        }
         yuyuebz = yuyuebeizhu.getText().toString().trim();

    }

    /**
     * 取消
     */
    @OnClick(R.id.yuyuefinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}


