package com.zyx1011.emojidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.scroll_view)
    ListView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mScrollView.setAdapter(new ListViewAdapter());
    }

    private class ListViewAdapter extends BaseAdapter {

        private String[] emojis = getResources().getStringArray(R.array.emoji_name);

        @Override
        public int getCount() {
            return emojis.length;
        }

        @Override
        public Object getItem(int position) {
            return emojis[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, android.view.View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.list_view_item, null);
                viewHolder.tvEmojiName = (TextView) convertView.findViewById(R.id.emoji_name);
                viewHolder.tvEmojiImage = (TextView) convertView.findViewById(R.id.emoji_image);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.tvEmojiName.setText(emojis[position]);
            EmojiUtil.setTextWithEmoji(viewHolder.tvEmojiImage, emojis[position], 50);

            return convertView;
        }
    }

    private class ViewHolder {
        TextView tvEmojiName;
        TextView tvEmojiImage;
    }
}
