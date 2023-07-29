import java.util.Scanner;

public class getUser {
    private String name;
    Scanner susan = new Scanner(System.in);
    public String get(){
        boolean flag = true;
        while (flag){
            try{
                name = susan.nextLine();
                flag = false;
            }catch (Exception e){
                System.out.println("RE-ENTER ");
                e.printStackTrace();
            }
        }
        return name;
    }
}
