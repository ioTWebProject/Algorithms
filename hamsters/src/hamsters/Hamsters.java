package hamsters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Hamsters {

 
    public static void main(String[] args) { 
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/hamsters/hamstr.in")); 
            
            int S = Integer.parseInt(br.readLine());
            int C = Integer.parseInt(br.readLine());
            
            Integer H[] = new Integer[C];
            Integer G[] = new Integer[C];
            
            int i = 0;
            String line = br.readLine();
            while (!line.isEmpty() || !line.equals("")) {
                H[i] = Integer.parseInt(line.split(" ")[0]);
                G[i++] = Integer.parseInt(line.split(" ")[1]);
                line = br.readLine();
                
                if (line == null) {
                    break;
                }
            }
            
            for (i = C - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (H[j] + G[j] * C > H[j+1] + G[j+1] * C) {
                        int temp = H[j];
                        H[j] = H[j+1];
                        H[j+1] = temp;
                        
                        temp = G[j];
                        G[j] = G[j+1];
                        G[j+1] = temp;
                    }
                }
            }
            
            int count = 0;
            int foodSum = 0;
            int GSum = 0;
            for (i = 0; i < C; i++) {
                if (S >= foodSum + H[i] + G[i] * count + GSum * count) {
                    foodSum += H[i] + G[i] * count + GSum * count;
                    count++;
                    GSum += G[i];
                }
            }
            
            
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("src/hamsters/hamstr.out", false));
            bw.write(count + "");
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      
    }
    
}
