package HomeWork04.part02;

import java.util.HashMap;

public class PhoneTableClass {

    private HashMap <String,String> stringHashMap = new HashMap<>();

    public void add (String phone, String secondName)
    {
        stringHashMap.put(phone, secondName);
    }

    public String getPhoneByFIO (String fio)
    {
        if(stringHashMap.containsValue(fio))
        {
            String result = "Номер телефона: ";
            for(String key: stringHashMap.keySet())
            {
                if (stringHashMap.get(key).equals(fio)) result += key + "; ";
            }
            return result;
        }
        else return "Не найдено";

    }


}
