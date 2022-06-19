package HomeWork01;

public class Course {

    String info;
    String result;
    String result2;
    Challenge[] challenges;
    private int zabeg;
    private int zapliv;

    public Course(Challenge[] challenges, int zabeg, int zapliv)
    {
        this.zabeg = zabeg;
        this.zapliv = zapliv;
        this.challenges = challenges;
        challenges[0] = new Challenge("(Swimming)", 500);
        challenges[1] = new Challenge("(Running)", 1000);
    }

    public Challenge[] getChallenges() {
        return challenges;
    }

    public String personInfo(Team team)
    {
        info = "Group name: "+ team.getName()+ " " + '\n';
        for (Person person : team.getPeople())
        {info += "Person name: " + person.getName() + " ";
            info += "Person age: " + person.getAge() + " " + '\n';}
        return info;}


    //Реализация №1

    public String doIt1 (Team team)
    {result = "Group name: "+ team.getName()+ " " + '\n';
        for(Person person
                : team.getPeople()) {
            result += "Person name: " + person.getName() + " " + '\n';
            int value = person.getMaxDistance();
            int value1 = person.getMaxSwimming();
            testZabeg(value);
            testZapliv(value1);}
        return result;}


    private void testZabeg(int value)
    {if(value <=zabeg) {result += "Not overcame the distance! (running) "+ '\n';}
        else {result += "YES! Overcame the distance! (running) " +'\n';}}

    private void testZapliv(int value1)

    {if(value1 <= zapliv) {result += "Not overcame the distance! (swimming) "+ '\n';}
        else {result += "YES! Overcame the distance! (swimming) " +'\n';}}


    //Реализация №2

    public String doIt2 (Team team)
    { result2  = "Group name: " + team.getName() + "\n";

        for (Person person : team.getPeople() )
        {
            result2 += '\n' + "Person name: " + person.getName() + "\n";

            if (challenges[0].getDistance() > person.getMaxSwimming()) {

                result2 +=  "Challenger not overcome the distandce " + this.challenges[0].getName() + "\n";
            } else {
                result2 +=  "Challenger overcome the distance " + this.challenges[0].getName() + "\n";
            }

            if (challenges[1].getDistance() > person.getMaxDistance()) {
                result2 +=  "Challenger not overcome the distandce " + this.challenges[1].getName() + "\n";
            } else {
                result2 += "Challenger overcome the distance " + this.challenges[1].getName() + "\n";
            }
        }

        return result2;
    }

}
