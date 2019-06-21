package br.com.ocdev.jornalwordpressapi.Utils;

import android.databinding.BindingAdapter;
import android.os.Build;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.ocdev.jornalwordpressapi.R;


public class UiUtils {
    @BindingAdapter("android:src")
    public static void LoadImageUrl(ImageView view, String url) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.communication);
        requestOptions.error(android.R.drawable.stat_notify_error);
        requestOptions.fallback(R.drawable.communication);

        Glide.with(view.getContext()).
                load(url).
                apply(requestOptions).
                into(view);
    }

    @BindingAdapter("android:background")
    public static void LoadImageUrlBackground(ImageView view, String url) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.communication);
        requestOptions.error(android.R.drawable.stat_notify_error);
        requestOptions.fallback(R.drawable.communication);

        Glide.with(view.getContext()).
                load(url).
                apply(requestOptions).
                into(view);
    }

    @BindingAdapter("convertdatatimeUTC")
    public static void ConvertDateUTC(TextView txtView, String datePublished) {

        try {
            SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss+00:00");

            Date dt = sd1.parse(datePublished);
            SimpleDateFormat sd2 = new SimpleDateFormat("dd-MM-yyyy");
            String newDate = sd2.format(dt);
            txtView.setText(newDate);


        } catch (ParseException e) {
            e.printStackTrace();
            txtView.setText("Erro");
        }
    }

    @BindingAdapter("criaListadeCategorias")
    public static void ListadeCategorias(TextView txtView, List<String> lista) {

        for (String categoria : lista) {
            txtView.append(categoria + ",");
        }


    }

    @BindingAdapter("setHtmltoText")
    public static void ListadeCategorias(org.sufficientlysecure.htmltextview.HtmlTextView textView, String content) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setHtml(content,
                    new HtmlHttpImageGetter(textView));
            // textView.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
            textView.setMovementMethod(LinkMovementMethod.getInstance());

        } else {
            textView.setHtml(content,
                    new HtmlHttpImageGetter(textView));
            textView.setMovementMethod(LinkMovementMethod.getInstance());

        }
    }


}


