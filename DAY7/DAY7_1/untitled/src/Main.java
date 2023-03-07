import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static String[] s;
    public static int x, y, counter = -1;
    public static ArrayList<Dane> list = new ArrayList<>();

    public static void main(String[] args) {

        try {
            File myObj = new File("C:\\Users\\Patryk\\Documents\\JAVA\\Advent of code\\DAY7\\DAY7_1\\untitled\\src\\o.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = data.split(" ");

                while (s[1].equals("cd")) {
                    if (s[2].equals("..")) {
                        break;
                    }
                    ArrayList<String> x = new ArrayList<>();
                    for(int h = 0; h < list.size(); h++){
                        if(list.get(h).getNazwa().equals(s[2])){
                            s[2] = s[2] + list.get(h).getC();
                            //System.out.println(s[2]);
                            break;
                        }
                    }
                    list.add(new Dane(0, s[2], x, 0));
                    counter++;
                    //System.out.println(s[2]);
                    if (myReader.hasNextLine()) {
                        data = myReader.nextLine();
                        s = data.split(" ");
                    } else {
                        break;
                    }

                    while (!s[1].equals("cd")) {
                        if (myReader.hasNextLine()) {
                            data = myReader.nextLine();
                            s = data.split(" ");
                        } else {
                            break;
                        }
                        if (s[1].equals("cd")) {
                            break;
                        }
                        if (!s[0].equals("dir")) {
                            list.get(counter).setSize(list.get(counter).getSize() + Integer.parseInt(s[0]));
                            //System.out.println(s[0]);
                        }
                        if (s[0].equals("dir")) {
                            for(int h = 0; h < list.size(); h++){
                                if(list.get(h).getNazwa().equals(s[1])){
                                    list.get(h).setC(list.get(h).getC() + 1);
                                    s[1] = s[1] + list.get(h).getC();
                                    break;
                                }
                            }
                            list.get(counter).getTaa().add(s[1]);
                        }
                    }
                }

            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        count("/");
        long g = 0;
        for (int z = 0; z < list.size(); z++){
            if(list.get(z).getSize()<=100000){
                g += list.get(z).getSize();
            }
        }
        System.out.println(g);
        //System.out.println(list.get(0).getNazwa());
       /* for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNazwa() + "   ---------------");
            System.out.println(list.get(i).getSize());
            System.out.println("");
        }*/


    }

    public static long count(String nazwa){
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNazwa().equals(nazwa)){
                //System.out.println(i);
                if(list.get(i).getTaa().isEmpty()){
                    return list.get(i).getSize();
                }else{
                    for (int j = 0; j < list.get(i).getTaa().size(); j++){
                       // System.out.println(list.get(i).getTaa().get(j));
                        list.get(i).setSize(list.get(i).getSize() + count(list.get(i).getTaa().get(j)));
                    }
                    temp = i;
                }
            }
        }
        return list.get(temp).getSize();
    }
}
class Dane{

    public Dane(long size, String nazwa, ArrayList<String> taa, int c) {
        this.size = size;
        this.setNazwa(nazwa);
        this.c = c;
    }
    private long size;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    private int c;

    public ArrayList<String> getTaa() {
        return taa;
    }

    public void setTaa(ArrayList<String> taa) {
        this.taa = taa;
    }

    private ArrayList<String> taa = new ArrayList<>();

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    private String nazwa;


    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}