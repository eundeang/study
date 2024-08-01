package jdbc_connect;

import java.sql.*;

public class FoodImpl implements Food{
    Connection conn;

    FoodImpl(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/team10", "root", "abcd1234@");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printAll() {
        String SQL = "select * from food join ingredient_food on food.food_id = ingredient_food.ingredient_id";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString("food_name"+ " "));
                System.out.print(rs.getString("ingredient_usage"));
                System.out.println();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void findByName(String name) {
        String SQL = "select * from food where food_name like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, "%"+name+"%");
            ResultSet rs = ps.executeQuery();
            int count  = 0;
            while (rs.next()) {
                count++;
            }
            System.out.println("총 "+count+"건의 요리가 존재합니다.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void insert() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
