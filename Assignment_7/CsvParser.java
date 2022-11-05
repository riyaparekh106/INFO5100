import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public CSVParser() {}

    public List<String> readFirstFiveLines(List<String> contents) {
        int i =0;
        List<String> firstFiveLines = new ArrayList<>();
        while(i < 5) {
            firstFiveLines.add(contents.get(i));
            i ++;
        }
        return firstFiveLines;
    }

    public List<String> parseFirstThreeColumns(List<String> contents) {
        List<String> tempList = new ArrayList<>();
        for (String line: contents) {
          String[] temp =  line.split(",");
          tempList.add(temp[0] + "," + temp[1] + "," + temp[2]);
        }
        return tempList;
    }
}