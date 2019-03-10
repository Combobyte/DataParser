public class County {

    private String name;
    private int fips;
    private Election2016 election;
    private Education2016 education;
    private Employment2016 employment;

    public County(String name, int fips, Election2016 election, Education2016 education, Employment2016 employment){
        this.name = name;
        this.fips = fips;
        this.education = education;
        this.election = election;
        this.employment = employment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFips() {
        return fips;
    }

    public void setFips(int fips) {
        this.fips = fips;
    }

    public Election2016 getElection() {
        return election;
    }

    public void setElection(Election2016 election) {
        this.election = election;
    }

    public Education2016 getEducation() {
        return education;
    }

    public void setEducation(Education2016 education) {
        this.education = education;
    }

    public Employment2016 getEmployment() {
        return employment;
    }

    public void setEmployment(Employment2016 employment) {
        this.employment = employment;
    }
}
