

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class cpucombine{
	int[] an;
	int[] at;
	int[] bt;
	int[] btc;
	int[] btp;
	int[] v1;
	int[] v2;
	int[] pr;
	public int[] wt;
	int n,q;
	
	public static void main(String args[])
	{	
		
	}
	
	public String fcf()
	{
		float t=0;
		int[] ct;
		int[] tat;
		
		ct=new int[n];
		tat=new int[n];
		String s;
		ct[0]=bt[0];
		for (int i = 1; i < n; i++) 
		{
			ct[i] = ct[i-1]+bt[i];
		}
		for (int i = 0; i < n; i++)
		{
			tat[i]=ct[i]-at[i];
		}
		for(int j=0;j<n;j++)
		{
			wt[j]=tat[j]-bt[j];
			t=t+wt[j];
		}
		t = t / n;
		//System.out.println(t);
		s=""+t;
		return s;
	}
	public int[] waiting(){
		return wt;
	}
	
	public static int RandomNumber(int min, int max)
	{	
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;
        return randomNumber;
    }
	public String nppro()
	{
		int[] res1;
		int[] num1;
		num1 = new int[n];
		res1 = new int[n];
		res1[0] = bt[0];
		v1[0]=1;
		num1[0]=0;
		for(int i = 1; i < n; i++)
		{
			nppro2(at,bt,v1,n,res1,i,num1);
		}
		return npres(at,bt,res1,num1,n);
	}
	
	public int[][] input(int n1,int q1)
	{
		int min,max;
		int nu,k1=1,k2,k3;
		n=n1;
		int table[][];
		wt=new int[n];
		table=new int[n][3];
		an = new int[n];
		at = new int[n];
		bt = new int[n];
		btc = new int[n];
		btp = new int[n];
		v1 = new int[n];
		v2 = new int[n];
		pr = new int[n];
		q=q1;
		min = 1;
		max = 10;
		at[0]=0;
		for (int i = 1 ;i < n ;i++)
		{
			at[i]=k1;
			k1=RandomNumber(min,max);
		}
		System.out.println(" Process"+"         Arr Time"+"         Burst Time"+"       Priority");
		for (nu = 0; nu < n; nu++)
		{
			an[nu]=at[nu];
			v1[nu] = 0;
			v2[nu] = 0;
			k2 = RandomNumber(min, max);
			bt[nu]=k2;
			btc[nu]=k2;
			btp[nu]=k2;
			k3 = RandomNumber(min, max);
			pr[nu]=k3;
			table[nu][0]=at[nu];
			table[nu][1]=bt[nu];
			table[nu][2]=pr[nu];
			System.out.println("    "+(nu+1)+"                 "+at[nu]+"               "+bt[nu]+"               "+pr[nu]);
		}
		return table;
	}
	
	public String npppro()
	{
		int[] res2;
		int[] num2;
		num2 = new int[n];
		res2 = new int[n];
		res2[0] = bt[0];
		v2[0]=1;
		num2[0]=0;
		for(int i = 1; i < n; i++)
		{
			npppro2(at,bt,v2,pr,n,res2,i,num2);
		}
		return nppres(at,bt,res2,num2,n);
	}
	
	public String ppro()
	{
		int[] arr;
		int[] arr2;
		int[] tot;
		int[] wtp;
		int[] btp2;
		btp2=new int[n];
		arr = new int[n];
		arr2 = new int[n];
		tot = new int[n];
		wtp = new int[n];
		int sum=0;
		String d;
		for(int j=0;j<n;j++)
		{
			btp2[j]=btp[j];
		}
		for(int i=0;i<n;i++)
		{
			arr[i]=i;
			arr2[i]=btp2[i];
			sum+=btp2[i];
		}
		for(int i=1;i<=sum;i++)
		{
			int mp=999999999,index=0;
			for (int j=0;j<n;j++)
			{
				if(at[j]<i	&&	btp2[j]<mp 	&& 	btp2[j]>0)
				{
					mp=btp2[j];
					index=j;
				}
			}
			btp2[index]-=1;
			if(btp2[index]==0)
			{
				tot[index]=i-at[index];
				wtp[index]=tot[index]-arr2[index];

			}
		}
		float waiting=0;
		for(int l=0;l<n;l++)
		{
			wt[l]=wtp[l];
			waiting+=wtp[l];
		}
		waiting=waiting/n;
	d=""+waiting;
	return d;
	}
	
	public String rbpro()
	{
		int c=0;
		int[] btc2;
		int[] wt;
		int[] t;
		t = new int [n];
		wt= new int[n];
		btc2=new int[n];
		for(int g=0;g<n;g++)
		{
			btc2[g]=btc[g];
			wt[g]=0;
			t[g]=btc[g];
		}
		for(int ii=0;ii<100000;ii++)
		{
			if(c==n-1)
			{
				break;
			}
			for(int i=0;i<n;i++)
			{
				if(btc[i]>q)
				{
					btc[i]=btc[i]-q;
					for(int j=0;j<n;j++)
					{
						if((j!=i) && (btc[j]!=0))
						{
							wt[j]=wt[j]+q;
						}
					}
				}
				else
				{
					for(int j=0;j<n;j++)
					{
						if((j!=i) && (btc[j]!=0))
						{
							wt[j]=wt[j]+btc[i];
						}
						if(j==i)
						{
							c++;
						}
					}
					btc[i]=0;
				}																										
			}
		}
		return rbres(n,wt);
	}
	public String pppro()
	{
	int[] ptat;
	int[] pwt;
	int[] cpbt;
	int[] bt2;
	String d;
	ptat = new int[n];
	pwt = new int[n];
	cpbt = new int[n];
	bt2=new int[n];
	int psum=0;
	for(int i=0;i<n;i++)
	{
		bt2[i]=bt[i];
	}
	for(int i=0;i<n;i++)
	{
		psum+=bt2[i];
		cpbt[i]=bt2[i];
	}

	for(int t=1;t<=psum;t++)
	{    
		int pmin=9999,pindex=0;    
	    	for(int j=0;j<n;j++)
	        {
	        	if(at[j]<t && pr[j]<pmin && bt2[j]>0)
	            {            
	             	pmin=pr[j];
	            	pindex=j;
	            }
	        }
	        bt2[pindex]-=1;
	        if(bt2[pindex]==0)
	        {            
	            ptat[pindex]=t-at[pindex];
	            pwt[pindex]=ptat[pindex]-cpbt[pindex];
	        }
	    }       
	int tot_wait=0;  
	for(int i=0;i<n;i++)
	{    
	    	tot_wait+=pwt[i];    
	}
	float avg_wait=(float)tot_wait/n;

	d=(""+avg_wait);
	return d;
	}
	public String npres(int at[],int bt[],int res1[],int num1[],int n)
	{
		float s1=0;
		int[] fina1;
		String d;
		fina1 = new int[n];
		fina1 = new int[n];
		fina1[0]=res1[0];
		for(int i=1;i<n;i++)
		{
			fina1[i]=res1[i]+fina1[i-1];
		}
		int fi1 =0,q=0;
		for(int j=0;j<n-1;j++)
		{
			q=num1[j+1];
			fi1=fina1[j+1]-(at[q]+bt[q]);
			wt[j]=fi1;
			s1=s1+fi1;
		}
		s1=s1/n;
		d=""+s1;
		return d;
	}
	
	public String nppres(int at[],int bt[],int res2[],int num2[],int n)
	{
		float s2=0;
		String d;
		int[] fina2;
		fina2 = new int[n];
		fina2 = new int[n];
		fina2[0]=res2[0];
		for(int i=1;i<n;i++)
		{
			fina2[i]=res2[i]+fina2[i-1];
		}
		int fi2 =0,q=0;
		for(int j=0;j<n-1;j++)
		{
			q=num2[j+1];
			fi2=fina2[j+1]-(at[q]+bt[q]);
			wt[j]=fi2;
			s2=s2+fi2;
		}
		s2=s2/n;
		d=""+s2;
		return d;
	}
	
	public String rbres(int n,int wt[])
	{
		float sum=0;
		String d;
		for(int k=0;k<n;k++)
		{
			sum=sum+wt[k];
		}
		sum=sum/n;
		d=""+sum;
		return d;
	}
	public void nppro2(int at[],int bt[],int v1[],int n,int res1[],int i,int num1[])
	{
		int m1 = 10000;
		int va1 = 0,fl1 = 0;
		for(int j = 0; j < n ;j++)
		{
			if(v1[j]==0 && bt[j] < m1 && bt[0]>=at[j] )
			{
					m1 = bt[j];
					fl1=1;
			}
		}
		if(fl1==1)
		{
			for(int jj = 0; jj < n ;jj++)
			{
				if(m1==bt[jj] && v1[jj]==0)
				{
					v1[jj] = 1;
					va1 = jj;
					break;
				}
			}
			res1[i]=m1;
			num1[i]=va1;
		}
		if(fl1==0 && bt[0]< at[i])
		{
			res1[i]=bt[i];
			num1[i]=i;
		}
	}
	
	public void npppro2(int at[],int bt[],int v2[],int pr[],int n,int res2[],int i,int num2[])
	{
		int m2 = 10000,mm=0;
		int va2 = 0,fl2 = 0,vi = 0;
		for(int j = 0; j < n ;j++)
		{
			if(v2[j]==0 && pr[j] < m2 && bt[0]>=at[j] )
			{
					m2 = pr[j];
					fl2=1;
			}
		}
		if(fl2==1)
		{
			for(int jj = 0; jj < n ;jj++)
			{
				if(m2==pr[jj] && v2[jj]==0)
				{
					v2[jj] = 1;
					va2 = jj;
					mm=bt[jj];
					break;
				}
			}
			res2[i]=mm;
			num2[i]=va2;
		}
		if(fl2==0 && bt[0]< at[i])
		{
			int nnm=100,ik=0;
			for(int kk = i; kk < n; kk++)
			{
				if(v2[kk]==0 && pr[kk] < nnm)
				{
					nnm=pr[kk];
				}
			}
			for(int ki = i;ki<n;ki++)
			{
				if(nnm==pr[ki] && v2[ki]==0)
				{
					v2[ki]=1;
					ik=bt[ki];
					vi=ki;
					break;
				}
			}
			res2[i]=ik;
			num2[i]=vi;
		}
	}
}

