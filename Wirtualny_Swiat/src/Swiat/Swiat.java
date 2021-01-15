package Swiat;

import Organizm.Organizm;
import Organizm.Zwierze.Komar;
import Organizm.Zwierze.Owca;
import Organizm.Zwierze.Wilk;
import Organizm.Zwierze.Zolw;

import java.util.*;

public class Swiat {
    private int szerokosc__;
    private int wysokosc__;
    List<Organizm> organizmy = new ArrayList<>();
    Swiat(int szerokosc, int wysokosc){
        this.szerokosc__ = szerokosc - 1;
        this.wysokosc__ = wysokosc - 1;
    }
    private void sortujOrganizmy(){
        organizmy.sort(new SortujPoInicjatywie());
    }
    public void dodajOrganizm(Organizm organizm) throws Exception {
        int tempX = organizm.getX__();
        int tempY = organizm.getY__();
        if (tempX >=0 && tempX <= getSzerokosc() && tempY >= 0 && tempY <= getWysokosc()) {
            organizmy.add(organizm);
            return;
        }
        throw new Exception("Organizm poza swiatem"); }

    public int getSzerokosc() {
        return szerokosc__;
    }

    public int getWysokosc() {
        return wysokosc__;
    }

    public void wykonajTure(){
        sortujOrganizmy();
        for (int i = 0; i<organizmy.size(); i++)
        {
            organizmy.get(i).akcja();
            organizmy.get(i).zwiekszWiek();
        }
//        for (Organizm organizm:
//             organizmy) {
//            organizm.akcja();
//            organizm.zwiekszWiek();
//        }
    }
    public void rysujSwiat(){
        boolean znalezionoOrganizm = false;
        for (int i = 0; i < getWysokosc(); i++){
            for (int j = 0; j < getSzerokosc(); j++){
                for (Organizm organizm: organizmy) {
                    if (organizm.getX__() == j && organizm.getY__() == i) {
                        organizm.rysowanie();
                        znalezionoOrganizm = true;
                        break;
                    }
                }
                if (!znalezionoOrganizm)
                    System.out.print('_');
                znalezionoOrganizm = false;
            }
            System.out.print('\n');
        }
    }
    private void usunMartweOrganizmy(){
        organizmy.removeIf(organizm -> !organizm.getZyje__());
    }
    public Organizm coStoi(int x, int y){
        for (Organizm organizm : organizmy) {
            if (x == organizm.getX__() && y == organizm.getY__())
            {
                return organizm;
            }
        }
        return null;
    }
    public class SortujPoInicjatywie implements Comparator<Organizm> {
        public int compare(Organizm o1, Organizm o2) {

            if (o1.getInicjatywa__() == o2.getInicjatywa__())
                return o2.getWiek__() - o1.getWiek__();
            return o2.getInicjatywa__() - o1.getInicjatywa__();
        }
    }
    public static void main(String[] args) {
        Swiat swiat = new Swiat(10,10);
        try {
            swiat.dodajOrganizm((new Komar(swiat, 1,1)));
            swiat.dodajOrganizm((new Owca(swiat, 4,1)));
            swiat.dodajOrganizm((new Owca(swiat, 5,7)));
            swiat.dodajOrganizm((new Komar(swiat, 2,1)));
            //swiat.dodajOrganizm((new Zolw(swiat, -1,1)));
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(-1);
        }
        Scanner scan = new Scanner(System.in);
        swiat.rysujSwiat();
        System.out.print('\n');
        int i = 1;
        while (true) {
            swiat.wykonajTure();
            swiat.usunMartweOrganizmy();
            swiat.rysujSwiat();
            System.out.println();
            System.out.println(i);
            System.out.println();
            i++;
            //scan.nextLine();
        }
    }
}
