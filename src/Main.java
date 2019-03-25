import java.util.ArrayList;

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
        DataManager data = Utils.parseAllData(election, education, employment);

        ArrayList<Double> educationScoresTrump = new ArrayList<>();
        ArrayList<Double> educationScoresClinton = new ArrayList<>();
        for(State state : data.getStates()){
            for(County c : state.getCounties()){
                System.out.println(c.getName() +" " + c.getFips());
                Education2016 edu = c.getEducation();
                Election2016 elect = c.getElection();
                double totalPeople = edu.getBachelorsOrMore() + edu.getNoHighSchool() + edu.getOnlyHighSchool() + edu.getSomeCollege();
                double bachelors = edu.getBachelorsOrMore() * 4;
                double college = edu.getSomeCollege() * 3;
                double highschool = edu.getOnlyHighSchool() * 2;
                double noHighschool = edu.getNoHighSchool();
                if(elect.getDemVotes() > elect.getGopVotes()){
                    educationScoresClinton.add((bachelors + college + highschool + noHighschool)/totalPeople);
                }else{
                    educationScoresTrump.add((bachelors + college + highschool + noHighschool)/totalPeople);
                }
            }
        }
        double averageTrumpEducation = sum(educationScoresTrump)/educationScoresTrump.size();
        double averageClintonEducation = sum(educationScoresClinton)/educationScoresClinton.size();
        System.out.println("Clinton education: " + averageClintonEducation);
        System.out.println("Trump education: " + averageTrumpEducation);
    }

    public static double sum(ArrayList<Double> arr){
        double sum = 0;
        for(double d : arr){
            sum += d;
        }
        return sum;
    }
}
