package HomeWork01;

public class Course {

    String info;
    String result;
    private int zabeg;
    private int zapliv;

    public Course(int zabeg, int zapliv)
    {
        this.zabeg = zabeg;
        this.zapliv = zapliv;
    }

    public String personInfo(Team team)
    {
        info = "Group name: "+ team.getName()+ " " + '\n';
        for (Person person : team.getPeople())
        {info += "Person name: " + person.getName() + " ";
            info += "Person age: " + person.getAge() + " " + '\n';}
        return info;
    }

    public String doIt1 (Team team)
    {
        result = "Group name: "+ team.getName()+ " " + '\n';
        for(Person person
                : team.getPeople()) {
            result += "Person name: " + person.getName() + " " + '\n';
            int value = person.getMaxDistance();
            int value1 = person.getMaxSwimming();
            testZabeg(value);
            testZapliv(value1);
        }
        return result;
    }

    private void testZabeg(int value)
    {
        if(value <=zabeg) {result += "Not overcame the distance! (running) "+ '\n';}
        else {result += "YES! Overcame the distance! (running) " +'\n';}
    }

    private void testZapliv(int value1)
    {

        if(value1 <= zapliv) {result += "Not overcame the distance! (swimming) "+ '\n';}
        else {result += "YES! Overcame the distance! (swimming) " +'\n';}

    }

}
