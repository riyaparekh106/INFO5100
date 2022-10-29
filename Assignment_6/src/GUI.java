import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUI extends JFrame {   /** GUI class is initialised **/

public void run() {
    JTextField tf1, tf2, tf3, tf4;
    JLabel l1, l2, l3;
    JFrame f = new JFrame();    /** Creating the frame **/
    JPanel panel = new JPanel();
    panel.setBounds(40, 80, 300, 400);
    panel.setBackground(Color.gray);
    l1 = new JLabel(" Point Total: ");
    l1.setBounds(50, 80, 100, 30);
    tf1 = new JTextField();
    tf1.setBounds(50, 120, 150, 20);
    l2 = new JLabel(" Earned Point: ");
    l2.setBounds(50, 150, 100, 30);
    tf2 = new JTextField();
    tf2.setBounds(50, 200, 150, 20);
    l3 = new JLabel(" Assignment Percentage: ");
    l3.setBounds(50, 250, 200, 30);
    tf3 = new JTextField();
    tf3.setBounds(50, 300, 150, 20);

    JButton b1 = new JButton("Calculate Score");   /** Creating a button **/
    b1.setBounds(50, 350, 200, 30);
    b1.setBackground(Color.yellow);
    panel.add(b1);

    tf4 = new JTextField();
    tf4.setBounds(50, 400, 100, 20);

    b1.addActionListener(new ActionListener() {    // taking the input from user
        @Override
        public void actionPerformed(ActionEvent e) {
            WeightedGrade wg = new WeightedGrade();
            double pointTotal, earnedPoints, assignmentPercentage;
            pointTotal = Double.parseDouble(tf1.getText());
            wg.setPointTotal(pointTotal);
            earnedPoints = Double.parseDouble(tf2.getText());
            wg.setEarnedPoints(earnedPoints);
            assignmentPercentage = Double.parseDouble(tf3.getText());
            wg.setAssignmentPercentage(assignmentPercentage);
            double weightedGrade = wg.getTotalWeightedGrade();

            tf4.setText(Double.toString(weightedGrade));

        }
    });


    f.add(l1);
    f.add(l2);
    f.add(l3);
    f.add(tf1);
    f.add(tf2);
    f.add(tf3);
    f.add(tf4);
    f.add(b1);
    f.add(panel);
    f.setSize(300, 300);
    f.setLayout(null);
    f.setVisible(true);

}
}

