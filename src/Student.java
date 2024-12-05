import java.util.ArrayList;
import java.io.Serializable;

public class Student implements Borrowable, Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes
    private String name;
    private String id;
    private ArrayList<String> borrowedItems;

    // Constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedItems = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ArrayList<String> getBorrowedItems() {
        return borrowedItems;
    }
    @Override
    public void borrowItem(String item) {
        borrowedItems.add(item);
        System.out.println("Borrowed item: " + item);
    }
    @Override
    public void returnItem(String item) {
        if(borrowedItems.remove(item)) {
            System.out.println("Returned item: " + item);
        } else {
            System.out.println(item + "not found in borrowed items");
        }
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", borrowedItems=" + borrowedItems +
                '}';
    }
}
