#include <iostream>
#include <string>

using namespace std;

class CarParent {
    public:
        string rendszam;
        string gyarto;
        string tipus;

        CarParent(string rndszm, string gyrt, string tps) {
            rendszam = rndszm;
            gyarto = gyrt;
            tipus = tps;
        }

        string getRendszam() {
            return rendszam;
        }
};

class CarChild : public CarParent{
    public:
        CarChild(string rndszm, string gyrt, string tps) : CarParent(rndszm, gyrt, tps) {
            rendszam = rndszm;
            gyarto = gyrt;
            tipus = tps;
        }

        string getGyarto() {
            return gyarto;
        }
};

int main() {

    CarParent* cp = new CarChild("ABC-123", "Ford", "Fiesta");
    CarChild* cc = new CarChild("ZYX-321", "Opel", "Astra");

    cout << cc->getGyarto() << " " << cp->getGyarto() << endl;

    return 0;
}