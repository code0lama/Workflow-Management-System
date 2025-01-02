package WMSdataStructuresProject;

import java.awt.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class FormattedTime {
    private Date CurrentDay;
    private final int[] monthsWith30Days = {3, 5, 8, 10};
    private final int[] monthsWith31Days = {0, 2, 4, 6, 7, 9, 11};
    public FormattedTime(){
        CurrentDay= new Date(124,0,1);
    }

    public Date getCurrentDay() {
        return CurrentDay;
    }

    void ProgressADay(){
        int Year = CurrentDay.getYear();
        int Month = CurrentDay.getMonth();
        int Day = CurrentDay.getDate();
        Day++;
        boolean UpdateMonth=false;
        for(int i=0;i<monthsWith31Days.length;i++){
            if(Day>31&&monthsWith31Days[i]==Month){
                UpdateMonth=true;
            }
        }
        for(int i=0;i<monthsWith30Days.length;i++){
            if(Day>30&&monthsWith30Days[i]==Month){
                UpdateMonth=true;
            }
        }
        if(Day>28&&Month==1){
            UpdateMonth=true;
        }
        if(UpdateMonth){
            Day=1;
            Month++;
        }
        if(Month>11){
            Month=0;
            Year++;
        }
        CurrentDay= new Date(Year,Month,Day);
    }

}
