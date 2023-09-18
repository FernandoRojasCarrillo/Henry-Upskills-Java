public abstract class Persona {
    private String FirstName;
    private String LastName;
    private double Height;
    private String Nationality;
    private int Age;

    public Persona() {}

    public Persona(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public Persona(String firstName, String lastName, double height, String nationality, int age) {
        FirstName = firstName;
        LastName = lastName;
        Height = height;
        Nationality = nationality;
        Age = age;
    }

    abstract public String getFullName();

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(float height) {
        Height = height;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
