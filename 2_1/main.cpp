#include <iostream>
#include <fstream>

using namespace std;

int main() {
    fstream ff;
    ff.open("o.txt",ios::in);
    string x, y;
    int score = 0;
    string read;

    while(getline(ff, read)){
        x = read[0];
        y = read[2];

        if(x == "A" && y == "Y"){
            score += 8;
            continue;
        }

        if(x == "A" && y == "Z"){
            score += 3;
            continue;
        }

         if(x == "B" && y == "X"){
            score += 1;
            continue;
        }

        if(x == "B" && y == "Z"){
            score += 9;
            continue;
        }

         if(x == "C" && y == "X"){
            score += 7;
            continue;
        }

        if(x == "C" && y == "Y"){
            score += 2;
            continue;
        }

        score +=3;
        
        if(y=="X"){
            score += 1;
        }
        else if(y=="Y"){
            score += 2;
        }
        else{
            score += 3;
        }
        continue;


    }

    cout<<score<<endl;

    ff.close();
    return 0;
}
