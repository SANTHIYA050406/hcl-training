import java.util.*;
public class MonthlyusageAnalyzer {
    static final int SLAB_1_LIMIT = 100;
    static final int SLAB_2_LIMIT = 300;
    static final double RATE_1 = 3.50;
    static final double RATE_2 = 5.00;
    static final double RATE_3 = 7.50;
    static double slabBill(int units) {
        if (units <= SLAB_1_LIMIT) {
            return units * RATE_1;
        } else if (units <= SLAB_2_LIMIT) {
            return SLAB_1_LIMIT * RATE_1 + (units - SLAB_1_LIMIT) * RATE_2;
        } else {
            return SLAB_1_LIMIT * RATE_1
                    + (SLAB_2_LIMIT - SLAB_1_LIMIT) * RATE_2
                    + (units - SLAB_2_LIMIT) * RATE_3;
        }
    }
    public static char grade(double avg){
        int realavg=(int)avg;
        if(realavg<=150){
            return 'A';
        } else if (realavg<=250) {
            return 'B';
        }
        else{
            return 'C';
        }
    }
    public static void displayDetails(int [] hMax,int[] hMin,double [] average1,double[] totalling,char[] grades){
        for(int i=0;i<3;i++){
            int h=i+1;
            System.out.println("house "+h +"'s maximum usage: "+hMax[i]);
            System.out.println("house"+h +"'s minimum usage: "+hMin[i]);
            System.out.println("house"+h+"'s average monthly usage: "+average1[i]);
            System.out.println("house"+h+"'s total bill: "+totalling[i]);
            System.out.println("house"+h+"'s grade: "+grades[i]);
        }
    }
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] HouseBills = new int[3][12];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 12; j++) {
                HouseBills[i][j] = sc.nextInt();
            }
        }
        int[] hMax = new int[3];
        int[] hMin = new int[3];
        double[] average1=new double[3];
        double [] totalling =new double[3];
        char [] grades= new char[3];


        long Total = 0;
        double avg = 0;
        double tolalBill=0;
        int max=0;
        int min=0;
        int n=0;
        for (int[] house : HouseBills) {
            Total=0;
            min = house[0];
            max = house[0];
            tolalBill=0 ;
            for (int i = 0; i < house.length; i++) {
                if (max < house[i]) {
                    max = house[i];
                }
                if (min > house[i]) {
                    min = house[i];
                }
                tolalBill += slabBill(house[i]);
                Total += house[i];
            }

            avg = (double) Total / 12;
            hMin[n] = min;
            hMax[n] = max;
            average1[n] = avg;
            totalling[n]=tolalBill;
            grades[n]=grade(avg);
            n++;
        }
        displayDetails(hMax,hMin,average1,totalling,grades);

    }

}
