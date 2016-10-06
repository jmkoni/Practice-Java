package edu.bu.met.cs232.hw5.ch7;

/**
 * Created by jmkoni on 4/2/16.
 *
 * Use a one-dimensional array to solve the following problem: A company pays its
 * salespeople on a commission basis. The salespeople receive $200 per week plus 9% of
 * their gross sales for that week. For example, a salesperson who grosses $5,000 in
 * sales in a week receives $200 plus 9% of $5,000, or a total of $650. Write an
 * application (using an array of counters) that determines how many of the salespeople
 * earned salaries in each of the following ranges (assume that each salesperson’s
 * salary is truncated to an integer amount):
 * a) $200-299
 * b) $300-399
 * c) $400-499
 * d) $500-599
 * e) $600-699
 * f) $700-799
 * g) $800-899
 * h) $900-999
 * i) $1,000 and over
 *
 * Summarize the results in tabular format.
 */
public class SalesCommissions {
  private int[] weeklySales;
  private int[] weeklyEarnings;
  private int[] frequency;
  public SalesCommissions(){
    this(new int[] {1002839, 78293, 300, 3958, 98293, 120, 8273, 800,
        923, 1000, 2000, 400, 683, 987, 45692, 82938, 82739, 923853, 500});
  }

  public SalesCommissions(int[] weeklySales){
    this.weeklySales = weeklySales;
    this.weeklyEarnings = calculateAllWeeklyEarnings(this.weeklySales);
    this.frequency = determineFrequency(this.weeklyEarnings);
  }

  public int[] getFrequency(){
    return this.frequency;
  }

  public int[] getWeeklyEarnings(){
    return this.weeklyEarnings;
  }

  public int[] getWeeklySales(){
    return this.weeklySales;
  }

  public int calculateWeeklyEarnings(int sales){
    return (int) (200 + (0.9 * sales));
  }

  public int[] calculateAllWeeklyEarnings(int[] weeklySales){
    int[] weeklyEarnings = new int[weeklySales.length];
    for(int i = 0; i < weeklySales.length; i++){
      weeklyEarnings[i] = calculateWeeklyEarnings(weeklySales[i]);
    }
    return weeklyEarnings;
  }

  public int[] determineFrequency(int[] weeklyEarnings){
    int[] frequency = new int[9];
    for (int currentEarnings:weeklyEarnings) {
      if(currentEarnings < 299){
        ++frequency[0];
      } else if (currentEarnings < 399){
        ++frequency[1];
      } else if (currentEarnings < 499){
        ++frequency[2];
      } else if (currentEarnings < 599){
        ++frequency[3];
      } else if (currentEarnings < 699){
        ++frequency[4];
      } else if (currentEarnings < 799){
        ++frequency[5];
      } else if (currentEarnings < 899){
        ++frequency[6];
      } else if (currentEarnings < 999){
        ++frequency[7];
      } else {
        ++frequency[8];
      }
    }
    return frequency;
  }

  public void displayData(int[] frequency){
    String[] freqAmounts = new String[] {"$200-299", "$300-399", "$400-499",
        "$500-599", "$600-699", "$700-799", "$800-899", "$900-999", ">=$1,000"};
    System.out.println("Amount        Number of Salespeople");
    System.out.println("-----------|-----------------------");
    for (int i = 0; i < 9; i++) {
      System.out.printf("%s             %d%n", freqAmounts[i], frequency[i]);
    }
  }
}
