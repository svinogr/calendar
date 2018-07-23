package upump.info.calendar.model;

public class Food {
    private int id;
    private TypeFood typeFood;
    private String title;
    private String description;
    private  int idCelebration;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeFood getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(TypeFood typeFood) {
        this.typeFood = typeFood;
    }


    public int getIdCelebration() {
        return idCelebration;
    }

    public void setIdCelebration(int idCelebration) {
        this.idCelebration = idCelebration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
