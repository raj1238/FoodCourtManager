package com.example.interview.service.comparator;

import com.example.interview.models.Weekday;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class WeekdayComparatorBuilderTest {


    @Test
    public void buildSalesComparator() {
        Comparator<Weekday> comparator = WeekdayComparatorBuilder.buildSalesComparator();
        Weekday weekday = Weekday.fromValue("MONDAY");
        weekday.addTotalSaleAmount(100);
        Weekday weekday1 = Weekday.fromValue("TUESDAY");
        weekday1.addTotalSaleAmount(2100);
        assertEquals(1,comparator.compare(weekday,weekday1));
    }

    @Test
    public void buildOrderComparator() {
        Comparator<Weekday> comparator = WeekdayComparatorBuilder.buildOrderComparator();
        Weekday weekday = Weekday.fromValue("MONDAY");
        weekday.addTotalOrders(300);
        Weekday weekday1 = Weekday.fromValue("TUESDAY");
        weekday1.addTotalOrders(2100);
        assertEquals(1,comparator.compare(weekday,weekday1));
    }
}