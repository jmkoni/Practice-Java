//package edu.bu.met.cs232.hw4.ch10;
//
//import java.time.LocalDateTime;
//
///**
// * Created by jmkoni on 2/27/16.
// * Left this class in since I did some work on it and tested it. Not in use though...
// */
//// Fig. 8.7: Date.java
//// Date class declaration.
//public class Date {
//  private int month; // 1-12
//  private int day; // 1-31 based on month
//  private int year; // any year
//
//  private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
//      31, 30, 31 };
//
//  // constructor: confirm proper value for month and day given the year
//  public Date(int month, int day, int year){
//    // check if month in range
//    if (month <= 0 || month > 12) {
//      throw new IllegalArgumentException("month (" + month + ") must be 1-12");
//    }
//
//    // check if day in range for month
//    if (day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
//      throw new IllegalArgumentException("day (" + day + ") out-of-range for the " +
//          "specified month and year");
//    }
//
//    // check for leap year if month is 2 and day is 29
//    if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 !=
//        0))){
//      throw new IllegalArgumentException("day (" + day + ") out-of-range for the " +
//          "specified month and year");
//    }
//
//    this.month = month;
//    this.day = day;
//    this.year = year;
//  }
//
//  public int getMonth(){
//    return month;
//  }
//
//  public int getDay(){
//    return day;
//  }
//
//  public int getYear(){
//    return year;
//  }
//  // return a String of the form month/day/year
//  public String toString(){
//    return String.format("%d/%d/%d", month, day, year);
//  }
//
//  public static Date today(){
//    LocalDateTime current = LocalDateTime.now();
//    return new Date(current.getMonthValue(), current.getDayOfMonth(), current.getYear());
//  }
//
//  public boolean equals(Date otherDate){
//    if (this.getMonth() == otherDate.getMonth() && this.getDay() == otherDate.getDay()
//        && this.getYear() == otherDate.getYear()){
//      return true;
//    } else {
//      return false;
//    }
//  }
//} // end class Date
