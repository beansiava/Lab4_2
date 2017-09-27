import java.util.*;
import java.lang.*;
public class Main {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int milesPerGallon = 0;  //Must be a positive integer
        double tankCapacity = 0;  //Should be a double to allow decimal points
        double percentageFull = 0; //Should be a decimal between 0 and 1 (inclusive)
        int numIterations = 5;
        int iterations =0;
        while (iterations < numIterations) {
            try {

                System.out.print("Enter your car's MPG rating (miles/gallon) as a positive integer.");
                milesPerGallon = scnr.nextInt();

                if (milesPerGallon <= 0) {
                    throw new Exception("ERROR: ONLY POSITIVE INTEGERS ACCEPTED FOR MPG!!!");
                }

                System.out.println("Enter your car's tank capacity (gallons) as a positive decimal.");
                tankCapacity = scnr.nextDouble();

                if (tankCapacity <= 0.0) {
                    throw new Exception("ERROR: ONLY POSITIVE DECIMAL NUMBERS ACCEPTED FOR TANK CAPACITY!!!");
                }

                System.out.println("Enter percentage of gas tank that is currently filled (from 0 - 100%)");
                percentageFull = scnr.nextDouble();

                if ((percentageFull < 0) || (percentageFull > 100)) {
                    throw new Exception("ERROR: PERCENTAGE MUST BE A DECIMAL IN THE RANGE OF 0 - 100 (INCLUSIVE)!!!");
                }

            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
                return;
            }

            int rawRange = (int) Math.round(milesPerGallon * tankCapacity * (percentageFull * 0.01));

            if (rawRange <= 25) {
                System.out.println("Attention!  Your current estimate is running low: " + rawRange + " miles left!");
            } else {
                System.out.println("Keep driving!  Your current estimated range is: " + rawRange + " miles!");
            }
            iterations += 1;
        }
    }
}

