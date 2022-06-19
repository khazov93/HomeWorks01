package HomeWork01;

public class Team {

    private String name;
    private Person[] people;

    public Team
            (String name, Person[] people) {
        this.name = name;
        this.people = people;
        people[0] = new Person("Nick", 20, 500, 1500);
        people[1] = new Person("John", 25, 300, 1200);
        people[2] = new Person("Drake", 30, 200, 800);
        people[3] = new Person("Tom", 27, 600, 900);
    }

    public String getName() {return name;}

    public Person[] getPeople() {return people;}

}
