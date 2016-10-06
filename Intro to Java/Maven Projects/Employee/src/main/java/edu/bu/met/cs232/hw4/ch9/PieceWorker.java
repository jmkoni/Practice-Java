package edu.bu.met.cs232.hw4.ch9;

/**
 * PieceWorker
 * 10.14
 * Created by jmkoni on 3/2/16.
 *
 * Class PieceWorker extends Employee and represents an instance of an employee who
 * gets a certain amount per pieces made. Yearly earnings are calculated by multiplying
 * the number of pieces made by the wage per piece.
 */
public class PieceWorker extends Employee{
  private double wage;
  private int pieces;
  public PieceWorker(String firstName, String lastName,
                        String socialSecurityNumber, double wage, int pieces)
  {
    super(firstName, lastName, socialSecurityNumber);
    // implicit call to Object constructor occurs here
    // if grossSales is invalid throw exception
    if (wage < 0.0){
      throw new IllegalArgumentException("Hourly wage must be >= 0.0");
    }
    this.wage = wage;
    this.pieces = pieces;
  } // end constructor

  // set wage per piece
  public void setWage(double wage)
  {
    if (wage < 0.0) {
      throw new IllegalArgumentException("Wage per piece must be >= 0.0");
    }
    this.wage = wage;
  }

  // return wage per piece
  public double getWage()
  {
    return wage;
  }

  // set pieces made
  public void setPieces(int pieces)
  {
    if (pieces < 0) {
      throw new IllegalArgumentException("Pieces made must be greater than or equal to " +
          "zero.");
    }
    this.pieces = pieces;
  }

  // return pieces made
  public int getPieces()
  {
    return pieces;
  }

  // calculate earnings
  public double earnings()
  {
    return getPieces() * getPieces();
  }

  // return String representation of piece worker object
  @Override
  public String toString()
  {
    return String.format("%s %s%s: %.2f%n%s: %d%n", "piece worker",
        super.toString(), "wage per piece", getWage(), "pieces made",
        getPieces());
  }
}
