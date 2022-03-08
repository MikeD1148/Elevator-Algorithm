package Elevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ElevatorAlgorithm {

    static int max = 5;	//How many different floors the elevator will go to (N)
    static int numberOfFloors = 20;	//How many floors there are in the building
    static int currentLevel = 1;	//Where the elevator starts from
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LinkedList<Integer> levelList = new LinkedList<Integer>();
        ArrayList<Level> lvl = new ArrayList<Level>();
        for (int i = 0; i < max; i++)
        {
            int random = (int) (Math.random() * (numberOfFloors-1) + 1);
            levelList.add(random);
        }

        System.out.println("The elevator will go to these floors: "+levelList);
        for (int i=0; i<levelList.size(); i++) {
            int diff = Math.abs(levelList.get(i)-currentLevel);
            Level l = new Level(diff,levelList.get(i));
            lvl.add(l);
        }
        Collections.sort(lvl,new CompareLevel());
        try {
            System.out.println("The current floor is: "+currentLevel);
            long timeStart = System.currentTimeMillis();
            while(!lvl.isEmpty()) {
                int l = lvl.get(0).level;
                System.out.println("level request "+l);
                while(l>currentLevel) {
                    String string = String.format("%s", currentLevel);
                    System.out.print(string);
                    Thread.sleep(1000);
                    currentLevel++;
                }

                while(l<currentLevel) {
                    String string = String.format("%s", currentLevel);
                    System.out.print(string);
                    Thread.sleep(1000);
                    currentLevel--;
                }
                System.out.println("\nYou have arrived level "+currentLevel);
                lvl.remove(0);
                Thread.sleep(2000);
            }

            long endTime = System.currentTimeMillis();
            double time = (endTime-timeStart)/1000;
            System.out.println("Duration : "+time+ " seconds");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }

}
