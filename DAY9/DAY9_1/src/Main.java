import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    private static String[] s;
    private static int xt = 299, yt = 299, xh = 299, yh = 299;
    private  static int[][] coord = new int[11][2];

    private static int[][][] tab = new int[600][600][11];

    public static void main(String[] args) {

        for (int i = 0; i < 600; i++){
            for (int j = 0; j < 600; j++){
                tab[i][j][0] = 0;
                tab[i][j][1] = 0;
            }
        }

        for (int i = 0; i < 11; i++){
            coord[i][0] = 299;
            coord[i][1] = 299;
            tab[coord[i][0]][coord[i][1]][i] = 1;
        }



        int temp = 0;

        try {
            File myObj = new File("src/o.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = data.split(" ");

                for (int i = 0; i < Integer.parseInt(s[1]); i++){

                    tab[coord[0][0]][coord[0][0]][0] = 0;
                    if(s[0].equals("U")){
                        coord[0][1]++;
                    }
                    if(s[0].equals("D")){
                        coord[0][1]--;
                    }
                    if(s[0].equals("R")){
                        coord[0][0]++;
                    }
                    if(s[0].equals("L")){
                        coord[0][0]--;
                    }

                    tab[coord[0][0]][coord[0][1]][0] = 1;

                    for (int u = 0; u < 9; u++){

                        for (int z = coord[u][0]-1; z < coord[u][0]+2; z++){
                            for (int y = coord[u][1]-1; y < coord[u][1]+2; y++){
                                if(tab[z][y][u+1] == 1){
                                    temp = 1;
                                    break;
                                }
                            }
                        }
                        if(temp == 1){
                            temp = 0;
                        }else{
                            tab[coord[u+1][0]][coord[u+1][1]][u+1] = 0;

                            if(coord[u][0] > coord[u+1][0]) {
                                coord[u+1][0]++;
                            }
                            if(coord[u][0] < coord[u+1][0]){
                                coord[u+1][0]--;
                            }
                            if(coord[u][1] > coord[u+1][1]) {
                                coord[u+1][1]++;
                            }
                            if(coord[u][1] < coord[u+1][1]){
                                coord[u+1][1]--;
                            }
                            tab[coord[u+1][0]][coord[u+1][1]][u+1] = 1;
                            tab[coord[9][0]][coord[9][1]][10] = 1;
                        }


                    }




                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        int p =0;
        for (int i = 0; i < 600; i++){
            for (int j = 0; j < 600; j++){
                if(tab[i][j][10] == 1){
                    p++;
                }
            }
        }

        System.out.println(p);

    }

    public static void check(){

    }
}