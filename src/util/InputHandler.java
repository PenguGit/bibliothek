package util;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
	
	public ArrayList<Integer> extractNumbers(String input) {
        ArrayList<Integer> extracted = new ArrayList<>();
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            extracted.add(number);
        }
        return extracted;
    }
}
