package HomeWork05;


import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CreateFileClass {

    public static ArrayList <FIleObject> fIleObjectArrayList = new ArrayList<>();
    public static final String pathToFile = "src/HomeWork05/files/test.csv";
    public static final String title = "value 1"+ "; " + "value 2"
            + "; " + "value 3" + "; " + '\n' ;

    public static void main(String[] args) throws IOException {


        createFileObjects();
        writer();
        AppData appData = readToObject();
    }

    public static void createFileObjects(){
        Random random = new Random();
        for(int i = 0; i < 10; i++) {
            fIleObjectArrayList.add( new FIleObject(random.nextInt(500), random.nextInt(500), random.nextInt(500)));
        }
    }

    public static void writer() throws IOException
    {
        try (FileWriter writer = new FileWriter(pathToFile);){
            writer.write(title);
            for(FIleObject fIleObject : fIleObjectArrayList) {
                writer.write(fIleObject.getValueOne() + ";" + fIleObject.getValueTwo()
                        + ";" + fIleObject.getValueThree() + ";" + '\n') ;
            }
        }
    }

    public static AppData readToObject() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line = br.readLine();
            appData.setHeader( line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        };

        int[][] resultData = new int[records.size()][3];

        for(int i=0 ; i<records.size(); i++)
        {
            for(int j=0 ; j<records.get(i).size(); j++) {
                resultData[i][j] = Integer.valueOf(records.get(i).get(j));
            }
        }
        appData.setData(resultData);
        return appData;

    }

}