#include <stdio.h>

void test_method(int x) { 
    if (x == 10) {          //Ha 2 = jelet használunk, akkor kifogástalan
        printf("%d\n", x);
    }
}

void test_method_2(int x) {
    if (x = 10) {           //Ha ha véletlen csak 1 = jelet írunk 2 helyett, akkor a feltétel mindig igaz lesz, ugyanis x-nek értékül adjuk 10-et
        printf("%d\n", x);
    }
}

void stable_method(int x) {
    if (10 = x) {           //Ha megszokjuk, hogy a változó van a második helyen a feltételben, akkor elkerülhetjük a bugokat, ugyanis a fordító
        printf("%d\n", x)   //figyelmeztet a szintaktikai hibára, ha csak 1 = jelet használtunk
    }
}

int main() {

    test_method(12);
    test_method_2(12);
    stable_method(12);    

    return 0;
}