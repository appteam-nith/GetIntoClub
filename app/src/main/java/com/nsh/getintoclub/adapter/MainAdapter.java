package com.nsh.getintoclub.adapter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nsh.getintoclub.activity.ContactDetail;
import com.nsh.getintoclub.activity.QuestionDetail;
import com.nsh.getintoclub.R;
import com.nsh.getintoclub.activity.SkillDetail;
import com.nsh.getintoclub.model.Quote;

import java.util.List;

/**
 * Created by ThisIsNSH on 9/1/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    ActivityOptions options;
    Intent intent;
    List<Quote> quoteList;
    Activity context;

    public MainAdapter(List<Quote> quoteList, Activity context) {
        this.context = context;
        this.quoteList = quoteList;
    }

    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.adapter_main, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MainAdapter.MyViewHolder holder, final int position) {
        Quote quote = quoteList.get(position);
        holder.detail.setText(quote.getDetail());
        holder.title.setText(quote.getTitle());
        holder.textView.setText(quote.getQuote());
        holder.relativeLayout.setBackground(quote.getDrawable());

        holder.textView.setAlpha(0f);
        holder.imageView.setAlpha(0f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(holder.imageView, "alpha", 0, 1);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(holder.imageView, "translationY", 50, 0);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(holder.textView, "alpha", 0, 1);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(holder.textView, "translationY", 50, 0);
        objectAnimator.setDuration(1000);
        objectAnimator.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator1.setDuration(1000);
        objectAnimator1.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator2.setDuration(1000);
        objectAnimator2.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator3.setDuration(1000);
        objectAnimator3.setInterpolator(new AnticipateOvershootInterpolator());
        objectAnimator.setStartDelay(100);
        objectAnimator1.setStartDelay(100);
        objectAnimator2.setStartDelay(300);
        objectAnimator3.setStartDelay(300);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimator, objectAnimator1, objectAnimator2, objectAnimator3);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                holder.textView.setAlpha(1f);
                holder.imageView.setAlpha(1f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        switch (position) {
            case 0:
                holder.imageView.setImageDrawable(context.getDrawable(R.drawable.question_smurf));
                break;
            case 1:
                holder.imageView.setImageDrawable(context.getDrawable(R.drawable.skill_smurf));
                break;
            case 2:
                holder.imageView.setImageDrawable(context.getDrawable(R.drawable.contact_smurf));
                break;
        }

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        options = ActivityOptions.makeSceneTransitionAnimation(
                                context,
                                Pair.create((View) holder.backCard, "backAnim"),
                                Pair.create((View) holder.frontCard, "frontAnim"));
                        intent = new Intent(context, QuestionDetail.class);
                        context.startActivity(intent
                                .putExtra("shared_element_transition_name", v.getTransitionName()), options.toBundle());
                        break;
                    case 1:
                        options = ActivityOptions.makeSceneTransitionAnimation(
                                context,
                                Pair.create((View) holder.backCard, "backAnim"),
                                Pair.create((View) holder.frontCard, "frontAnim"));
                        intent = new Intent(context, SkillDetail.class);
                        context.startActivity(intent
                                .putExtra("shared_element_transition_name", v.getTransitionName()), options.toBundle());
                        break;
                    case 2:
                        options = ActivityOptions.makeSceneTransitionAnimation(
                                context,
                                Pair.create((View) holder.backCard, "backAnim"),
                                Pair.create((View) holder.frontCard, "frontAnim"));
                        intent = new Intent(context, ContactDetail.class);
                        context.startActivity(intent
                                .putExtra("shared_element_transition_name", v.getTransitionName()), options.toBundle());
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView, title, detail;
        RelativeLayout relativeLayout;
        ImageView imageView;
        CardView backCard, frontCard;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            frontCard = itemView.findViewById(R.id.frontCard);
            backCard = itemView.findViewById(R.id.backCard);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            detail = itemView.findViewById(R.id.detail);
            title = itemView.findViewById(R.id.title);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
