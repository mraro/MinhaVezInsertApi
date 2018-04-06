package domain.aro.minhavezinsertapi.Model;

/**
 * Created by alessandro.roliveir4 on 04/04/2018.
 */

public class Narutinho {
    private String name;
    private String thumbnail;
    private String image_url;
    private String description;


    public Narutinho() {

    }

    public Narutinho(String name, String thumbnail, String image_url, String description) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.image_url = image_url;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getimage_url() {
        return image_url;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setImage(String image_url) {
        this.image_url = image_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
