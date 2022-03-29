package ro.fasttrackit;

import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        int[] agenda = new int[4];
        displayAgenda(agenda);
    }

    public static void displayAgenda(int[] agenda) {
        String[] agendaOptions = {"Adaugare", "Modificare", "Stergere", "Cautare", "Exit"};
        boolean isAlive = true;
        while (isAlive) {
            for (int i = 0; i < agendaOptions.length; i++) {
                System.out.println(i + 1 + " " + agendaOptions[i]);
            }
            Scanner s = new Scanner(System.in);
            System.out.println("Press the option: ");
            int optionNumber = s.nextInt();
            switch (optionNumber) {
                case 1 -> {
                    System.out.println("Please enter phone number: ");
                    int number = s.nextInt();
                    if (add(agenda, number) != -1) {
                        System.out.println("Number added successfully!");
                    } else {
                        System.out.println("Cannot add number");
                    }
                }
                case 2 -> {
                    System.out.println("Please add the number to replace: ");
                    int actualNumber = s.nextInt();
                    System.out.println("Please add the new number");
                    int newNumber = s.nextInt();
                    if (replace(agenda, actualNumber, newNumber) != -1) {
                        System.out.println("Number has been replaced");
                    } else {
                        System.out.println("Number cannot be replaced");
                    }
                }
                case 3 -> {
                    System.out.println("Please enter number to remove:");
                    int removeNumber = s.nextInt();
                    if (remove(agenda, removeNumber) != -1) {
                        System.out.println("Number has been removed");
                    } else {
                        System.out.println("Number does not exist");
                    }
                }

                case 4 -> {
                    System.out.println("Please enter number to search");
                    int numberToSearch = s.nextInt();
                    if (search(agenda, numberToSearch) != -1) {
                        System.out.println("Number has been found");
                    } else {
                        System.out.println("Number does not exist");
                    }
                }
                case 5 -> {
                    isAlive = false;
                    System.out.println("You will exit the agenda options");
                }
                default -> {
                    System.out.println("Please enter a valid option");
                }
            }
        }
    }

    public static int add(int[] agenda, int nr) {
        if (search(agenda, nr) != -1) {
            return -1;
        }
        int position = 0;
        while (position < agenda.length) {
            if (agenda[position] == 0) {
                agenda[position] = nr;
                return position;
            }
            position++;
        }
        return -1;
    }

    public static int replace(int[] agenda, int actual, int newnr) {
        if (search(agenda, newnr) != -1) {
            return -1;
        }
        int position = search(agenda, actual);
        if (position != -1) {
            agenda[position] = newnr;
        }
        return position;
    }

    public static int remove(int[] agenda, int nr) {
        int position = search(agenda, nr);
        if (position != -1) {
            agenda[position] = 0;
        }
        return position;
    }

    public static int search(int[] agenda, int nr) {
        int position = 0;
        while (position < agenda.length) {
            if (agenda[position] == nr) {
                return position;
            }
            position++;
        }
        return -1;
    }

}
