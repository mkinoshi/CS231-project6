import java.util.*
public class Spawner exnteds Cell{
	private Landscape scape;
	private int counterrows;
	private int numproducts;

	public Spawner(int num) {
		scape = new Landscape(100, 100);
		Customer customer = new Customer();
		iterations = num;
		numproducts = 20;
	}
	public addingAgent () {
		for (int j= 0; j < numproducts; j ++) {
			scape.add(new Cell(0,0));
		}
		iterations = iterations -1;
	}

}