package com.csc;

import org.junit.jupiter.api.BeforeEach;

public class TestPayroll {

  Payroll payroll;

  @BeforeEach
  void setUp() {
    payroll = new Payroll();
  }

  @Test
  public void testOne(){
    payroll.callMenu();
  }
  // Add your tests here
}
