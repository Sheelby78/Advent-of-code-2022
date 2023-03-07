import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        String[] s;
        int x,y;

        try {
            File myObj = new File("src/o.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                s = data.split("");
                System.out.println(s.length);
                for(int i=0; i<s.length-3; i++){
                    if(!s[i].equals(s[i+1]) && !s[i].equals(s[i+2]) && !s[i].equals(s[i+3]) && !s[i].equals(s[i+4]) && !s[i].equals(s[i+5]) && !s[i].equals(s[i+6]) && !s[i].equals(s[i+7]) && !s[i].equals(s[i+8]) && !s[i].equals(s[i+9]) && !s[i].equals(s[i+10]) && !s[i].equals(s[i+11]) && !s[i].equals(s[i+12]) && !s[i].equals(s[i+13])){
                        if(!s[i+1].equals(s[i+2]) && !s[i+1].equals(s[i+3]) && !s[i+1].equals(s[i+4]) && !s[i+1].equals(s[i+5]) && !s[i+1].equals(s[i+6]) && !s[i+1].equals(s[i+7]) && !s[i+1].equals(s[i+8]) && !s[i+1].equals(s[i+9]) && !s[i+1].equals(s[i+10]) && !s[i+1].equals(s[i+11]) && !s[i+1].equals(s[i+12]) && !s[i+1].equals(s[i+13])){
                            if(!s[i+2].equals(s[i+3]) && !s[i+2].equals(s[i+4]) && !s[i+2].equals(s[i+5]) && !s[i+2].equals(s[i+6]) && !s[i+2].equals(s[i+7]) && !s[i+2].equals(s[i+8]) && !s[i+2].equals(s[i+9]) && !s[i+2].equals(s[i+10]) && !s[i+2].equals(s[i+11]) && !s[i+2].equals(s[i+12]) && !s[i+2].equals(s[i+13])){
                                if(!s[i+3].equals(s[i+4]) && !s[i+3].equals(s[i+5]) && !s[i+3].equals(s[i+6]) && !s[i+3].equals(s[i+7]) && !s[i+3].equals(s[i+8]) && !s[i+3].equals(s[i+9]) && !s[i+3].equals(s[i+10]) && !s[i+3].equals(s[i+11]) && !s[i+3].equals(s[i+12]) && !s[i+3].equals(s[i+13])){
                                    if(!s[i+4].equals(s[i+5]) && !s[i+4].equals(s[i+6]) && !s[i+4].equals(s[i+7]) && !s[i+4].equals(s[i+8]) && !s[i+4].equals(s[i+9]) && !s[i+4].equals(s[i+10]) && !s[i+4].equals(s[i+11]) && !s[i+4].equals(s[i+12]) && !s[i+4].equals(s[i+13])){
                                        if(!s[i+5].equals(s[i+6]) && !s[i+5].equals(s[i+7]) && !s[i+5].equals(s[i+8]) && !s[i+5].equals(s[i+9]) && !s[i+5].equals(s[i+10]) && !s[i+5].equals(s[i+11]) && !s[i+5].equals(s[i+12]) && !s[i+5].equals(s[i+13])){
                                            if(!s[i+6].equals(s[i+7]) && !s[i+6].equals(s[i+8]) && !s[i+6].equals(s[i+9]) && !s[i+6].equals(s[i+10]) && !s[i+6].equals(s[i+11]) && !s[i+6].equals(s[i+12]) && !s[i+6].equals(s[i+13])){
                                                if(!s[i+7].equals(s[i+8]) && !s[i+7].equals(s[i+9]) && !s[i+7].equals(s[i+10]) && !s[i+7].equals(s[i+11]) && !s[i+7].equals(s[i+12]) && !s[i+7].equals(s[i+13])){
                                                    if(!s[i+8].equals(s[i+9]) && !s[i+8].equals(s[i+10]) && !s[i+8].equals(s[i+11]) && !s[i+8].equals(s[i+12]) && !s[i+8].equals(s[i+13])){
                                                        if(!s[i+9].equals(s[i+10]) && !s[i+9].equals(s[i+11]) && !s[i+9].equals(s[i+12]) && !s[i+9].equals(s[i+13])){
                                                            if(!s[i+10].equals(s[i+11]) && !s[i+10].equals(s[i+12]) && !s[i+10].equals(s[i+13])){
                                                                if(!s[i+11].equals(s[i+12]) && !s[i+11].equals(s[i+13])){
                                                                    if(!s[i+12].equals(s[i+13])){
                                                                        System.out.println(i+14);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}