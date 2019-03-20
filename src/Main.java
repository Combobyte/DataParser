/**
 * Main class for the data parser
 *
 * @author: Varun Sreedhar
 */

public class Main {

    public static void main(String[] args) {
        String election = Utils.readFileAsString("C:\\Users\\vsreedhar337\\Desktop\\data\\2016_Presidential_Results.csv");
        String education = Utils.readFileAsString("C:\\Users\\vsreedhar337\\Desktop\\data\\Education.csv");
        String employment = Utils.readFileAsString("C:\\Users\\vsreedhar337\\Desktop\\data\\Unemployment.csv");
        Utils.parseAllData(election, education, employment);
    }
}
