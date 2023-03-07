import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    private static String[] s;
    private  static int[] tab = new int[6];
    private static int counter = 1, sum=1;

    public static void main(String[] args) {


        try {
            File myObj = new File("src/o.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = data.split(" ");

                if(s[0].equals("noop")){
                    check();
                    counter++;
                }else {
                    for (int i = 0; i < 3; i++){
                        check();
                        if(i==2){
                            sum += Integer.parseInt(s[1]);
                            break;
                        }
                        counter++;
                    }
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(tab[0]+tab[1]+tab[2]+tab[3]+tab[4]+tab[5]);



    }

    public static void check(){
        if(counter == 20){
            tab[0] = sum*20;
        }
        if(counter == 60){
            tab[1] = sum*60;
        }
        if(counter == 100){
            tab[2] = sum*100;
        }
        if(counter == 140){
            tab[3] = sum*140;
        }
        if(counter == 180){
            tab[4] = sum*180;
        }
        if(counter == 220){
            tab[5] = sum*220;
        }
    }
}