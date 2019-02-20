package CLI.SimulatedAnnealing;

import Models.Digit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimulatedAnnealingDriver {

   /* private static double TEMPERATURE = 1000000;
    private static double COOLING_RATE = 0.0003;
    private static ArrayList<Digit> DIGITS_BANK = new ArrayList<>();



    private void GetClosestMatch () throws IOException {

       // ArrayList<City> cities = new ArrayList<>(loadDataTxtFile());
        //Collections.shuffle(cities , new Random(100));
       // Route currentRoute = new Route(cities);
       // currentRoute.generateRandomRoute();

        Digit currentDigit = DIGITS_BANK.get(0);


        //Route optimalRoute = new Route(currentRoute.getCities());

        Digit optimalDigit = DIGITS_BANK.get(0);

        while (TEMPERATURE > 1){

            Digit newOptimalDigit = currentDigit;


            Route newOptimalRoute = new Route(currentRoute.getCities());


            int cityOneIndex = randomIntInRange(0 , newOptimalRoute.getCities().size() -1);
            int cityTwoIndex = randomIntInRange(0 , newOptimalRoute.getCities().size() -1);

            while (cityOneIndex == cityTwoIndex)cityTwoIndex = randomIntInRange(0 , newOptimalRoute.getCities().size() -1);

            City cityOne = newOptimalRoute.getCities().get(cityOneIndex);
            City cityTwo = newOptimalRoute.getCities().get(cityTwoIndex);

            newOptimalRoute.getCities().set(cityTwoIndex , cityOne);
            newOptimalRoute.getCities().set(cityOneIndex , cityTwo);

            newOptimalRoute.calculateTotalDistance();

            double initRouteDistance = currentRoute.getTotalDistance();
            double newRouteDistance = newOptimalRoute.getTotalDistance();
            double randomDouble = randomDoubleInRange();
            if(calculateAcceptanceProbability(initRouteDistance, newRouteDistance , temperature) > randomDouble){
                currentRoute = new Route(newOptimalRoute.getCities());
            }
            if(newOptimalRoute.getTotalDistance() < optimalRoute.getTotalDistance()){
                optimalRoute = new Route(newOptimalRoute.getCities());
            }
            TEMPERATURE *= 1 - COOLING_RATE;
        }
        Main.addSolution(optimalRoute);

    }
    private static double calculateAcceptanceProbability(double currentDistance, double newDistance , double temperature){
        if(newDistance < currentDistance)
            return 1.0;
        return Math.exp((currentDistance - newDistance) / temperature);
    }
    private static double randomDoubleInRange(){
        return new Random().nextInt(1000 )/ 1000.0;
    }
    private static int randomIntInRange(int min , int max){
        if(min > max){
            throw new IllegalArgumentException("max must be greater than min");
        }
        return new Random().nextInt((max - min) + 1) + min;
    }
    private static ArrayList<City> loadData()throws IOException {
        HttpLoader httpRequest = new HttpLoader();
        String url = "http://www.cwa.mdx.ac.uk/csd3939/coursework/test2atsp.txt"; //getStrInput();
        // String data = httpRequest.makeRequest(url , "UTF-8");
        Parser parser = new Parser();
        String data =  parser.loadTxt("datasets/dataset3.txt" , UTF_8);
        String[][] dataset = parser.parseArray2D(data , " ");
        ArrayList<City> cities = new ArrayList<>();
        for (String[] anArray : dataset) {
            double x = Double.parseDouble(anArray[1]);
            double y = Double.parseDouble(anArray[2]);
            cities.add(new City(x , y , anArray[0]));
        }
        return cities;
    }

    @Override
    public void run() {
        try {
            this.SimulatedAnnealingLogic();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ArrayList<City> loadDataTxtFile() throws IOException {
        Parser parser = new Parser();
        String  data = parser.loadTxt("datasets/dataset.txt" , UTF_8);
        String[][] dataset = parser.parseArray2D(data , " ");
        ArrayList<City> cities = new ArrayList<>();
        for (String[] anArray : dataset) {
            double x = Double.parseDouble(anArray[1]);
            double y = Double.parseDouble(anArray[2]);
            cities.add(new City(x , y , anArray[0]));
        }
        return cities;

    }
*/
}
