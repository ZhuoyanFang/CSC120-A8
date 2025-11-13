import java.util.ArrayList;

/* This is a stub for the House class */
/**
 * This class represents a building with residents.
 */
public class House extends Building implements HouseRequirements {

    private ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
    private boolean hasDiningRoom;
    private boolean elevator;

    /**
     * Construct a house with name, address, number of floors, and whether it includes a dining room.
     * @param name the name of the house
     * @param address the address of the house
     * @param nFloors the number of floors in the building
     * @param hasDiningRoom whether the house has a dining room
     * @param elevator whether the house has an elevator
     */
    public House(String name,String address,int nFloors,boolean hasDiningRoom,boolean elevator) {
        super(name,address,nFloors);
        this.hasDiningRoom=hasDiningRoom;
        this.elevator=elevator;
        this.residents=new ArrayList<Student>();
        System.out.println("You have built a house: 🏠");
    }

    /*
     * Overload the constructor with no dining room but the elevator.
     */
    public House(String name, String address) {
        this(name, address, 1, false, true);
    }

    /**
     * Check whether this house has a dining room.
     * @return true if the house has a dining room, false if the house does not has a dining room
     */
    public boolean hasDiningRoom() {
        if (this.hasDiningRoom) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns the number of students live in this house.
     * @return the number of residents
     */
    public int nResidents() {
        return this.residents.size();
    }

    
    /**
     * Add a student to the residents in this house.
     * @param s the student that moves into the house
     * @throws RuntimeException if the student is already in the list of the residents
     */
    public void moveIn(Student s) {
        if (this.residents.contains(s)) {
            throw new RuntimeException("This student is already a resident in the house.");
        } else {
            this.residents.add(s);
        }
    }


    /**
     * Removes a student from the residents in this house.
     * @param s the student moving out of the house
     * @return the student who can move out
     * @throws RuntimeException if the student is not found from the list of the residents
     */
    public Student moveOut(Student s) {
        if (this.residents.contains(s)) {
            this.residents.remove(s);
            return s;
        } else {
            throw new RuntimeException("This student is not a resident of this house.");
        }
       
    }

    /**
     * Since sometimes we only use the name when moving in and out, we can overload the move out by the student name instead of a Student itself
     * @param name the name of the student moving out
     * @return the student who move out
     * @throws RuntimeException if no resident has the name that we want 
     */
    public Student moveOut(String name) {
        for (int i = 0; i < this.residents.size(); i++) {
            Student s = this.residents.get(i);
            if (s.getName().equals(name)) {
                this.residents.remove(i);
                return s;
            }
        }
        throw new RuntimeException("No resident has this name.");
    }

    /**
     * Checks whether a student is the resident in this house.
     * @param s the student we want to check
     * @return true if the student is a resident, false if the student is not a resident
     */
    public boolean isResident(Student s) {
        if (this.residents.contains(s)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Show all available methods for this House.
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + hasDiningRoom()");
        System.out.println(" + nResidents()");
        System.out.println(" + moveIn(Student s)");
        System.out.println(" + moveOut(Student s)");
        System.out.println(" + moveOut(String name)");
        System.out.println(" + isResident(Student s)");
    }

    /**
     * Moves the user to a specified floor. If the house has no elevator, the user may only move one floor at a time.
     * @param floorNum the floor to move to
     * @throws RuntimeException if the user is not inside the house
     * @throws RuntimeException if the floor number is invalid
     * @throws RuntimeException if the house has no elevator and the user tries to move more than one floor away
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this House. Must call enter() first.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this House is 1-" + this.nFloors + ".");
        }
        if (this.elevator) {
            super.goToFloor(floorNum);
        } else {
            if (this.activeFloor-floorNum==1||this.activeFloor-floorNum==-1){
                super.goToFloor(floorNum);
            }else{
                throw new RuntimeException("This house has no elevator. You cannot go more than one floor.");
            }
        }
    }

    // public static void main(String[] args) {

    // }
}