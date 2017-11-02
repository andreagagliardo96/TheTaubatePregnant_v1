package service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Baby {
    //date or bithday format: yyyy/mm/dd
    SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
    public ArrayList<Gift> gift = new ArrayList();
    private String name;
    private Date birthday;
    private char gender;
    public Date today=new Date(); //today's date
    
    public Baby(){
        //this.gift = new ArrayList();
        this.name=null;
        this.birthday=null;
        this.gender='\0';
    }
    public Baby(String birthday, String name, char gender) throws ParseException {
        //this.gift = new ArrayList();
        this.name = name;
        this.gender = gender;
        this.birthday = dateFormat.parse(birthday);
    }
    
    public Baby(Date birthday, String name, char gender){
        //this.gift = new ArrayList();
        this.name=name;
        this.birthday=birthday;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public boolean isOlder(Baby baby){
        if(this.getBirthday().before(baby.birthday))return true;
        return false;
    }
    
    public int howOld(){
        long longDifference=today.getTime()-this.birthday.getTime();
        int intDifference=(int)longDifference;
        return intDifference;
        
    }
    
    
    
    public boolean equals(Baby baby){
        if(!this.name.equals(baby.getName())) return false;
        else if(this.birthday!=baby.getBirthday()) return false;
        else if(this.gender!=baby.getGender()) return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "Name:" + name + ", birthday=" + birthday + ", gender=" + gender;
    }
    
}
