public class Employment2016 {

    private int totalLaborForce;
    private int employedLaborForce;
    private int unemployedLaborForce;
    private double percentEmployed;

    public Employment2016(int total, int employed, int unemployed, double percent){
        totalLaborForce = total;
        employedLaborForce = employed;
        unemployedLaborForce = unemployed;
        percentEmployed = percent;

    }

    public int getTotalLaborForce() {
        return totalLaborForce;
    }

    public void setTotalLaborForce(int totalLaborForce) {
        this.totalLaborForce = totalLaborForce;
    }

    public int getEmployedLaborForce() {
        return employedLaborForce;
    }

    public void setEmployedLaborForce(int employedLaborForce) {
        this.employedLaborForce = employedLaborForce;
    }

    public int getUnemployedLaborForce() {
        return unemployedLaborForce;
    }

    public void setUnemployedLaborForce(int unemployedLaborForce) {
        this.unemployedLaborForce = unemployedLaborForce;
    }

    public double getPercentEmployed() {
        return percentEmployed;
    }

    public void setPercentEmployed(double percentEmployed) {
        this.percentEmployed = percentEmployed;
    }
}
