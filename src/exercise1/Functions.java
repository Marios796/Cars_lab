//icsd13091 : Κωνσταντίνου Μάριος

package exercise1;
import static exercise1.Cars.code;    //δηλωσεις import
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;



public class Functions {
    
    private ArrayList<Cars>lista = new ArrayList<>();   //δηλωση λιστας τυπου αντικειμενου Cars για εισαγωγη των αυτοκινητων
    public static  ArrayList<String>all_makes = new ArrayList<String>();    //δηλωση λιστας τυπου String για αποθηκευση των μαρκων χωρις διπλοτυπα
    
    
    Scanner input=new Scanner(System.in);
    
    
    public void addCar(Cars c)  //μεθοδος για προσθηκη του αντικειμενου στην λιστα  
    {
        c.setCode();
        lista.add(c);
    }

    public void printList()   //μεθοδος για εμφανιση των αυτοκινητων
    {
        for (Cars i : lista)
        {
            System.out.println(i);
        }
        
    }
    
    
    public void removeCar()   //μεθοδος για διαγραφη αυτοκινητου
    {
        Cars c=new Cars();
        System.out.println("-----Deleting a car-----");
        System.out.println("The car IDs are the following : ");
        c.printCodeList();   //εμφανιση κωδικων για να επιλεξει ο χρηστης
        System.out.println("Please enter the car ID you wish to delete . ");
        int answer=input.nextInt();  //εισαγωγη του κωδικου για το αυτοκινητο που θελει να διαγραψει
 
        if (code.contains(answer))   //αν υπαρχει αυτος ο κωδικος 
        {
            int index=code.indexOf(answer);  //
            lista.remove(index);  //διαγραφη του αντικειμενου
            code.remove(index);   //διαγραφη του κωδικου
        }
        else
        {
            System.out.println("Wrong input .");  //αν εδωσε λαθος κωδικο , εμφανιση καταλληλου μηνυματος 
        }
       
        System.out.println("The cars after the delete process are the following :");
        for (Cars i : lista)
        {
            System.out.println(i);   //εμφανιση των αυτοκινητων μετα τη διαγραφη
        }
       
    }
    
    public void searchCar()  //μεθοδος για αναζητηση αυτοκινητου με βαση τον κωδικο
    {
        
        Cars c = new Cars();
        System.out.println("-----Searching a car-----");
        System.out.println("The car IDs are the following : ");  //εμφανιση των κωδικων για να επιλεξει ο χρηστης
        c.printCodeList();
        System.out.println("Please enter the car ID you wish to search : ");
        int answer=input.nextInt();
        if (code.contains(answer))  //αν υπαρχει ο κωδικος που εδωσε
        {
            int index=code.indexOf(answer);
            System.out.println(lista.get(index));   //εμφανιση του αυτοκινητου με τον κωδικο που εδωσε
        }
        else
        {
            System.out.println("Wrong input .");  //αν εδωσε λαθος κωδικο , εμφανιση καταλληλου μηνυματος 
        }
        
        
    }
    
    public void noDuplicates(Cars c)   //μεθοδος για ευρεση μαρκων χωρις διπλοτυπα
    
    {
        all_makes.add(c.getMake());  //βαζω ολες τις μαρκες στη λιστα all_makes
        HashSet hs = new HashSet();  //χρησιμοποιω HashSet , καθως δεν επιτρεπει διπλοτυπα
        hs.addAll(all_makes);       //βαζω ο,τι εχει η all_makes στην hs , αλλα η hs κραταει μονο τις διαφορετικες μαρκες 
        all_makes.clear();          //"καθαριζω" την all_makes
        all_makes.addAll(hs);       //και περναω τα παντα απο την hs στην all_makes . τελικα η all_makes θα εχει τις μαρκες χωρις διπλοτυπα
    }
    
    
    public void searchHP()  //μεθοδος για εμφανιση αυτοκινητου με τα μεγιστα και τα ελαχιστα αλογα
    {
        System.out.println("-----Printing highest and lowest HP car-----");
        Cars c_max = new Cars();
        Cars c_min = new Cars();
        int maxHP=0,minHP=1500; //αρχικοποιηση μεταβλητων για να μπει παντα στην 1η if 
        int indexMax = -1,indexMin=-1;
        for ( int i=0;i<lista.size();i++)  //ελεγχος για ολα τα αντικειμενα
        {
            if (lista.get(i).getHP()>maxHP)  //αν εχει περισσοτερα αλογα απο το max 
            {
                maxHP=lista.get(i).getHP(); //αλλαγη του max
                indexMax=i;                 //αποθηκευση της θεσης του max
            }
             
            if (lista.get(i).getHP()<minHP)  //ακριβως το ιδιο , αλλα για min 
            {
                
                minHP=lista.get(i).getHP();
                indexMin=i;
                
            }
             
        }
        
        
        c_max=lista.get(indexMax);  //στο c_max αποθηκευω στο αυτοκινητο που εχει τα περισσοτερα αλογα
        c_min=lista.get(indexMin);  //στο c_min αποθηκευω στο αυτοκινητο που εχει τα λιγοτερα αλογα
        System.out.println("Highest hp car: "+c_max);  //και εμφανιζω
        System.out.println("Lowest hp car: "+c_min);
        
        
    }
    
    public void searchHPperMake()  //μεθοδος για αναζητηση αυτοκινητου με τα μεγιστα και τα ελαχιστα αλογα ανα μαρκα
    {
        
        System.out.println("-------Printing highest hp car per make-------");
        
        for (int i=0;i<all_makes.size();i++)   //αναζητηση για καθε ξεχωριστη μαρκα
        {
            
            int maxHP=0;   //αρχικοποιηση μεταβλητων για να μπει στην 1η if 
            int minHP=1500;
            int indexMax=-1;
            int indexMin=-1;
            for (int j=0;j<lista.size();j++)   //αναζητηση για ολα τα αυτοκινητα 
            {
                if (all_makes.get(i).equals(lista.get(j).getMake()))   //αν εχουν ιδια μαρκα
                {
                    if (lista.get(j).getHP()>maxHP)   //ελεγχος για ιπποδυναμη
                    {
                        maxHP=lista.get(j).getHP();   //αποθηκευση μεγιστης ιπποδυναμης
                        indexMax=j;                   //και θεσης
                    }
                    if (lista.get(j).getHP()<minHP)  //το ιδιο για ελαχιστη ιπποδυναμη
                    {
                        minHP=lista.get(j).getHP();
                        indexMin=j;
                    }
                }
            }
                                                //Πριν κλεισει η πρωτη for , δηλαδη πριν παει στην επομενη μαρκα
            Cars c_max=lista.get(indexMax);   //στο c_max περναω το αυτοκινητο που εχει τα περισσοτερα αλογα 
            Cars c_min=lista.get(indexMin);   //στο c_min περναω το αυτοκινητο που εχει τα λιγοτερα αλογα 
            System.out.println("Highest hp "+all_makes.get(i));
            System.out.println(c_max);   //εμφανιση 
            System.out.println("Lowest hp "+all_makes.get(i));
            System.out.println(lista.get(indexMin));  //εμφανιση
        }

    }
    
    
    public void printMakeNum()   //μεθοδος για εμφανιση πληθους αυτοκινητων ανα μαρκα
    {
        
        
        System.out.println("-----Printing number of cars-----");
        
        for (int i=0;i<all_makes.size();i++)   //αναζητηση για τις διαφορετικες μαρκες
        {
            
            int sum=0;  //μεταβλητη που μετραει το πληθος
            for (int j=0;j<lista.size();j++)   //αναζητηση σε ολα τα αυτοκινητα
            {
                if(all_makes.get(i).equals(lista.get(j).getMake()))   //αν εχουν ιδιο ονομα
                {
                    
                    sum+=1;   //προσθετω 1 στο πληθος
                    
                    
                }
                
                
            }
            
            System.out.println(all_makes.get(i)+" has "+sum+" cars available .");  //εμφανιση πληθους , πριν παει στο επομενο αυτοκινητο 
             
        }
    }
        

    public void priceSearch() {    //μεθοδος για αναζητηση αυτοκινητου με βαση τα την τιμη
        
        System.out.println("-----Price based search-----");
        System.out.println();
        System.out.println("Enter the price value :");
        int answer=input.nextInt();
        System.out.println("Printing cars with higher price than what you entered ");
        for (Cars i : lista)   //για ολα τα αυτοκινητα
        {
            
            if(i.getPrice()>answer)  //αν η τιμη που εδωσε ειναι μεγαλυτερη απο την τιμη των αυτοκινητων , τα εμανιζει 
            {
                
                System.out.println(i);
                
            }
    
        }
        
        System.out.println();
        System.out.println("Printing cars with lower price than what you entered ");
        for (Cars i : lista)
        {
            
            if(i.getPrice()<answer)   //αν η τιμη που εδωσε ειναι μικροτερη απο την τιμη των αυτοκινητων , τα εμανιζει 
            {
                
                System.out.println(i);
                
            }
            
            
        } 
        
    }
    
        
    }

    
    
    
    
    
    
    
    
  /*public class CarHPComparator implements Comparator<Functions> {
    public int compare(Cars c1, Cars c2) {
        return c1.getHP() - c2.getHP();
    }
} */
    
    
    
    


  
