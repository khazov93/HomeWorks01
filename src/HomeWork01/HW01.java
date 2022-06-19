package HomeWork01;

public class HW01  {

    public static void main (String [] args)
    {
        Person[] people = new Person[4];

        Team team = new Team("Best", people);

        Challenge[] challenges = new Challenge[2];

        Course marafon = new Course(challenges, 1000, 500);

        String info = marafon.personInfo(team);
        System.out.println(info);

        String result = marafon.doIt1(team);
        System.out.println(result);

        String result2 = marafon.doIt2(team);
        System.out.println(result2);

    }


}
