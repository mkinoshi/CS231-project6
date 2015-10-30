import java.util.*
public class Checkout extends Cell {
	private MyQueue<Cell> stack;

	public int getQueueSize() {
		return stack.size();
	}

	public void updateState(Landscape land) {
		MyQueue<Cell> temstack;
		Double checkX = this.getX();
		Double checkY = this.getY();
		for (int i =0; i< stack.size(); i++) {
			Cell item = stack.poll();
			item.setX(checkX + 0.1*(i+1));
			item.setY(checkY + 0.1*(i+1));
			tempstack.add(item);
		}
		stack = tempstack;
		if (stack.size() > 0) {
			Cell head = stack.peek();
			if (((Customer) head).)
		}
	}

}