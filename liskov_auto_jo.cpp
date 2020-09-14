class Auto {
//public:
    //virtual void benzin_fogyasztas() {};
};

class Program {
public:
    void fgv (Auto &auto) {
        auto.benzin_fogyasztas();
    }
};

class BenzinesAuto : public Auto
{
    virtual void repul() {};
};

class Trabant : public Auto 
{};

class VolvoXC60Recharge : public BenzinesAuto
{};

int main(int argc, char **argv) {
    Program program;
    Auto auto;
    program.fgv(auto);

    Trabant trabant;
    program.fgv(trabant);

    VolvoXC60Recharge elektromosVolvo;
    program.fgv(elektromosVolvo);
}