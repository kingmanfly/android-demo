package c.k.androiddemo.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import c.k.androiddemo.R;

/**
 * Created by Kingman_Li on 2018/3/13.
 */

public class RecycleViewActivity extends Activity{
    private RecyclerView recyclerView;
    private String[] data = {
            "http://172.31.66.26:9080/ibsdata/20170313/fa82ead9f4cd41adba0c334da2d6bd7e.jpg",
            "http://172.31.66.26:9080/ibsdata/20170313/fa82ead9f4cd41adba0c334da2d6bd7e.jpg",
            "http://172.31.66.26:9080/ibsdata/20170313/fa82ead9f4cd41adba0c334da2d6bd7e.jpg",
            "http://172.31.66.26:9080/ibsdata/20170313/fa82ead9f4cd41adba0c334da2d6bd7e.jpg",
            "http://www.beautifulstar.ltd/img/baoyuedianhua.jpg",
            "http://www.beautifulstar.ltd/img/baoyuedianhua.jpg",
            "http://www.beautifulstar.ltd/img/baoyuedianhua.jpg",
            "http://106.14.176.248/kingman/music/music-start.png",
            "http://106.14.176.248/kingman/music/music-start.png",
            "http://106.14.176.248/kingman/lottery/danfan.png"
    };

    private Integer[] data2 = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher
    };
    private RecyclerGridViewAdapter recyclerGridViewAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recycleview );
        recyclerView = findViewById( R.id.fragment_recyclerview );
        GridLayoutManager mgr = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mgr);
        recyclerGridViewAdapter = new RecyclerGridViewAdapter(
                this, data);
        recyclerView.setAdapter(recyclerGridViewAdapter);
    }
}
