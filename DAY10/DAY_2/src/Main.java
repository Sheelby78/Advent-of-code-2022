import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    private static String[] s;
    private  static int[] tab = new int[6];
    private static int counter = 0, sum=1;

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
                        if(i==2){
                            sum += Integer.parseInt(s[1]);
                            break;
                        }
                        check();
                        counter++;
                    }
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }




    }

    public static void check(){
        if(counter == 40){
            System.out.println("");
            counter=0;
        }
        if(counter == sum || counter == sum-1 || counter == sum+1){
            System.out.print("#");
        }else {
            System.out.print(".");
        }
    }
}