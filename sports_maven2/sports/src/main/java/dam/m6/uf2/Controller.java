package dam.m6.uf2;

import java.sql.Connection;

public class Controller {
	Connection conn;

	public static void main(String[] args) { 
		System.out.println("Current directory (aquí heu de posar el XML): " + System.getProperty("user.dir"));
		Controller controller = new Controller();
		controller.init();
	}

	private void init() {

		this.conn = ConnectionManager.getConnection("database.xml");
		MainView mainView = new MainView();
		UserPgDAO userPgDAO = new UserPgDAO(conn);
		SportPgDAO sportPgDAO = new SportPgDAO(conn);
		SportmanPgDAO sportmanPgDAO = new SportmanPgDAO(conn);
		int option;

		do { 
			option = mainView.mainMenu();
			// switch option
			switch (option) {
				case 0:
					// MainView sortir 
					break;
				case 1:
					Sport newSport = mainView.addSportForm();
					if (newSport != null){
						sportPgDAO.add(newSport);
					}
					break;
				case 2:
					mainView.showSports(sportPgDAO.getAll());
					Sportman newSportman = mainView.addSportmanForm();
					if (newSportman != null){
						sportmanPgDAO.add(newSportman);
					}
					break;
				case 3:
					mainView.showSports(sportPgDAO.getAll());
					int sp = mainView.obtainSport();
					mainView.showSportmans(sportmanPgDAO.getBySport(sp));
					break;
				default:
					// Parlar del error
					break;
			}
		} while (option != 0);
		
	}
}
