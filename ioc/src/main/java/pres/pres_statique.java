package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class pres_statique {

    public static void main(String[] args){

        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao);
        //metier.setDao(dao);
        System.out.println("Résultat : " + metier.calcul());
    }
}
