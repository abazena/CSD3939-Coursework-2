package CLI.NearestNeighbor;

import Models.Digit;
import Utils.Utility;

import java.util.ArrayList;
import java.util.List;

public class NearestNeighborDriver {

    private ArrayList<Digit> digitsBank;
    public NearestNeighborDriver(List<Digit> digits)
    {
        this.digitsBank = new ArrayList<>(digits);
    }

    /**
     * @description getNearestNeighbor: this method classifies a digit against the training data
     * @param digit:Digit image/bitmap to classify
     * @return double: matching classifier class
     */
    public int getNearestNeighbor(Digit digit)
    {
        // var to store the min distance recorded || assign the distance to the first value in the training data-set for a starting point
        double minDistance = Utility.calculateDistance(digit, digitsBank.get(0));
        // var to store the class value for the min distance recorded
        int NearestNeighborClass = digitsBank.get(0).getDigitClass();

        // loop thru the training data-set
        for(Digit dgt : this.digitsBank)
        {
            //calculate the distance between the passed digit and the current index of the loop
            double newDistance = Utility.calculateDistance(digit, dgt);
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
