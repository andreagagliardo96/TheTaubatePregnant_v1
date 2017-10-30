
import java.text.*;
import java.util.*;
import service.Baby;
import service.Gift;

public class BabyRegister {
    public static void main(String[] args) throws ParseException {
        ArrayList<Baby> babys=new ArrayList();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Baby> babysCpy=new ArrayList();
        babys.add(new Baby("10/02/2002","Paolo",'m'));
        babys.add(new Baby("28/10/2001","ZZ",'m'));
        Gift e= new Gift();
        babys.get(0).gift.add(e);
        for(Baby b:babys){
            System.out.println(b);
        }
        while(true){
            Scanner keyboard = new Scanner(System.in);
            String birthday;
            String name;
            Character gender; 
            System.out.println("What do you want to do? (type the number of choise)");
            System.out.println("1)Add new baby");
            System.out.println("2)List Babies by age");
            System.out.println("3)List Babies by name");
            System.out.println("4)Add gift");
            System.out.println("5)List gift ");
            System.out.println("0)Exit ");
            int choise = keyboard.nextInt();
            if(choise==0) break;
            else if(choise<0 || choise >5) System.out.println("Error, chose writing a number between 0 and 5");
            else{
                switch(choise){
                    case 1:
                        System.out.println("Type the birthday like that '01/01/2001' ");
                        birthday=keyboard.next();
                        System.out.println("Type the name ");
                        name=keyboard.next();
                        
                        System.out.println("Type the gender (m/f)");            
                        gender= keyboard.next().charAt(0);
                        
                        
                        babys.add(new Baby(birthday,name,gender));
                        break;
                    case 2:
                        ArrayList<Baby> babysSorted=new ArrayList();
                       
                        for(Baby b:babys)
                            babysCpy.add(b);
                        int i=0;
                        int j=babysCpy.size();
                        Baby bb;
                        while (i!=j){
                            bb=babysCpy.get(0);
                            for(Baby b:babysCpy){
                                if(bb.getName().compareTo(b.getName())>0) bb=b;
                            }
                        System.out.println(bb);
                        babysSorted.add(bb);
                        babysCpy.remove(bb);
                        i++;
                        
                        }
                        
                        break;
                    
                    case 3:
                        ArrayList<Baby> babysSortedByAge=new ArrayList();
                        for(Baby b:babys)
                            babysCpy.add(b);
                        i=0;
                        j=babys.size();
                        while (i!=j){
                            bb=babysCpy.get(0);
                            for(Baby b:babysCpy){
                                if(!bb.isOlder(b)) bb=b;
                            }
                        System.out.println(bb);
                        babysSortedByAge.add(bb);
                        babysCpy.remove(bb);
                        i++;
                        }
                        break;
                    case 4:
                        System.out.println("Do you want to gift this present to which baby?");
                        System.out.println("Insert name:");
                        String nameOfBaby=keyboard.next();
                        System.out.println("Type the birthday like that '01/01/2001' ");
                        String d1=keyboard.next();
                        Date birthdayOfBaby=dateFormat.parse(d1);
                        for(Baby b: babys){
                            if (b.getName().equals(nameOfBaby) && birthdayOfBaby.equals(b.getBirthday())){
                                Gift g;
                                System.out.println("Do you want to describe your gift? (yes/no)...");
                                String yesOrNo=keyboard.next();
                                if(yesOrNo.equals("yes")){
                                System.out.println("Insert your name :");
                                String donator=keyboard.next();
                                System.out.println("Insert a description for the gift :");
                                keyboard.nextLine();
                                String description=keyboard.nextLine();
                                System.out.println("Insert the date of the gift:");
                                String d=keyboard.next();
                                Date date=dateFormat.parse(d);
                                g = new Gift(donator, description, date);
                                }
                                else 
                                    g = new Gift(); 
                                b.gift.add(g);
                            }
                            
                        }
                        break;
                    case 5:
                        System.out.println("choise:5");
                        System.out.println("Insert name:");
                        nameOfBaby=keyboard.next();
                        System.out.println("Type the birthday like that '01/01/2001' ");
                        d1=keyboard.next();
                        birthdayOfBaby=dateFormat.parse(d1);
                        System.out.println(birthdayOfBaby);
                        for(Baby b: babys){
                            if (b.getName().equals(nameOfBaby) && birthdayOfBaby.equals(b.getBirthday())){
                                for(Gift g:b.gift) System.out.print(g + "\n");
                            }
                        }
                        break;
                        }
                }
            
            }
        }
    }
