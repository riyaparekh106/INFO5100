/*
Name - Riya Ketan Parekh
Class - Section 8
Lab# - 3
 */

public class WeightedGradeIfElse {
    private final int DIVISOR = 100;
    char grade;


    /**
     * Constructor method
     */
    public WeightedGradeIfElse() {

    }

    /**
     *
     * @param pointTotal
     * @param earnedPoints
     * @param assignmentPercentage
     * @return
     */
    public double updateTotalWeightedScore(double pointTotal, double earnedPoints, double assignmentPercentage) {
        double result = (earnedPoints / pointTotal * (assignmentPercentage / DIVISOR) * DIVISOR);
        return result;
    }

    /** Usage of if and elseif to output the grade depending upon the totalWeightedScore
     * @param finalGrade Takes calculated double value as param.
     * @return grade Calculate grade as char
     * */
    public char getTotalWeightGrade(double finalGrade) {
        char grade;
        if (finalGrade >= 90 && finalGrade <=100) {
            grade = 'A';
        } else if (finalGrade >= 80 && finalGrade < 90) {
            grade = 'B';
        } else if (finalGrade >= 70 && finalGrade < 80) {
            grade = 'C';
        } else if (finalGrade >= 60 && finalGrade < 70) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        return grade;
    }
}




