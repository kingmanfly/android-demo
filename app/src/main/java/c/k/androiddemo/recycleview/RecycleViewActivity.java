package c.k.androiddemo.recycleview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

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

    private RecyclerGridViewAdapter recyclerGridViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_recycleview );
        initView();
        initEvent();
    }

    private void initView() {
        recyclerView = findViewById( R.id.fragment_recyclerview );
        GridLayoutManager mgr = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mgr);

        int spanCount = 2;//跟布局里面的spanCount属性是一致的
        int spacing = 2;//每一个矩形的间距
        boolean includeEdge = true;//如果设置成false那边缘地带就没有间距
        //设置每个item间距
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        recyclerGridViewAdapter = new RecyclerGridViewAdapter(
                this, data);
        recyclerView.setAdapter(recyclerGridViewAdapter);
    }

    private void initEvent() {
        onRecyclerItemClickListener();
    }

    private void onRecyclerItemClickListener() {
        recyclerGridViewAdapter.setmOnRecyclerViewItemListener(new OnRecyclerViewItemListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                Toast.makeText(RecycleViewActivity.this,
                        "onClick:" + position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(View view, int position) {
                Toast.makeText(RecycleViewActivity.this,
                        "onLongClick:" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
