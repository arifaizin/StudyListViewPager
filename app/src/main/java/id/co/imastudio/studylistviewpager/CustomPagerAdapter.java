package id.co.imastudio.studylistviewpager;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by idn on 8/3/2017.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private final Context context;
    private final int[] gambarPager;
    private final int[] suaraBuah;

    public CustomPagerAdapter(Context context, int[] gambarPager, int[] suaraBuah) {
        this.context = context;
        this.gambarPager = gambarPager;
        this.suaraBuah = suaraBuah;
    }

    @Override
    public int getCount() {
        return gambarPager.length;
        //jumlah list
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (LinearLayout) object;
        //layout di item
    }

    // generate override method

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_pager, null, true);

        ImageView imagepager = (ImageView) itemView.findViewById(R.id.ivGambarPager);

        //set data
        imagepager.setImageResource(gambarPager[position]);
        imagepager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer player = MediaPlayer.create(context, suaraBuah[position]);
                player.start();
            }
        });

        //tambahan
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
