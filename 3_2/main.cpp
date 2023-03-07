#include <iostream>
#include <fstream>

using namespace std;

int main() {

    fstream ff;
    ff.open("o.txt",ios::in);
    string x, y, z;
    int score = 0;
    string read;
    char temp;
    char a = 'a';

    while(getline(ff, read)){
        x = read;
        getline(ff, read);
        y = read;
        getline(ff, read);
        z = read;

        for(int i = 0; i < x.size(); i++){
            for(int j = 0; j < y.size(); j++){
                if(x[i]==y[j]){
                    for(int k = 0; k < z.size(); k++){
                        if(x[i]==z[k]){
                            temp = x[i];
                            goto sum;
                        }
                    }
                }
            }
        }

       sum:
       if((int)temp>=96){
            score += (int)temp - 96;

       }
       else{
            score += (int)temp - 38;

       }
    }
    
    cout<<score<<endl;
    ff.close();
    return 0;
}
