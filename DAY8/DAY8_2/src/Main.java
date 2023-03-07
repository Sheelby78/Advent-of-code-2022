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
        int[][][] tab = new int[99][99][6];
        try {
            File myObj = new File("src/o.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = data.split("");
                for (int i = 0; i < 99; i++){
                    tab[x][i][0] = Integer.parseInt(s[i]);
                    tab[x][i][1] = 0;
                    tab[x][i][2] = 0;
                    tab[x][i][3] = 0;
                    tab[x][i][4] = 0;
                    tab[x][i][5] = 0;
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

                for (int z = i-1; z >= 0 ; z--){
                    if(tab[i][j][0] <= tab[z][j][0]){
                        tab[i][j][1]++;
                        break;
                    }else {
                        tab[i][j][1]++;
                    }
                }

                for (int z = i+1; z < 99; z++){
                    if(tab[i][j][0] <= tab[z][j][0]){
                        tab[i][j][2]++;
                        break;
                    }else {
                        tab[i][j][2]++;
                    }
                }

                for (int z = j-1; z >= 0 ; z--){
                    if(tab[i][j][0] <= tab[i][z][0]){
                        tab[i][j][3]++;
                        break;
                    }else {
                        tab[i][j][3]++;
                    }
                }

                for (int z = j+1; z < 99; z++){
                    if(tab[i][j][0] <= tab[i][z][0]){
                        tab[i][j][4]++;
                        break;
                    }else {
                        tab[i][j][4]++;
                    }
                }
               tab[i][j][5] = tab[i][j][1] * tab[i][j][2] * tab[i][j][3] * tab[i][j][4];
            }
        }
        int max = 0;
        for (int o = 0; o < 99; o++){
            for (int r = 0; r < 99; r++){
                if(max < tab[o][r][5]){
                    max = tab[o][r][5];
                }
            }
        }
        System.out.println(max);

    }
}