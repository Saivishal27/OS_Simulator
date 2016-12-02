

import java.awt.EventQueue;
import javax.swing.border.MatteBorder;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.UIManager;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JTextPane;

public class cpuallcodes {
	
	String npp;
	String pp;
	String rr;
	String np;
	String f;
	String p;
	String pa=null;
	private JFrame frame;
	private JTextField noofprocesses;
	private JTextField time;
	private JTextField rrt;
	private JTextField ft;
	private JTextField npt;
	private JTextField pt;
	private JTextField nppt;
	private JTextField ppt;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void cpu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cpuallcodes window = new cpuallcodes();
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
	public cpuallcodes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
		final cpucombine fcfs=new cpucombine();
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 700);
		frame.getContentPane().setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		noofprocesses = new JTextField();
		noofprocesses.setBounds(271, 52, 110, 20);
		noofprocesses.setColumns(10);
		
		JLabel lblNoOfProcesses = new JLabel("No of Processes:");
		lblNoOfProcesses.setForeground(Color.PINK);
		lblNoOfProcesses.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
		lblNoOfProcesses.setBounds(155, 51, 130, 20);
		
		JButton btnFcfs = new JButton("FCFS");
		btnFcfs.setForeground(new Color(128, 128, 128));
		btnFcfs.setBackground(Color.CYAN);
		btnFcfs.setContentAreaFilled(false);
		 btnFcfs.setOpaque(true);

		btnFcfs.setBounds(43, 125, 99, 23);
		 btnFcfs.setOpaque(true);

		btnFcfs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//combine fcfs=new combine();
				f=fcfs.fcf();
				int wt[]=fcfs.waiting();
				
				ft.setText(f);
				
				String t=noofprocesses.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(Math.abs(wt[i]))+'\n'+'\n');
					System.out.println("array"+Math.abs(wt[i]));
				}
				textPane.setText(pa);
			}
		});
		btnFcfs.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		
		JButton btnSjfpreemptive = new JButton("SJF-Preemptive");
		btnSjfpreemptive.setForeground(new Color(128, 128, 128));
		btnSjfpreemptive.setBackground(Color.CYAN);
		btnSjfpreemptive.setBounds(412, 125, 130, 23);
		btnSjfpreemptive.setContentAreaFilled(false);
		btnSjfpreemptive.setOpaque(true);
		btnSjfpreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//combine fcfs=new combine();
				p=fcfs.ppro();
				pt.setText(p);
				int wt[]=fcfs.waiting();
				String t=noofprocesses.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(Math.abs(wt[i]))+'\n'+'\n');
					System.out.println("array"+Math.abs(wt[i]));
				}
				textPane.setText(pa);
			}
		});
		btnSjfpreemptive.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		
		JButton btnSjfnonPreemptive = new JButton("SJF-Non Preemptive");
		btnSjfnonPreemptive.setForeground(new Color(128, 128, 128));
		btnSjfnonPreemptive.setBackground(Color.CYAN);
		btnSjfnonPreemptive.setContentAreaFilled(false);
		btnSjfnonPreemptive.setOpaque(true);

		btnSjfnonPreemptive.setBounds(216, 125, 149, 23);
		btnSjfnonPreemptive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//combine fcfs=new combine();
				np=fcfs.nppro();
				npt.setText(np);
				int wt[]=fcfs.waiting();
				String t=noofprocesses.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(Math.abs(wt[i]))+'\n'+'\n');
					System.out.println("array"+Math.abs(wt[i]));
				}
				textPane.setText(pa);
				}
		});
		btnSjfnonPreemptive.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		
		JButton btnRoundRobin = new JButton("Round Robin");
		btnRoundRobin.setForeground(new Color(128, 128, 128));
		btnRoundRobin.setBackground(Color.CYAN);
		btnRoundRobin.setBounds(43, 209, 109, 23);
		btnRoundRobin.setContentAreaFilled(false);
		btnRoundRobin.setOpaque(true);
		btnRoundRobin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//combine fcfs=new combine();
			rr=fcfs.rbpro();
				rrt.setText(rr);
				int wt[]=fcfs.waiting();
				String t=noofprocesses.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(Math.abs(wt[i]))+'\n'+'\n');
					System.out.println("array"+Math.abs(wt[i]));
				}
				textPane.setText(pa);
				}
		});
		btnRoundRobin.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		
		JButton btnSjf = new JButton("SJF-NonPreempPrio");
		btnSjf.setForeground(new Color(128, 128, 128));
		btnSjf.setBackground(Color.CYAN);
		btnSjf.setContentAreaFilled(false);
		btnSjf.setOpaque(true);
		btnSjf.setBounds(216, 209, 149, 23);
		btnSjf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//combine fcfs=new combine();
				npp=fcfs.npppro();
				nppt.setText(npp);
				int wt[]=fcfs.waiting();
				String t=noofprocesses.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(Math.abs(wt[i]))+'\n'+'\n');
					System.out.println("array"+Math.abs(wt[i]));
				}
				textPane.setText(pa);
			}
		});
		btnSjf.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		
		JButton btnSjfpreempprio = new JButton("SJF-PreempPrio");
		btnSjfpreempprio.setForeground(new Color(128, 128, 128));
		btnSjfpreempprio.setBackground(Color.CYAN);
		btnSjfpreempprio.setBounds(412, 209, 130, 23);
		btnSjfpreempprio.setContentAreaFilled(false);
		btnSjfpreempprio.setOpaque(true);
		btnSjfpreempprio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pp=fcfs.pppro();
				ppt.setText(pp);
				int wt[]=fcfs.waiting();
				String t=noofprocesses.getText();
				int n=Integer.parseInt(t);
				pa=new String();
				for(int i=0;i<n;i++){
					pa=pa.concat(Integer.toString(Math.abs(wt[i]))+'\n'+'\n');
					System.out.println("array"+Math.abs(wt[i]));
				}
				textPane.setText(pa);
			}
		});
		btnSjfpreempprio.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		
		JLabel lblNewLabel = new JLabel("Scheduling Algorithms");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(178, 11, 235, 29);
		lblNewLabel.setFont(new Font("Kristen ITC", Font.BOLD, 17));
		
		time = new JTextField();
		time.setBounds(271, 83, 110, 20);
		time.setColumns(10);
		
		JLabel lblTimeQuantum = new JLabel("Time Quantum:");
		lblTimeQuantum.setForeground(Color.WHITE);
		lblTimeQuantum.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
		lblTimeQuantum.setBounds(165, 85, 110, 20);
		
		rrt = new JTextField();
		rrt.setBounds(69, 257, 73, 20);
		rrt.setColumns(10);
		
		final JPanel panel = new JPanel();
		panel.setBounds(133, 321, 314, 301);
		frame.getContentPane().add(panel);
		
		JButton input = new JButton("Input");
		input.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 12));
		input.setForeground(Color.WHITE);
		input.setBackground(Color.GREEN);
		input.setBounds(436, 64, 89, 23);
		input.setContentAreaFilled(false);
		 input.setOpaque(true);

		input.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n=noofprocesses.getText();
				String m=time.getText();
				int q=Integer.parseInt(m);
				int a=Integer.parseInt(n);
				int tab[][]=fcfs.input(a,q);
				Object data[][];
				data=new Object[a+1][4];
				Object column[]={"Process","Arrival Time","Burst Time","Priority"};
				data[0][0]="Process";
				data[0][1]="Arrival Time";
				data[0][2]="Burst Time";
				data[0][3]="Priority";
				for(int i=0,b=1;i<a;i++,b++)
				{
						data[b][0]="p"+i;
						data[b][1]=tab[i][0];
						data[b][2]=tab[i][1];
						data[b][3]=tab[i][2];
						//data[i].setPadding(10);
				}
				JTable jt=new JTable(data,column);
				frame.getContentPane().setLayout(null);
				jt.setBackground(Color.pink);
				jt.setForeground(Color.black);
				Color color = UIManager.getColor("Table.gridColor");
				MatteBorder border = new MatteBorder(1, 1, 1, 1, color);
				jt.setBorder(border);
				panel.add(jt);
			}
		});
		
		ft = new JTextField();
		ft.setBounds(53, 160, 73, 20);
		ft.setColumns(10);
		
		npt = new JTextField();
		npt.setBounds(240, 160, 86, 20);
		npt.setColumns(10);
		
		pt = new JTextField();
		pt.setBounds(439, 160, 86, 20);
		pt.setColumns(10);
		
		nppt = new JTextField();
		nppt.setBounds(240, 257, 86, 20);
		nppt.setColumns(10);
		
		ppt = new JTextField();
		ppt.setBounds(439, 257, 86, 20);
		ppt.setColumns(10);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(noofprocesses);
		frame.getContentPane().add(lblNoOfProcesses);
		frame.getContentPane().add(btnFcfs);
		frame.getContentPane().add(btnSjfpreemptive);
		frame.getContentPane().add(btnSjfnonPreemptive);
		frame.getContentPane().add(btnRoundRobin);
		frame.getContentPane().add(btnSjf);
		frame.getContentPane().add(btnSjfpreempprio);
		frame.getContentPane().add(lblNewLabel);
		frame.getContentPane().add(time);
		frame.getContentPane().add(lblTimeQuantum);
		frame.getContentPane().add(rrt);
		frame.getContentPane().add(input);
		frame.getContentPane().add(ft);
		frame.getContentPane().add(npt);
		frame.getContentPane().add(pt);
		frame.getContentPane().add(nppt);
		frame.getContentPane().add(ppt);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 12));
		btnHome.setBackground(Color.RED);
		btnHome.setForeground(Color.WHITE);
		btnHome.setContentAreaFilled(false);
		btnHome.setOpaque(true);

		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulator s=new simulator();
				s.main(null);
				
				frame.setVisible(false);
			}
		});
		btnHome.setBounds(10, 64, 89, 23);
		frame.getContentPane().add(btnHome);
		
		textPane = new JTextPane();
		textPane.setBounds(606, 52, 37, 353);
		frame.getContentPane().add(textPane);
		
		
		JLabel lblWaitingTime = new JLabel("Waiting Time");
		lblWaitingTime.setForeground(new Color(255, 255, 0));
		lblWaitingTime.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		lblWaitingTime.setBounds(580, 20, 110, 20);
		frame.getContentPane().add(lblWaitingTime);
		
		JLabel lblInputProcesses = new JLabel("Input Processes");
		lblInputProcesses.setForeground(Color.WHITE);
		lblInputProcesses.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 15));
		lblInputProcesses.setBounds(240, 288, 173, 22);
		frame.getContentPane().add(lblInputProcesses);
	}
}
