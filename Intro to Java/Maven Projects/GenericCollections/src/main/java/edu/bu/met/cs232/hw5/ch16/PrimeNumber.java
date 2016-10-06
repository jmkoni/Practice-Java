package edu.bu.met.cs232.hw5.ch16;

import java.util.HashSet;
import java.util.Set;

/**
 * PrimeNumber
 * 16.19
 * Created by jmkoni on 3/31/16.
 *
 * Write a program that takes a whole number input from a user and determines whether
 * it's prime. If the number is not prime, display it's unique prime factors. Remember
 * that a prime number's factors are only 1 and the number itself. Every number that's
 * not prime has a unique prime factorization. For example, consider the number 54. The
 * prime factors of 54 are 2, 3, 3, and 3. When the values are multiplied together,
 * they make 54. For the number 54, the prime factors output should be 2 and 3. Use
 * Sets as part of the solution.
 *
 * I did a quick search to see if there was an existing algorithm to determine the
 * prime factors of a number and I found this:
 * http://www.vogella.com/tutorials/JavaAlgorithmsPrimeFactorization/article.html
 *
 * Since this is a common mathematical problem, I assumed it was acceptable to use an
 * existing algorithm.
 */
public class PrimeNumber {
  private Set<Integer> primeFactors;
  private boolean isPrime;
  private int number;

  public PrimeNumber(int number){
    this.number = number;
    this.primeFactors = determinePrimeFactors();
    this.isPrime = determineIfPrime();
  }

  public HashSet<Integer> determinePrimeFactors() {
    int n = this.number;
    HashSet<Integer> factors = new HashSet<Integer>();
    for (int i = 2; i <= n; i++) {
      while (n % i == 0) {
        factors.add(i);
        n /= i;
      }
    }

    return factors;
  }

  public boolean determineIfPrime(){
    return this.primeFactors.contains(this.number) ? true : false;
  }

  public String returnTextPrimes(){
    String textPrimes = "";
    if (this.isPrime){
      textPrimes =  "This is a prime number!";
    } else {
      textPrimes = "This is not a prime number, here are the factors: \n" +
          this.primeFactors;
    }
    return textPrimes;
  }
}
