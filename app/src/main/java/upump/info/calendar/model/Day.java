package upump.info.calendar.model;

import java.util.Date;

public class Day {
    private int id;
    private int idCelebration;
    private Date date;
    private Date oldDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCelebration() {
        return idCelebration;
    }

    public void setIdCelebration(int idCelebration) {
        this.idCelebration = idCelebration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getOldDate() {
        return oldDate;
    }

    public void setOldDate(Date oldDate) {
        this.oldDate = oldDate;
    }
}
