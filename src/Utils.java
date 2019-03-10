import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {


    public static String readFileAsString(String filepath) {
        StringBuilder output = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(filepath))) {

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    public static DataManager parseAllData(String education, String election, String employment){
        DataManager dataManager = new DataManager();

        return dataManager;
    }

    public static String removeGarbage(String str){
        while(str.indexOf("\"") != -1){
            int indexOfFirstQuote = str.indexOf("\"");
            int indexOfSecondQuote = str.indexOf("\"", indexOfFirstQuote + 1);
            String fixed = removeCommas(str.substring(indexOfFirstQuote, indexOfSecondQuote));
            fixed = fixed.trim();
            str = str.substring(0, indexOfFirstQuote) + fixed + str.substring(indexOfSecondQuote + 1);
        }
        return str;
    }

    public static String removeCommas(String str){
        String output = "";
        for(int i = 0; i < str.length(); i++){
            if(str.substring(i, i+1).equals(",")){
                output+= str.substring(i, i+1);
            }
        }
        return output;
    }
}
