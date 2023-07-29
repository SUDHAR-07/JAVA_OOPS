import java.util.ArrayList;


public class Gal {
    final private ArrayList<Family> familyArrayList;

    public Gal(ArrayList<Family> familyArrayList){
        this.familyArrayList = familyArrayList;
    }

    public void execute(String person) {
        Family groom = getPerson(person);
        if(groom.getPerson()!= null){
            Family father = getFather(groom);
            Family mother = getMother(groom);
            if(father != null){
                getSister(father,groom);
            }
            if(mother != null){
                getSister(mother,groom);
            }
        }
//        System.out.println(" GROOM " + groom.getPerson());
//        System.out.println(" father " + father.getPerson());
    }

    public void getSons(Family person,Family groom){
        if(person.getSon()!= null) {
            ArrayList<String> personSon = person.getSon();
            if (!(personSon == null)) {
                System.out.println("GROOM " + groom.getPerson() + " has following");
                for (String son : personSon) {
                    System.out.print(son + " ");
                }
            } else {
                System.out.println("GROOM doest have any such");
            }
        }
    }
    public void getDaughter(Family person,Family groom){
//        System.out.println("GROOM " + groom.getPerson() + " has following");
        if(person.getDaughter()!=null) {
            ArrayList<String> personDaughter = person.getDaughter();
            if (!(personDaughter == null)) {
                System.out.println("GROOM " + groom.getPerson() + " has following");
                for (String daughter : personDaughter) {
                    System.out.print(daughter + " ");
                }
            } else {
                System.out.println("GROOM doest have any such");
            }
        }
    }
    public void getSister(Family person,Family groom){
//        try {
            if (person.getSister() != null && !person.getSister().isEmpty()) {
                ArrayList<String> personSisters = person.getSister();
                if (personSisters != null && !personSisters.isEmpty()) {
                    for (String sisName : personSisters) {
                        for (Family obj : familyArrayList) {
                            if (obj.getPerson().equals(sisName)) {
                                if (groom.getGender().equals("male")) {
                                    getDaughter(obj, groom);
                                } else {
                                    getSons(obj, groom);
                                }
                            }
                        }
                    }
                }
            }
//        }catch (Exception e){
////            System.out.println("catches");
//        }
    }
    public Family getFather(Family person){
        for(Family obj : familyArrayList){
            if(obj.getPerson().equals(person.getFather())){
                return obj;
            }
        }
        return null;
    }
    public Family getPerson(String person){
        for (Family family : familyArrayList) {
            if(family.getPerson().equals(person)){
                return family;
            }
        }
        return null;
    }
    public Family getMother(Family person){
        for(Family obj : familyArrayList){
            if (obj.getPerson().equals(person.getMother())) {
                    return obj;
            }
        }
        return null;
    }

}

