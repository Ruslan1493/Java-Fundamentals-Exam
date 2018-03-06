/**
 * Created by Ruslan on 3.3.2018 г..
 */
import java.util.Scanner;
public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double money = Double.parseDouble(sc.nextLine());
        Integer countOfStudents = Integer.parseInt(sc.nextLine());
        Double lights = Double.parseDouble(sc.nextLine());
        Double robes = Double.parseDouble(sc.nextLine());
        Double belts = Double.parseDouble(sc.nextLine());

        Double remainder = (double)countOfStudents % 10;
        Integer tenProcents = (int)(countOfStudents / 10);
        //System.out.println(tenProcents);
        //System.out.println(tenProcents);
        //System.out.println(remainder);
        //System.out.println(remainder % 10);
        if(remainder % 10 > 0)
        {
            tenProcents += 1;
        }
        //System.out.println(tenProcents);
        Integer freeBelts = 0;
        //if(countOfStudents >= 6){
        freeBelts = countOfStudents / 6;
        //}
        //System.out.println(freeBelts);
        Double sum = (lights * (countOfStudents + tenProcents)) + (robes * (countOfStudents)) + (belts * (countOfStudents - freeBelts));
        if(sum > money){
            System.out.printf("Ivan Cho will need %.2flv more.", sum - money);
        }else{
            System.out.printf("The money is enough - it would cost %.2flv.", sum);
        }
    }
}
