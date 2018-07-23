package upump.info.calendar.model;

public class Holy {
    private int id;
    private String name;
    private String img;
    private String description;
    private  int idDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdDay() {
        return idDay;
    }

    public void setIdDay(int idDay) {
        this.idDay = idDay;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
