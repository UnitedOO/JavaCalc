package com.work;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ksu on 10.09.2017.
 */
public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
     public void testSum(){
        int rez = calculator.funct_calc(1, 2, '+');
        assertEquals(3,rez );
    }

    @Test
    public void testMinus(){
        int rez = calculator.funct_calc(1, 2, '-');
        assertEquals(-1,rez );
    }

    @Test
    public void testMul(){
        int rez = calculator.funct_calc(2, 2, '*');
        assertEquals(4,rez );
    }

    @Test
    public void testDiv(){
        int rez = calculator.funct_calc(4, 2, '/');
        assertEquals(2,rez );
    }

 }