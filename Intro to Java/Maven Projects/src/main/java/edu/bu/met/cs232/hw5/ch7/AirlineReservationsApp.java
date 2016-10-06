package edu.bu.met.cs232.hw5.ch7;


/**
 * Application to test AirlineReservations
 *
 */
public class AirlineReservationsApp
{
    public static void main( String[] args )
    {
//      Scanner input = new Scanner(System.in);
//      AirlineReservations currentFlight = new AirlineReservations();
//      boolean stillActive = true;
//      while(stillActive){
//        stillActive = currentFlight.welcomeScreen(input);
//      }
      divide(2,0);
    }
  public static void divide(int i, int j) {
    try {
      int c = i / j; } catch(Exception e) {
      System.out.println("Exception thrown!"); } finally {
      System.out.println("and finally, I am done...");
    } }
}
