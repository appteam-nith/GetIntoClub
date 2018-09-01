package com.nsh.getintoclub;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<View> itemViewList = new ArrayList<>();
    String[] SubjectValues;
    Context context;
    View view1;
    ViewHolder viewHolder1;
    int numPosition;
    List<String> selected  = new ArrayList<>();
    public RecyclerViewAdapter(Context context1, String[] SubjectValues1) {

        SubjectValues = SubjectValues1;
        context = context1;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view1 = LayoutInflater.from(context).inflate(R.layout.recyclerview_items, parent, false);

        viewHolder1 = new ViewHolder(view1);
        itemViewList.add(view1);
        numPosition =  itemViewList.size() ;
        return viewHolder1;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final int[] numposi = new int[numPosition];
        for(int i=0;i<numPosition;i++) {
            numposi[i] = 0;
        }
        holder.textView.setText(SubjectValues[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch ( position) {
                    case 0:
                        setData(position,numposi);
                        break;
                    case 1:
                        setData(position,numposi);
                        break;
                    case 2:
                        setData(position,numposi);
                        break;

                    case 3:
                        setData(position,numposi);
                        break;

                    case 4:
                        setData(position,numposi);
                        break;

                    case 5:
                        setData(position,numposi);
                        break;

                    case 6:
                        setData(position,numposi);
                        break;

                    case 7:
                        setData(position,numposi);
                        break;

                    case 8:
                        setData(position,numposi);
                        break;

                }

            }
        });

    }
    public void setData(int position,int [] numposi)
    {
        numposi[position] += 1;
        if (numposi[position]%2==1) {
            add(position);
            itemViewList.get(position).setBackgroundResource(R.color.redLight);
        }
        else {
            delete(position);
            itemViewList.get(position).setBackgroundResource(R.color.white);
        }
    }
public void add(int p)
{
    int i;
    for ( i = 0;i<selected.size();i++)
    {
        if(selected.get(i) == SkillDetail.subjects[p])
        {
            break;
        }
    }
    if (i == selected.size())
        selected.add(SkillDetail.subjects[p]);
    SkillDetail.skillet.setText("");
    for(i=0;i<selected.size();i++)
    {
        if (selected.get(i) != "")
        SkillDetail.skillet.append(selected.get(i));
    }

}
public void delete(int p)
{
    int i;
    for ( i = 0;i<selected.size();i++)
    {
        if(selected.get(i) == SkillDetail.subjects[p])
        {
            break;
        }
    }
    if (i != selected.size())
        selected.set(i,"");
    SkillDetail.skillet.setText("");
    for(i=0;i<selected.size();i++)
    {
        if (selected.get(i) != "")
            SkillDetail.skillet.append(selected.get(i));
    }


}
    @Override
    public int getItemCount() {

        return SubjectValues.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View v) {

            super(v);

            textView = (TextView) v.findViewById(R.id.subject_textview);
        }
    }
}
