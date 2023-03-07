import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    private static String[] s1, s2, s3, s4, s5;
    private static int[] tab = new int[6];
    private static int counter = 0, sum = 1;
    private static ArrayList<Monkey> malpy = new ArrayList<>();

    public static void main(String[] args) {


        try {
            File myObj = new File("src/o.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                String data = myReader.nextLine();
                s1 = data.split(" ");
                data = myReader.nextLine();
                s2 = data.split(" ");
                data = myReader.nextLine();
                s3 = data.split(" ");
                data = myReader.nextLine();
                s4 = data.split(" ");
                data = myReader.nextLine();
                s5 = data.split(" ");
                if (myReader.hasNextLine()){
                    myReader.nextLine();
                }
                ArrayList<String> operator = new ArrayList<>();
                operator.add(s2[6]);
                operator.add(s2[7]);
                ArrayList<Long> k = new ArrayList<>();
                for (int i = 4; i < s1.length; i++){
                    String[] help;
                    help = s1[i].split(",");
                    k.add(Long.parseLong(help[0]));
                }
                malpy.add(new Monkey(Long.parseLong(s3[5]), Integer.parseInt(s4[9]), Integer.parseInt(s5[9]), operator, k, 0));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        check();
    }

    public static void check() {

        for (int z = 0 ; z < 10000; z++){
            for(int i = 0; i < malpy.size(); i++){
                malpy.get(i).setCount(malpy.get(i).getCount() + malpy.get(i).getItems().size());
                while (malpy.get(i).getItems().size() != 0){

                    if(malpy.get(i).getOperator().get(0).equals("+")){
                        malpy.get(i).getItems().set(0, malpy.get(i).getItems().get(0) + Integer.parseInt(malpy.get(i).getOperator().get(1)));
                    }else {
                        if(malpy.get(i).getOperator().get(1).equals("old")){
                            malpy.get(i).getItems().set(0, malpy.get(i).getItems().get(0) * malpy.get(i).getItems().get(0));
                        }else{
                            malpy.get(i).getItems().set(0, malpy.get(i).getItems().get(0) * Integer.parseInt(malpy.get(i).getOperator().get(1)));
                        }
                    }
                    //malpy.get(i).getItems().set(0, malpy.get(i).getItems().get(0) / 3);
                    if(malpy.get(i).getItems().get(0) % malpy.get(i).getDiv() == 0){
                        malpy.get(malpy.get(i).getTrueGO()).getItems().add(malpy.get(i).getItems().get(0));
                        malpy.get(i).getItems().remove(0);
                    } else{
                        malpy.get(malpy.get(i).getFalseGO()).getItems().add(malpy.get(i).getItems().get(0));
                        malpy.get(i).getItems().remove(0);
                    }
                }
            }
        }

        long max = 0, max2 = 0;
        for (int i = 0; i < malpy.size(); i++){
           if(max < malpy.get(i).getCount()){
               max2 = max;
               max = malpy.get(i).getCount();
           }
        }
        System.out.println(max*max2);

    }
}

class Monkey{
    private ArrayList<Long> items = new ArrayList<>();
    private ArrayList<String> operator = new ArrayList<>();
    private Long div;
    private int trueGO;
    private int falseGO;
    private int count;

    public Monkey(Long div, int trueGO, int falseGO, ArrayList<String> operator, ArrayList<Long> items, int count) {
        this.div = div;
        this.trueGO = trueGO;
        this.falseGO = falseGO;
        this.operator = operator;
        this.items = items;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public ArrayList<String> getOperator() {
        return operator;
    }

    public void setOperator(ArrayList<String> operator) {
        this.operator = operator;
    }

    public Long getDiv() {
        return div;
    }

    public void setDiv(Long div) {
        this.div = div;
    }

    public int getTrueGO() {
        return trueGO;
    }

    public void setTrueGO(int trueGO) {
        this.trueGO = trueGO;
    }

    public int getFalseGO() {
        return falseGO;
    }

    public void setFalseGO(int falseGO) {
        this.falseGO = falseGO;
    }
    public ArrayList<Long> getItems() {
        return items;
    }

    public void setItems(ArrayList<Long> items) {
        this.items = items;
    }
}