package upump.info.calendar.model;

public class Blessing {
    private int id;
    private String title;
    private TypeBlessing typeBlessing;
    private  int idDay;
    private int idCelebration;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeBlessing getTypeBlessing() {
        return typeBlessing;
    }

    public void setTypeBlessing(TypeBlessing typeBlessing) {
        this.typeBlessing = typeBlessing;
    }

    public int getIdDay() {
        return idDay;
    }

    public void setIdDay(int idDay) {
        this.idDay = idDay;
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
}
