package com.codingdojo.gotnxt.constraints;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PresentOrFutureDateValidator implements ConstraintValidator<DatePresentOrFuture, Date> {

	@Override
	public void initialize(DatePresentOrFuture date) {

	}

	@Override
	public boolean isValid(Date EventDate, ConstraintValidatorContext context) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(new Date());
		Date todaysDate = null;
		try {
			todaysDate = formatter.parse(dateString);
		} catch (Exception e1) {
			return false;
		}
		System.out.println("This Is Today's Date:" + todaysDate);
		System.out.println("This Is Entered Date:" + EventDate);
		try {
			if (EventDate.equals(todaysDate) || EventDate.after(todaysDate)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
		}
		return false;
	}
}
