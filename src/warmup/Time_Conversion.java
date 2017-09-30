package warmup;

import java.util.Scanner;

public class Time_Conversion {
    static String timeConversion(String s) {

        // Complete this function
        String amPM = s.substring(s.length() - 2, s.length());
        String splits[] = s.split(":", 2);
        String hour = splits[0];
        int hourInt = Integer.parseInt(hour);
        if (amPM.equals("AM")) {
            if (hour.equals("12")) {
                hour = "00";
            }
        } else {
            if( hourInt < 12) {
                hourInt = 12 + hourInt;
                hour = String.valueOf(hourInt);
            }
        }

        // strip the AM/ PM
        splits[0] = hour;
        String finalHour = splits[0] + ":" + splits[1] ;

        return finalHour.substring(0, finalHour.length()-2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
