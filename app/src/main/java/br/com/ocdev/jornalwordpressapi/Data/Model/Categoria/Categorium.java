
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria;

import java.util.List;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Categorium extends BaseObservable implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("taxonomy")
    @Expose
    private String taxonomy;
    @SerializedName("parent")
    @Expose
    private Integer parent;
    @SerializedName("meta")
    @Expose
    private List<Object> meta = null;
    @SerializedName("_links")
    @Expose
    private Links links;
    public final static Parcelable.Creator<Categorium> CREATOR = new Creator<Categorium>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Categorium createFromParcel(Parcel in) {
            return new Categorium(in);
        }

        public Categorium[] newArray(int size) {
            return (new Categorium[size]);
        }

    }
    ;

    protected Categorium(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.slug = ((String) in.readValue((String.class.getClassLoader())));
        this.taxonomy = ((String) in.readValue((String.class.getClassLoader())));
        this.parent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.meta, (java.lang.Object.class.getClassLoader()));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
    }

    public Categorium() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        notifyPropertyChanged(BR.news);

    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
        notifyPropertyChanged(BR.news);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.news);
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
        notifyPropertyChanged(BR.news);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.news);
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
        notifyPropertyChanged(BR.news);
    }

    public String getTaxonomy() {
        return taxonomy;
    }

    public void setTaxonomy(String taxonomy) {
        this.taxonomy = taxonomy;
        notifyPropertyChanged(BR.news);
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
        notifyPropertyChanged(BR.news);
    }

    public List<Object> getMeta() {
        return meta;
    }

    public void setMeta(List<Object> meta) {
        this.meta = meta;
        notifyPropertyChanged(BR.news);
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
        notifyPropertyChanged(BR.news);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(count);
        dest.writeValue(description);
        dest.writeValue(link);
        dest.writeValue(name);
        dest.writeValue(slug);
        dest.writeValue(taxonomy);
        dest.writeValue(parent);
        dest.writeList(meta);
        dest.writeValue(links);
    }

    public int describeContents() {
        return  0;
    }

}
