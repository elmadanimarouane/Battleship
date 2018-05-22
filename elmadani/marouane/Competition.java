package elmadani.marouane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Competition {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int f = 0;
        for (int i = 0; i < 50;i++){
            a = a + AIvsAI.battleAi(0,1);
            d = d + AIvsAI.battleAi(1,0);

            b = b + AIvsAI.battleAi(0,2);
            e = e + AIvsAI.battleAi(2,0);

            c = c + AIvsAI.battleAi(1,2);
            f = f + AIvsAI.battleAi(2,1);
        }

        a = a + (50-d);
        b = b + (50-e);
        c = c + (50-f);

        System.out.println("Result of the tournament : ");
        System.out.println("AI 0 : " + a + " AI 1 : " + (100-a));
        System.out.println("AI 0 : " + b + " AI 2 : " + (100-b));
        System.out.println("AI 1 : " + c + " AI 2 : " + (100-c));

        try {
            PrintWriter pw = new PrintWriter(new File("result.csv"));
            StringBuilder sb = new StringBuilder();
            // AI 0 vs AI 1 //
            sb.append("AI Level Beginner");
            sb.append(",");
            sb.append(a);
            sb.append(",");
            sb.append("Level Medium");
            sb.append(",");
            sb.append(100-a);
            sb.append("\n");
            sb.append("AI Level Beginner");
            sb.append(",");
            sb.append(b);
            sb.append(",");
            sb.append("Level Hard;");
            sb.append(100-b);
            sb.append("\n");
            sb.append("AI Medium");
            sb.append(",");
            sb.append(c);
            sb.append(",");
            sb.append("Level Hard");
            sb.append(",");
            sb.append(100-c);
            pw.write(sb.toString());
            pw.close();
            System.out.println("CSV File 'result.csv' created successfully");
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            System.out.println("Error in CsvFileWriter");
        }
    }


}
