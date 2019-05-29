
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.Post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WpTerm implements Parcelable
{

    @SerializedName("taxonomy")
    @Expose
    private String taxonomy;
    @SerializedName("embeddable")
    @Expose
    private Boolean embeddable;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<WpTerm> CREATOR = new Creator<WpTerm>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WpTerm createFromParcel(Parcel in) {
            return new WpTerm(in);
        }

        public WpTerm[] newArray(int size) {
            return (new WpTerm[size]);
        }

    }
    ;

    protected WpTerm(Parcel in) {
        this.taxonomy = ((String) in.readValue((String.class.getClassLoader())));
        this.embeddable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public WpTerm() {
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
    }

    public Boolean getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(Boolean embeddable) {
        this.embeddable = embeddable;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(taxonomy);
        dest.writeValue(embeddable);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}
