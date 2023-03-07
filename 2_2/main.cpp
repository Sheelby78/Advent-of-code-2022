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

        if(y=="X"){
            if(x=="A"){
               score += 3;
               continue;
            }
            else if(x=="B"){
               score += 1;
               continue;
            }
            else{
               score += 2;
               continue;
            }
        }
        else if(y=="Y"){
            score += 3;
            
            if(x=="A"){
               score += 1;
               continue;
            }
            else if(x=="B"){
               score += 2;
               continue;
            }
            else{
               score += 3;
               continue;
            }
        }
        else{
            score += 6;

            if(x=="A"){
               score += 2;
               continue;
            }
            else if(x=="B"){
               score += 3;
               continue;
            }
            else{
               score += 1;
               continue;
            }
        }
    }

    cout<<score<<endl;

    ff.close();
    return 0;
}
