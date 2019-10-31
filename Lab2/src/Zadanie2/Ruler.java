package Zadanie2;

public class Ruler {

    public static void main(String[] args) {
        print(2, 5);
    }

    /**
     * Function manage the length of ruler,
     * it prepare variables,
     * and draw ruler with provided scale
     * @param length total number of cm to draw
     * @param deep the scale of ruler
     */
    public static void print(int length, int deep)
    {
        printLine(deep, deep);
        for (int j = 1; j <= length; j++) {
            printbeetwen(deep - 1, deep);
            printLine(deep, deep);
        }
    }

    /**
     * Controls how big interval is
     * @param Length current amount of dashes to draw
     * @param majorDeep maximum amount of dashes to draw
     */
    private static void printbeetwen(int Length, int majorDeep) {
        if (Length >= 1) {
        	
            printbeetwen(Length - 1, majorDeep);
            printLine(Length, majorDeep);
            printbeetwen(Length - 1, majorDeep);
            
        }
    }

    /**
     * draw current line with enough spaces
     * @param deep current amount of dashes to draw
     * @param majorDeep maximum amount of dashes to draw
     */
    public static void printLine(int deep, int majorDeep)
    {
        for (int j = 0; j < (majorDeep-deep); j++)
        {
            System.out.print(" ");
        }
        for (int j = 0; j < (deep*2); j++)
        {
            System.out.print("-");
        }
        
        System.out.print("\n");
    }
}
