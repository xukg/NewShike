package com.shike.android.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.android.core.adapter.RecyclerAdapter;
import com.android.core.adapter.RecyclerViewHolder;
import com.android.core.widget.glide.ImageLoader;
import com.android.core.widget.glide.ImageLoaderUtil;
import com.shike.android.R;
import com.shike.android.model.repo.Classify;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerAdapter<Classify.TngouEntity> {

    private String URL_Base = "http://tnfs.tngou.net/image";

    public HomeRecyclerAdapter(Context context, int layoutId, List<Classify.TngouEntity> datas) {
        super(context, layoutId, datas);
    }

    @Override
    public void convert(final RecyclerViewHolder holder, final Classify.TngouEntity item) {
//        Uri uri = Uri.parse(URL_Base + item.getImg());
        String url = URL_Base + item.getImg();
        ImageView view = holder.getView(R.id.sv_classitfy_img);

//        LoadingImgUtil.loadimgAnimate(url, view);

        ImageLoaderUtil.getInstance().loadImage(mContext, new ImageLoader.Builder()
                .url(url)
                .placeHolder(R.drawable.icon_load_default_img)
                .imgView(view)
                .build());

        holder.setText(R.id.sv_classitfy_des, item.getTitle());
        holder.setOnClickListener(R.id.sv_classitfy_img, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(holder.getView(R.id.sv_classitfy_img), item.getTitle(), Snackbar.LENGTH_LONG).show();
//                SwipBackActivity.start(mContext);
            }
        });
    }
}
