import java.util.ArrayList;

public class Family {
    private String Person;
    private String Gender;
    private String Father;
    private String Mother;
    final private ArrayList<String> Son;
    final private ArrayList<String> Daughter;
    final private ArrayList<String> Brother;
    final private ArrayList<String> Sister;
    public Family(String Person,String Gender,String Father,String Mother){
        this.Person = Person;
        this.Gender = Gender;
        this.Father = Father;
        this.Mother = Mother;
        this.Brother = new ArrayList<>();
        this.Sister = new ArrayList<>();
        this.Son = new ArrayList<>();
        this.Daughter = new ArrayList<>();
    }
    public String getPerson() {
        return Person;
    }

    public void setPerson(String person) {
        Person = person;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getFather() {
        return Father;
    }

    public void setFather(String father) {
        Father = father;
    }

    public String getMother() {
        return Mother;
    }

    public void setMother(String mother) {
        Mother = mother;
    }

    public ArrayList<String> getSon() {
        return Son;
    }

    public void setSon(String son) {
        Son.add(son);
    }

    public ArrayList<String> getDaughter() {
        return Daughter;
    }

    public void setDaughter(String daughter) {
        Daughter.add(daughter);
    }

    public ArrayList<String> getBrother() {
        return Brother;
    }

    public void setBrother(String brother) {
        Brother.add(brother);
    }

    public ArrayList<String> getSister() {
        return Sister;
    }

    public void setSister(String sister) {
        Sister.add(sister);
    }
}
