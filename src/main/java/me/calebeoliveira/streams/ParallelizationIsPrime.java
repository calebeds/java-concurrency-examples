package me.calebeoliveira.streams;

import java.util.stream.IntStream;

public class ParallelizationIsPrime {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        // sequential stream
        long numberOfPrimes = IntStream.rangeClosed(2, Integer.MAX_VALUE/100).filter(ParallelizationIsPrime::isPrime).count();
        System.out.println("Number of primes (sequential): " + numberOfPrimes);
        System.out.println("Time taken (sequential): " + (System.currentTimeMillis() - startTime));

        // parallel stream
        startTime = System.currentTimeMillis();

        numberOfPrimes = IntStream.rangeClosed(2, Integer.MAX_VALUE/100).parallel().filter(ParallelizationIsPrime::isPrime).count();
        System.out.println("Number of primes (parallel): " + numberOfPrimes);
        System.out.println("Time taken (sequential): " + (System.currentTimeMillis() - startTime));

    }

    public static boolean isPrime(long num) {
        if(num <= 1) {
            return false;
        }

        if(num == 2) {
            return true;
        }

        if(num % 2 == 0) {
            return false;
        }

        // we can check the numbers in the range [0, sqrt(N)]
        long maxDivisor = (long) Math.sqrt(num);

        for (int i = 3; i < maxDivisor; i+=2) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
