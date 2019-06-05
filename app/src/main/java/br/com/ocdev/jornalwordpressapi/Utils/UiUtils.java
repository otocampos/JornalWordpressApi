package br.com.ocdev.jornalwordpressapi.Utils;

import android.databinding.BindingAdapter;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.ocdev.jornalwordpressapi.R;


public class UiUtils {
    @BindingAdapter("wpImage")
    public static void LoadImageUrl(ImageView view, List<String> url) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.communication);
        requestOptions.error(android.R.drawable.stat_notify_error);
        requestOptions.fallback(R.drawable.communication);

        Glide.with(view.getContext()).
                load((Html.fromHtml(url.get(0)))).
                apply(requestOptions).
                into(view);
    }

    @BindingAdapter("convertdatatimeUTC")
    public static void ConvertDateUTC(TextView txtView, String datePublished) {

        try {
            SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

            Date dt = sd1.parse(datePublished);
            SimpleDateFormat sd2 = new SimpleDateFormat("dd-MM-yyyy");
            String newDate = sd2.format(dt);
            txtView.setText(newDate);

        } catch (ParseException e) {
            e.printStackTrace();
            txtView.setText("Erro");
        }
    }


}


