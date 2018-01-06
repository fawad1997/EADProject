package BackingBeans;

public class JobDTO {
    private String title;
    private String description;
    private int vacencies;
    private String address;
    private int experienceYears;
    private String salary;
    private int minQualification;
    private int companyId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVacencies() {
        return vacencies;
    }

    public void setVacencies(int vacencies) {
        this.vacencies = vacencies;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getMinQualification() {
        return minQualification;
    }

    public void setMinQualification(int minQualification) {
        this.minQualification = minQualification;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
