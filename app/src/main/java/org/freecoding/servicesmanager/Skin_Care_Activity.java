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
import org.freecoding.servicesmanager.view.RoundLinearLayout;
import org.freecoding.servicesmanager.view.SeekBarPressure;
import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * 护理/皮肤护理
 */
public class Skin_Care_Activity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
   @Bind(R.id.pifuriqi)
   LinearLayout pifuriqi;
    @Bind(R.id.pifuhulishijian)
    SeekBarPressure pifuhulishijian;
    @Bind(R.id.pifuhulishowshijian)
    TextView pifuhulishowshijian;
    @Bind(R.id.pifuhulibeizhu)
    EditText pifuhulibeizhu;
    @Bind(R.id.pifuname)
    EditText pifuname;
    @Bind(R.id.pifuphone)
    EditText pifuphone;
    @Bind(R.id.pifudizhi)
    EditText pifudizhi;
    ServicesItem info;
    @Bind(R.id.pifuhulifuwu)
    CheckBox pifuhulifuwu;
    Handler hd;
    StringBuffer sb;
    String shijian;
    String name;
    String phone;
    String dizhi;
    String bz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin__care_);
        ButterKnife.bind(this);
        init();
        hd=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what==0){
                    msg("操作成功");
                }else if(msg.what==1){
                    msg("操作失败");
                }else{
                    msg("请检查网络");
                }
            }
        };
    }

    private void init() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        pifuhulishijian.setOnSeekBarChangeListener(new SeekBarPressure.OnSeekBarChangeListener() {
            @Override
            public void onProgressBefore() {
            }

            @Override
            public void onProgressChanged(SeekBarPressure seekBar, double progressLow, double progressHigh) {
                pifuhulishowshijian.setText(String.format(getString(R.string.seekbar_time_title), String.valueOf((int) (12 + progressLow)/2+":00"), String.valueOf((int) (12 + progressHigh)/2+":00")));
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
//保存
    private void save() {
        int state=1;
        bz = pifuhulibeizhu.getText().toString().trim();
        shijian=pifuhulishowshijian.getText().toString().trim();
         name = pifuname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            pifuname.requestFocus();
            return;
        }
         phone = pifuphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            pifuphone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            pifuphone.requestFocus();
            return;
        }
         dizhi = pifudizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            pifudizhi.requestFocus();
            return;
        }
        sb = new StringBuffer();
        if (pifuhulifuwu.isChecked()) {
            sb.append("1:" + pifuhulifuwu.getText().toString().trim() + ";");
        }
        HttpUtils.saveServiceItemHuLi(info.id,"2016-5-5",shijian,sb.toString(),bz,name,dizhi,phone,state,new StringCallback() {
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
    @OnClick(R.id.pifuadd)
    void btntijiao() {
       int state=2;
        bz = pifuhulibeizhu.getText().toString().trim();
        shijian=pifuhulishowshijian.getText().toString().trim();
         name = pifuname.getText().toString().trim();
        if (name.length() == 0) {
            msg("请输入姓名");
            pifuname.requestFocus();
            return;
        }
         phone = pifuphone.getText().toString().trim();
        if (phone.length() == 0) {
            msg("请输入手机号");
            pifuphone.requestFocus();
            return;
        }
        if (phone.length() !=11) {
            msg("手机号输入错误");
            pifuphone.requestFocus();
            return;
        }
         dizhi = pifudizhi.getText().toString().trim();
        if (dizhi.length() == 0) {
            msg("请选择地址");
            pifudizhi.requestFocus();
            return;
        }
         bz = pifuhulibeizhu.getText().toString().trim();
         sb = new StringBuffer();
        if (pifuhulifuwu.isChecked()) {
            sb.append("1:" + pifuhulifuwu.getText().toString().trim() + ";");
        }
        HttpUtils.saveServiceItemHuLi(info.id,"2016-5-5",shijian,sb.toString(),bz,name,dizhi,phone,state,new StringCallback() {
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
    @OnClick(R.id.pifufinsh)
    void btnqxfinsh() {
        this.finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu, menu);
        return true;
    }

}

