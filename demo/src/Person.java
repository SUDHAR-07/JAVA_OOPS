import java.util.*;

class Person{
    private String name;
    private String gender;
    private Person father;
    private Person mother;
    private Person spouse;
    private ArrayList <Person> sons = new ArrayList <Person>();
    private ArrayList <Person> daughters = new ArrayList <Person>();
    private ArrayList <Person> brothers = new ArrayList <Person>();
    private ArrayList <Person> sisters = new ArrayList <Person>();

    private static HashMap <String, Person> members = new HashMap <>();

    public void setBrothers(Person obj){
        brothers.add(obj);
    }

    public ArrayList<Person> getBrothers(){
        return brothers;
    }

    public void setSisters(Person obj){
        sisters.add(obj);
    }

    public ArrayList<Person> getSisters(){
        return sisters;
    }

    public boolean hasSister(Person obj){
        return sisters.contains(obj);
    }

    public boolean hasBrother(Person obj){
        return brothers.contains(obj);
    }

    public void setSpouse(Person obj){
        this.spouse = obj;
    }

    public Person getSpouse(){
        return this.spouse;
    }

    public static boolean hasMember(String name){
        return members.containsKey(name);
    }

    public static Person getMember(String name){
        return(members.get(name));
    }

    public static void addMember(String name, Person obj){
        members.put(name, obj);
    }


    public Person(String name, String gender){
        this.name = name;
        this.gender = gender;
    }


    public void addSons(Person son){
        this.sons.add(son);
    }

    public boolean isSonsEmpty(){
        return this.sons.isEmpty();
    }

    public boolean isDaughtersEmpty(){
        return this.daughters.isEmpty();
    }

    public ArrayList<Person> getSons(){
        return this.sons;
    }

    public ArrayList<Person> getDaughters(){
        return this.daughters;
    }

    public void addDaughters(Person daughter){
        this.daughters.add(daughter);
    }


    public void setGender(String gender){
        this.gender = gender;
    }

    public void setFather(Person father){
        this.father = father;
    }

    public void setMother(Person mother){
        this.mother = mother;
    }

    public String getName(){
        return(this.name);
    }

    public String getGender(){
        return(this.gender);
    }

    public Person getFather(){
        return(this.father);
    }

    public Person getMother(){
        return(this.mother);
    }

}



/*
Enter name : suriya
Enter gender : male
Enter father : siva
Enter mother : sivagami
Continue : y
Enter name : karthi
Enter gender : male
Enter father : siva
Enter mother : sivagami
Continue : y
Enter name : jothika
Enter gender : female
Enter father : jf
Enter mother : jm
Continue : y
Enter name : nagma
Enter gender : female
Enter father : jf
Enter mother : jm
Continue : y
Enter name : siva
Enter gender : male
Enter father : sf
Enter mother : sm
Continue : y
Enter name : jm
Enter gender : female
Enter father : sf
Enter mother : sm
Continue : n
Enter name to match : surya
No such person
PS C:\Users\S HARIPRAKASH\Desktop\Hack day 2> cd "c:\Users\S HARIPRAKASH\Desktop\Hack day 2\" ; if ($?) { javac Family.java } ; if ($?) { java Family }
Enter name : suriya
Enter gender : male
Enter father : siva
Enter mother : sivagami
Continue : y
Enter name : karthi
Enter gender : male
Enter father : siva
Enter mother : sivagami
Continue : y
Enter name : jothika
Enter gender : female
Enter father : jf
Enter mother : jm
Continue : y
Enter name : nagma
Enter gender : female
Enter father : jf
Enter mother : jm
Continue : y
Enter name : siva
Enter gender : male
Enter father : sf
Enter mother : sm
Continue : y
Enter name : jm
Enter gender : female
Enter father : sf
Enter mother : sm
Continue : suriya
Enter name to match : suriya
jothika
nagma
*/

//  suriya male siva sivagami y karthi male siva sivagami y jothika female jf jm y nagma female jf jm y siva male sf sm y jm female sf sm n


/*
Enter name : c
Enter gender : male  
Enter father : a
Enter mother : b
Continue : y
Enter name : e
Enter gender : female
Enter father : a
Enter mother : b
Continue : y
Enter name : g
Enter gender : male
Enter father : a
Enter mother : b
Continue : y
Enter name : i
Enter gender : male
Enter father : c
Enter mother : d
Continue : y
Enter name : j
Enter gender : female
Enter father : c
Enter mother : d
Continue : y
Enter name : k
Enter gender : male 
Enter father : c
Enter mother : d
Continue : y
Enter name : l
Enter gender : male
Enter father : f
Enter mother : e
Continue : y
Enter name : m
Enter gender : female
Enter father : f
Enter mother : e
Continue : y
Enter name : n
Enter gender : female
Enter father : f
Enter mother : e
Continue : y
Enter name : o
Enter gender : male
Enter father : g
Enter mother : h
Continue : y
Enter name : p
Enter gender : female
Enter father : g
Enter mother : h
Continue : y
Enter name : q
Enter gender : female
Enter father : g
Enter mother : h
Continue : n
Enter name to match : i
m
n
*/