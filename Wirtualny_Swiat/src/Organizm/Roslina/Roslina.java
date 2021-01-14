package Organizm.Roslina;
import Organizm.*;

public abstract class Roslina extends Organizm {

    Roslina()
    {
        setInicjatywa__(0); // wszystkie rosliny maja inicjatywe = 0
        setSila__(0);  // wiekszosc roslin w tabelce ma 0
    }
    @Override
    public void akcja() {

    }

    @Override
    public void kolizja(Organizm organizm) {

    }

    @Override
    public abstract void rysowanie();

    @Override
    public boolean reakcja(Organizm przeciwnik) {
        return false;
    }
}
