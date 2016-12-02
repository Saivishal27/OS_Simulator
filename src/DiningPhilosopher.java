import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class DiningPhilosopher implements Runnable {
		public int id;
	DiningFork leftFork, rightFrok; 
	private JLabel  comments;
	private JLabel  image;
	private Random randomPeriod = new Random(); 
	int maxPeriod = 2000; 
	int numberOfMeals = 0;
	ImageIcon eat= new ImageIcon("C:\\Users\\sai vishal\\workspace\\diningphilosopher\\img\\eating.png");
	ImageIcon hungry= new ImageIcon("C:\\Users\\sai vishal\\workspace\\diningphilosopher\\img\\waiting.png");
	ImageIcon think= new ImageIcon("C:\\Users\\sai vishal\\workspace\\diningphilosopher\\img\\thinking.jpg");
	public DiningPhilosopher(int id, DiningFork leftFork, DiningFork rightFrok, JLabel comments, JLabel image) {
		super();
		this.id = id;
		this.leftFork = leftFork;
		this.rightFrok = rightFrok;
		this.comments = comments;
		this.image=image;
	}
	public void run() {
		while (true) {
			try {
				this.think();
				this.hungry();
				this.eat();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private void think() throws InterruptedException {
	
		comments.setText("Philosopher# "+id+" Thinking");
		image.setIcon(think);
		comments.setForeground(Color.RED);
		Thread.sleep(randomPeriod.nextInt(maxPeriod));
	}
	public void hungry() throws InterruptedException {
		while (DiningGUI.leftNeighbourPhilosopher(id) || DiningGUI.rightNeighbourPhilosopher(id)) {
			Thread.sleep(randomPeriod.nextInt(10));
		}
		DiningGUI.permissions.acquire();
		leftFork.pickUp();
		rightFrok.pickUp();
		DiningGUI.philIsEating[id] = true;
	}

	private void eat() throws InterruptedException {
		
		comments.setText("Philosopher# "+id+" Eating");
		comments.setForeground(Color.GREEN);
		image.setIcon(eat);
		Thread.sleep(randomPeriod.nextInt(maxPeriod));
		leftFork.putDown();
		rightFrok.putDown();
		DiningGUI.permissions.release();
		DiningGUI.philIsEating[id] = false;
	}
}
