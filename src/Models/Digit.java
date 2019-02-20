package Models;
import java.util.Arrays;
import java.util.List;

public class Digit {

    private int digitClass;

    private int[] bitmaps;

    public Digit(String actualValue, List<String> bitmaps)
    {
        this.digitClass = Integer.parseInt(actualValue);
        this.bitmaps = parseBitmaps(bitmaps);
    }

    private int[] parseBitmaps(List<String> bitmaps)
    {
        int[] bitmapsTable = new int[bitmaps.size()];


        for(int i = 0; i< bitmaps.size(); i++)
        {

          bitmapsTable[i] = Integer.parseInt(bitmaps.get(i));

        }



        return bitmapsTable;
    }

    public int getDigitClass()
    {
        return digitClass;
    }

    public int[] getBitmaps()
    {
        return bitmaps;
    }

    public void printDigit()
    {
        System.out.println("bitmaps: " + Arrays.toString(bitmaps));
        System.out.println("Actual Value: " + digitClass);

    }
}
