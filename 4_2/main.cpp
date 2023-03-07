#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {

    fstream ff;
    ff.open("o.txt",ios::in);
    string x, y, z;
    int score = 0;
    int x1, x2, y1, y2;
    string read;

    while(getline(ff, read)){

        x = read.substr(0,read.find_first_of(","));
        y = read.substr(read.find_first_of(",")+1, read.size()-1);
        x1 = stoi(x.substr(0,x.find_first_of("-")));
        x2 = stoi(x.substr(x.find_first_of("-")+1, x.size()-1));
        y1 = stoi(y.substr(0,y.find_first_of("-")));
        y2 = stoi(y.substr(y.find_first_of("-")+1, x.size()-1));
        if(x1 >= y1 && x1 <=y2){
            score++;
            continue;
        }
         if(x2 >= y1 && x2 <=y2){
            score++;
            continue;
         }
         if(x1 <= y1 && x2 >= y1){
            score++;
            continue; 
        }
        if(x2 >= y2 && x1 <= y1){
            score++;
            continue;
        }
    }
    
    cout<<score<<endl;
    ff.close();
    return 0;
}
