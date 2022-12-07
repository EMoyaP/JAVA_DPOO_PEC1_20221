package edu.uoc.pac1;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PAC1Ex3 {

    static DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("EN"));
    static DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);

    static final int FIRST_YEAR = 2012;

    static double[][] evolutionCPI = {
            //Jan'12 - Dec'12
            {-1.1,0.1,0.7,1.4,-0.1, -0.2, -0.2, 0.6, 1, 0.8, -0.1, 0.1},
            //Jan'13 - Dec'13
            {-1.3, 0.2, 0.4, 0.4, 0.2, 0.1, -0.5, 0.3, -0.2, 0.4, 0.2, 0.1},
            //Jan'14 - Dec'14
            {-1.3, 0, 0.2, 0.9, 0, 0, -0.9, 0.2, 0.2, 0.5, -0.1, -0.6},
            //Jan'15 - Dec'15
            {-1.6, 0.2, 0.6, 0.9, 0.5, 0.3, -0.9, -0.3, -0.3, 0.6, 0.4, -0.3},
            //Jan'16 - Dec'16
            {-1.9, -0.4, 0.6, 0.7, 0.5, 0.5, -0.7, 0.1, 0, 1.1, 0.4, 0.6},
            //Jan'17 - Dec'17
            {-0.5, -0.4, 0, 1, -0.1, 0, -0.7, 0.2, 0.2, 0.9, 0.5, 0},
            //Jan'18 - Dec'18
            {-1.1, 0.1,0.1,0.8,0.9,0.3,-0.7,0.1,0.2,0.9,-0.1,-0.4},
            //Jan'19 - Dec'19
            {-1.3,0.2,0.4,1,0.2,-0.1,-0.6,-0.1,0,1,0.2,-0.1},
            //Jan'20 - Dec'20
            {-1,-0.1,-0.4,0.3,0,0.5,-0.9,0,0.2,0.5,0.2,0.2},
            //Jan'21 - Dec'21
            {0,-0.6,1,1.2,0.5,0.5,-0.8,0.5,0.8,1.8,0.3,1.2},
            //Jan'22 - Jun'22
            {-0.4,0.8,3,-0.2,0.8,1.9}
    };

    public static double calculateSalaryWithAbsoluteCPI(double salary, double absoluteCPI) {
        //TODO
        double rateOfChange = absoluteCPI/100;

        if (salary <= 0 || absoluteCPI <= 0) {
            return salary;
        } else {
            double salaryWithAbsoluteCPI = salary * (1 + rateOfChange);
            return salaryWithAbsoluteCPI;
        }
    }

    public static double calculateAccumulateCPI(int firstYear, int monthFirstYear, int secondYear, int monthSecondYear){
        //TODO


        if (firstYear < 0 || secondYear > evolutionCPI.length) {
            return -1;
        } else if (firstYear > secondYear) {
            return -1;
        } else if (firstYear == secondYear && monthFirstYear > monthSecondYear) {
            return -1;
        } else if ((monthFirstYear >= evolutionCPI[firstYear].length) || (monthSecondYear >= evolutionCPI[secondYear].length)) {
            return -1;
        } else {
            int year = firstYear;
            int month = monthFirstYear;
            double accumulateCPI = 0.0;

            while (year < secondYear) {
                accumulateCPI += evolutionCPI[year][month];
                if (month < evolutionCPI[year].length - 1) {
                    month++;
                } else {
                    year++;
                    month = 0;
                }
            }

            for (int i = 0; i <= monthSecondYear; i++) {
                accumulateCPI += evolutionCPI[secondYear][i];
            }
            return accumulateCPI;
        }

    }

    public static double calculateSalaryWithIntervalCPI(double salary, int firstYear, int monthFirstYear, int secondYear, int monthSecondYear){
       //TODO
        double accumulateCPI = calculateAccumulateCPI(firstYear, monthFirstYear, secondYear, monthSecondYear);
        double salaryWithIntervalCPI = calculateSalaryWithAbsoluteCPI(salary, accumulateCPI);

        return salaryWithIntervalCPI;
    }

    public static void printSalaryInARange(double salary, int firstYear, int secondYear){
       //TODO
        double salaryWithCPI = salary;
        int sizeYear = 12;

        for (int i = firstYear; i <= secondYear; i++) {
            if (evolutionCPI[i].length < sizeYear) {
                System.out.println("[ERROR] There was an error with printSalaryInARange");
            } else {
                int year = FIRST_YEAR + i;

                salaryWithCPI = calculateSalaryWithIntervalCPI(salaryWithCPI, i, 0, i, 11);
                System.out.println("Year " + year + ", your salary should be " + decimalFormat.format(salaryWithCPI));
            }
        }
    }

}
