package com.example.ratingui;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.graphics.Color;
import android.graphics.Paint;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;


import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class FilterVH extends RecyclerView.ViewHolder {
        public RatingBar ratingBar1,ratingBar2,ratingBar3,ratingBar4,ratingBar5;
        public TextView tvAll,tvComment, tvMedia, tvCountAll, tvCountComment, tvCountMedia;
        public LinearLayout loAll, loComment, loMedia;
        public TextView tv5Star, tv4Star, tv3Star, tv2Star, tv1Star;
        public FilterVH(@NonNull View itemView) {
            super(itemView);
            ratingBar1 = itemView.findViewById(R.id.ratingBar1);
            ratingBar2 = itemView.findViewById(R.id.ratingBar2);
            ratingBar3 = itemView.findViewById(R.id.ratingBar3);
            ratingBar4 = itemView.findViewById(R.id.ratingBar4);
            ratingBar5 = itemView.findViewById(R.id.ratingBar5);
            tvAll = itemView.findViewById(R.id.tv_all);
            tvComment =itemView.findViewById(R.id.tv_comment);
            tvMedia = itemView.findViewById(R.id.tv_media);
            loAll = itemView.findViewById(R.id.lo_all);
            loComment = itemView.findViewById(R.id.lo_comment);
            loMedia = itemView.findViewById(R.id.lo_media);
            tvCountAll = itemView.findViewById(R.id.tv_count_all);
            tvCountComment = itemView.findViewById(R.id.tv_count_comment);
            tvCountMedia = itemView.findViewById(R.id.tv_count_media);
            tv5Star =itemView.findViewById(R.id.tv_5start);
            tv4Star =itemView.findViewById(R.id.tv_4start);
            tv3Star =itemView.findViewById(R.id.tv_3start);
            tv2Star =itemView.findViewById(R.id.tv_2start);
            tv1Star =itemView.findViewById(R.id.tv_1start);

        }
    }

    class RatingVH extends RecyclerView.ViewHolder {
        public ImageView ivProfile;
        public TextView tvName;
        public RatingBar rbItem;
        public TextView tvDate;
        public TextView tvContent;
        public TextView tvSeeMore;
        public TextView tvShopName;
        public TextView tvReply;
        public LinearLayout linearLayout;
        public ImageView ivCmt1,ivCmt2,ivCmt3,ivCmt4,ivCmt5;

        public RatingVH(@NonNull View itemView) {
            super(itemView);
            ivProfile = itemView.findViewById(R.id.iv_profile);
            tvName = itemView.findViewById(R.id.tv_name);
            rbItem = itemView.findViewById(R.id.rb_item);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvSeeMore = itemView.findViewById(R.id.tv_seemore);
            tvShopName = itemView.findViewById(R.id.tv_shopname);
            tvReply = itemView.findViewById(R.id.tv_reply);
            linearLayout = itemView.findViewById(R.id.lo_image);
            ivCmt1 = itemView.findViewById(R.id.iv_cmt1);
            ivCmt2 = itemView.findViewById(R.id.iv_cmt2);
            ivCmt3 = itemView.findViewById(R.id.iv_cmt3);
            ivCmt4 = itemView.findViewById(R.id.iv_cmt4);
            ivCmt5 = itemView.findViewById(R.id.iv_cmt5);
        }
    }

public class RatingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int VIEW_TYPE_FILTER = 1;
    private final int VIEW_TYPE_RATING = 0;
    private final List<Rating> ratingList;
    Activity activity;


    public RatingAdapter(List<Rating> ratingList, Activity activity) {
        this.ratingList = ratingList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_FILTER) {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_filter, parent, false);
            return new FilterVH(view);
        }
        else {
            View view = LayoutInflater.from(activity).inflate(R.layout.item_rating, parent, false);
            return new RatingVH(view);
        }
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof RatingVH) {
            Rating rating = ratingList.get(position);
            RatingVH ratingVH = (RatingVH) holder;
            ratingVH.ivProfile.setImageResource(rating.getImage());
            ratingVH.rbItem.setRating(rating.getRating());
            ratingVH.tvName.setText(rating.getName());
            ratingVH.tvDate.setText(rating.getDate());
            ratingVH.tvContent.setText(rating.getContent());
            if(rating.getSeeMore() != null) {
                ratingVH.tvSeeMore.setVisibility(View.VISIBLE);
                ratingVH.tvSeeMore.setPaintFlags(ratingVH.tvSeeMore.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
                ratingVH.tvSeeMore.setText(rating.getSeeMore());
            }
            else{
                ratingVH.tvSeeMore.setVisibility(View.GONE);
            }
            ratingVH.tvSeeMore.setOnClickListener(view -> {
                ratingVH.tvContent.setText(rating.getContent() + rating.getContentSeeMore());
                ratingVH.tvSeeMore.setVisibility(View.GONE);
            });

            if(rating.getShopName() != null) {
                ratingVH.tvShopName.setVisibility(View.VISIBLE);
                ratingVH.tvShopName.setText(rating.getShopName());
            }
            else{
                ratingVH.tvShopName.setVisibility(View.GONE);
            }

            if(rating.getReply() != null) {
                ratingVH.tvReply.setVisibility(View.VISIBLE);
                ratingVH.tvReply.setText(rating.getReply());
            }
            else{
                ratingVH.tvReply.setVisibility(View.GONE);
            }

            if(rating.isListImage()) {
                ratingVH.linearLayout.setVisibility(View.VISIBLE);
            }
            else {
                ratingVH.linearLayout.setVisibility(View.GONE);
            }

        }
        else if(holder instanceof FilterVH) {
            FilterVH filterVH = (FilterVH) holder;
            filterVH.loAll.setOnClickListener(v -> {
                filterVH.loAll.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tvAll.setTextColor(Color.WHITE);
                filterVH.tvCountAll.setTextColor(Color.WHITE);

                filterVH.loComment.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvComment.setTextColor(Color.BLACK);
                filterVH.tvCountComment.setTextColor(Color.BLACK);

                filterVH.loMedia.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvMedia.setTextColor(Color.BLACK);
                filterVH.tvCountMedia.setTextColor(Color.BLACK);

                filterVH.tv5Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv5Star.setTextColor(Color.BLACK);
                filterVH.tv4Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv4Star.setTextColor(Color.BLACK);
                filterVH.tv3Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv3Star.setTextColor(Color.BLACK);
                filterVH.tv2Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv2Star.setTextColor(Color.BLACK);
                filterVH.tv1Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv1Star.setTextColor(Color.BLACK);

            });
            filterVH.loComment.setOnClickListener(v -> {
                filterVH.loComment.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tvComment.setTextColor(Color.WHITE);
                filterVH.tvCountComment.setTextColor(Color.WHITE);

                filterVH.loAll.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvAll.setTextColor(Color.BLACK);
                filterVH.tvCountAll.setTextColor(Color.BLACK);

                filterVH.loMedia.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvMedia.setTextColor(Color.BLACK);
                filterVH.tvCountMedia.setTextColor(Color.BLACK);
                filterVH.tv5Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv5Star.setTextColor(Color.BLACK);
                filterVH.tv4Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv4Star.setTextColor(Color.BLACK);
                filterVH.tv3Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv3Star.setTextColor(Color.BLACK);
                filterVH.tv2Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv2Star.setTextColor(Color.BLACK);
                filterVH.tv1Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv1Star.setTextColor(Color.BLACK);
            });

            filterVH.loMedia.setOnClickListener(v -> {
                filterVH.loMedia.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tvMedia.setTextColor(Color.WHITE);
                filterVH.tvCountMedia.setTextColor(Color.WHITE);

                filterVH.loComment.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvComment.setTextColor(Color.BLACK);
                filterVH.tvCountComment.setTextColor(Color.BLACK);

                filterVH.loAll.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvAll.setTextColor(Color.BLACK);
                filterVH.tvCountAll.setTextColor(Color.BLACK);

                filterVH.tv5Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv5Star.setTextColor(Color.BLACK);

                filterVH.tv4Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv4Star.setTextColor(Color.BLACK);

                filterVH.tv3Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv3Star.setTextColor(Color.BLACK);

                filterVH.tv2Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv2Star.setTextColor(Color.BLACK);

                filterVH.tv1Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv1Star.setTextColor(Color.BLACK);
            });

            filterVH.tv5Star.setOnClickListener(view -> {
                filterVH.tv5Star.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tv5Star.setTextColor(Color.WHITE);

                filterVH.loComment.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvComment.setTextColor(Color.BLACK);
                filterVH.tvCountComment.setTextColor(Color.BLACK);

                filterVH.loAll.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvAll.setTextColor(Color.BLACK);
                filterVH.tvCountAll.setTextColor(Color.BLACK);

                filterVH.loMedia.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvMedia.setTextColor(Color.BLACK);
                filterVH.tvCountMedia.setTextColor(Color.BLACK);

                filterVH.tv4Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv4Star.setTextColor(Color.BLACK);

                filterVH.tv3Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv3Star.setTextColor(Color.BLACK);

                filterVH.tv2Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv2Star.setTextColor(Color.BLACK);

                filterVH.tv1Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv1Star.setTextColor(Color.BLACK);
            });

            filterVH.tv4Star.setOnClickListener(view -> {
                filterVH.tv4Star.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tv4Star.setTextColor(Color.WHITE);

                filterVH.loComment.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvComment.setTextColor(Color.BLACK);
                filterVH.tvCountComment.setTextColor(Color.BLACK);

                filterVH.loAll.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvAll.setTextColor(Color.BLACK);
                filterVH.tvCountAll.setTextColor(Color.BLACK);

                filterVH.loMedia.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvMedia.setTextColor(Color.BLACK);
                filterVH.tvCountMedia.setTextColor(Color.BLACK);

                filterVH.tv5Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv5Star.setTextColor(Color.BLACK);

                filterVH.tv3Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv3Star.setTextColor(Color.BLACK);

                filterVH.tv2Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv2Star.setTextColor(Color.BLACK);

                filterVH.tv1Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv1Star.setTextColor(Color.BLACK);
            });

            filterVH.tv3Star.setOnClickListener(view -> {
                filterVH.tv3Star.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tv3Star.setTextColor(Color.WHITE);

                filterVH.loComment.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvComment.setTextColor(Color.BLACK);
                filterVH.tvCountComment.setTextColor(Color.BLACK);

                filterVH.loAll.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvAll.setTextColor(Color.BLACK);
                filterVH.tvCountAll.setTextColor(Color.BLACK);

                filterVH.loMedia.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvMedia.setTextColor(Color.BLACK);
                filterVH.tvCountMedia.setTextColor(Color.BLACK);

                filterVH.tv4Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv4Star.setTextColor(Color.BLACK);

                filterVH.tv5Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv5Star.setTextColor(Color.BLACK);

                filterVH.tv2Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv2Star.setTextColor(Color.BLACK);

                filterVH.tv1Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv1Star.setTextColor(Color.BLACK);
            });

            filterVH.tv2Star.setOnClickListener(view -> {
                filterVH.tv2Star.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tv2Star.setTextColor(Color.WHITE);

                filterVH.loComment.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvComment.setTextColor(Color.BLACK);
                filterVH.tvCountComment.setTextColor(Color.BLACK);

                filterVH.loAll.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvAll.setTextColor(Color.BLACK);
                filterVH.tvCountAll.setTextColor(Color.BLACK);

                filterVH.loMedia.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvMedia.setTextColor(Color.BLACK);
                filterVH.tvCountMedia.setTextColor(Color.BLACK);

                filterVH.tv4Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv4Star.setTextColor(Color.BLACK);

                filterVH.tv3Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv3Star.setTextColor(Color.BLACK);

                filterVH.tv5Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv5Star.setTextColor(Color.BLACK);

                filterVH.tv1Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv1Star.setTextColor(Color.BLACK);
            });

            filterVH.tv1Star.setOnClickListener(view -> {
                filterVH.tv1Star.setBackgroundResource(R.drawable.filter_selected);
                filterVH.tv1Star.setTextColor(Color.WHITE);

                filterVH.loComment.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvComment.setTextColor(Color.BLACK);
                filterVH.tvCountComment.setTextColor(Color.BLACK);

                filterVH.loAll.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvAll.setTextColor(Color.BLACK);
                filterVH.tvCountAll.setTextColor(Color.BLACK);

                filterVH.loMedia.setBackgroundResource(R.drawable.item_filter);
                filterVH.tvMedia.setTextColor(Color.BLACK);
                filterVH.tvCountMedia.setTextColor(Color.BLACK);

                filterVH.tv4Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv4Star.setTextColor(Color.BLACK);

                filterVH.tv3Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv3Star.setTextColor(Color.BLACK);

                filterVH.tv2Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv2Star.setTextColor(Color.BLACK);

                filterVH.tv5Star.setBackgroundResource(R.drawable.item_filter);
                filterVH.tv5Star.setTextColor(Color.BLACK);
            });


            filterVH.ratingBar1.setRating(1f);
            filterVH.ratingBar2.setRating(2f);
            filterVH.ratingBar3.setRating(3f);
            filterVH.ratingBar4.setRating(4f);
            filterVH.ratingBar5.setRating(5f);

        }

    }

    @Override
    public int getItemCount() {
        return ratingList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? VIEW_TYPE_FILTER : VIEW_TYPE_RATING;
    }


}
