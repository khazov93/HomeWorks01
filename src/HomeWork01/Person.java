package HomeWork01;

public class Person {
    private String name;
    private int age;
    private int maxSwimming;
    private int maxDistance;

    public Person (String name, int age, int maxSwimming, int maxDistance)
    {
        this.name = name;
        this.age = age;
        this.maxSwimming = maxSwimming;
        this.maxDistance = maxDistance;
    }
    public String getName() {return name;}

    public int getAge() {return age;}

    public int getMaxSwimming (){return maxSwimming;}

    public int getMaxDistance() {
        return maxDistance;
    }

}
