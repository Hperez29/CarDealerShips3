package com.pluralsight.dealership.dao;


import com.pluralsight.dealership.database.ConnectionManager;
import com.pluralsight.dealership.models.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDaoImpl implements VehicleDao {

    @Override
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> vehicles = new ArrayList<>();

        String sql = "SELECT * FROM vehicles WHERE make = ? AND model = ?";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, make);
            stmt.setString(2, model);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setVin(rs.getString("vin"));
                vehicle.setYear(rs.getInt("year"));
                vehicle.setMake(rs.getString("make"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setOdometer(rs.getInt("odometer"));
                vehicle.setPrice(rs.getDouble("price"));
                vehicle.setVehicleType(rs.getString("vehicle_type"));

                vehicles.add(vehicle);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vehicles;
    }
}