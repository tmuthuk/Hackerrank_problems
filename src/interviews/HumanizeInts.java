package interviews;

import java.math.BigInteger;
import java.util.HashMap;

public class HumanizeInts {
    static HashMap<BigInteger, String> stringMapping = new HashMap<>();
    public static void main(String[] args) {
    generateMapping();
        System.out.println(humanizeNumbers(BigInteger.valueOf(10126)));
        System.out.println(humanizeNumbers(BigInteger.valueOf(111_026_100)));
    }

    public static String humanizeNumbers(BigInteger number) {
        StringBuilder sb = new StringBuilder();

        if(number == null ||
                number.compareTo(BigInteger.valueOf(0)) < 0 ||
                number.compareTo(BigInteger.valueOf((long) Math.pow(10, 21))) > 0) return "";

        int power = 21;
        BigInteger base = BigInteger.valueOf((long) Math.pow(10, power));

        while(power>0) {
            if(number.compareTo(BigInteger.valueOf((long) Math.pow(10,power))) < 0) {
                power -= 3;
            } else{
                base = BigInteger.valueOf((long) Math.pow(10, power));
                break;
            }
        }


        while(base.compareTo(BigInteger.ZERO) > 0) {
            // 10026/1000
            // base = 100

            //10026/100
            BigInteger currentBase = number.divide(base); //=> 10


            if(number.compareTo(BigInteger.valueOf(100)) < 0) {
                currentBase = currentBase.multiply(base) ;
                sb.append(stringMapping.get(currentBase)); // ten
                sb.append(" ");
//                sb.append(stringMapping.get(base)); // thousand
            } else {
                if(currentBase.compareTo(BigInteger.valueOf(1000)) < 0) {
                    sb = breakCurrentBase(currentBase, BigInteger.valueOf(100), sb);
                } else {
                    sb.append(stringMapping.get(currentBase)); // ten
                    sb.append(" ");
                    sb.append(stringMapping.get(base)); // thousand
                    sb.append(" ");
                }
            }


            number = number.mod(base); //26 26/100 = 0

            int divideBy = 10;
            if(power>3) {power -= 3;
                base = base.divide(BigInteger.valueOf((long) Math.pow(10,power)));
            } else{power--;
                base = base.divide(BigInteger.valueOf(10));
            }
        }

        return sb.toString();
    }

    public static StringBuilder breakCurrentBase(BigInteger number, BigInteger base, StringBuilder sb) {

        while(base.compareTo(BigInteger.ZERO) > 0) {
            BigInteger currentBase = number.divide(base);
            currentBase = currentBase.multiply(base);
            sb.append(stringMapping.get(currentBase)); // ten
            sb.append(" ");
            base = base.divide(BigInteger.valueOf(10));
        }
        return sb;
    }
    // 111_026_100

    public static void generateMapping() {
        stringMapping.put(BigInteger.ZERO, "zero");
        stringMapping.put(BigInteger.ONE, "one");
        stringMapping.put(BigInteger.valueOf(2), "two");
        stringMapping.put(BigInteger.valueOf(3), "three");
        stringMapping.put(BigInteger.valueOf(4), "four");
        stringMapping.put(BigInteger.valueOf(5), "five");
        stringMapping.put(BigInteger.valueOf(6), "six");
        stringMapping.put(BigInteger.valueOf(10), "ten");
        stringMapping.put(BigInteger.valueOf(11), "eleven");
        stringMapping.put(BigInteger.valueOf(12), "twelve");
        stringMapping.put(BigInteger.valueOf(20), "twenty");
        stringMapping.put(BigInteger.valueOf(30), "thirty");
        stringMapping.put(BigInteger.valueOf(100), "hundred");
        stringMapping.put(BigInteger.valueOf(1000), "thousand");
        stringMapping.put(BigInteger.valueOf(1000_000), "million");
        stringMapping.put(BigInteger.valueOf(1000_000_000), "billion");
        //10 => "ten"
    }
}


/**
 1-9 one, two...



 10 , 20, 30, 40 twenty
 100
 1000
 million
 billion


 input : number -

 int 2^31
 long 2^64
 BigInteger

 null => ""
 -negative => ""
 num > 10^21 => ""

 10026 => 10 ten thousand

 // base 1000 => 10026 % 1000 = 26

 base/10 => 100 <SKIP MECHANISM>
 base/10 => 26  26/10 = 2* current base => 20  26%10 = 6 * 1

 20 -> map lookup



 base

 num > 10^21

 => base

 10026
 String Builder

 var number
 loop() {
 number / base => 1000



 base = base/10
 }
 */

/*
Your previous Ruby content is preserved below:

# We need to create a way to convert numeric values to humanized strings.
# We should be able to convert numbers up to one sextillion (10^21).

# Examples:
# converter(0) => "zero"
# converter(10026) => "ten thousand twenty six"

# Notes:
# Feel free to use the internet to look up technical details, but stick to official documentation.
# Your code should be tested to ensure that it meets the requirements.

# Reference:
# (10^3) => one thousand
# (10^6) => one million
# (10^9) => one billion
# (10^12) => one trillion
# (10^15) => one quadrillion
# (10^18) => one quintillion
# (10^21) => one sextillion
 */