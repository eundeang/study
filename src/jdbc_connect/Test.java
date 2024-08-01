package jdbc_connect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int input = 100;
            while (input != 0) {
                System.out.print("요리가 궁금하다면 1번을, 재료가 궁금하다면 2번을 눌러주세요! (종료 : 0)>>\"");
                input = Integer.parseInt(br.readLine());
                if(input == 1) {
                    Food food = new FoodImpl();
                    System.out.print("요리 전체 조회 : 1, 요리 조회 : 2, 칼로리 낮은 순 조회: 3, 종료 : 0를 입력하시오. >>\"");
                    input = Integer.parseInt(br.readLine());
                    if(input == 1) {
                        food.printAll();
                    }
                    if(input == 2) {
                        String name  = br.readLine();
                        food.findByName(name);
                    }
                }

                if(input == 2) {
                    Ingredient ingredient = new IngredientImpl();
                    System.out.println(" 특정 음식에 들어가는 종류가 궁금하다면: 1, 재료를 추가하고 싶다면: 2, 종료 : 0를 입력하시오. >>");
                    input = Integer.parseInt(br.readLine());
                    if(input == 1) {
                        System.out.print("성분이 궁금한 음식의 이름을 알려주세요! >> ");
                        String name = br.readLine();
                        ingredient.findIngredientsByFoodName(name);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
