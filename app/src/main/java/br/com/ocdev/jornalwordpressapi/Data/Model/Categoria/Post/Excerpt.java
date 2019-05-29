
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Excerpt implements Parcelable
{

    @SerializedName("rendered")
    @Expose
    private String rendered;
    @SerializedName("protected")
    @Expose
    private Boolean _protected;
    public final static Parcelable.Creator<Excerpt> CREATOR = new Creator<Excerpt>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Excerpt createFromParcel(Parcel in) {
            return new Excerpt(in);
        }

        public Excerpt[] newArray(int size) {
            return (new Excerpt[size]);
        }

    }
    ;

    protected Excerpt(Parcel in) {
        this.rendered = ((String) in.readValue((String.class.getClassLoader())));
        this._protected = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Excerpt() {
    }

    public String getRendered() {
        return rendered;
    }

    public void setRendered(String rendered) {
        this.rendered = rendered;
    }

    public Boolean getProtected() {
        return _protected;
    }

    public void setProtected(Boolean _protected) {
        this._protected = _protected;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rendered);
        dest.writeValue(_protected);
    }

    public int describeContents() {
        return  0;
    }

}
