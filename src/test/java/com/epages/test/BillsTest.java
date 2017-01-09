/*
 * @Author	:	Nana O. Baah
 * @Project	:	Rent and Energy Reminder
 * @Date	:	8-Nov-2016
 */

package com.epages.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.epages.bills.BillsReminder;

public class BillsTest {

	private BillsReminder rentBill;
	private BillsReminder waterBill;
	private LocalDate dateTest;

	@Before
	public void setUp() throws Exception {
		rentBill = new BillsReminder();
		waterBill = new BillsReminder();
		dateTest = LocalDate.now();
	}

	@Test
	public void canValidateDate() throws Exception {
		int output = rentBill.weekendValidation(dateTest, 2);
		System.out.println(output);
		assertEquals(output, dateTest.getDayOfMonth());
	}

	@Test
	public void canPayOnDate() throws Exception {
		rentBill.billsPaymentDates(-1, -2);
		List<Integer> output = new ArrayList<Integer>(Arrays.asList(30, 30, 31, 28, 31, 28, 31, 30, 31, 31, 29, 31));
		assertEquals(output, rentBill.getPaymentList());

		// Pay water bills on the 15th of every month and if it falls on a
		// weekend, pay it on the next Monday.
		waterBill.billsPaymentDates(15, 1);
		List<Integer> output1 = new ArrayList<Integer>(Arrays.asList(15, 15, 16, 15, 15, 17, 15, 15, 17, 15, 15, 16));
		assertEquals(output1, waterBill.getPaymentList());

	}

}
