import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
public class simulator {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					simulator window = new simulator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public simulator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.PINK);
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		ImageIcon buttonIcon = new ImageIcon("C:\\Users\\sai vishal\\workspace\\ossimulator\\img\\cpu.jpg");
		JButton but = new JButton("");
		but.setIcon(buttonIcon);
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cpuallcodes c=new cpuallcodes();
				c.cpu();
				
				frame.setVisible(false);
			}
		});
		but.setBounds(62, 82, 239, 243);
		frame.getContentPane().add(but);
		ImageIcon buttonIcon1 = new ImageIcon("C:\\Users\\sai vishal\\workspace\\ossimulator\\img\\page.jpg");
		JButton but1 = new JButton("");
		but1.setIcon(buttonIcon1);
		but1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pageallcodes p=new pageallcodes();
				p.page();
				frame.setVisible(false);
			}
		});
		but1.setBounds(359, 76, 261, 249);
		frame.getContentPane().add(but1);
		
		ImageIcon buttonIcon2 = new ImageIcon("C:\\Users\\sai vishal\\workspace\\ossimulator\\img\\dining1.png");
		JButton but2 = new JButton("");
		but2.setIcon(buttonIcon2);
		but2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DiningGUI d=new DiningGUI();
				d.dine();
				frame.setVisible(false);
			}
		});
		but2.setBounds(50, 362, 261, 265);
		frame.getContentPane().add(but2);
		
		ImageIcon buttonIcon3 = new ImageIcon("C:\\Users\\sai vishal\\workspace\\ossimulator\\img\\disk.png");
		JButton but3 = new JButton("");
		but3.setIcon(buttonIcon3);
		but3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				diskallcombine h=new diskallcombine();
				h.initialize();
				frame.setVisible(false);
			}
		});
		but3.setBounds(359, 372, 261, 255);
		frame.getContentPane().add(but3);
		
		JLabel lblNewAbel = new JLabel("OS Simulator");
		lblNewAbel.setForeground(Color.YELLOW);
		lblNewAbel.setFont(new Font("Lucida Handwriting", Font.BOLD, 25));
		lblNewAbel.setBounds(227, 27, 248, 38);
		frame.getContentPane().add(lblNewAbel);
		
		JLabel lblCpu = new JLabel("CPU Scheduling");
		lblCpu.setForeground(Color.CYAN);
		lblCpu.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 15));
		lblCpu.setBounds(124, 324, 150, 20);
		frame.getContentPane().add(lblCpu);
		
		JLabel lblPageReplacement = new JLabel("Page Replacement");
		lblPageReplacement.setForeground(Color.ORANGE);
		lblPageReplacement.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 15));
		lblPageReplacement.setBounds(433, 321, 161, 25);
		frame.getContentPane().add(lblPageReplacement);
		
		JLabel lblDiningPhilosopher = new JLabel("Dining Philosopher");
		lblDiningPhilosopher.setForeground(Color.WHITE);
		lblDiningPhilosopher.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		lblDiningPhilosopher.setBounds(109, 625, 176, 25);
		frame.getContentPane().add(lblDiningPhilosopher);
		
		JLabel lblDiskScheduling = new JLabel("Disk Scheduling");
		lblDiskScheduling.setForeground(Color.YELLOW);
		lblDiskScheduling.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		lblDiskScheduling.setBounds(433, 625, 146, 25);
		frame.getContentPane().add(lblDiskScheduling);
	}
}
