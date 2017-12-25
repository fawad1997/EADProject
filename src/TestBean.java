import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "test")
public class TestBean {
    List<String> selectedSkills;
    public TestBean(){
        selectedSkills = new ArrayList<>();
    }

    public List<String> getSelectedSkills() {
        return selectedSkills;
    }

    public void setSelectedSkills(List<String> selectedSkills) {
        this.selectedSkills = selectedSkills;
    }

    public List<String> completeTheme(String query) {
        List<String> filteredThemes = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
             filteredThemes.add("Fawad"+i);
        }

        return filteredThemes;
    }
}
