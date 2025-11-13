import java.util.Hashtable;
/* This is a stub for the Library class */
/**
 * This class represents a library.
 */
public class Library extends Building implements LibraryRequirements {

    /** 
     * A hashtable that represents the collection.
     */
    private Hashtable<String, Boolean> collection;
    private boolean elevator;


    /**
     * Constructs a library with name, address and number of floors.
     * @param name the name of the library
     * @param address the address of the library
     * @param nFloors the number of floors in the library
     * @param elevator whether the house has an elevator
     */
    public Library(String name,String address,int nFloors,boolean elevator) {
      super(name,address,nFloors);
      this.collection=new Hashtable<String, Boolean>();
      this.elevator=elevator;
      System.out.println("You have built a library: 📖");
    }
  
    /**
     * Add a new book to the library, and set the status as availble.
     * @param title the title of the book we want to add
     */
    public void addTitle(String title) {
        this.collection.put(title, true);
    }

    /**
    * Overload addTitle so that it can allow adding multiple books at once.
    * @param titles an array of book titles to add
    */
    public void addTitle(String[] titles) {
        for (int i = 0; i < titles.length; i++) {
            this.addTitle(titles[i]);
        }
    }
    /**
     * Remove a book from the library.
     * @param title the title of the book that we want to remove
     * @return the removed book
     * @throws RuntimeException if the book is not in the collection
     */
    public String removeTitle(String title) {
         if (this.collection.containsKey(title)) {
            this.collection.remove(title);
            return title;
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }
    }

    /**
     * Check out a book from the library.
     * @param title the title of the book we want to check out
     * @throws RuntimeException if the book is not in the collection
     */
    public void checkOut(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                this.collection.replace(title, false);
            }else{
                throw new RuntimeException("This book is already checked out.");
            }
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }
    }

    /**
    * Overloaded checkOut, which can allow checking out multiple books at once.
    * @param titles an array of book titles that we want to check out
    */
    public void checkOut(String[] titles) {
        for (int i = 0; i < titles.length; i++) {
            this.checkOut(titles[i]);
        }
    }

    /**
     * Return a book to the library.
     * @param title the title of the book we want to return
     * @throws RuntimeException if the book is not in the collection
     */
    public void returnBook(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                throw new RuntimeException("This book is already returned.");
            }else{
                this.collection.replace(title, true);
            }
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }

    }

    /**
     * Check whether the library contains a title.
     * @param title the title of the book we need to search for
     * @return true if the book is in the collection, false otherwise
     */
    public boolean containsTitle(String title) {
        if (this.collection.containsKey(title)){
            return true;
        }else{
            return false;
        }
    }

    /**
    * Determine whether a book in the library is available now.
    * @param title the title of the book we need to check
    * @return true if the book is currently available, false if the book is checked out
    * @throws RuntimeException if the book is not in the collection
    */
    public boolean isAvailable(String title) {
        if (this.collection.containsKey(title)) {
            if (this.collection.get(title)) {
                return true;
            }else{
                return false;
            }
        }else{
            throw new RuntimeException("This book is not in the collection.");
        }
    }

    /**
     * Print all the books in the library and their status.
     */
    public void printCollection() {
        for (String title : this.collection.keySet()) {
            String status;
            if (this.collection.get(title)) {
                status="Now available";
            }else{
                status="Checked out";
            } 
            System.out.println(title + " [" + status + "]");
        }
    }

    /**
     * Show all available methods for this Library.
     */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(String title)");
        System.out.println(" +  addTitle(String[] titles)");
        System.out.println(" + removeTitle(String title)");
        System.out.println(" + checkOut(String title)");
        System.out.println(" + checkOut(String[] titles)");
        System.out.println(" + returnBook(String title)");
        System.out.println(" + printCollection()");
    }


    /**
     * Moves the user to a specified floor. If the library has no elevator, the user may only move one floor at a time.
     * @param floorNum the floor to move to
     * @throws RuntimeException if the user is not inside the house
     * @throws RuntimeException if the floor number is invalid
     * @throws RuntimeException if the library has no elevator and the user tries to move more than one floor away
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Library. Must call enter() first.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Library is 1-" + this.nFloors + ".");
        }
        if (this.elevator) {
            super.goToFloor(floorNum);
        } else {
            if (this.activeFloor-floorNum==1||this.activeFloor-floorNum==-1){
                super.goToFloor(floorNum);
            }else{
                throw new RuntimeException("This library has no elevator. You cannot go more than one floor.");
            }
        }
    }

    // public static void main(String[] args) {
    //   new Library();
    // }
    
  }