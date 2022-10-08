import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        double pointTotal[] = new double[]{20, 30, 40, 50, 60, 100, 200, 300};  /** Input the value for variable in the form of arrays */
        double earnedPoints[] = new double[]{20, 30, 40, 50, 60, 100, 100, 300};
        double assignmentPercentage[] = new double[]{10, 10, 10, 10, 10, 10, 15, 25};
        double finalGrade = 0;
        WeightedGradeIfElse weightedGradeIfElse = new WeightedGradeIfElse();

        for (int i = 0; i < 8; i++) {
            finalGrade += weightedGradeIfElse.updateTotalWeightedScore(pointTotal[i], earnedPoints[i], assignmentPercentage[i]);
        }

        char grade = weightedGradeIfElse.getTotalWeightGrade(finalGrade);

        System.out.println("The grade is: " + grade);
        System.out.println("The total weighted score is: " + finalGrade );

    }
}
