package edu.uoc.pac1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PAC1Ex3Test {

    private ByteArrayOutputStream outContent;
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testCalculateSalaryWithAbsoluteCPI() {

        //Profesor Lector 1
        assertEquals(32732, PAC1Ex3.calculateSalaryWithAbsoluteCPI(28000, 16.9));
        //Profesor Lector 2
        assertEquals(37408, PAC1Ex3.calculateSalaryWithAbsoluteCPI(32000, 16.9));
        //Profesor Lector 3
        assertEquals(40915, PAC1Ex3.calculateSalaryWithAbsoluteCPI(35000, 16.9));

        //Profesor Agregado 1
        assertEquals(42084, PAC1Ex3.calculateSalaryWithAbsoluteCPI(36000, 16.9));
        //Profesor Agregado 2
        assertEquals(46760, PAC1Ex3.calculateSalaryWithAbsoluteCPI(40000, 16.9));
        //Profesor Agregado 3
        assertEquals(52605, PAC1Ex3.calculateSalaryWithAbsoluteCPI(45000, 16.9));

        //Catedratico/Senior 1
        assertEquals(56112, PAC1Ex3.calculateSalaryWithAbsoluteCPI(48000, 16.9));
        //Catedratico/Senior 2
        assertEquals(61957, PAC1Ex3.calculateSalaryWithAbsoluteCPI(53000, 16.9));

        //Variant Profesor Lector 2
        assertEquals(32832, PAC1Ex3.calculateSalaryWithAbsoluteCPI(32000, 2.6));
        assertEquals(36032, PAC1Ex3.calculateSalaryWithAbsoluteCPI(32000, 12.6));
        assertEquals(32320, PAC1Ex3.calculateSalaryWithAbsoluteCPI(32000, 1));

        //ERRORS
        assertEquals(-32000, PAC1Ex3.calculateSalaryWithAbsoluteCPI(-32000, 1));
        assertEquals(32000, PAC1Ex3.calculateSalaryWithAbsoluteCPI(32000, -1.24));
    }

    @Test
    void testCalculateAccumulateCPI(){

        //CPI'12
        assertEquals(3, PAC1Ex3.calculateAccumulateCPI(0,0,0,11), 0.01);

        //CPI'13
        assertEquals(0.3, PAC1Ex3.calculateAccumulateCPI(1,0,1,11), 0.01);

        //CPI'14
        assertEquals(-0.9, PAC1Ex3.calculateAccumulateCPI(2,0,2,11), 0.01);

        //CPI'15
        assertEquals(0.09, PAC1Ex3.calculateAccumulateCPI(3,0,3,11), 0.01);

        //CPI'16
        assertEquals(1.5, PAC1Ex3.calculateAccumulateCPI(4,0,4,11), 0.01);

        //CPI'17
        assertEquals(1.1, PAC1Ex3.calculateAccumulateCPI(5,0,5,11), 0.01);

        //CPI'18
        assertEquals(1.1, PAC1Ex3.calculateAccumulateCPI(6,0,6,11), 0.01);

        //CPI'19
        assertEquals(0.8, PAC1Ex3.calculateAccumulateCPI(7,0,7,11), 0.01);

        //CPI'20
        assertEquals(-0.5, PAC1Ex3.calculateAccumulateCPI(8,0,8,11), 0.01);

        //CPI'21
        assertEquals(6.39, PAC1Ex3.calculateAccumulateCPI(9,0,9,11), 0.01);

        //CPI'22
        assertEquals(5.9, PAC1Ex3.calculateAccumulateCPI(10,0,10,5), 0.01);

        //CPI May'12 - May'22
        assertEquals(15.8, PAC1Ex3.calculateAccumulateCPI(0,4,10,4 ), 0.01);
    }

    @Test
    void testCalculateSalaryWithIntervalCPI() {
        assertEquals(37056, PAC1Ex3.calculateSalaryWithIntervalCPI(32000, 0, 4, 10, 4), 0.2);
    }

    @Test
    void testPrintSalaryInARange0() {
        PAC1Ex3.printSalaryInARange(32000, 0, 0);
        assertEquals("Year 2012, your salary should be 32960.00", outContent.toString().trim());
    }

    @Test
    void testPrintSalaryInARange1(){
        PAC1Ex3.printSalaryInARange(28000,0,0);
        assertEquals("Year 2012, your salary should be 28840.00", outContent.toString().trim());
    }

    @Test
    void testPrintSalaryInARange2() {
        PAC1Ex3.printSalaryInARange(32000, 0, 1);
        assertEquals("Year 2012, your salary should be 32960.00" + System.lineSeparator() +
                        "Year 2013, your salary should be 33058.88"
                , outContent.toString().trim());
    }

    @Test
    void testPrintSalaryInARange3(){
        PAC1Ex3.printSalaryInARange(28000,0,1);
        assertEquals("Year 2012, your salary should be 28840.00"+System.lineSeparator()+
        "Year 2013, your salary should be 28926.52", outContent.toString().trim());
    }

    @Test
    void testPrintSalaryInARange4(){
        PAC1Ex3.printSalaryInARange(32000,0,2);
        assertEquals("Year 2012, your salary should be 32960.00"+System.lineSeparator()+
                        "Year 2013, your salary should be 33058.88"+System.lineSeparator()+
                        "Year 2014, your salary should be 33058.88"
                , outContent.toString().trim());
    }

    @Test
    void testPrintSalaryInARange5(){
        PAC1Ex3.printSalaryInARange(32000,0,9);
        assertEquals("Year 2012, your salary should be 32960.00"+System.lineSeparator()+
                        "Year 2013, your salary should be 33058.88"+System.lineSeparator()+
                        "Year 2014, your salary should be 33058.88"+System.lineSeparator()+
                        "Year 2015, your salary should be 33091.94"+System.lineSeparator()+
                        "Year 2016, your salary should be 33588.32"+System.lineSeparator()+
                        "Year 2017, your salary should be 33957.79"+System.lineSeparator()+
                        "Year 2018, your salary should be 34331.33"+System.lineSeparator()+
                        "Year 2019, your salary should be 34605.98"+System.lineSeparator()+
                        "Year 2020, your salary should be 34605.98"+System.lineSeparator()+
                        "Year 2021, your salary should be 36820.76"
                , outContent.toString().trim());
    }

    @Test
    void testPrintSalaryInARange6(){
        PAC1Ex3.printSalaryInARange(32000,0,10);
        assertEquals("Year 2012, your salary should be 32960.00"+System.lineSeparator()+
                        "Year 2013, your salary should be 33058.88"+System.lineSeparator()+
                        "Year 2014, your salary should be 33058.88"+System.lineSeparator()+
                        "Year 2015, your salary should be 33091.94"+System.lineSeparator()+
                        "Year 2016, your salary should be 33588.32"+System.lineSeparator()+
                        "Year 2017, your salary should be 33957.79"+System.lineSeparator()+
                        "Year 2018, your salary should be 34331.33"+System.lineSeparator()+
                        "Year 2019, your salary should be 34605.98"+System.lineSeparator()+
                        "Year 2020, your salary should be 34605.98"+System.lineSeparator()+
                        "Year 2021, your salary should be 36820.76"+System.lineSeparator()+
                        "[ERROR] There was an error with printSalaryInARange"
                , outContent.toString().trim());
    }
}
