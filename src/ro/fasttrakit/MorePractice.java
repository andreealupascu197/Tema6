package ro.fasttrakit;

import java.util.Arrays;
import java.util.Random;

public class MorePractice {

    public static void main(String[] args) {
        System.out.println(arrayProduct(new int[]{2, 3}));
        System.out.println(numberOfOddElements(new int[]{2, 3, 5, 6}));
        System.out.println(Arrays.toString(smallerThanGivenInt(new int[]{10, 8, 2, 5, 7, 10}, 6)));
        donations(2000, 3);
        String fraza = "Ana. Are mere. Cine stie.";
        printEachSentence(fraza);
    }

    public static int arrayProduct(int[] arrayOfInt) {
        int result = 1;
        for (int i : arrayOfInt) {
            result *= i;

        }
        return result;
    }

    public static int numberOfOddElements(int[] arrayOfInt) {
        int position = 0;
        for (int i : arrayOfInt) {
            if (i % 2 != 0) {
                position++;
            }
        }
        return position;
    }

    public static int[] smallerThanGivenInt(int[] arrayOfInt, int givenInt) {
        int[] smallerNumbers = new int[arrayOfInt.length];
        int capacity = 0;
        for (int i : arrayOfInt) {
            if (i < givenInt) {
                smallerNumbers[capacity] = i;
                capacity++;
            }
        }
        for (int i = 0; i < capacity; i++) {
            System.out.print(smallerNumbers[i] + " ");
        }
        System.out.println();
        return smallerNumbers;
    }

    public static void donations(int donationTarget, int maxDonations) {
        Random numar = new Random();
        System.out.println("Donation target is: " + donationTarget);
        int totalAmount = 0;
        int donationCount = 0;
        while (totalAmount < donationTarget && maxDonations > donationCount) {
            totalAmount = totalAmount + numar.nextInt(0, donationTarget);
            donationCount++;
            System.out.println("Total amount is: " + totalAmount);
            System.out.println("Number of donations is: " + donationCount);
        }
        System.out.println("Success!");
    }

    public static void printEachSentence(String fraza) {
        String[] parts = fraza.split("\\. ");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}




