import java.util.ArrayList;

public class Brother_Sister {
    final private ArrayList<Family> family;

    public Brother_Sister(ArrayList<Family> family) {
        this.family = family;
    }

    public void execute() {
        for (Family person1 : family) {
            for (Family person2 : family) {
                if (!(person2.getPerson().equalsIgnoreCase(person1.getPerson()))) {
                    if (person1.getMother().equals(person2.getMother())) {
                        addSibling(person1, person2);
                        addSibling(person2, person1);
                    }
                }
            }
        }
    }

    private void addSibling(Family person, Family sibling) {
        if (person.getGender().equals("male") && sibling.getGender().equals("male")) {
            if(!person.getBrother().contains(sibling.getPerson())){
                person.setBrother(sibling.getPerson());
            }
        } else if (person.getGender().equals("female") && sibling.getGender().equals("female")) {
            if(!person.getSister().contains(sibling.getPerson())){
                person.setSister(sibling.getPerson());
            }
        } else if (person.getGender().equals("male") && sibling.getGender().equals("female")) {
            if(!person.getSister().contains(sibling.getPerson())){
                person.setSister(sibling.getPerson());
            }
        } else if (person.getGender().equals("female") && sibling.getGender().equals("male")) {
            if(!person.getBrother().contains(sibling.getPerson())){
                person.setBrother(sibling.getPerson());
            }
        }
    }
}
