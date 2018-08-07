package pmp.tianxundai.com.okgodownload;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.GetRequest;
import com.lzy.okserver.OkDownload;
import com.lzy.okserver.download.DownloadTask;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pmp.tianxundai.com.okgodownload.R;

/**
 * 创建人： 九尾妖狐
 * 创建时间： 2018/8/6 10:00
 * 功能描述：下载视频
 * 联系方式：1037438704@qq.com
 *
 * @author dell-pc
 */
public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.button_1)
    Button button1;
    @BindView(R.id.button_2)
    Button button2;
    @BindView(R.id.button_3)
    Button button3;
    DownloadTask task;
    DownloadTask task2;
    //这里是下载的路径
    private String path2 = Environment.getExternalStorageDirectory().getPath() + "/aaa";
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        list.add("http://2449.vod.myqcloud.com/2449_22ca37a6ea9011e5acaaf51d105342e3.f20.mp4");
        //视频网路地址
        GetRequest<File> request = OkGo.get(list.get(0));
        task = OkDownload.request("taskTag", request)
                .folder(path2)//存放地方
                .save();
    }
    /**
     * 开始下载
     * */
    @OnClick(R.id.button_1)
    public void onButton1Clicked() {
        task.start();
    }

    /**
     * (
     * 暂停
     */
    @OnClick(R.id.button_2)
    public void onButton2Clicked() {
        task.pause();
    }

    /**
     * (
     * 删除
     */
    @OnClick(R.id.button_3)
    public void onButton3Clicked() {
        task.remove(true);
    }
}
