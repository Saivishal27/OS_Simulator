
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
public class DiningGUI extends JApplet {
	private JFrame frame;
	ImageIcon eat= new ImageIcon("C:\\Users\\sai vishal\\workspace\\ossimulator\\img\\eating.png");
	ImageIcon think= new ImageIcon("C:\\Users\\sai vishal\\workspace\\ossimulator\\img\\thinking.jpg");
	ImageIcon dining= new ImageIcon("C:\\Users\\sai vishal\\workspace\\ossimulator\\img\\diningtable.jpg");
	static final int NUM_PHILOSOPHERS = 5;
	DiningPhilosopher[] philosophers = new DiningPhilosopher[NUM_PHILOSOPHERS];
	static Semaphore permissions = new Semaphore(2);
	static boolean [] philIsEating = {false, false, false, false, false};
	JLabel[] PhilsLables = new JLabel[5];
	JLabel[] comments = new JLabel[5];
	JLabel[] image = new JLabel[5];
	private JLabel lblNewLabel_0;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel Label0;
	private JLabel Label1;
	private JLabel Label2;
	private JLabel Label3;
	private JLabel Label4;
	public static void dine() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiningGUI window = new DiningGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public DiningGUI() {
		initialize();
	}
	ImageIcon[] I=new ImageIcon[5];
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0,850,800);
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Button start = new Button("Start");
		start.setForeground(Color.RED);
		start.setBounds(81, 115, 77, 22);
		start.setBackground(Color.GREEN);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start();
				}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(start);
		lblNewLabel_0 = new JLabel("Philosopher# 0");
		lblNewLabel_0.setForeground(Color.CYAN);
		lblNewLabel_0.setFont(new Font("Perpetua", Font.PLAIN, 17));
		lblNewLabel_0.setBounds(297, 60, 181, 22);
		frame.getContentPane().add(lblNewLabel_0);
		
		lblNewLabel_1 = new JLabel("Philosopher# 1");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setFont(new Font("Perpetua", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(586, 115, 169, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Philosopher# 2");
		lblNewLabel_2.setForeground(Color.CYAN);
		lblNewLabel_2.setFont(new Font("Perpetua", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(563, 337, 169, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Philosopher# 3");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Perpetua", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(321, 511, 169, 22);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Philosopher# 4");
		lblNewLabel_4.setForeground(Color.CYAN);
		lblNewLabel_4.setFont(new Font("Perpetua", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(58, 283, 169, 18);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel Label0 = new JLabel("\\");
		Label0.setBounds(278, 93, 212, 152);
		frame.getContentPane().add(Label0);
		Label0.setIcon(think);
		
		JLabel Label1 = new JLabel("");
		Label1.setBounds(553, 149, 202, 152);
		frame.getContentPane().add(Label1);
		Label1.setIcon(think);
		
		JLabel Label2 = new JLabel("");
		Label2.setBounds(530, 370, 212, 152);
		frame.getContentPane().add(Label2);
		Label2.setIcon(think);
		
		JLabel Label3 = new JLabel("");
		Label3.setBounds(288, 534, 202, 157);
		frame.getContentPane().add(Label3);
		Label3.setIcon(think);
		
		JLabel Label4 = new JLabel("");
		Label4.setBounds(35, 312, 202, 145);
		frame.getContentPane().add(Label4);
		Label4.setIcon(think);
		
		comments[0] = lblNewLabel_0;
		comments[1] = lblNewLabel_1;
		comments[2] = lblNewLabel_2;
		comments[3] = lblNewLabel_3;
		comments[4] = lblNewLabel_4;
		image[0]=Label0;
		image[1]=Label1;
		image[2]=Label2;
		image[3]=Label3;
		image[4]=Label4;
		
		JLabel lblDiningPhilosopher = new JLabel("Dining Philosopher");
		lblDiningPhilosopher.setForeground(Color.GREEN);
		lblDiningPhilosopher.setFont(new Font("Kristen ITC", Font.BOLD, 20));
		lblDiningPhilosopher.setBounds(339, 11, 245, 28);
		frame.getContentPane().add(lblDiningPhilosopher);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(255, 264, 288, 236);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(dining);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.MAGENTA);
		btnHome.setBackground(Color.YELLOW);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulator s=new simulator();
				s.main(null);
				frame.setVisible(false);
			}
		});
		btnHome.setBounds(79, 158, 77, 23);
		btnHome.setContentAreaFilled(false);
		 btnHome.setOpaque(true);

		frame.getContentPane().add(btnHome);
		}
	
	public void start() {		
		
		DiningFork[] forks = new DiningFork[NUM_PHILOSOPHERS];
		for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
			forks[i] = new DiningFork(i);
		}
		for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
			philosophers[i] = new DiningPhilosopher(i, forks[(i + 1) % NUM_PHILOSOPHERS], forks[i], comments[i],image[i]);
			new Thread(philosophers[i]).start();
		}
	}
	public synchronized static boolean leftNeighbourPhilosopher(int id) {
		return DiningGUI.philIsEating[(id + 1)
				% DiningGUI.NUM_PHILOSOPHERS]; 
	}
	public synchronized static boolean rightNeighbourPhilosopher(int id) {

		if (id == 0)
			return DiningGUI.philIsEating[4]; 
		else
			return DiningGUI.philIsEating[(id - 1)
					% DiningGUI.NUM_PHILOSOPHERS]; 
	}
}