
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PredecessorVersion implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<PredecessorVersion> CREATOR = new Creator<PredecessorVersion>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PredecessorVersion createFromParcel(Parcel in) {
            return new PredecessorVersion(in);
        }

        public PredecessorVersion[] newArray(int size) {
            return (new PredecessorVersion[size]);
        }

    }
    ;

    protected PredecessorVersion(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PredecessorVersion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
