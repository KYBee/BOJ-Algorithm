#include <iostream>

using namespace std;

int main() {

    //freopen("input", "r", stdin);

    int start, end; 
    cin >> start;
    cin >> end;

    int total = 0;
    int min_number = 10000;

    for (int i = 1; i <= 100; i++) {
        int number = i * i;
        if (number < start) {
            continue;
        } else if (start <= number && number <= end) {
            total += number;
            min_number = min(min_number, number);
        } else if (number > end) {
            break;
        }
    }

    if (total == 0) {
        cout << -1;
    } else {
        cout << total << endl;
        cout << min_number;
    }
}