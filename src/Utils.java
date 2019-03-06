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

    public static ArrayList<ElectionResult> parse2016PresidentialResults(String str){
        int count = 0;
        String[] data = str.split("\n");
        ArrayList<ElectionResult> output = new ArrayList<>();
        for(String s : data){
            if(!(count == 0)) {
                s = removeOddities(s);
                String[] values = s.split(",");
                output.add(new ElectionResult(Double.parseDouble(values[1]), Double.parseDouble(values[2]),
                        Double.parseDouble(values[3]), Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]), Double.parseDouble(values[6]), Double.parseDouble(values[7]),
                        values[8], values[9], Double.parseDouble(values[10])));
            }
            count++;
        }
        return output;
    }

    private static String removeOddities(String s){
        int num = countCommas(s);
        String output = "";
        int commaCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i+1).equals(",")){
                commaCount++;
            }
            if(!(((commaCount == 7 && num > 10) || (commaCount == 8 && num > 11)) || (s.substring(i, i+1).equals("\"") || s.substring(i, i+1).equals("%")))){
                output+=s.substring(i, i+1);
            }
        }
        return output;
    }

    private static int countCommas(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i+1).equals(",")){
                sum++;
            }
        }
        return sum;
    }
}
