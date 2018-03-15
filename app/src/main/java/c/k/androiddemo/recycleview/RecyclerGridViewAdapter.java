package c.k.androiddemo.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import c.k.androiddemo.R;

/**
 * Created by Kingman_Li on 2018/3/13.
 */

public class RecyclerGridViewAdapter extends RecyclerView.Adapter<RecyclerGridViewAdapter.ViewHolder> {
    private Context mContext;
    private String[] data;
    private LayoutInflater inf;

    private OnRecyclerViewItemListener mOnRecyclerViewItemListener;

    public RecyclerGridViewAdapter(Context mContext, String[] data) {
        this.mContext = mContext;
        this.data = data;
        inf = LayoutInflater.from(mContext);
    }

    public void setmOnRecyclerViewItemListener(
            OnRecyclerViewItemListener listener) {
        this.mOnRecyclerViewItemListener = listener;
    }

    //单机事件
    private void itemOnClick(final RecyclerView.ViewHolder holder) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                mOnRecyclerViewItemListener.onItemClickListener(holder.itemView, position);
            }
        });
    }
    //长按事件
    private void itemOnLongClick(final RecyclerView.ViewHolder holder) {
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = holder.getLayoutPosition();
                mOnRecyclerViewItemListener.onItemLongClickListener(holder.itemView, position);
                //返回true是为了防止触发onClick事件
                return true;
            }
        });
    }

    //RecyclerView显示的子View
    //该方法返回是ViewHolder，当有可复用View时，就不再调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = inf.inflate( R.layout.recycler_item, viewGroup, false);
        return new ViewHolder(v);
    }

    //将数据绑定到子View，会自动复用View
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (viewHolder == null) {
            return;
        }

        if (mOnRecyclerViewItemListener != null) {
            itemOnClick(viewHolder);
            itemOnLongClick(viewHolder);
        }

        Picasso.with(mContext)
                .load( data[position])
                .placeholder( R.mipmap.ic_launcher_round)
                .into( viewHolder.imageView );
    }

    //RecyclerView显示数据条数
    @Override
    public int getItemCount() {
        return data.length;
    }

    //自定义的ViewHolder,减少findViewById调用次数
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        //在布局中找到所含有的UI组件
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recycleview_image);
        }
    }
}
