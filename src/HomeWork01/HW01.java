package HomeWork01;

public class HW01  {

    public static void main (String [] args)
    {
        Person[] people = new Person[4];

        Team team = new Team("Best", people);

        Course marafon = new Course(1000, 500);


        String info = marafon.personInfo(team);
        System.out.println(info);

        String result = marafon.doIt1(team);
        System.out.println(result);

    }


}
