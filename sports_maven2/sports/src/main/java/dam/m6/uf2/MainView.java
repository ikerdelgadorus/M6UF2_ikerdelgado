package dam.m6.uf2;

import java.util.List;
import java.util.Scanner;

public class MainView {

    /**
     * @return
     */

    private Scanner sc;

    public MainView(){
        sc = new Scanner(System.in);
    }

    public int mainMenu() {
        // TODO Auto-generated method stub
        System.out.print("1. Afegeix sport\n2. Afegeix atleta\n3. Llistar atletes per sport\n0. Sortir\n\nEscriu una opcio: ");
        int option = sc.nextInt();
        System.out.println();

        return option;
    }

    public void showUsers(List<User> list) {
        // Llistat d'usuaris
        System.out.println("MOSTRAR LLISTAT USUARIS....");
        for (User user : list) {
            System.out.println(user.name + "\t" + user.password + "\tetc");
        }
        System.out.println();
    }

    public void showSports(List<Sport> list) {
        // Llistat d'usuaris
        System.out.println("MOSTRAR LLISTAT ESPORTS....");
        for (Sport s : list) {
            System.out.println(s.cod + "\t" + s.name);
        }
        System.out.println();
    }

    public void showSportmans(List<Sportman> list) {
        // Llistat d'usuaris
        System.out.println("MOSTRAR LLISTAT ESPORTISTES....");
        for (Sportman s : list) {
            System.out.println(s.cod + "\t" + s.name);
        }
        System.out.println();
    }

    
    public User addUserForm(){
        // Formulari usuari,
        System.out.println("FORMULARI USUARI....nom, pass, etc");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        String password = "1234";

        return new User(username,password);
    }

    public Sport addSportForm(){
        // Formulari usuari,
        sc.nextLine();
        System.out.println("FORMULARI SPORT");
        System.out.print("Escriu el nom del esport: ");

        String s_name = sc.nextLine();
        System.out.println();

        return new Sport(0, s_name);
    }

    public Sportman addSportmanForm(){
        // Formulari usuari,
        sc.nextLine();
        System.out.println("FORMULARI SPORTMAN");
        System.out.print("Escriu el nom del atleta: ");

        String s_name = sc.nextLine();

        System.out.print("Escriu el nombre del esport: ");

        String s_sport = sc.nextLine();
        System.out.println();

        return new Sportman(0, s_name, Integer.parseInt(s_sport));
    }

    public int obtainSport(){
        System.out.print("Escriu el nombre del esport: ");
        //Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        System.out.println();
        //sc.close();
        return option;
    }
}
