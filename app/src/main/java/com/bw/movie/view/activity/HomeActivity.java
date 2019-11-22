package com.bw.movie.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.bw.movie.view.fragment.CinemaFragment;
import com.bw.movie.view.fragment.MovieFragment;
import com.bw.movie.view.fragment.MyFragment;
import com.bw.movie.view.myview.NoScrollViewPager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private NoScrollViewPager viewpager;
    private List<Fragment> list;
    private RadioGroup radioGroup;
    private ImageView dingweitu;
    private RadioButton home_but1;
    private RadioButton home_but2;
    private RadioButton home_but3;
    private ImageView Search;
    private AMapLocationClientOption mLocationOption;
    private int GPS_REQUEST_CODE = 10;
    private TextView dingwei;
    private AMapLocationClient mlocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        viewpager = findViewById(R.id.viewpager);
        radioGroup = findViewById(R.id.radiogroup);
        home_but1 = findViewById(R.id.home_but1);
        home_but2 = findViewById(R.id.home_but2);
        home_but3 = findViewById(R.id.home_but3);
        dingweitu = findViewById(R.id.dingweitu);
        dingwei = findViewById(R.id.dingwei);
        Search = findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, SearchActivity.class));
            }
        });
        Intent intent = getIntent();
        int userId = intent.getIntExtra("userId", 0);
        String sessionId = intent.getStringExtra("sessionId");
        Log.e("USER", "onCreate: " + userId);
        Log.e("SESSION", "onCreate: " + sessionId);

        dingweitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
                    //开启定位权限,200是标识码
                    ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                } else {
                    MyLocation(HomeActivity.this);//开始定位
                }
            }
        });


        list = new ArrayList<>();
        list.add(new MovieFragment());
        list.add(new CinemaFragment());
        list.add(new MyFragment());
        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_but1:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.home_but2:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.home_but3:
                        viewpager.setCurrentItem(2);
                        break;
                }
            }
        });
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.home_but1);
                        break;
                    case 1:
                        radioGroup.check(R.id.home_but2);
                        break;
                    case 2:
                        radioGroup.check(R.id.home_but3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /*
     * 定位 判断是否开启权限
     * 有 执行
     * 无 弹框提示进入设置开启权限
     * */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200://刚才的识别码
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//用户同意权限,执行我们的操作
                    MyLocation(HomeActivity.this);//开始定位
                } else {//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
                    Toast.makeText(HomeActivity.this, "未开启定位权限,请手动到设置去开启权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    /*
     * 定位成功回调信息，设置相关消息
     * */
    public void MyLocation(Context context) {
        mlocationClient = new AMapLocationClient(context);
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息

                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            dingwei.setText(amapLocation.getAoiName());
                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                            Toast.makeText(HomeActivity.this, "没有权限，请打开权限...", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(HomeActivity.this)
                                    .setTitle("定位服务未开启")
                                    .setMessage("请在系统设置中开启定位服务\n" +
                                            "以便为您提供更好的服务")
                                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivityForResult(intent, GPS_REQUEST_CODE);
                                        }
                                    })
                                    .show();
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);

        } else {
            MyLocation(HomeActivity.this);//开始定位
            //Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }

    }

    //内存泄露和定位
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mlocationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            mlocationClient.onDestroy();
            mlocationClient = null;
        }
    }
}
