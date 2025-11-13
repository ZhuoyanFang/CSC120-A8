import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        
        House cutter = new House("Cutter House", "10 Prospect Street Northampton, MA 01063", 3, true, true);  
        House morrow = new House("Morrow House", "Mandelle Rd");  //use the overloaded constructor of house here since morrow has elevator but no dining room
        myMap.addBuilding(cutter);
        myMap.addBuilding(morrow);

    
        Student s1 = new Student("Selina", "991472877", 2028);
        Student s2 = new Student("Linda", "991472876", 2027);
        cutter.moveIn(s1);
        morrow.moveIn(s2);
        cutter.moveOut("Selina"); // use the overloaded moveOut method of House class since I remove the Student only by their name.

   
        Library neilson = new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4, true);
        myMap.addBuilding(neilson);

    
        neilson.addTitle("Pride and Prejudice");
        neilson.addTitle("Harry Potter 1");
        String[] Books = {"Harry Potter 2", "1984", "The Lord of Rings 1"};
        neilson.addTitle(Books); // ues the the overloaded addTitles method in Library class so that we can add multiple books at one time
        neilson.checkOut(Books);  // use the the overloaded checkOut method in Library class so that we can check out multiple books at one time
        neilson.printCollection();

    
        Cafe compass = new Cafe("Compass Cafe", "Inside Neilson Library at 2st Floor", 1, 300, 200, 150, 100);
        Cafe campusCenterCafe = new Cafe("Campus Center Cafe", "Inside Campus Center", 1); //use the overloaded constructor os Cafe here since we have default initial inventory for the CC cafe
        
   
        compass.sellCoffee(12, 1, 1);
        campusCenterCafe.sellCoffee(8,2); //use the overloaded sellCoffee method for the Cafe class since the order here do not need sugar

   
        myMap.addBuilding(new Building("Chapin House", "3 Chapin Way Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Seelye Hall", "Seelye Lawn Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Ziskind House", "1 Henshaw Ave Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("McConnell Hall", "2 Tyler Ct Northampton, MA 01063", 4));

        System.out.println(myMap);
    }
    
}
