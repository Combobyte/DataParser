public class ElectionResult {

    private double votes_dem;
    private double votes_gop;
    private double total_votes;
    private double percent_dem;
    private double percent_gop;
    private double diff;
    private double per_point_diff;
    private String state_abbr;
    private String county;
    private double combined_fips;

    public ElectionResult(double dem, double gop, double total, double perDem, double perGop, double diff, double perDiff, String state, String county, double combined){
        votes_dem = dem;
        votes_gop = gop;
        total_votes = total;
        percent_dem = perDem;
        percent_gop = perGop;
        this.diff = diff;
        per_point_diff = perDiff;
        state_abbr = state;
        this.county = county;
        combined_fips = combined;
    }

    public double getVotes_dem() {
        return votes_dem;
    }

    public void setVotes_dem(double votes_dem) {
        this.votes_dem = votes_dem;
    }

    public double getVotes_gop() {
        return votes_gop;
    }

    public void setVotes_gop(double votes_gop) {
        this.votes_gop = votes_gop;
    }

    public double getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(double total_votes) {
        this.total_votes = total_votes;
    }

    public double getPercent_dem() {
        return percent_dem;
    }

    public void setPercent_dem(double percent_dem) {
        this.percent_dem = percent_dem;
    }

    public double getPercent_gop() {
        return percent_gop;
    }

    public void setPercent_gop(double percent_gop) {
        this.percent_gop = percent_gop;
    }

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }

    public double getPer_point_diff() {
        return per_point_diff;
    }

    public void setPer_point_diff(double per_point_diff) {
        this.per_point_diff = per_point_diff;
    }

    public String getState_abbr() {
        return state_abbr;
    }

    public void setState_abbr(String state_abbr) {
        this.state_abbr = state_abbr;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public double getCombined_fips() {
        return combined_fips;
    }

    public void setCombined_fips(double combined_fips) {
        this.combined_fips = combined_fips;
    }
}
