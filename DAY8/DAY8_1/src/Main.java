import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String[] s;
        int x = 0,y = 0;
        int[][] tab = new int[99][99];
        try {
            File myObj = new File("src/o.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = data.split("");
                for (int i = 0; i < 99; i++){
                    tab[x][i] = Integer.parseInt(s[i]);
                }
                x++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 1; i < 98; i++){
            for (int j = 1; j < 98; j++){
                int temp=0;
                for (int z = 0; z < i; z++){
                    if(tab[i][j] <= tab[z][j]){
                        temp ++;
                        break;
                    }
                }
                if(temp == 0){
                    y++;
                    continue;
                }

                temp=0;
                for (int z = 0; z < j; z++){
                    if(tab[i][j] <= tab[i][z]){
                        temp ++;
                        break;
                    }
                }
                if(temp == 0){
                    y++;
                    continue;
                }

                temp=0;
                for (int z = i+1; z < 99; z++){
                    if(tab[i][j] <= tab[z][j]){
                        temp ++;
                        break;
                    }
                }
                if(temp == 0){
                    y++;
                    continue;
                }

                temp=0;
                for (int z = j+1; z < 99; z++){
                    if(tab[i][j] <= tab[i][z]){
                        temp ++;
                        break;
                    }
                }
                if(temp == 0){
                    y++;
                    continue;
                }
            }
        }

        y += 392;
        System.out.println(y);
    }
}