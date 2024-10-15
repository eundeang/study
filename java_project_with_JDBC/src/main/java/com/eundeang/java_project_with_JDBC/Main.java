package java_project_with_JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        BoardRepository repo = BoardRepositoryMysql.getInstance();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            System.out.println("1. 게시글 작성, 2. 게시글 목록, 3.게시글 수정, 4. 게시글 삭제, -1 종료");
            int select = Integer.parseInt(br.readLine());
            if(select == -1) break;

            switch (select){
                case 1:
                    System.out.print("title>>");
                    String title = br.readLine();
                    System.out.print("writer>");
                    String writer = br.readLine();
                    System.out.print("content>");
                    String content = br.readLine();
                    repo.insert(new BoardDTO(title,content,writer));
                    break;
                    case 2:
                        for(BoardDTO b : repo.selectAll()) {
                            System.out.println(b);
                        }
//                    case 3:
//                        System.out.print("title(없으면 enter)>>");
//                        String title = br.readLine();
//                        System.out.print("writer(없으면 enter)>");
//                        String writer = br.readLine();
//                        System.out.print("content(없으면 enter)>");
//                        String content = br.readLine();

            }
        }
    }
}
