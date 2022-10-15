import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  /** to take input from user */
        List<Double> pointTotal = new LinkedList<>();  /** List of pointTotals */
        List<Double> earnedPoints = new LinkedList<>();  /** List of earnedPoints */
        List<Double> assignmentPercentage = new LinkedList<>();  /** List of assignmentPercentage */
        double finalGrade = 0;
        WeightedGrade weightedGrade = new WeightedGrade();

        System.out.println("Enter number of inputs");
        int count = sc.nextInt();
        do {
            System.out.println("Enter Point Total");
            pointTotal.add(sc.nextDouble());
            System.out.println("Enter Earned Points");
            earnedPoints.add(sc.nextDouble());
            System.out.println("Enter Assignment Percentage");
            assignmentPercentage.add(sc.nextDouble());
            count--;

        } while (count>0);

        weightedGrade.setPointTotal(pointTotal);
        weightedGrade.setEarnedPoints(earnedPoints);
        weightedGrade.setAssignmentPercentage(assignmentPercentage);

        weightedGrade.calculateTotalWeightedGrade();
        System.out.println(weightedGrade.getTotalWeightedGrade());
        weightedGrade.setgrade();
        System.out.println(weightedGrade.getGrade());  /** Displaying the grade of user */


    }
}

