
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.UIManager;

public class diskallcombine extends JFrame {

	/**
	 *
	 */
	//private static final long serialVersionUID = 1L;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	private JPanel graph;
	
	public static int[] process;
	public int c=0;
	int[] k1={98,183,37,122,14,124,65,67};//{23, 89, 132, 42, 187},{95, 180, 34, 119, 11, 123, 62, 64}};
	public static int tail;
	public int n;
	public static int min=0;
	public static int max=199;
	private JTextField textField_2;
	private JTextField textField_1;
	public diskallcombine(){
		super("Graph");
		getContentPane().setBackground(new Color(255, 239, 213));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(new Dimension(672, 514));
		setLocationRelativeTo(null);
		setVisible(true);
		initialize();
		
	}
	public void setgraph(JPanel panel){
		graph.setLayout(new FlowLayout());
		graph.removeAll();
		graph.add(panel);
		graph.repaint();
		graph.revalidate();


	}
	public static void input(){

	}
	
	public void initialize(){
		
		getContentPane().setLayout(null);
		graph=new JPanel();
		graph.setBounds(0, 46, 656, 318);
		graph.setPreferredSize(new Dimension(300, 300));
		getContentPane().add(graph);
		
		JButton btnNewButton = new JButton("FCFS");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int c=0;
				n=8;
				process=new int[n+3];
				process[0]=min;
				process[1]=max;
				process[2]=53;
				int head=process[2];
				int k=0;
				for (int j = 3 ;j < n+3;j++)
				{
					process[j]=k1[k];
					k++;
				}
				int[] pro;
				pro=new int[n+1];
				int g=0;
				for(int j=2;j<n+3;j++)
				{
					System.out.println(process[j]);
					pro[g]=process[j];
					g++;
				}
				int y=pro[0]-head;
				c=c+Math.abs(y);
				for(int j=1;j<=n;j++)
				{
					int x=pro[j]-pro[j-1];
					c=c+Math.abs(x);
				}
				System.out.print("Total Head Movement Number:"+c);
				String t=Integer.toString(c);
				textField_2.setText(t);
					setgraph(new diskDrawGraph(pro));

			}
		});
		btnNewButton.setBounds(10, 419, 97, 25);
		 btnNewButton.setContentAreaFilled(false);
		 btnNewButton.setOpaque(true);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("LOOK");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m,ind=0,c=0,j;
				int tem[];
				n=8;
				process=new int[n+3];
				tem = new int[n+3];
				process[0]=min;
				process[1]=max;
				process[2]=53;
				int head=process[2];
				int t=0;
				for (j = 3 ;j < n+3;j++)
				{
					process[j]=k1[t];
					t++;
				}
				int[] pro;
				pro= new int[n+1];
				int l=0;
				m=n+3;
				for(int k=0;k<n;k++)
				{
					tem[k]=process[k+3];
				}
				tem[n]=min;tem[n+1]=head;tem[n+2]=max;
				Arrays.sort(tem);
				int y1,y2;
				y1=Math.abs(head-min);
				y2=Math.abs(max-head);
				for(int k=0;k<m;k++)
				{
					if(head==tem[k])
					{
						ind=k;
						break;
					}
				}
				int i=0;
				for(j=ind;j>=1;j--)
				{
					pro[i]=tem[j];
					i++;
				}
				for(int k=ind+1;k<=m-2;k++)
				{
					pro[i]=tem[k];
					i++;
				}
				if(y1<y2)
				{
					for(j=ind;j>=2;j--)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					c=c+Math.abs(tem[ind+1]-tem[1]);
					for(int k=ind+1;k<m-2;k++)
					{
						c=c+Math.abs(tem[k+1]-tem[k]);
					}
					System.out.print("Total Head Movement Number:"+c);
					String w=Integer.toString(c);
					textField_2.setText(w);
				}
				else
				{
					for(j=ind+1;j<m-1;j++)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					c=c+(tem[m-2]-tem[ind-1]);
					for(int k=ind-1;k>=2;k++)
					{
						c=c+Math.abs(tem[k]-tem[k-1]);
					}
					System.out.print("Total Head Movement Number:"+c);
					String w=Integer.toString(c);
					textField_2.setText(w);
				}
				
		setgraph(new diskDrawGraph(pro));

			}
		});
		btnNewButton_1.setBounds(438, 419, 97, 25);
		btnNewButton_1.setContentAreaFilled(false);
		 btnNewButton_1.setOpaque(true);

		getContentPane().add(btnNewButton_1);

		JButton btnCscan = new JButton("SSTF");
		btnCscan.setForeground(Color.WHITE);
		btnCscan.setBackground(Color.BLACK);
		btnCscan.addActionListener(new ActionListener() {
			public int next_head(int arr[],int res[],int i,int n)
			{
				int y2=99999,id=0,y1=0;
				for(int j=0;j<n;j++)
				{
					y1=Math.abs(arr[j+3]-res[i]);
					if(y1<y2)
					{
						y2=y1;
						id=j;
					}
				}
				c=c+Math.abs(arr[id+3]-res[i]);
				return id;
			}
			public void actionPerformed(ActionEvent arg0) {
				int ind=0,k=0,l=0,c=0;
				int t1=0,t2=999999,res[];
				n=8;
				process=new int[n+3];
				res = new int[n];
				process[0]=min;
				process[1]=max;
				process[2]=53;
				int head=process[2];
				int a=0,i=0;
				for (int j = 3 ;j < n+3;j++)
				{
					process[j]=k1[a];
					a++;
				}
				int[] pro;
				pro=new int[n+1];
				for(int j=0;j<n;j++)
				{
					t1=Math.abs(process[j+3]-head);
					if(t1<t2)
					{
						t2=t1;
						ind=j;
					}
				}
				
				c=c+Math.abs(process[ind+3]-head);
				int y=process[ind+3];
				res[k]=y;
				process[ind+3]=999999;
				for(int j=0;j<n-1;j++)
				{
					l=next_head(process,res,j,n);
					c=c+Math.abs(process[l+3]-res[j]);
					k++;
					res[k]=process[l+3];process[l+3]=999999;
				}
				pro[i]=head;
				i++;
				for(int p=0;p<n;p++)
				{
					pro[i]=res[p];
					i++;
				}
				System.out.print("Total Head Movement Number:"+c);
				String b=Integer.toString(c);
				textField_2.setText(b);
				setgraph(new diskDrawGraph(pro));

			}
		});
		btnCscan.setBounds(117, 419, 97, 25);
		 btnCscan.setContentAreaFilled(false);
         btnCscan.setOpaque(true);
		getContentPane().add(btnCscan);

		JButton btnStsf = new JButton("CSCAN");
		btnStsf.setBackground(Color.BLACK);
		btnStsf.setForeground(Color.WHITE);
		btnStsf.addActionListener(new ActionListener() {
			private int dloc;
			public void actionPerformed(ActionEvent e) {
				int m,ind=0,c=0;
				int c1=0,c2=0;
				int tem[];
				n=8;
				process=new int[n+3];
				tem = new int[n+3];
				m=n+3;
				int[] pro;
				pro= new int[n+3];
				process[0]=min;
				process[1]=max;
				process[2]=53;
				int head=process[2];
				int t=0;
				for (int j = 3 ;j < n+3;j++)
				{
					process[j]=k1[t];
					t++;
				}
				for(int j=0;j<n;j++)
				{
					tem[j]=process[j+3];
					if(head>process[j+3])
					{
						c1++;
					}
					else
					{
						c2++;
					}
				}
				tem[n]=min;tem[n+1]=head;tem[n+2]=max;
				Arrays.sort(tem);
				for(int j=0;j<m;j++)
				{
					if(head==tem[j])
					{
						ind=j;
						break;
					}
				}
				int i=0;
				pro[i]=tem[ind];
				i++;
				for(int j=ind+1;j<m;j++)
				{
					pro[i]=tem[j];
					i++;
				}
				pro[i]=tem[0];
				i++;
				for(int k=1;k<ind;k++)
				{
					pro[i]=tem[k];
					i++;
				}
				if(c2>c1)
				{
					for(int j=ind+1;j<m;j++)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					for(int k=1;k<ind;k++)
					{
						c=c+Math.abs(tem[k]-tem[k-1]);
					}
					System.out.print("Total Head Movement Number:"+c);
					String a=Integer.toString(c);
					textField_2.setText(a);
				}
				else
				{
					for(int j=ind;j>=1;j--)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					for(int k=m-1;k>=ind+1;k--)
					{
						c=c+Math.abs(tem[k]-tem[k-1]);
					}
					System.out.print("Total Head Movement Number:"+c);
					String a=Integer.toString(c);
					textField_2.setText(a);
				}
				setgraph(new diskDrawGraph(pro));

			}
		});
		btnStsf.setBounds(331, 419, 97, 25);
		btnStsf.setContentAreaFilled(false);
		 btnStsf.setOpaque(true);

		getContentPane().add(btnStsf);

		JButton btnScan = new JButton("SCAN");
		btnScan.setForeground(Color.WHITE);
		btnScan.setBackground(Color.BLACK);
		btnScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m,ind=0,c=0;
				int tem[];
				n=8;
				process=new int[n+3];
				int pro[];
				tem = new int[n+3];
				pro=new int[n+2];
				m=n+3;
				process[0]=min;
				process[1]=max;
				process[2]=53;
				int head=process[2];
				int t=0;
				for (int j = 3 ;j < n+3;j++)
				{
					process[j]=k1[t];
					t++;
				}
				for(int j=0;j<n;j++)
					tem[j]=process[j+3];
				tem[n]=min;tem[n+1]=head;tem[n+2]=max;
				Arrays.sort(tem);
				int y1,y2;
				y1=Math.abs(head-min);
				y2=Math.abs(max-head);
				for(int j=0;j<m;j++)
				{
					if(head==tem[j])
					{
						ind=j;
						break;
					}
				}
				int i=0;
				for(int j=ind;j>=1;j--)
				{
					pro[i]=tem[j];
					i++;
				}
				pro[i]=tem[0];
				i++;
				for(int k=ind+1;k<m-2;k++)
				{
					pro[i]=tem[k];
					i++;
				}
				pro[i]=tem[m-2];
				if(y1<y2)
				{
					for(int j=ind;j>=1;j--)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					c=c+tem[ind+1];
					for(int k=ind+1;k<m-2;k++)
					{
						c=c+Math.abs(tem[k+1]-tem[k]);
					}
					System.out.print("Total Head Movement Number:"+c);
					String a=Integer.toString(c);
					textField_2.setText(a);
				}
				else
				{
					for(int j=ind+1;j<m;j++)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					c=c+(max-tem[ind-1]);
					for(int k=ind-1;k>1;k++)
					{
						c=c+Math.abs(tem[k]-tem[k-1]);
					}
					System.out.print("Total Head Movement Number:"+c);
					String a=Integer.toString(c);
					textField_2.setText(a);
				}
				
		setgraph(new diskDrawGraph(pro));
			}
		});
		btnScan.setBounds(224, 419, 97, 25);
		btnScan.setContentAreaFilled(false);
		 btnScan.setOpaque(true);

		getContentPane().add(btnScan);

		JButton btnClook = new JButton("CLOOK");
		btnClook.setBackground(Color.BLACK);
		btnClook.setForeground(Color.WHITE);
		btnClook.addActionListener(new ActionListener() {
			public int c=0;
			public void actionPerformed(ActionEvent e) {
				int m,ind=0,c=0;
				int c1=0,c2=0;
				int tem[];
				int pro[];
				n=8;
				process=new int[n+3];
				tem = new int[n+3];
				pro=new int[n+1];
				m=n+3;
				process[0]=min;
				process[1]=max;
				process[2]=53;
				int head=process[2];
				int t=0;
				for (int j = 3 ;j < n+3;j++)
				{
					process[j]=k1[t];
					t++;
				}
				for(int j=0;j<n;j++)
				{
					tem[j]=process[j+3];
					if(head>process[j+3])
					{
						c1++;
					}
					else
					{
						c2++;
					}
				}
				tem[n]=min;tem[n+1]=head;tem[n+2]=max;
				Arrays.sort(tem);
				for(int j=0;j<m;j++)
				{
					if(head==tem[j])
					{
						ind=j;
						break;
					}
				}
				int i=0;
				for(int j=ind+1;j<m-1;j++)
				{
					pro[i]=tem[j-1];
					i++;
				}
				pro[i]=tem[m-2];
				i++;
				for(int a=2;a<ind;a++)
				{
					pro[i]=tem[a-1];
					i++;
				}
				pro[i]=tem[ind-1];
				if(c2>c1)
				{
					for(int j=ind+1;j<m-1;j++)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					for(int a=2;a<ind;a++)
					{
						c=c+Math.abs(tem[a]-tem[a-1]);
					}
					System.out.print("Total Head Movement Number:"+c);
					
					String a=Integer.toString(c);
					textField_2.setText(a);
				}
				else
				{
					for(int j=ind;j>=2;j--)
					{
						c=c+Math.abs(tem[j]-tem[j-1]);
					}
					for(int b=m-2;b>=ind+1;b--)
					{
						c=c+Math.abs(tem[b]-tem[b-1]);
					}
					System.out.print("Total Head Movement Number:"+c);
					String a=Integer.toString(c);
					textField_2.setText(a);
				}
		setgraph(new diskDrawGraph(pro));

			}
		});
		btnClook.setBounds(545, 419, 97, 25);
		btnClook.setContentAreaFilled(false);
		 btnClook.setOpaque(true);

		getContentPane().add(btnClook);

		JLabel lblHead = new JLabel("Head");
		lblHead.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		lblHead.setForeground(Color.DARK_GRAY);
		lblHead.setBounds(32, 375, 56, 16);
		getContentPane().add(lblHead);

		JLabel lblChooseSchedulingAlgorithm = new JLabel("Disk Scheduling Algorithms");
		lblChooseSchedulingAlgorithm.setForeground(Color.BLUE);
		lblChooseSchedulingAlgorithm.setFont(new Font("Kristen ITC", Font.PLAIN, 16));
		lblChooseSchedulingAlgorithm.setBounds(221, 0, 272, 35);
		getContentPane().add(lblChooseSchedulingAlgorithm);
		
		JLabel lblNewLabel = new JLabel("Total Head Movements:");
		lblNewLabel.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(354, 375, 205, 14);
		getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(541, 373, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.BLACK);
		btnHome.setBackground(Color.YELLOW);
		 btnHome.setContentAreaFilled(false);
         btnHome.setOpaque(true);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				simulator s=new simulator();
				s.main(null);
			}
		});
		btnHome.setBounds(18, 23, 89, 23);
		getContentPane().add(btnHome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 375, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					diskallcombine window = new diskallcombine();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
//	public Main() {
//		initialize();
//	}
}
