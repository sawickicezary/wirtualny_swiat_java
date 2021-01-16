package Swiat;

import Organizm.Organizm;
import Organizm.Roslina.Ciern;
import Organizm.Roslina.Mlecz;
import Organizm.Roslina.Trawa;
import Organizm.Zwierze.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aplikacja {
    private Swiat swiat;
    private int x;
    private int y;
    private JFrame frame;
    private JPanel przycisk;
    private JPanel mapa;
    Aplikacja(int x, int y){
        swiat = new Swiat(x,y);
        this.x = x - 1;
        this.y = y - 1;
    }
    public void startGry(){
        frame = new JFrame("Cezary Sawicki 175723");
        frame.setVisible(true);
        frame.setSize(618,612);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void stworzyPolePrzyciskow(){
        JPanel panelPrzyciskow = new JPanel();
        panelPrzyciskow.setLayout(new GridLayout(1,1));
        panelPrzyciskow.setBackground(Color.lightGray);
        JButton przyciskNastepnaTura = new JButton("Nastepna tura");
        przyciskNastepnaTura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                swiat.wykonajTure();
                swiat.usunMartweOrganizmy();
                frame.remove(mapa);
                mapa = stworzPoleMapy();
                frame.add(mapa);
                //frame.setVisible(false);
                frame.setVisible(true);
                //stworzPoleMapy();
            }
        });
        panelPrzyciskow.add(przyciskNastepnaTura);
        frame.add(panelPrzyciskow, BorderLayout.NORTH);
        frame.setVisible(true);
    }
    public JPanel stworzPoleMapy(){
        JPanel panelMapy = new JPanel();
        JButton temp;
        panelMapy.setLayout(new GridLayout(x, y));
        panelMapy.setBackground(Color.white);
        boolean znalezionoOrganizm = false;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++){
                for (Organizm organizm:swiat.getOrganizmy()){
                    if(organizm.getX__() == i && organizm.getY__() == j) {
                        temp = organizm.rysowanie();
                        panelMapy.add(temp);
                        znalezionoOrganizm = true;
                        break;
                    }
                }
                if(!znalezionoOrganizm){
                    temp = new JButton();
                    temp.setBackground(Color.white);
                    panelMapy.add(temp);
                }
                znalezionoOrganizm = false;
            }
        }
//        frame.add(panelMapy);
//        frame.setVisible(true);
        return panelMapy;
    }
    public void dodajOrganizmy() {
        try {
            swiat.dodajOrganizm((new Trawa(swiat, 1, 1)));
            swiat.dodajOrganizm((new Mlecz(swiat, 4, 1)));
            swiat.dodajOrganizm((new Ciern(swiat, 5, 7)));
            swiat.dodajOrganizm((new Komar(swiat, 2,1)));
            swiat.dodajOrganizm((new Zolw(swiat, 5,1)));
            swiat.dodajOrganizm((new Zolw(swiat, 5,2)));
            swiat.dodajOrganizm((new Wilk(swiat, 7,4)));
            swiat.dodajOrganizm((new Wilk(swiat, 7,5)));
            swiat.dodajOrganizm((new Koala(swiat, 9,9)));
            swiat.dodajOrganizm((new Owca(swiat, 9,5)));
            swiat.dodajOrganizm((new Owca(swiat, 9,6)));
            swiat.dodajOrganizm((new Owca(swiat, 9,7)));
        } catch (Exception exception) {
            exception.printStackTrace();
            System.exit(-1);
        }
    }
    public static void main(String[] args) {
        Aplikacja aplikacja = new Aplikacja(10,10);
        aplikacja.dodajOrganizmy();
        aplikacja.startGry();
      //  aplikacja.stworzPoleMapy();
        aplikacja.swiat.wykonajTure();
        aplikacja.stworzyPolePrzyciskow();
        aplikacja.mapa = aplikacja.stworzPoleMapy();
        aplikacja.frame.add(aplikacja.mapa);

//        while (true){
////            aplikacja.frame.invalidate();
////            aplikacja.frame.validate();
////            aplikacja.frame.repaint();
//            //aplikacja.stworzPoleMapy();
//
//        }
    }
}
