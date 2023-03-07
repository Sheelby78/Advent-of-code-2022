import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        ArrayList<String> List1 = new ArrayList<String>(Arrays.asList("N","D","M","Q","B","P","Z"));
        ArrayList<String> List2 = new ArrayList<String>(Arrays.asList("C","L","Z","Q","M","D","H","V"));
        ArrayList<String> List3 = new ArrayList<String>(Arrays.asList("Q","H","R","D","V","F","Z","G"));
        ArrayList<String> List4 = new ArrayList<String>(Arrays.asList("H","G","D","F","N"));
        ArrayList<String> List5 = new ArrayList<String>(Arrays.asList("N","F","Q"));
        ArrayList<String> List6 = new ArrayList<String>(Arrays.asList("D","Q","V","Z","F","B","T"));
        ArrayList<String> List7 = new ArrayList<String>(Arrays.asList("Q","M","T","Z","D","V","S","H"));
        ArrayList<String> List8 = new ArrayList<String>(Arrays.asList("M","G","F","P","N","Q"));
        ArrayList<String> List9 = new ArrayList<String>(Arrays.asList("B","W","R","M"));

        ArrayList<ArrayList> Glowna = new ArrayList<ArrayList>(Arrays.asList(List1,List2,List3,List4,List5,List6,List7,List8,List9));
        String[] s;
        int x,y;

        try {
            File myObj = new File("src/o.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = data.split(" ");
                for(int i=0; i<Integer.parseInt(s[1]); i++){
                    x = Integer.parseInt(s[3])-1;
                    y = Integer.parseInt(s[5])-1;
                    Glowna.get(y).add(Glowna.get(x).get(Glowna.get(x).size()-1));
                    Glowna.get(x).remove(Glowna.get(x).size()-1);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.print(Glowna.get(0).get(Glowna.get(0).size()-1));
        System.out.print(Glowna.get(1).get(Glowna.get(1).size()-1));
        System.out.print(Glowna.get(2).get(Glowna.get(2).size()-1));
        System.out.print(Glowna.get(3).get(Glowna.get(3).size()-1));
        System.out.print(Glowna.get(4).get(Glowna.get(4).size()-1));
        System.out.print(Glowna.get(5).get(Glowna.get(5).size()-1));
        System.out.print(Glowna.get(6).get(Glowna.get(6).size()-1));
        System.out.print(Glowna.get(7).get(Glowna.get(7).size()-1));
        System.out.print(Glowna.get(8).get(Glowna.get(8).size()-1));

    }
}