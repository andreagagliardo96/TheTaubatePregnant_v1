package service;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Gift {
    SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
    private final String donator;
    private final String description;
    private final Date date;

    public Gift(String donator, String description, Date date) {
        this.donator = donator;
        this.description = description;
        this.date = date;
    }
    public Gift(){
    this.donator="unkown";
    this.description="";
    this.date=new Date(); //time today
    }
    public Gift(String donator, String description){
    this.donator=donator;
    this.description=description;
    this.date=new Date(); //time today
    }

    @Override
    public String toString() {
        return "Donator: " + donator + ", description: " + description + ", date:" + date ;
    }
    
}
