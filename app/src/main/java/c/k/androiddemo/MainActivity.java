package c.k.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import c.k.androiddemo.recycleview.RecycleViewActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        intent = new Intent();
    }

    public void onRecycleView(View view) {
        intent.setClass( this, RecycleViewActivity.class );
        startActivity( intent );
    }
}
