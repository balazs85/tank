import java.util.List;


public class MainController {
	MainModel m;
	MainView v;
	
	
	
	public MainController(MainModel m, MainView v){
		this.m = m;
		this.v = v;
		intit();
		
	}



	private void intit() {
		//List<String> where = new ArrayList<String>();
		List<String> schoolClasses = m.getSchoolClasses();
		for (String string : schoolClasses) {
			v.classComboBox.addItem(string);
		}
		List<String> aaa = m.getStudentsInClass("1/a", 2013);
		v.showWindow();
		
	}
}
