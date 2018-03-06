import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ruslan on 4.3.2018 г..
 */
public class Reg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[STARstar]+");
        Integer count = Integer.parseInt(sc.nextLine());
        ArrayList<String> message = new ArrayList<>();
        String key = "";
        for (int i = 0; i < count; i++) {
            String input = sc.nextLine();
            Matcher matcher = pattern.matcher(input);
            key = "";
            while (matcher.find()) {
                key += matcher.group();
            }
            //System.out.println(key);
            String tempMessage = "";
            for (int j = 0; j < input.length(); j++) {
                tempMessage += (char) (input.charAt(j) - key.length());
                //System.out.print(tempMessage);
            }
            message.add(tempMessage.toString());
            //System.out.println(tempMessage);
        }
        //System.out.println(key);
//        for (int i = 0; i < message.size(); i++) {
//            System.out.println(message.get(i));
//        }
        ArrayList<String> attackedPlanets = new ArrayList<>();
        ArrayList<String> destroyedPlanets = new ArrayList<>();
        Pattern pattern2 = Pattern.compile("[^\\@\\-\\>\\:\\!]*@([a-zA-Z]+)[^\\@\\:\\-\\>\\!]*\\:" +
                "[^\\@\\-\\>\\:\\!]*[\\d]+[^\\@\\-\\>\\:\\!]*!([A|D]+)![^\\@\\-\\>\\:\\!]*->[^\\@\\:\\-\\>\\!][\\d]+");
        for (int i = 0; i < count; i++) {
            Matcher matchInput = pattern2.matcher(message.get(i));
            if(matchInput.find()){
                if(matchInput.group(2).equals("A")){
                    attackedPlanets.add(matchInput.group(1));
                }else if(matchInput.group(2).equals("D")){
                    destroyedPlanets.add(matchInput.group(1));
                }
            }
            //System.out.println(matchInput.groupCount());
        }
        System.out.printf("Attacked planets: %d\n", attackedPlanets.size());
        attackedPlanets.stream().sorted().forEach(s-> System.out.printf("-> %s\n", s));
        System.out.printf("Destroyed planets: %d\n", destroyedPlanets.size());
        destroyedPlanets.stream().sorted().forEach(s-> System.out.printf("-> %s\n", s));
    }


}
