
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JPanel;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
public class pageallcodes {

	int f,a;
	String fifo1;
	String lru;
	String optimal;
	String secondchance;
	String pa;
	String pa1;
	private JFrame frame;
	private JTextField noofprocesses;
	private JTextField noofframes;
	private JTextField fifotext;
	private JTextField optimaltext;
	private JTextField lrutext;
	private JTextField secondtext;
	private JTable table;
	private JTextPane textPane;
	private JTextPane textPane_1;

	/**
	 * Launch the application.
	 */
	public static void page() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageallcodes window = new pageallcodes();
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
	public pageallcodes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		final pagecombine page=new pagecombine();
		frame = new JFrame();
		frame.setBounds(100, 100, 621, 595);
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("No of Processes");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		lblNewLabel.setBounds(52, 72, 114, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("No of Frames");
		lblNewLabel_1.setForeground(new Color(255, 222, 173));
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		lblNewLabel_1.setBounds(245, 72, 96, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton fifobutton = new JButton("FIFO");
		fifobutton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		fifobutton.setForeground(Color.BLACK);
		fifobutton.setBackground(Color.CYAN);
		fifobutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fifo1=page.fifo();
				fifotext.setText(fifo1);
				int result[]=page.res();
				String t=noofframes.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(result[i])+'\n'+'\n');
					System.out.println("array"+result[i]);
				}
				textPane.setText(pa);
				
				/*
				Object data[][];
				data=new Object[f][a];
				Object column[];
				column=new Object[a];
				int k=0;
				for(int i=0;i<f;i++)
				{
					for(int j=0;j<a;j++)
					{
						data[i][j]=Integer.toString(fifo[k]);
						k++;
						column[j]="";
					}
					
				}
				JTable jt=new JTable(data,column);
				frame.getContentPane().setLayout(null);
				panel.add(jt);*/
			}
			
		});
		fifobutton.setBounds(34, 125, 89, 23);
		fifobutton.setContentAreaFilled(false);
		fifobutton.setOpaque(true);
		frame.getContentPane().add(fifobutton);
		
		JButton optimalbutton = new JButton("Optimal");
		optimalbutton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		optimalbutton.setBackground(Color.CYAN);
		optimalbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				optimal=page.optimal();
				optimaltext.setText(optimal);
				int result[]=page.res();
				String t=noofframes.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(result[i])+'\n'+'\n');
					System.out.println("array"+result[i]);
				}
				textPane.setText(pa);
				
			}
		});
		optimalbutton.setBounds(343, 125, 89, 23);
		optimalbutton.setContentAreaFilled(false);
		optimalbutton.setOpaque(true);
		frame.getContentPane().add(optimalbutton);
		
		JButton lrubutton = new JButton("LRU");
		lrubutton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		lrubutton.setBackground(Color.CYAN);
		lrubutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lru=page.lru();
				lrutext.setText(lru);
				int result[]=page.res();
				String t=noofframes.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(result[i])+'\n'+'\n');
					System.out.println("array"+result[i]);
				}
				textPane.setText(pa);
			}
		});
		lrubutton.setBounds(37, 207, 89, 23);
		lrubutton.setContentAreaFilled(false);
		lrubutton.setOpaque(true);
		frame.getContentPane().add(lrubutton);
		
		JButton secondbutton = new JButton("Second Chance");
		secondbutton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		secondbutton.setBackground(Color.CYAN);
		secondbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secondchance=page.secondchance();
				secondtext.setText(secondchance);
				int result[]=page.res();
				String t=noofframes.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(result[i])+'\n'+'\n');
					System.out.println("array"+result[i]);
				}
				textPane.setText(pa);
			}
		});
		secondbutton.setBounds(312, 207, 142, 23);
		secondbutton.setContentAreaFilled(false);
		secondbutton.setOpaque(true);
		frame.getContentPane().add(secondbutton);
		
		noofprocesses = new JTextField();
		noofprocesses.setBounds(169, 70, 59, 20);
		frame.getContentPane().add(noofprocesses);
		noofprocesses.setColumns(10);
		
		noofframes = new JTextField();
		noofframes.setBounds(343, 70, 59, 20);
		frame.getContentPane().add(noofframes);
		noofframes.setColumns(10);
		
		fifotext = new JTextField();
		fifotext.setBounds(37, 159, 86, 20);
		frame.getContentPane().add(fifotext);
		fifotext.setColumns(10);
		
		optimaltext = new JTextField();
		optimaltext.setBounds(346, 159, 86, 20);
		frame.getContentPane().add(optimaltext);
		optimaltext.setColumns(10);
		
		lrutext = new JTextField();
		lrutext.setBounds(37, 243, 86, 20);
		frame.getContentPane().add(lrutext);
		lrutext.setColumns(10);
		
		secondtext = new JTextField();
		secondtext.setBounds(346, 243, 86, 20);
		frame.getContentPane().add(secondtext);
		secondtext.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Page Replacement Algorithms");
		lblNewLabel_2.setForeground(new Color(238, 130, 238));
		lblNewLabel_2.setFont(new Font("Kristen ITC", Font.BOLD, 19));
		lblNewLabel_2.setBounds(161, 11, 313, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton inputbutton = new JButton("Input");
		inputbutton.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		inputbutton.setForeground(Color.WHITE);
		inputbutton.setBackground(Color.GREEN);
		inputbutton.setContentAreaFilled(false);
		 inputbutton.setOpaque(true);
		inputbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=noofprocesses.getText();
				String m=noofframes.getText();
			 f=Integer.parseInt(m);
			 a=Integer.parseInt(n);
				int input[]=page.input(a,f);
				pa1=new String();
				for(int j=0;j<a;j++){
					pa1=pa1.concat(Integer.toString(input[j])+' '+' ');
				}
				textPane_1.setText(pa1);
			}
		});
		inputbutton.setBounds(196, 172, 89, 23);
		frame.getContentPane().add(inputbutton);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 12));
		btnHome.setForeground(Color.WHITE);
		btnHome.setBackground(Color.RED);
		btnHome.setContentAreaFilled(false);
		 btnHome.setOpaque(true);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulator s=new simulator();
				s.main(null);
				frame.setVisible(false);
			}
		});
		btnHome.setBounds(34, 34, 89, 23);
		frame.getContentPane().add(btnHome);
		
		textPane = new JTextPane();
		textPane.setBounds(489, 78, 32, 331);
		frame.getContentPane().add(textPane);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(37, 339, 417, 31);
		frame.getContentPane().add(textPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("Input Processes");
		lblNewLabel_3.setForeground(Color.GREEN);
		lblNewLabel_3.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 13));
		lblNewLabel_3.setBounds(224, 305, 114, 23);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblFinalOutput = new JLabel("Final Output");
		lblFinalOutput.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
		lblFinalOutput.setForeground(Color.CYAN);
		lblFinalOutput.setBounds(471, 43, 89, 24);
		frame.getContentPane().add(lblFinalOutput);
		
		
		
	}
}
