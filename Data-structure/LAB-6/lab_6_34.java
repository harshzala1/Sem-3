
import java.util.Scanner;

public class lab_6_34{
    public static void main(String[] args) {
        Employee_Detail e= new Employee_Detail();
        e.getDetails();
        e.printDetails();

    }

}
class Employee_Detail{
    Scanner sc = new Scanner(System.in);
      int employee_id;
     String name;
      String desigation;
     double salary;

     public void getDetails(){

         System.out.println("enter employee id");
         employee_id = sc.nextInt();

         System.out.println("enter employee name");
         name = sc.next();

         System.out.println("enter employee desigation");
         desigation = sc.next();

         System.out.println("enter employee salary");
         salary = sc.nextInt();
    }
    
     public void printDetails(){
        System.out.println(employee_id);
        System.out.println(name);
        System.out.println(desigation);
        System.out.println(salary);
    }

}

