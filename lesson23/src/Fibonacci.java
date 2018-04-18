import adt.Map;
import impl.LLQHashTableMap;
public class Fibonacci {

    /////////////////////////
    // Version One
    /////////////////////////

    private static int callCount1;

    public static long fibCalc1(int n) {
        if(n == 0 ||n == 1) return n;
        callCount1++;
        return fibCalc1(n-1) + fibCalc1(n-2);
    }


    public static void testFibCalc1(int n) {
        callCount1 = 0;
        System.out.println("fibCalc1("+n+") = " + fibCalc1(n) +
                "; takes " + callCount1 + " calls.");
    }

    /////////////////////////
    // Version Two
    /////////////////////////

    private static int callCount2;
    private static Map<Integer, Long> ansMap = new LLQHashTableMap(10);



    public static long fibCalc2(int n) {
        if(n == 0 ||n == 1) return n;
        if(ansMap.getSize() <= 2){
            ansMap.define(0, (long) 0);
            ansMap.define(1, (long) 1);
        }
        long tempVal1, tempVal2;
        try {
            long temp = ansMap.remove(n);
            ansMap.define(n, temp);
        } catch (Exception ex){

            try {
                long temp = ansMap.remove(n-1);
                ansMap.define(n, temp);
                tempVal1 = ansMap.getValue(n-1);
            } catch (Exception ex1){
                tempVal1 = fibCalc2(n-1);
            }
            try {
                long temp = ansMap.remove(n-2);
                ansMap.define(n, temp);
                tempVal2 = ansMap.getValue(n-2);
            } catch (Exception ex1){
                tempVal2 = fibCalc2(n-2);
            }
            ansMap.define(n, tempVal1+tempVal2);
        }
        callCount2++;
        System.out.println(ansMap.getValue(n));
        return ansMap.getValue(n);
    }


    public static void testFibCalc2(int n) {
        callCount2 = 0;

        System.out.println("fibCalc2("+n+") = " + fibCalc2(n) +
                "; takes " + callCount2 + " calls.");
    }

    ///////////

    public static void main(String[] args) {

//        for (int x = 0; x < 30; x++) {
//            testFibCalc1(x);
//        }

        for (int x = 3; x < 30; x++) {
            try{
                testFibCalc2(x);
            } catch (Exception ex){
                ex.printStackTrace();
            }

        }

    }
}