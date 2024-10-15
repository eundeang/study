package com.eundeang.jdbc_connect;

import java.sql.*;

public class IngredientImpl implements Ingredient {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    IngredientImpl() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team10", "root", "abcd1234@");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void insert() {

    }

    @Override
    public void findIngredientsByFoodName(String foodName) {
        try {
            String SQL = "SELECT ingredient FROM ingredient_food " +
                    "join food on ingredient_food.food_id = food.food_id" +
                    "join ingredient on ingredient_food.ingredient_id = ingredient.ingredient_id" +
                    "where food.food_name = ?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, foodName);
            rs = ps.executeQuery();
            while (rs.next()) {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void printAll() {

    }
}
