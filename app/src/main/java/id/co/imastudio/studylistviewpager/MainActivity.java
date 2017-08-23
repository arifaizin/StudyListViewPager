package id.co.imastudio.studylistviewpager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView list;
    ViewPager pager;

    String[] namaBuah = {
            "Alpukat",
            "Apel",
            "Ceri",
            "Durian",
            "Jambu air",
            "Manggis",
            "Strawberri"
    };

    int[] gambarBuah = {
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry
    };

    //ctrl + R
    int[] suaraBuah = {
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
            R.raw.jambuair,
            R.raw.manggis,
            R.raw.strawberry
    };

    int[] gambarPager = {
            R.drawable.wallpaper1,
            R.drawable.wallpaper2,
            R.drawable.wallpaper3,
            R.drawable.wallpaper4,
            R.drawable.wallpaper5
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, namaBuah);

        CustomListAdapter adapter = new CustomListAdapter(MainActivity.this, namaBuah, gambarBuah);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Posisi "+position, Toast.LENGTH_SHORT).show();
                MediaPlayer player = MediaPlayer.create(MainActivity.this, suaraBuah[position]);
                player.start();
            }
        });

        pager = (ViewPager) findViewById(R.id.viewPager);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(MainActivity.this, gambarPager, suaraBuah);
        pager.setAdapter(pagerAdapter);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                MediaPlayer player = MediaPlayer.create(MainActivity.this, suaraBuah[position]);
                player.start();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
