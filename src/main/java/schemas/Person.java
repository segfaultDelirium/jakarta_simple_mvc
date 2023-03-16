package schemas;

public class Person {
    public int id;
    public String fname;
    public String lname;
    public String city;

    public Person(int id, String fname, String lname, String city){
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.city = city;
    }
}
