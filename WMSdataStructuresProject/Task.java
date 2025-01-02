package WMSdataStructuresProject;

import java.util.Date;

public class Task {
    private String title;
    private Date dueDate;
    private  boolean quality;


    public boolean isQuality() {
        return quality;
    }

    @Override
    public String toString() {
        String qual= quality?"met":"unmet";
        return   title +
                ", Due Date: " + dueDate.getDate() +" "+(dueDate.getMonth()+1)+" "+(dueDate.getYear()+1900)+
                ", Quality: " +qual;
    }

    public void setQuality(boolean quality) {
        this.quality = quality;
    }


    public Task(String title , Date dueDate){
        quality=true;
        this.title=title;
        dueDate.setYear(dueDate.getYear()-1900);
        this.dueDate=dueDate;
    }



    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        dueDate.setYear(dueDate.getYear()-1900);
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
