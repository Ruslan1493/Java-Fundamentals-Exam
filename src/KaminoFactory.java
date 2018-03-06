import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ruslan on 4.3.2018 г..
 */
public class KaminoFactory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer length = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<String> listOfDnasLeft = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> samples = new ArrayList<>();
        while(!input.equals("Clone them!")){
            //System.out.println(input);
            String inputOfDNA = input.replaceAll("!", "").toString();
            if(inputOfDNA.length() == length){
                    list.add(inputOfDNA.toString());
            }

            input = sc.nextLine();
        }
        if(list.size() == 1){
            int sum = 0;
            int ii = 0;
            String output = "";
            //for (int i = 0; i < newDna.size(); i++) {
            int currentSum = 0;
            for (int j = 0; j < list.get(0).length(); j++) {
                currentSum += Integer.parseInt(String.valueOf(list.get(0).charAt(j)));
            }
            System.out.printf("Best DNA sample %d with sum: %d.\n", 1, currentSum);
            for(int i =0;i < list.get(0).length();i++){
                System.out.print(list.get(0).charAt(i) + " ");
            }
            return;
        }else {
            Integer biggestSequence = 0;
            Integer largestSeq = 0;

            for (int i = 0; i < list.size(); i++) {
                Integer currentLength = 0;
                boolean hasStarted = false;
                Integer bestLength = 0;
                Integer lowestIndex = Integer.MAX_VALUE;

                for (int j = 0; j < list.get(i).length() - 1; j++) {
                    if (list.get(i).charAt(j) == '1' && list.get(i).charAt(j + 1) == '1') {
                        if (!hasStarted) {
                            bestLength = 2;
                            currentLength = bestLength;
                            biggestSequence = bestLength;
                            hasStarted = true;
                            if (largestSeq < currentLength) {
                                lowestIndex = j;
                            }

                        } else {
                            bestLength++;
                            biggestSequence = bestLength;
                            currentLength = bestLength;
                            if (largestSeq < biggestSequence) {
                                lowestIndex = j;
                            }
                        }

                    } else {
                        bestLength = 0;
                        hasStarted = false;
                    }
                }
                //System.out.printf("lowest index %d\n", lowestIndex);
                if (largestSeq <= biggestSequence) {
                    indexes.add(biggestSequence);
                    listOfDnasLeft.add(list.get(i));
                    largestSeq = biggestSequence;
                    biggestSequence = 0;
                }
                //System.out.println(bestLength);
            }

            for (int i = 0; i < listOfDnasLeft.size(); i++) {
                //System.out.println(listOfDnasLeft.get(i));
            }

            ArrayList<String> newDna = new ArrayList<>();
            for (int i = 0; i < indexes.size(); i++) {
                if (largestSeq == indexes.get(i)) {
                    newDna.add(listOfDnasLeft.get(i));
                    samples.add(i);
                }
            }
            for (int i = 0; i < newDna.size(); i++) {
                //System.out.println(newDna.get(i));
            }

            // working
            if (newDna.size() > 1) {
                int biggestSeq = 0;
                int lowIndexForArray = Integer.MAX_VALUE;
                ArrayList<Integer> lowIndexs = new ArrayList<>();
                for (int i = 0; i < newDna.size(); i++) {
                    biggestSeq = 0;
                    int currentSeq = 0;
                    int lowestIndex = 0;
                    int lowestIndexTemp = 0;
                    boolean hasSatred = false;
                    for (int j = 0; j < newDna.get(i).length() - 1; j++) {
                        //110011110011

                        //if 1 and 1 matches
                        if (newDna.get(i).charAt(j) == '1' && newDna.get(i).charAt(j + 1) == '1') {
                            if (!hasSatred) {
                                currentSeq = 2;
                                lowestIndexTemp = j;
                                //biggestSeq = currentSeq;
                            } else {
                                currentSeq++;
                                //biggestSeq = currentSeq;
                            }
                            // if sequence has ended
                        } else {
                            if (biggestSeq < currentSeq) {
                                biggestSeq = currentSeq;
                                lowestIndex = lowestIndexTemp;
                            }
                            currentSeq = 0;
                        }
                    }
                    if (biggestSeq < currentSeq) {
                        biggestSeq = currentSeq;
                        lowestIndex = lowestIndexTemp;
                    }
                    if (lowIndexForArray > lowestIndex) {
                        lowIndexForArray = lowestIndex;
                        lowIndexs.add(lowIndexForArray);
                    }
                    //System.out.println("lowest index " + lowestIndex);
                }
                int tempIndex = 0;
                int tempSum = 0;
                int a1 = 0;
                int a2 = 0;

                for (int a = 0; a < lowIndexs.size() - 1; a++) {
                    if (lowIndexs.get(a) < lowIndexs.get(a + 1)) {
                        tempIndex = a;
                        a1++;
                    } else if (lowIndexs.get(a) > lowIndexs.get(a + 1)) {
                        tempIndex = a + 1;
                        a2++;
                    } else {
                        tempSum++;
                    }
                    //System.out.println(lowIndexs.get(a));
                }

                if(biggestSeq == 0){
                    int sum = 0;
                    int sampleIndex = 0;
                    int index = Integer.MAX_VALUE;
                    String output = "";
                    //for (int i = 0; i < newDna.size(); i++) {
                    int currentSum = 0;
                    String output1 = "";
                    for (int j = 0; j < newDna.size(); j++) {
                        for(int a=0;a < newDna.get(j).length();a++) {
                            if(newDna.get(j).charAt(a) == '1') {
                                if(index > a) {
                                    index = a;
                                    output1 = newDna.get(j);
                                    sampleIndex = j;
                                    break;
                                }
                            }
                        }
                    }
                    System.out.printf("Best DNA sample %d with sum: %d.\n", samples.get(sampleIndex) + 1, 1);
                    for (int i = 0; i < output1.length(); i++) {
                        System.out.print(output1.charAt(i) + " ");
                    }

                }else {
                    int sum = 0;
                    int ii = 0;
                    String output = "";
                    //for (int i = 0; i < newDna.size(); i++) {
                    int currentSum = 0;
                    for (int j = 0; j < newDna.get(tempIndex).length(); j++) {
                        currentSum += Integer.parseInt(String.valueOf(newDna.get(tempIndex).charAt(j)));
                    }
                    if (currentSum > sum) {
                        sum = currentSum;
                        output = newDna.get(tempIndex);
                        //ii = tempIndex;
                    }
                    //}
                    System.out.printf("Best DNA sample %d with sum: %d.\n", samples.get(tempIndex) + 1, sum);
                    for (int i = 0; i < newDna.get(tempIndex).length(); i++) {
                        System.out.print(newDna.get(tempIndex).charAt(i) + " ");
                    }
                }
                //else {
//                sum = 0;
//                output = "";
//                ii = 0;
//                if (tempSum >= 0) {
//                    for (int i = 0; i < newDna.size(); i++) {
//                        currentSum = 0;
//                        for (int j = 0; j < newDna.get(i).length(); j++) {
//                            currentSum += Integer.parseInt(String.valueOf(newDna.get(i).charAt(j)));
//                        }
//                        if (currentSum > sum) {
//                            sum = currentSum;
//                            output = newDna.get(i);
//                            ii = i;
//                        }
//                    }
//                    System.out.printf("Best DNA sample %d with sum: %d.\n", samples.get(ii) + 1, sum);
//                }
                //}
            }else {
                int sum = 0;
                int ii = 0;
                String output = "";
                //for (int i = 0; i < newDna.size(); i++) {
                int currentSum = 0;
                for (int j = 0; j < newDna.get(0).length(); j++) {
                    currentSum += Integer.parseInt(String.valueOf(newDna.get(0).charAt(j)));
                }
                if (currentSum > sum) {
                    sum = currentSum;
                    output = newDna.get(0);
                    //ii = tempIndex;
                }
                //}
                System.out.printf("Best DNA sample %d with sum: %d.\n", samples.get(0) + 1, sum);
                for (int i = 0; i < newDna.get(0).length(); i++) {
                    System.out.print(newDna.get(0).charAt(i) + " ");
                }
            }
        }
    }
}
