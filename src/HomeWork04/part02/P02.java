package HomeWork04.part02;

public class P02 {

    public static void main(String[] args) {
        PhoneTableClass phoneTableClass = new PhoneTableClass();
        phoneTableClass.add("770777", "Петров");
        phoneTableClass.add("660678", "Иванов");
        phoneTableClass.add("550789", "Петров");
        phoneTableClass.add("242424", "Сидоров");
        phoneTableClass.add("333333", "Ткачёв");
        phoneTableClass.add("444444", "Петров");
        phoneTableClass.add("123456", "Иванов");

        System.out.println(phoneTableClass.getPhoneByFIO("Иванов"));
    }

}
