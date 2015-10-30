import java.util.*;
public class Customer {
	private int baskets;
	private int phase;
	private int timetilcounter;
	public int selection;

	public Customer (double x0, double y0) {
		super(x0, y0);
		baskets = 1;
		selection = 1;
	}

	public void setX(double xval) {
		x = xval;
	}

	public void setY(double yval) {
		y = yval;
	}
	
	public void updateState(Landscape land) {
		Random r = new Random();
		if (selection == 1) {
			int index = r.nextInt(land.getAgent(2).size())
			land.getAgent(2).get(index).addtoQueue(this);
			time = time + 1;
		} else if (selection == 2) {
			int index1 = r.nextInt(land.getAgent(2).size());
			int index2 = r.nextInt(land.getAgent(2).size());
			while (index == index2) {
				index2 = r.nextInt(land.getAgent(2).size());
			}
			if (land.getAgent(2).get(index1).size() > land.getAgent(2).get(index2).size()) {
				land.getAgent(2).get(index2).addtoQueue(this);
			} else {
				land.getAgent(2).get(index1).addtoQueue(this);
			}
		} else if (selection == 3) {
			Consumer default = land.getAgent(2).get(0);
			for (int i=1; i < land.getAgent(2).size(); i++) {
				if(land.getAgent(2).get(i).getQueueSize() < default.getQueueSize()) {
					defualt = land.getAgent(2).get(i).addtoQueue(this);
				}
			}
			default.addtoQueue(this);
		}
	}
}