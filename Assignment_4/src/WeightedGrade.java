/*
Name - Riya Ketan Parekh
Class - Section 8
Lab# - 4
 */

import java.util.LinkedList;
import java.util.List;

public class WeightedGrade {
    List<Double> pointTotal = new LinkedList<>();  /** Array of pointTotals */
    List<Double> earnedPoints = new LinkedList<>();  /** Array of earnedPoints */
    List<Double> assignmentPercentage = new LinkedList<>();  /** Array of assignmentPercentage */
    double totalWeightedGrade;
    private final int DIVISOR = 100;
     char grade;


    public void setPointTotal(List<Double> pointTotal) {
        this.pointTotal = pointTotal;
    }

    public void setEarnedPoints(List<Double> earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public void setAssignmentPercentage(List<Double> assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }

    public double getTotalWeightedGrade()
    {
        return totalWeightedGrade;
    }

    public  List<Double> getPointTotal() {
        return pointTotal;
    }

    public List<Double> getEarnedPoints() {
        return earnedPoints;
    }

    public List<Double> getAssignmentPercentage() {
        return assignmentPercentage;
    }



    /**
     *
     * @param pointTotal
     * @param earnedPoints
     * @param assignmentPercentage
     * @return
     */


    /** method to calculate total weighted grade */
    public void calculateTotalWeightedGrade()
    {
        for(int j=0;j<pointTotal.size();j++) {
            totalWeightedGrade = totalWeightedGrade + (earnedPoints.get(j) / pointTotal.get(j) * (assignmentPercentage.get(j) / DIVISOR) * DIVISOR);

        }
    }

    /**
     * Constructor method
     */
    public WeightedGrade() {

    }







    /** Usage of if and elseif to output the grade depending upon the totalWeightedScore

     * @return grade Calculate grade as char
     * */
    public void setgrade() {
        if (totalWeightedGrade >= 90 && totalWeightedGrade <=100) {
            grade = 'A';
        } else if (totalWeightedGrade >= 80 && totalWeightedGrade < 90) {
            grade = 'B';
        } else if (totalWeightedGrade >= 70 && totalWeightedGrade < 80) {
            grade = 'C';
        } else if (totalWeightedGrade >= 60 && totalWeightedGrade < 70) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    public char getGrade() {
        return grade;
    }
}





