/*
 * @Author	:	Nana O. Baah
 * @Project	:	Rent and Energy Reminder
 * @Date	:	8-Nov-2016
 */

package com.epages.bills;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BillsReminder {
	private List<Integer> paymentList;
	private LocalDate date;
	private static final int MONTHS = 12;

	public BillsReminder() {
		paymentList = new ArrayList<Integer>(12);
		date = LocalDate.now();
	}

	public List<Integer> getPaymentList() {
		return paymentList;
	}

	public void billsPaymentDates(int day, int firstWeekendDay) {

		for (int month = 0; month < MONTHS; month++) {
			LocalDate tempDate = date.plusMonths(month);
			tempDate = (day == -1) ? tempDate.withDayOfMonth(tempDate.lengthOfMonth()) : tempDate.withDayOfMonth(day);
			paymentList.add(weekendValidation(tempDate, firstWeekendDay));
		}
	}

	public int weekendValidation(LocalDate date, int weekendStart) {

		int weekEnd = weekendStart + 1;

		if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
			return date.plusDays(weekendStart).getDayOfMonth();
		} else if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
			return date.plusDays(weekEnd).getDayOfMonth();
		}
		return date.getDayOfMonth();
	}
}
