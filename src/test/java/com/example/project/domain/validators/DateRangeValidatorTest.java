package com.example.project.domain.validators;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.ConstraintValidatorContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
/**
 * DateRangeValidatorTest
 */

@RunWith(MockitoJUnitRunner.class)
public class DateRangeValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;


    @InjectMocks
    DateRangeValidator dateRangeValidator;


    // @Before
    // public void setUp() {
    //     dateRangeValidator = new DateRangeValidator();
    // }
    
    @Test
    public void should_NotBeValid_When7DaysBack() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -8);
        assertFalse(dateRangeValidator.isValid(date.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_When7DaysAfter() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, +8);
        assertFalse(dateRangeValidator.isValid(date.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenIsNull() {
        assertFalse(dateRangeValidator.isValid(null, constraintValidatorContext));
    }

    @Test
    public void should_BeValidToday() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, 0);
        assertTrue(dateRangeValidator.isValid(date.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValidWhenNot7DaysAfter() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, +7);
        assertTrue(dateRangeValidator.isValid(date.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValidWhenNot7DaysBefore() {
        Calendar date = Calendar.getInstance();
        date.add(Calendar.DAY_OF_MONTH, -6);
        assertTrue(dateRangeValidator.isValid(date.getTime(), constraintValidatorContext));
    }
}