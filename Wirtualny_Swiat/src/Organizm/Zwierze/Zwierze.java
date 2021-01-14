package Organizm.Zwierze;
import Organizm.Organizm;

abstract class Zwierze extends Organizm {

    protected abstract Zwierze rozmnazanie(Organizm rodzic, int x, int y);
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
                    //akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(nowyX, getY__());
                if (przeciwnik == null)
                    setX__(nowyX);
                else
                    kolizja(przeciwnik);
                break;
            case 1:
                nowyY = getY__() - 1;
                if (nowyY < 0 || nowyY >= getSwiat__().getWysokosc()){
                    //akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(getX__(), nowyY);
                if (przeciwnik == null)
                    setY__(nowyY);
                else
                    kolizja(przeciwnik);
                break;
            case 2:
                nowyX = getX__() + 1;
                if(nowyX < 0 || nowyX >= getSwiat__().getSzerokosc())
                {
                    //akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(nowyX, getY__());
                if (przeciwnik == null)
                    setX__(nowyX);
                else
                    kolizja(przeciwnik);
                break;
            case 3:
                nowyY = getY__() + 1;
                if (nowyY < 0 || nowyY >= getSwiat__().getWysokosc()){
                    //akcja();
                    return;
                }
                przeciwnik = getSwiat__().coStoi(getX__(), nowyY);
                if (przeciwnik == null)
                    setY__(nowyY);
                else
                    kolizja(przeciwnik);
                break;
        }
    }

    @Override
    public void kolizja(Organizm organizm) {

        if (organizm.getClass() == this.getClass()){
            int losowyWybor;
            losowyWybor = (int) Math.random() * 4;
            Organizm organizmNaPolu;
            int wspolrzedna;
            switch (losowyWybor){
                case 0:
                    wspolrzedna = organizm.getX__()-1;
                    if (wspolrzedna < 0 || wspolrzedna > getSwiat__().getSzerokosc())
                        return;
                    organizmNaPolu = getSwiat__().coStoi(wspolrzedna,organizm.getY__());
                    if (organizmNaPolu == null) {
                        organizmNaPolu = rozmnazanie(organizm, wspolrzedna, organizm.getY__());

                        try {
                            getSwiat__().dodajOrganizm(organizmNaPolu);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    wspolrzedna = organizm.getY__() - 1;
                    if (wspolrzedna < 0 || wspolrzedna > getSwiat__().getWysokosc())
                        return;
                        organizmNaPolu = getSwiat__().coStoi(organizm.getX__(),wspolrzedna);
                    if (organizmNaPolu == null) {
                        organizmNaPolu = rozmnazanie(organizm, organizm.getX__(), wspolrzedna);

                        try {
                            getSwiat__().dodajOrganizm(organizmNaPolu);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                        wspolrzedna = organizm.getX__() + 1;
                    if (wspolrzedna < 0 || wspolrzedna > getSwiat__().getSzerokosc())
                        return;
                    organizmNaPolu = getSwiat__().coStoi(wspolrzedna,organizm.getY__());
                    if (organizmNaPolu == null) {
                        organizmNaPolu = rozmnazanie(organizm, wspolrzedna, organizm.getY__());

                        try {
                            getSwiat__().dodajOrganizm(organizmNaPolu);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    wspolrzedna = organizm.getY__() + 1;
                    if (wspolrzedna < 0 || wspolrzedna > getSwiat__().getWysokosc())
                        return;
                        organizmNaPolu = getSwiat__().coStoi(organizm.getX__(),wspolrzedna);
                    if (organizmNaPolu == null) {
                        organizmNaPolu = rozmnazanie(organizm, organizm.getX__(), wspolrzedna);

                        try {
                            getSwiat__().dodajOrganizm(organizmNaPolu);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
//            Zwierze noweZwierze = rozmnazanie();
//            getSwiat__().dodaj
        }
        else if (organizm.reakcja(this)) {
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

