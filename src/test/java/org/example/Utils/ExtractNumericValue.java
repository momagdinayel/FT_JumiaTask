package org.example.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumericValue {
    public static void numericValue( String originalText) {
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(originalText);
        if (matcher.find()) {
            String numericValue = matcher.group();
            double numericDouble = Double.parseDouble(numericValue);
            double result = numericDouble * 2;
            System.out.println("Original Text: " + originalText);
            System.out.println("Numeric Value: " + numericDouble);
            System.out.println("Result of Calculation: " + result);
        } else {
            System.out.println("No numeric value found in the text.");
        }
    }
}
