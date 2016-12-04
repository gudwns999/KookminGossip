package com.gudwns999.kookmingossip.Gossip;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.gudwns999.kookmingossip.R;

/**
 * Created by Kim on 2016-12-02.
 */

public class Gossip extends Activity {
    private ListView aListView = null;
    private ListViewAdapter aAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gossip);

        aListView = (ListView)findViewById(R.id.gossipList);
        aAdapter = new ListViewAdapter(this);
        aListView.setAdapter(aAdapter);
        //sample
        aAdapter.addItem(getResources().getDrawable(R.drawable.gossip), "잘생긴형준", "글씨가 써지네요 우후후", "2015-07-20", "man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.gossip), "잘생긴형준", "글씨가 써지네요 우후후", "2015-07-20", "man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.gossip), "잘생긴형준", "글씨가 써지네요 우후후", "2015-07-20", "man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.gossip), "잘생긴형준", "글씨가 써지네요 우후후", "2015-07-20", "man");
        aAdapter.addItem(getResources().getDrawable(R.drawable.gossip), "잘생긴형준", "글씨가 써지네요 우후후", "2015-07-20", "man");
        //List내용이 클릭되면 이벤트 -> 댓글확인
        aListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                ListData mData = aAdapter.mListData.get(position);
            }
        });
    }
}
