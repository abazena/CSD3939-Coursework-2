package CLI.NearestNeighbor;

import Models.Digit;

import java.util.ArrayList;
import java.util.List;

public class NearestNeighborDriver {

    private ArrayList<Digit> digitsBank;
    public NearestNeighborDriver(List<Digit> digits)
    {
        this.digitsBank = new ArrayList<>(digits);
    }

    /**
     * @description calculateDistance: this method calculates the Euclidean Distance between two images/bitmaps
     * @param digitOne:Digit image one/ bitmap one
     * @param digitTwo:Digit image two/ bitmap two
     * @return double: Euclidean Distance
     */
    private double calculateDistance(Digit digitOne, Digit digitTwo)
    {
        //local reference to the bitmaps from the digits passed
        int[] digitOneBitmap = digitOne.getBitmaps();
        int[] digitTwoBitmap = digitTwo.getBitmaps();

        //temp var to hold the distance
        double euclideanDistance = 0.0;

        //loop thru the arrays
        for(int i = 0; i < digitOneBitmap.length; i++)
        {
            //calculate distance using Euclidean Distance using Euclidean formula
            euclideanDistance += Math.sqrt( Math.pow((digitOneBitmap[i] - digitTwoBitmap[i]), 2));

        }
        return euclideanDistance;
    }

    /**
     * @description getNearestNeighbor: this method classifies a digit against the training data
     * @param digit:Digit image/bitmap to classify
     * @return double: matching classifier class
     */
    public int getNearestNeighbor(Digit digit)
    {
        // var to store the min distance recorded || assign the distance to the first value in the training data-set for a starting point
        double minDistance = this.calculateDistance(digit, digitsBank.get(0));
        // var to store the class value for the min distance recorded
        int NearestNeighborClass = digitsBank.get(0).getDigitClass();

        // loop thru the training data-set
        for(Digit dgt : this.digitsBank)
        {
            //calculate the distance between the passed digit and the current index of the loop
            double newDistance = this.calculateDistance(digit, dgt);
            // check if the new distance is less than the min distance recorded
            if(newDistance < minDistance)
            {
                minDistance = newDistance;
                NearestNeighborClass = dgt.getDigitClass();
            }
        }
        //return Nearest Neighbor Class
        return NearestNeighborClass;
    }
}
