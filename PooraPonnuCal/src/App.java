import java.util.ArrayList;
import java.util.Scanner;

public class App {
    ArrayList<Family> familyList;
    Scanner susan = new Scanner(System.in);
    boolean flag = true;
    public App() {
        familyList = new ArrayList<>(); // Initialize familyList in the constructor
    }
    String name, gender, father, mother,person;

    public void print(){
        for(Family family : familyList){
            if(!family.getSon().isEmpty()) {
                System.out.println(family.getPerson() + " has son named " + family.getSon());
            }
            if(!family.getDaughter().isEmpty()) {
                System.out.println(family.getPerson() + " has daughter named " + family.getDaughter());
            }
            if(!family.getBrother().isEmpty()) {
                System.out.println(family.getPerson() + " has BROTHER named " + family.getBrother());
            }
            if(!family.getSister().isEmpty()) {
                System.out.println(family.getPerson() + " has SISTER named " + family.getSister());
            }
        }
    }

    public boolean isContain(String person){
        for (Family family : familyList){
            if(family.getPerson().equals(person)){
                return true;
            }
        }
        return false;
    }

    public void getPerson() {
        boolean f = true;
        while (f) {
            System.out.println("enter person to find");
            person = susan.nextLine().toLowerCase(); // Read and set the person value from user input
            Gal gal = new Gal(familyList);
            if (isContain(person)) {
                gal.execute(person);
                f = false;
            } else {
                System.out.println("No such person");
            }
        }
    }

    public void getUser() {
        Son son = new Son(familyList);
        Daughter daughter = new Daughter(familyList);
        Brother_Sister bro_sis = new Brother_Sister(familyList);
        while(flag) {

            getUser get = new getUser();
            System.out.println("Enter name  :");
            name = get.get().toLowerCase();
            System.out.println("Enter gender :");
            gender = get.get().toLowerCase();
            System.out.println("Enter father :");
            father = get.get().toLowerCase();
            System.out.println("Enter mother :");
            mother = get.get().toLowerCase();
            System.out.println("Continue (y/n) :");
            familyList.add(new Family(name,gender,father,mother));
            if(susan.nextLine().equals("n")){
                flag = false;
                son.execute();
                daughter.execute();
                bro_sis.execute();
                print();
                getPerson();
            }
        }
    }


    public static void main(String[] args) {
        App app = new App();
        app.getUser();
    }
}
