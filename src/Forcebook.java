import java.util.*;

/**
 * Created by Ruslan on 4.3.2018 г..
 */
public class Forcebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, ArrayList<String>> sides = new LinkedHashMap<>();
        LinkedHashMap<String, String> userFromSides = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("->")) {
                String[] tokens = input.split("[->]+");
                String side = tokens[1].trim();
                String user = tokens[0].trim();
                if (userFromSides.containsKey(user)) {
                    for (Map.Entry<String, ArrayList<String>> k : sides.entrySet()) {
                        if (k.getValue().contains(user)) {
                            k.getValue().remove(user);
                        }
                    }
                    sides.putIfAbsent(side, new ArrayList<>());
                    sides.get(side).add(user);
                    userFromSides.remove(user);
                    userFromSides.putIfAbsent(user, side);
                    System.out.printf("%s joins the %s side!\n", user, side);
                } else {
                    sides.putIfAbsent(side, new ArrayList<>());
                    sides.get(side).add(user);
                    userFromSides.putIfAbsent(user, side);
                    System.out.printf("%s joins the %s side!\n", user, side);
                }
            } else if (input.contains("|")) {
                String[] tokens = input.split("[\\|]+");
                String side = tokens[0].trim();
                String user = tokens[1].trim();
                if(!userFromSides.containsKey(user)) {
                    sides.putIfAbsent(side, new ArrayList<>());
                    sides.get(side).add(user);
                    userFromSides.putIfAbsent(user, side);
                }
            }
            input = sc.nextLine();
        }
        sides.entrySet().removeIf(s -> s.getValue().size() == 0);
        sides.entrySet().stream()
                .sorted((a, b) -> {
                    String first = a.getKey();
                    String second = b.getKey();
                    if (first.compareTo(second) < 0) {
                        return -1;
                    } else {
                        return 1;
                    }
                }).sorted((a, b) -> {
            int first = a.getValue().size();
            int second = b.getValue().size();
            if (first > second) {
                return -1;
            } else {
                return 1;
            }
        })
                .forEach(s -> {
                    System.out.printf("Side: %s, Members: %d\n", s.getKey(), s.getValue().size());
                    ArrayList<String> usersNames = s.getValue();
                    Collections.sort(usersNames);
                    for (String v : usersNames) {
                        System.out.printf("! %s\n", v);
                    }
                });
    }
}
