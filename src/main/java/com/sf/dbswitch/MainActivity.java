package com.sf.dbswitch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.sf.dbswitch.core.db.ISimpleDataGet;
import com.sf.dbswitch.core.db.ormlite.SimpleData;
import com.sf.dbswitch.core.repository.Repo;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.add).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        SimpleData simpleData = new SimpleData(1000);
        Repo.getInstance().addSimpleData(simpleData, new ISimpleDataGet() {
          @Override
          public void Get(SimpleData data) {

          }

          @Override
          public void Get(List<SimpleData> data) {

          }

          @Override
          public void index(int index) {
            Log.d(TAG,"add index is "+index);
          }


        });
      }
    });



    findViewById(R.id.button).setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Repo.getInstance().querySimpleData(null, new ISimpleDataGet() {
          @Override
          public void Get(SimpleData data) {

          }

          @Override
          public void Get(List<SimpleData> data) {
            for (SimpleData simpleData : data) {
              Log.d(TAG,simpleData.toString());
            }
          }
          @Override
          public void index(int index) {

          }
        });
      }
    });
  }
}
