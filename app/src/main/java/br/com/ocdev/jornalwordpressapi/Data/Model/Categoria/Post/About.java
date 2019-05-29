
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class About implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<About> CREATOR = new Creator<About>() {


        @SuppressWarnings({
            "unchecked"
        })
        public About createFromParcel(Parcel in) {
            return new About(in);
        }

        public About[] newArray(int size) {
            return (new About[size]);
        }

    }
    ;

    protected About(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public About() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
