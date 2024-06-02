/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.csd420;

/**
 *
 * @author devin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FansProgram {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String DB_USER = "student1"; // Replace with your database username
    private static final String DB_PASSWORD = "pass"; // Replace with your database password

    private JFrame frame;
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField favoriteTeamField;

    public FansProgram() {
        frame = new JFrame("Fans Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        JLabel favoriteTeamLabel = new JLabel("Favorite Team:");
        favoriteTeamField = new JTextField();

        JButton displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fanId;
                try {
                    fanId = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID");
                    return;
                }

                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    String query = "SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setInt(1, fanId);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        firstNameField.setText(resultSet.getString("firstname"));
                        lastNameField.setText(resultSet.getString("lastname"));
                        favoriteTeamField.setText(resultSet.getString("favoriteteam"));
                    } else {
                        JOptionPane.showMessageDialog(frame, "Fan not found in the database");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fanId;
                try {
                    fanId = Integer.parseInt(idField.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid ID");
                    return;
                }

                String newFirstName = firstNameField.getText();
                String newLastName = lastNameField.getText();
                String newFavoriteTeam = favoriteTeamField.getText();

                try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
                    String query = "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, newFirstName);
                    preparedStatement.setString(2, newLastName);
                    preparedStatement.setString(3, newFavoriteTeam);
                    preparedStatement.setInt(4, fanId);

                    int rowsUpdated = preparedStatement.executeUpdate();
                    if (rowsUpdated > 0) {
                        JOptionPane.showMessageDialog(frame, "Record updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Fan not found in the database");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.add(idLabel);
        frame.add(idField);
        frame.add(firstNameLabel);
        frame.add(firstNameField);
        frame.add(lastNameLabel);
        frame.add(lastNameField);
        frame.add(favoriteTeamLabel);
        frame.add(favoriteTeamField);
        frame.add(displayButton);
        frame.add(updateButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FansProgram());
    }
}

