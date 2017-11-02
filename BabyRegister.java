
import java.text.*;
import java.util.*;
import service.Baby;
import service.Gift;

public class BabyRegister {
    public static void main(String[] args) throws ParseException {	
		ArrayList<Baby> babysSorted = new ArrayList();
		ArrayList<Baby> babysSortedByAge = new ArrayList();
        ArrayList<Baby> babys = new ArrayList();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        ArrayList<Baby> babysCpy = new ArrayList();
        babys.add(new Baby("10/02/2002","Paolo",'M'));
        babys.add(new Baby("28/10/2001","Zeno",'M'));
        Gift g1= new Gift();
        babys.get(0).gift.add(g1);		//give to Paolo an empty gift
        for(Baby b:babys){
            System.out.println(b);
        }
        while(true){
            Scanner keyboard = new Scanner(System.in);
            Date birthday = new Date();
            String name;
            Character gender; 
            System.out.println("What do you want to do? (type the number of choise)");
            System.out.println("1)Add new baby");
            System.out.println("2)List Babies by name");
            System.out.println("3)List Babies by age");
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
                        
						boolean validDate = false;
						while(!validDate){
							try{
								birthday = dateFormat.parse(keyboard.next());
								validDate = true;
							}catch(ParseException e){
								System.out.println("Invalid date, type it again");
								validDate = false;
							}
						}
                        System.out.println("Type the name ");
                        name=keyboard.next();
                        
                        
						while(true){
							System.out.println("Type the gender (M/F)");
							String input=keyboard.next();
							if(input.length()==1){
								if (input.equalsIgnoreCase("m") || input.equalsIgnoreCase("f")){
									

									gender= Character.toUpperCase(input.charAt(0));
									break;
								}
							}
						}
                        
                        
                        
                        babys.add(new Baby(birthday,name,gender));
                        break;
					//MIGLIORARE QUI
                    case 2:
                       
                        for(Baby b:babys)
                            babysCpy.add(b);	//copio la lista
                        int j=babysCpy.size();
                        Baby bb;
                        while (j>0){
                            bb=babysCpy.get(j-1);
                            for(Baby b:babysCpy){
                                if(bb.getName().compareToIgnoreCase(b.getName())>0) bb=b;
                            }
                        System.out.println(bb);
                        babysSorted.add(bb);
                        babysCpy.remove(bb);
                        j--;
                        
                        }
                        
                        break;
                    
                    case 3:
                        
                        for(Baby b:babys)
                            babysCpy.add(b);
                        
                        j=babys.size();
                        while (j>0){
                            bb=babysCpy.get(j-1);
                            for(Baby b:babysCpy){
                                if(!bb.isOlder(b)) bb=b;
                            }
                        System.out.println(bb);
                        babysSortedByAge.add(bb);
                        babysCpy.remove(bb);
                        j--;
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
								String yesOrNo = new String();
                                while (true){
									yesOrNo=keyboard.next();
									if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("no")) break;
									System.out.println("write just yes or no... ");
								}
								
                                if(yesOrNo.equalsIgnoreCase("yes")){
                                System.out.println("Insert your name :");
                                String donator=keyboard.next();
                                System.out.println("Insert a description for the gift :");
                                keyboard.nextLine();
                                String description=keyboard.nextLine();
                                System.out.println("Insert the date of the gift:");
								
								validDate = false;
								Date date = new Date();
								while(!validDate){
									try{
										date = dateFormat.parse(keyboard.next());
										validDate = true;
									}catch(ParseException e){
										System.out.println("Invalid date, type it again");
										validDate = false;
									}
								}
                                
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
