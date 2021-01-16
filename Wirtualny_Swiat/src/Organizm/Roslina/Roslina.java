package Organizm.Roslina;
import Organizm.*;

import java.security.interfaces.RSAKey;

public abstract class Roslina extends Organizm {

    Roslina()
    {
        setInicjatywa__(0); // wszystkie rosliny maja inicjatywe = 0
        setSila__(0);  // wiekszosc roslin w tabelce ma 0
    }
    protected abstract void rozprzestrzenianie(Roslina rodzic, int x, int y);
    @Override
    public void akcja() {
        int losowaLiczba;
        losowaLiczba = (int) (Math.random() * 4);
        int wspolrzedna;
        Organizm roslinaNaPolu;
        switch (losowaLiczba){
            case 0:
                wspolrzedna = this.getX__() - 1;
                if (wspolrzedna < 0 || wspolrzedna >= getSwiat__().getSzerokosc())
                    return;
                roslinaNaPolu = getSwiat__().coStoi(wspolrzedna, this.getY__());
                if(roslinaNaPolu == null) {
                    rozprzestrzenianie(this, wspolrzedna,this.getY__());
                }
                break;
            case 1:
                wspolrzedna = this.getY__() - 1;
                if (wspolrzedna < 0 || wspolrzedna >= getSwiat__().getWysokosc())
                    return;
                roslinaNaPolu = getSwiat__().coStoi(this.getX__(), wspolrzedna);
                if(roslinaNaPolu == null) {
                    rozprzestrzenianie(this, this.getX__(), wspolrzedna);
                }
                break;
            case 2:
                wspolrzedna = this.getX__() + 1;
                if (wspolrzedna < 0 || wspolrzedna >= getSwiat__().getSzerokosc())
                    return;
                roslinaNaPolu = getSwiat__().coStoi(wspolrzedna, this.getY__());
                if(roslinaNaPolu == null) {
                    rozprzestrzenianie(this, wspolrzedna, this.getY__());
                }
                break;
            case 3:
                wspolrzedna = this.getY__() + 1;
                if (wspolrzedna < 0 || wspolrzedna >= getSwiat__().getWysokosc())
                    return;
                roslinaNaPolu = getSwiat__().coStoi(this.getX__(), wspolrzedna);
                if(roslinaNaPolu == null) {
                    rozprzestrzenianie(this, this.getX__(), wspolrzedna);
                }
                break;
        }
    }


    @Override
    public abstract void rysowanie();
}
