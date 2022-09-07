//icsd13091 : Κωνσταντίνου Μάριος

package exercise1;

import static exercise1.Functions.all_makes;


import java.util.Scanner;


public class Main {    //Main συναρτηση

    
    public static void main(String[] args) {
        
        Scanner input=new Scanner(System.in);
        
        Cars c=new Cars();
        
        Functions f=new Functions();
        
        
        Cars c1=new Cars("Nissan","300zx","Black",300,3000,25000);  //Δημιουργια αντικειμενων 
        f.addCar(c1);                                               //και προσθηκη στη λιστα 
        
        Cars c2=new Cars("Toyota","Celica","Grey",120,1800,10000);
        f.addCar(c2);
        //System.out.println(f.getListItems());

        Cars c3=new Cars("Nissan","Skyline","Blue",280,2600,30000);
        f.addCar(c3);

        Cars c4=new Cars("Dodge","Charger Hellcat","Red",707,6200,70000);
        f.addCar(c4);

        Cars c5=new Cars("Audi","Quattro","Green",400,2300,50000);
        f.addCar(c5);
        System.out.println();
        
        Cars c6=new Cars("Dodge","Challenger","Orange",360,5000,35000);
        f.addCar(c6);
        System.out.println();
        
       
        System.out.println("The cars available in the dealership are the following:");   //εμφανιση της λιστας με τα αυτοκινητα με ολα τους τα χαρακτηριστικα
        System.out.println();
        f.printList();      //εμφανιση της λιστας με τα αυτοκινητα με ολα τους τα χαρακτηριστικα
        f.removeCar();      //Μεθοδος για διαγραφη αυτοκινητου με βαση τον κωδικο
        f.searchCar();      //μεθοδος για αναζητηση αυτοκινητου με βαση τον κωδικο

        System.out.println("-------Printing car makes without duplicates-------");
        f.noDuplicates(c1);
        f.noDuplicates(c2);
        f.noDuplicates(c3);
        f.noDuplicates(c4);
        f.noDuplicates(c5);
        f.noDuplicates(c6);
        for (String i:all_makes)
        {
            System.out.println(i);   //εμφανιση μαρκων αυτοκινητων χωρις διπλοτυπα
        }

        f.searchHP();       //εμφανιση αυτοκινητων με τα μεγιστα και τα ελαχιστα αλογα
        f.searchHPperMake();    //εμφανιση αυτοκινητων ανα μαρκα με μεγιστα και ελαχιστα αλογα  
        f.printMakeNum();       //εμφανιση πληθους αυτοκινητων ανα μαρκα
        f.priceSearch();        //αναζητηση αυτοκινητων με βαση την τιμη 
    
    }
    
}
