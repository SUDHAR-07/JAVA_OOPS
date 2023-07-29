import java.util.ArrayList;

public class Daughter {
    final private ArrayList<Family> family;

    public Daughter(ArrayList<Family> family){
        this.family = family;
    }
    public void execute(){
        for(Family family1 : family){
            for (Family family2 : family){
                if(family1.getGender().equals("female") && family1.getMother().equals(family2.getPerson())){
                    family2.setDaughter(family1.getPerson());
                }
                if(family1.getGender().equals("female") && family1.getFather().equals(family2.getPerson())){
                    family2.setDaughter(family1.getPerson());
                }
            }
        }
    }

}
