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

    public ArrayList<ElectionResult> parse2016PresidentialResults(String str){
        String[] data = str.split("\n");
        ArrayList<ElectionResult> output = new ArrayList<>();
        for(String s : data){

        }
        return null;
    }

    private int countCommas(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i, i+1).equals(",")){
                sum++;
            }
        }
        return sum;
    }
}
