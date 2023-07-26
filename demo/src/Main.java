import java.util.ArrayList;
import java.util.Scanner;

class Family{
    public static void main(String[] args){

        ArrayList<Person> family = new ArrayList<>();

        getPersons(family);
    }

    public static void Finder(ArrayList <Person> family, String match){
        Person obj = Person.getMember(match);
        if(obj == null){
            System.out.println("No such person");
        }
        else{
            if(obj.getMother().getBrothers() != null){
                for(Person obj1 : obj.getMother().getBrothers()){
                    for(Person obj2 : obj1.getDaughters()){
                        System.out.println(obj2.getName());
                    }
                }
            }
            if(obj.getFather().getSisters() != null){
                for(Person obj1 : obj.getFather().getSisters()){
                    for(Person obj2 : obj1.getDaughters()){
                        System.out.println(obj2.getName());
                    }
                }
            }
        }
    }


    public static void getPersons(ArrayList <Person> family){
        Scanner sc1 = new Scanner(System.in);
        boolean choice = true;
        while(choice){
            Person obj1, obj2, obj3;
            System.out.print("Enter name : ");
            String name = sc1.next();
            System.out.print("Enter gender : ");
            String gender = sc1.next();
            if(Person.hasMember(name)){
                obj1 = Person.getMember(name);
                obj1.setGender(gender);
            }
            else{
                obj1 = new Person(name, gender);
                family.add(obj1);
                Person.addMember(name, obj1);
            }
            System.out.print("Enter father : ");
            String father = sc1.next();
            if(!Person.hasMember(father)){
                obj2 = new Person(father, "male");
                family.add(obj2);
                Person.addMember(father, obj2);
            }
            else{
                obj2 = Person.getMember(father);
            }
            obj1.setFather(obj2);
            System.out.print("Enter mother : ");
            String mother = sc1.next();
            if(!Person.hasMember(mother)){
                obj3 = new Person(mother, "female");
                family.add(obj3);
                Person.addMember(mother, obj3);
            }
            else{
                obj3 = Person.getMember(mother);
            }
            obj1.setMother(obj3);
            if(obj1.getGender().equals("male")){
                obj2.addSons(obj1);
                obj3.addSons(obj1);
            }
            else{
                obj2.addDaughters(obj1);
                obj3.addDaughters(obj1);
            }
            if(obj2.getSpouse() == null){
                obj2.setSpouse(obj3);
            }
            if(obj3.getSpouse() == null){
                obj3.setSpouse(obj2);
            }
            if(obj1.getGender().equals("male")){
                if(!obj1.getMother().isSonsEmpty()){
                    for(Person obj : obj1.getMother().getSons()){
                        if(!obj.hasBrother(obj1)){
                            obj.setBrothers(obj1);
                        }
                    }
                }
                if(!obj1.getMother().isDaughtersEmpty()){
                    for(Person obj : obj1.getMother().getDaughters()){
                        if(!obj.hasBrother(Person.getMember(name))){
                            obj.setBrothers(Person.getMember(name));
                        }
                    }
                }
            }
            else{
                for(Person obj : obj1.getMother().getSons()){
                    if(!obj.hasSister(obj1)){
                        obj.setSisters(obj1);
                    }
                }

                for(Person obj : Person.getMember(name).getMother().getDaughters()){
                    if(!obj.hasSister(obj1)){
                        obj.setSisters(obj1);
                    }
                }
            }
            System.out.print("Continue : ");
            char ch = sc1.next().charAt(0);
            choice = ch == 'y';
        }
        System.out.print("Enter name to match : ");
        String match = sc1.next();
        Finder(family, match);

        sc1.close();
    }

    public static void printFamily(Person[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i].getName() + " " + array[i].getGender() + " " + array[i].getFather() + " " + array[i].getMother());
        }
    }
}
