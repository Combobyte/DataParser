/**
 * Main class for the data parser
 *
 * @author: Varun Sreedhar
 */

public class Main {

    public static void main(String[] args) {
        String election = Utils.readFileAsString("C:\\Users\\Varun\\Desktop\\data\\2016_Presidential_Results.csv");
        String education = Utils.readFileAsString("C:\\Users\\Varun\\Desktop\\data\\Education.csv");
        String employment = Utils.readFileAsString("C:\\Users\\Varun\\Desktop\\data\\Unemployment.csv");
        Utils.parseAllData(election, education, employment);
    }
}
