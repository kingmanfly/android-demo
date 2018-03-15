package c.k.androiddemo.recycleview;

import android.view.View;

/**
 * Created by Kingman_Li on 2018/3/15.
 */

public interface OnRecyclerViewItemListener {
    void onItemClickListener(View view, int position);
    void onItemLongClickListener(View view, int position);
}
