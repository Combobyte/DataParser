import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static DataManager parseAllData(String election, String education, String employment){
        DataManager dataManager = new DataManager();
        String[] educationArr = removeNotNeeded(education.split("\n"), 5);
        String[] employmentArr = removeNotNeeded(employment.split("\n"), 8);
        String[] electionArr = removeNotNeeded(election.split("\n"), 1);
        String lastState = "AK";
        State state = new State(lastState);
        for(int n = 0; n < electionArr.length; n++){
            System.out.println(n);
            String str = removeGarbage(electionArr[n]);
            String[] valsElect = str.split(",");
            if(!valsElect[8].equals(lastState)){
                lastState = valsElect[8];
                dataManager.add(state);
                state = new State(lastState);
            }
            int indexOfFipsEdu = 0;
            int indexOfFipsEmploy = 0;
            for(int i = 0; i < educationArr.length; i++){
                if(educationArr[i].indexOf(valsElect[10]) == 0){
                    indexOfFipsEdu = i;
                    break;
                }
            }
            for(int i = 0; i < employmentArr.length; i++){
                if(employmentArr[i].indexOf(valsElect[10]) == 0){
                    indexOfFipsEmploy = i;
                    break;
                }
            }
            String[] valsEdu = removeGarbage(educationArr[indexOfFipsEdu]).split(",");
            String[] valsEmploy = removeGarbage(employmentArr[indexOfFipsEmploy]).split(",");
            Election2016 elect = new Election2016(Double.parseDouble(valsElect[1]), Double.parseDouble(valsElect[2]), Double.parseDouble(valsElect[3]));
            Education2016 edu = new Education2016(Double.parseDouble(valsEdu[39]),Double.parseDouble(valsEdu[40]),Double.parseDouble(valsEdu[41]),Double.parseDouble(valsEdu[42]));
            Employment2016 employ = new Employment2016(((int)Double.parseDouble(valsEmploy[42])),((int)Double.parseDouble(valsEmploy[43])),((int)Double.parseDouble(valsEmploy[44])),Double.parseDouble(valsEmploy[45]));
            County c = new County(valsEdu[2], Integer.parseInt(valsEdu[0]),elect,edu,employ);
            state.add(c);
            if(n == electionArr.length -1){
                dataManager.add(state);
            }
        }
        return dataManager;
    }

    private static String[] removeNotNeeded(String[] arr, int remove) {
        String[] output = new String[arr.length - remove];
        for(int i = 0; i < arr.length; i++){
            if(i >= remove){
                output[i - remove] = arr[i];
            }
        }
        return output;
    }

    private static String removeGarbage(String str){
        while(str.indexOf("\"") != -1){
            int indexOfFirstQuote = str.indexOf("\"");
            int indexOfSecondQuote = str.indexOf("\"", indexOfFirstQuote + 1);
            String fixed = removeCommas(str.substring(indexOfFirstQuote, indexOfSecondQuote));
            fixed = fixed.trim();
            str = str.substring(0, indexOfFirstQuote) + fixed.substring(1) + str.substring(indexOfSecondQuote + 1);
        }
        return str;
    }

    private static String removeCommas(String str){
        String output = "";
        for(int i = 0; i < str.length(); i++){
            if(!(str.substring(i, i+1).equals(","))){
                output+= str.substring(i, i+1);
            }
        }
        return output;
    }
}
