
public class MainClass {

	public static void main(String[] args) {
		MainModel m = new MainModel();
		MainView v = new MainView();
		MainController c = new MainController(m, v);
		
		//System.out.print("Hello");
		//m.getSchoolClasses();

	}

}
