/*
Name - Riya Ketan Parekh
Class - Section 8
Lab# - 6
 */


import java.util.Scanner;

/**
 * Java program to calculate Weighted Grade where Point Total, Earned Points and
 * Assignment percentage is taken from user and then Total Weight Grade is calculated
 */

public class WeightedGrade {         /** Class header is initialised */
private double pointTotal;       /** @param pointTotal to let the users input the value of pointTotal */
private double earnedPoints;     /** @param earnedPoints to let the users input the value of earnedPoints */
private double assignmentPercentage; /** @param assignmentPercentage to let the users input the value of assignmentPercentage */
private double totalWeightedGrade; /** @param totalWeightedGrade to calculate  */
private final int DIVISOR = 100;


    public void setPointTotal(double pointTotal) {
        this.pointTotal = pointTotal;
    } /** Setters methods takes a parameter and assigns it to the attribute */
    public void setEarnedPoints(double earnedPoints) {
        this.earnedPoints = earnedPoints;
    }
    public void setAssignmentPercentage(double assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }

    /** Getter methods are used to return the value of the attribute **/
    public double getPointTotal() {
        return pointTotal;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }

    public double getAssignmentPercentage() {
        return assignmentPercentage;
    }

    /** Formula to calculate the Total Weighted Grade */
    public double getTotalWeightedGrade() {
        totalWeightedGrade = (earnedPoints / pointTotal * (assignmentPercentage / DIVISOR) * DIVISOR);
        return totalWeightedGrade;
    }

    public WeightedGrade() {}   /** Constructor method */

}

