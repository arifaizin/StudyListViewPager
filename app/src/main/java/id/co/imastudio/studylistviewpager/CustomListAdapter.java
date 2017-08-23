package id.co.imastudio.studylistviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by idn on 8/2/2017.
 */

public class CustomListAdapter extends ArrayAdapter {

    private final Context context;
    private final String[] namaBuah;
    private final int[] gambarBuah;

    public CustomListAdapter(Context context, String[] namaBuah, int[] gambarBuah) {
        super(context, R.layout.item_list, namaBuah);
        this.context = context;
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
    }

    //klik kanan > generate /Alt+insert

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_list, null, true);

        TextView teksNamaBuah = (TextView) itemView.findViewById(R.id.tvNamabuah);
        ImageView imageBuah = (ImageView) itemView.findViewById(R.id.ivBuah);

        //set data
        teksNamaBuah.setText(namaBuah[position]);
        imageBuah.setImageResource(gambarBuah[position]);

        return itemView;
    }
}
