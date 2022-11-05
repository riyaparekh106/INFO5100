import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
public class GUI extends JFrame {
    private JPanel contentPanel;
    private JTextField newfilename;
    private boolean buttonClicked = false ;
    private JTextArea printFive;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI frame = new GUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GUI() {}
    /**
     * Create the frame.
     */
    public void render() {
        FileOperations fileOperations = new FileOperations();
        CSVParser parser = new CSVParser();
        List<String> lines = fileOperations.readFile("annual.csv");
        List<String> parsedFiveLines = parser.readFirstFiveLines(lines);
        List<String> parsedThreeColumns = parser.parseFirstThreeColumns(lines);

        //
        setFont(new Font("Galvji", Font.PLAIN, 12));
        setTitle("CSV Reader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 511, 443);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPanel);
        getContentPane().setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Reading File name");
        lblNewLabel_1.setBounds(28, 28, 121, 16);
        contentPanel.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Annual.csv");
        lblNewLabel.setBounds(28, 56, 76, 16);
        contentPanel.add(lblNewLabel);

        JButton readbutton = new JButton("Click to read from file");
        JTextArea printfive;
        readbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reached here");
                for(String line : parsedFiveLines) {
                    printfive.append(line + "\n");
                }
            }
        });
        readbutton.setBounds(16, 84, 188, 29);
        contentPanel.add(readbutton);

        JLabel lblNewLabel_2 = new JLabel("First five lines of the file");
        lblNewLabel_2.setBounds(28, 125, 154, 16);
        contentPanel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Enter new file name");
        lblNewLabel_3.setBounds(297, 28, 143, 16);
        contentPanel.add(lblNewLabel_3);

        newfilename = new JTextField();
        newfilename.setBounds(294, 51, 130, 26);
        contentPanel.add(newfilename);
        newfilename.setColumns(10);

        JButton newfilebutton = new JButton("Click to write to new file");
        newfilebutton.setBounds(277, 84, 188, 29);
        contentPanel.add(newfilebutton);

        JLabel lblNewLabel_4 = new JLabel("first five lines of the new file");
        lblNewLabel_4.setBounds(277, 125, 204, 16);
        contentPanel.add(lblNewLabel_4);

        printfive = new JTextArea();
        System.out.println(parsedFiveLines.size());
        
        printfive.setEditable(false);
        printfive.setBounds(28, 153, 188, 183);
        contentPanel.add(printfive);

        JTextArea printnewfive = new JTextArea();
        printnewfive.setBounds(297, 153, 188, 175);
        System.out.println(parsedThreeColumns.size());
        for(String line: parsedThreeColumns){
            printnewfive.append(line + '\n');
        }
        contentPanel.add(printnewfive);
    }
}
