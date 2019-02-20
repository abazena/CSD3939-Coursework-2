package CLI;

import CLI.NearestNeighbor.NearestNeighborDriver;
import Models.Digit;
import Utils.Parser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String args[]) throws IOException
    {
        ArrayList<Digit> dataSet = new ArrayList<>(loadDataSet("DataSets/DataSet1.csv"));

        int halfSize = dataSet.size() /2;

        NearestNeighborDriver nearestNeighborDriver = new NearestNeighborDriver(dataSet);

        ArrayList<Digit> testingDataSet = new ArrayList<>(loadDataSet("DataSets/DataSet2.csv"));


        int matches = 0;
        for(int i = 0; i <testingDataSet.size() ; i++)
        {
            int digitClass = nearestNeighborDriver.getNearestNeighbor(testingDataSet.get(i));

            System.out.println("Nearest Neighbor: actual digit class: " +testingDataSet.get(i).getDigitClass() + " result digit class: " + digitClass );//digitClass
            if(testingDataSet.get(i).getDigitClass()  == digitClass)
            {
                matches++;
            }
            if(i == testingDataSet.size() -1)
            {
                double accuracy = (matches / i - 1) ;
                System.out.println("Accuracy: " + accuracy );
                System.out.println("Size: " + i);
                System.out.println("Matches: " + (matches - 1));

            }
        }
    }


    private static ArrayList<Digit> loadDataSet(String path) throws IOException {
        Parser parser = new Parser();
        String rawDataSet = parser.loadFile(path , Charset.defaultCharset());

        if(rawDataSet == null)
        {
            throw new IOException();
        }

        List<List<String>> data = parser.parseString(rawDataSet , ",");
        ArrayList<Digit> dataSet = new ArrayList<>();

        for (int i = 0; i< data.size() ; i++)
        {
            dataSet.add( new Digit(data.get(i).get(data.get(i).size()-1) , data.get(i) ) );
        }
        return dataSet;
    }
}
//99.45612401664513