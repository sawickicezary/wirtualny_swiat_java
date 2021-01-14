package Organizm.Zwierze;
import Organizm.Organizm;

abstract class Zwierze extends Organizm {

    @Override
    public boolean reakcja(Organizm przeciwnik) {
        return true; // Zezwala na dalszy ruch
    }


    @Override
    public void akcja() {
        int wybor = (int) (Math.random() * 4);
        int nowyX;
        int nowyY;
        Organizm przeciwnik;
        switch (wybor) {
            case 0:
                nowyX = getX__() - 1;
                if(nowyX < 0 || nowyX >= getSwiat__().getSzerokosc())
                {
                    akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(nowyX, getY__());
                if (przeciwnik == null)
                    setX__(nowyX);
                else
                    kolizja(przeciwnik);
            case 1:
                nowyY = getY__() - 1;
                if (nowyY < 0 || nowyY >= getSwiat__().getWysokosc()){
                    akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(getX__(), nowyY);
                if (przeciwnik == null)
                    setY__(nowyY);
                else
                    kolizja(przeciwnik);
            case 2:
                nowyX = getX__() + 1;
                if(nowyX < 0 || nowyX >= getSwiat__().getSzerokosc())
                {
                    akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(nowyX, getY__());
                if (przeciwnik == null)
                    setX__(nowyX);
                else
                    kolizja(przeciwnik);
            case 3:
                nowyY = getY__() + 1;
                if (nowyY < 0 || nowyY >= getSwiat__().getWysokosc()){
                    akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(getX__(), nowyY);
                if (przeciwnik == null)
                    setY__(nowyY);
                else
                    kolizja(przeciwnik);
        }
    }

    @Override
    public void kolizja(Organizm organizm) {
        if (organizm.reakcja(this)) {
            if (getSila__() >= organizm.getSila__()) {
                this.setX__(organizm.getX__());
                this.setY__(organizm.getY__());
                organizm.setZyje__(false);
                return;
            }
            this.setZyje__(false);
        }
    }

    @Override
    public abstract void rysowanie();

}

