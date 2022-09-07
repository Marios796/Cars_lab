//icsd13091 : Κωνσταντίνου Μάριος

package exercise1;

import java.util.ArrayList;         
import java.util.Random;


public class Cars {
    
    private String make,model,color;  //δηλωσεις ιδιοτητων 
    private int hp,cc,price,id;
    
    public static  ArrayList<Integer>code = new ArrayList<Integer>();  //δηλωση λιστας τυπου integer για αποθηκευση των κωδικων 
    
//Default constructor
    public Cars()
    {
        make=null;
        model=null;
        color=null;
        hp=-1;
        cc=-1;
        price=-1;
        id=-1;        
    }
    
    //Constructor arxikopoiisis timwn
    public Cars(String make,String model,String color,int hp,int cc,int price)
    {
        this.make=make.toUpperCase();
        this.model=model.toUpperCase();
        this.color=color.toUpperCase();
        this.hp=hp;
        this.cc=cc;
        this.price=price;
               
    }
    
    public String getMake()  //get συναρτησεις για καθε ιδιοτητα
    {
        return make;
    }
    
    public String getModel()
    {
        return model;
    }
    
    public String getColor()
    {
        return color;
    }
    
    public int getHP()
    {
        return hp;
    }
    
    public int getCC()
    {
        return cc;
    }
    
    public int getPrice()
    {
        return price;
    }
    
    public int getCode()
    {
        return this.id;
    }
    
   
    
    public void setCode()
    {
        Random randnum=new Random();
        int nextNumber=randnum.nextInt(899) + 100;      //Generating random 
        while(code.contains(nextNumber)!=true)          //unique ID
        {
        code.add(nextNumber);
        this.id=nextNumber;   //προσθηκη του τυχαιου και μοναδικου κωιδκου στην καταλληλη ιδιοτητα του αυτοκινητου
        }
    
    }
    
    public void printCodeList()         //εμφανιση ολων των κωδικων
    {
        for (int i : code )
        {
            System.out.println(i);
        }
    }
    
   
    
    @Override    //Override συναρτηση για εκτυπωση ολων των στοιχειων του αυτοκινητου
    public String toString() {
        return("Make:"+this.getMake()+" Model:"+this.getModel()+" Color:"+this.getColor()+" HP:"+this.getHP()+" CC:"+this.getCC()+" Price:"+this.getPrice()+" ID:"+this.getCode());
                    
   }
    
}
