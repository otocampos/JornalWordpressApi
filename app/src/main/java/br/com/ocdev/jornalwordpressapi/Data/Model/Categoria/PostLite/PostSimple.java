
package br.com.ocdev.jornalwordpressapi.Data.Model.Categoria.PostLite;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostSimple implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("date_modified")
    @Expose
    private String dateModified;
    @SerializedName("excerpt")
    @Expose
    private String excerpt;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("author_id")
    @Expose
    private Integer authorId;
    @SerializedName("author_nicename")
    @Expose
    private String authorNicename;
    @SerializedName("category_ids")
    @Expose
    private List<Integer> categoryIds = null;
    @SerializedName("category_names")
    @Expose
    private List<String> categoryNames = null;
    @SerializedName("tag_ids")
    @Expose
    private List<Object> tagIds = null;
    @SerializedName("tag_names")
    @Expose
    private List<Object> tagNames = null;
    @SerializedName("acf")
    @Expose
    private Boolean acf;
    @SerializedName("yoast")
    @Expose
    private Boolean yoast;
    @SerializedName("media")
    @Expose
    private Media media;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorNicename() {
        return authorNicename;
    }

    public void setAuthorNicename(String authorNicename) {
        this.authorNicename = authorNicename;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<String> getCategoryNames() {
        return categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames) {
        this.categoryNames = categoryNames;
    }

    public List<Object> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Object> tagIds) {
        this.tagIds = tagIds;
    }

    public List<Object> getTagNames() {
        return tagNames;
    }

    public void setTagNames(List<Object> tagNames) {
        this.tagNames = tagNames;
    }

    public Boolean getAcf() {
        return acf;
    }

    public void setAcf(Boolean acf) {
        this.acf = acf;
    }

    public Boolean getYoast() {
        return yoast;
    }

    public void setYoast(Boolean yoast) {
        this.yoast = yoast;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.title);
        dest.writeString(this.slug);
        dest.writeString(this.permalink);
        dest.writeString(this.date);
        dest.writeString(this.dateModified);
        dest.writeString(this.excerpt);
        dest.writeString(this.content);
        dest.writeString(this.author);
        dest.writeValue(this.authorId);
        dest.writeString(this.authorNicename);
        dest.writeList(this.categoryIds);
        dest.writeStringList(this.categoryNames);
        dest.writeList(this.tagIds);
        dest.writeList(this.tagNames);
        dest.writeValue(this.acf);
        dest.writeValue(this.yoast);
        dest.writeParcelable(this.media, flags);
    }

    public PostSimple() {
    }

    protected PostSimple(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.title = in.readString();
        this.slug = in.readString();
        this.permalink = in.readString();
        this.date = in.readString();
        this.dateModified = in.readString();
        this.excerpt = in.readString();
        this.content = in.readString();
        this.author = in.readString();
        this.authorId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.authorNicename = in.readString();
        this.categoryIds = new ArrayList<Integer>();
        in.readList(this.categoryIds, Integer.class.getClassLoader());
        this.categoryNames = in.createStringArrayList();
        this.tagIds = new ArrayList<Object>();
        in.readList(this.tagIds, Object.class.getClassLoader());
        this.tagNames = new ArrayList<Object>();
        in.readList(this.tagNames, Object.class.getClassLoader());
        this.acf = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.yoast = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.media = in.readParcelable(Media.class.getClassLoader());
    }

    public static final Creator<PostSimple> CREATOR = new Creator<PostSimple>() {
        @Override
        public PostSimple createFromParcel(Parcel source) {
            return new PostSimple(source);
        }

        @Override
        public PostSimple[] newArray(int size) {
            return new PostSimple[size];
        }
    };
}
