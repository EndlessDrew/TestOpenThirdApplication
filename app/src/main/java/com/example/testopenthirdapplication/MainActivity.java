package com.example.testopenthirdapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tencent.smtt.sdk.TbsReaderView;

public class MainActivity extends Activity implements TbsReaderView.ReaderCallback{

    private LinearLayout mLl_linearlayout;
    private TbsReaderView mTbsReaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLl_linearlayout = findViewById(R.id.linearLayout);
        mTbsReaderView = new TbsReaderView(this,this);
        mLl_linearlayout.addView(mTbsReaderView,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        Button bt_button = findViewById(R.id.bt_button);
        bt_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了按钮", Toast.LENGTH_SHORT).show();
                Log.i("Drew","点击按钮显示日志");
                showFile();

            }
        });

    }

    @Override
    public void onCallBackAction(Integer integer, Object o, Object o1) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private  void showFile()
    {
        Bundle bundle = new Bundle();
        String stringPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/test.docx";
        bundle.putString("filePath",stringPath);
        boolean isResult = mTbsReaderView.preOpen(stringPath,false);
        if (isResult)
        {
         mTbsReaderView.openFile(bundle);
        }else
            {
                Log.i("aaa","没有打开文件");
            }
            
              Log.i("Drew","打印日志");
    }
}
