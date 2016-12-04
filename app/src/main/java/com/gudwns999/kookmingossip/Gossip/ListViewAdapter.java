package com.gudwns999.kookmingossip.Gossip;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gudwns999.kookmingossip.R;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Kim on 2016-12-02.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context mContext = null;
    public ArrayList<ListData> mListData = new ArrayList<ListData>();
    public ListViewAdapter(Context mContext) {
        super();
        this.mContext = mContext;
    }
    @Override
    public int getCount() {
        return mListData.size();
    }

    @Override
    public Object getItem(int position) {
        return mListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(Drawable icon, String nick, String mTitle, String mDate, String gender) {
        ListData addInfo = null;
        addInfo = new ListData();
        addInfo.mIcon = icon;
        addInfo.nick = nick;
        addInfo.mTitle = mTitle;
        addInfo.gender = gender;

        mListData.add(addInfo);
    }

    public void remove(int position) {
        mListData.remove(position);
        dataChange();
    }

    public void sort() {
        Collections.sort(mListData, ListData.ALPHA_COMPARATOR);
        dataChange();
    }

    public void dataChange() {
        this.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.gossip_list, null);

            holder.mIcon = (ImageView) convertView.findViewById(R.id.alertTitle);
            holder.mText = (TextView) convertView.findViewById(R.id.ss);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListData mData = mListData.get(position);

        if (mData.mIcon != null) {
            holder.mIcon.setVisibility(View.VISIBLE);
            holder.mIcon.setImageDrawable(mData.mIcon);
        } else {
            holder.mIcon.setVisibility(View.GONE);
        }

        holder.mText.setText(mData.mTitle);
        holder.nick.setText(mData.nick);
        holder.gender.setText(mData.gender);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Reply.class);
                mContext.startActivity(intent);
            }
        });
        return convertView;

    }
}

