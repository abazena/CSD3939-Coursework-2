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

    private double calculateDistance(Digit digitOne, Digit digitTwo)
    {
        int[] digitOneBitmap = digitOne.getBitmaps();
        int[] digitTwoBitmap = digitTwo.getBitmaps();

        double euclideanDistance = 0.0;

        for(int y = 0; y < digitOneBitmap.length; y++)
        {
            int digitOneX = digitOneBitmap[y];
            //int digitOneY = digitOneBitmap[x][y];

            int digitTwoX = digitTwoBitmap[y];
            //int digitTwoY = digitTwoBitmap[x][y];

            euclideanDistance += Math.sqrt( Math.pow((digitOneX - digitTwoX), 2));

        }
        return euclideanDistance;
    }
    public int getNearestNeighbor(Digit digit)
    {
        double minDistance = this.calculateDistance(digit, digitsBank.get(0));
        int NearestNeighborClass = digitsBank.get(0).getDigitClass();


        for(Digit dgt : this.digitsBank)
        {
            double newDistance = this.calculateDistance(digit, dgt);
            if(newDistance < minDistance)
            {
                minDistance = newDistance;
                NearestNeighborClass = dgt.getDigitClass();
            }
        }
        return NearestNeighborClass;
    }
}
