package com.pluralsight.dealership;

import com.pluralsight.dealership.dao.VehicleDao;
import com.pluralsight.dealership.dao.VehicleDaoImpl;
import com.pluralsight.dealership.models.Vehicle;

import java.util.List;
import java.util.Scanner;

public class HerbsDealers {

    private static final Scanner scanner = new Scanner(System.in);
    private static final VehicleDao vehicleDao = new VehicleDaoImpl();

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            showMainMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchByMakeAndModel();
                    break;
                case "2":
                    System.out.println("Search by price range - coming soon...");
                    break;
                case "3":
                    System.out.println("Add vehicle - coming soon...");
                    break;
                case "4":
                    System.out.println("Remove vehicle - coming soon...");
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }

            System.out.println(); // Blank line between menus
        }

        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("=== HERBS DEALERS MAIN MENU ===");
        System.out.println("1. Search by Make and Model");
        System.out.println("2. Search by Price Range");
        System.out.println("3. Add a Vehicle");
        System.out.println("4. Remove a Vehicle");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void searchByMakeAndModel() {
        System.out.print("Enter make: ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter model: ");
        String model = scanner.nextLine().trim();

        List<Vehicle> results = vehicleDao.getVehiclesByMakeModel(make, model);

        if (results.isEmpty()) {
            System.out.println("No vehicles found for " + make + " " + model);
        } else {
            System.out.println("Vehicles found:");
            for (Vehicle v : results) {
                System.out.println(v);
            }
        }
    }
}