

import java.util.Random;

public class pagecombine {
	int n,m;
	int[] arr;
	int[] arr2;
	int[] res;
	int[] val;
	int[] ref;
	public static int p=0;
	public static int pf=0;
	public static int pf1=0;
	public static int pf2=0;
	public static int pf3=0;
	public static void main(){
		
	}
	public String fifo(){
		
		return Result(n,m,arr,res,val);
	}
	public String lru(){
		return Result1(n,m,arr,res,val);
	}
	public String optimal(){
		return Result2(n,m,arr,res,val);
	}
	public String secondchance(){
		return Result3(n,m,arr,res,val,ref);
	}
	public int[] input(int n1,int q1)
	{
		int x,j;
		
		int min,max,k1=1;
		n=n1;
		m=q1;
		arr=new int[n];
		res=new int[m];
		val=new int[m];
		ref=new int[m];
		min = 1;
		max = 10;
		for (int i = 0 ;i < n ;i++)
		{
			arr[i]=k1;
			k1=RandomNumber(min,max);
		}
		for(int i=0;i<m;i++)
		{
			res[i]=-1;
			val[i]=0;
		}
		System.out.println("Given Input");
		for (int nu = 0; nu < n; nu++)
		{
				System.out.println(arr[nu]);
		}
		return arr;
	}
	public static int RandomNumber(int min, int max)
	{	
        Random foo = new Random();
        int randomNumber = foo.nextInt((max + 1) - min) + min;
        return randomNumber;
    }
public int[] res(){
	return res;
}
public static String Result(int n,int m,int arr[],int res[],int val[])
{
	String t;
	int x;
	for(int k=0;k<n;k++)
	{
		x=arr[k];
		check(x,k,res,m,val);
	}
	
	t=""+pf;
	return t;
}
public static void print(int m,int res[])
{
	for(int k=0;k<m;k++)
	{
		System.out.println("resultant"+res[k]);
	}
}
public static String Result1(int n,int m,int arr[],int res[],int val[])
{
	String t;
	int x;
	for(int j=0;j<n;j++)
	{
		x=arr[j];
		check1(x,j,res,m,val);
	}
	t=""+pf1;
	return t;
}
public static String Result2(int n,int m,int arr[],int res[],int val[])
{
	String t;
	int x;
	for(int j=0;j<n;j++)
	{
		x=arr[j];
		check2(x,j,res,m,val,n,arr);
	}
	t=""+pf2;
	return t;
}
public static String Result3(int n,int m,int arr[],int res[],int val[],int ref[])
{
	String t;
	int x;
	for(int j=0;j<n;j++)
	{
		x=arr[j];
		check3(x,j,res,m,val,ref);
	}
	t=""+pf3;
	return t;
}
public static void check1(int x,int j,int res[],int m,int val[])
{
	int f=0,min=100,ind=0;
	for(int i=0;i<m;i++)
	{
		if(res[i]==-1)
		{	
			res[i]=x;
			pf1++;
			for(int g=0;g<=j%m;g++)
			{
				val[g]++;
			}
			f=1;
			break;
		}
		else if(res[i]==x)
		{
			f=1;
			val[i]=0;
			for(int g=0;g<m;g++)
			{
				if(g!=i)
				{
					val[g]++;
				}
			}
			break;
		}
	}
	if(f==0)
	{	min=val[0];
		ind=0;
		for(int l=1;l<m;l++)
		{
			if(min<val[l])
			{
				min=val[l];
				ind=l;
			}
		}
		res[ind]=x;
		val[ind]=0;
		for(int i=0;i<m;i++)
		{
			if(i!=ind)
			{
				val[i]++;
			}
		}
		pf1++;
	}
}
public static void check(int x,int j,int res[],int m,int val[])
{
	int f=0,min=100,ind=0;
	for(int i=0;i<m;i++)
	{
		if(res[i]==-1)
		{
			res[i]=x;
			pf++;
			for(int g=0;g<=j%m;g++)
			{
				val[g]++;
			}
			f=1;
			break;
		}
		else if(res[i]==x)
		{
			f=1;
			for(int g=0;g<m;g++)
			{
				val[g]++;
			}
			break;
		}
	}
	if(f==0)
	{	min=val[0];
		ind=0;
		for(int l=1;l<m;l++)
		{
			if(min<val[l])
			{
				min=val[l];
				ind=l;
			}
		}
		res[ind]=x;
		val[ind]=1;
		pf++;
		for(int g=0;g<m;g++)
		{
			if(g!=ind)
			{
				val[g]++;
			}
		}
	}
}
public static void check3(int x,int j,int res[],int m,int val[],int ref[])
{
	int f=0,min=100,ind=0;
	for(int i=0;i<m;i++)
	{
		if(res[i]==-1)
		{
			res[i]=x;
			pf3++;
			for(int g=0;g<=j%m;g++)
			{
				val[g]++;
			}
			f=1;
			break;
		}
		else if(res[i]==x)
		{
			f=1;
			ref[i]=1;
			for(int g=0;g<m;g++)
			{
				val[g]++;
			}
			break;
		}
	}
	if(f==0)
	{	min=val[0];
		ind=0;
		for(int l=1;l<m;l++)
		{
			if(min<val[l])
			{
				min=val[l];
				ind=l;
			}
		}
		if(ref[ind]==0)
		{
			res[ind]=x;
			val[ind]=1;
			ref[ind]=0;
			for(int i=0;i<m;i++)
			{
				if(i!=ind)
				{
					val[i]++;
				}
			}
		}
		else
		{
			int mmi=-1;
			int inn=0;
			for(int y=0;y<m;y++)
			{
				if((ref[y]==0)&&(mmi<val[y]))
				{
					mmi=val[y];
					inn=y;
				}
			}
			res[inn]=x;
			val[inn]=1;
			for(int i=0;i<m;i++)
			{
				ref[i]=0;
				if(i!=inn)
				{
					val[i]++;
				}
			}
		}
		pf3++;
	}
}
public static void check2(int x,int j,int res[],int m,int val[],int n,int arr[])
{
	int f=0,min=100,ind=0;
	for(int i=0;i<m;i++)
	{
		if(res[i]==-1)
		{
			res[i]=x;
			int cc=0;
			for(int gg=0;gg<=j%m;gg++)
			{
				cc=0;
				for(int g=j+1;g<n;g++)
				{
					if(res[gg]==arr[g])
					{
						val[gg]=g;
						cc=1;
						break;
					}
				}
				if(cc==0)
				{
					val[gg]=1000;
				}
			}
			pf2++;
			f=1;
			break;
		}
		else if(res[i]==x)
		{
			f=1;
			int c=0;
			for(int gg=0;gg<m;gg++)
			{
				c=0;
				for(int g=j+1;g<n;g++)
				{
					if(res[gg]==arr[g])
					{
						val[gg]=g;
						c=1;
						break;
					}
				}
				if(c==0)
				{
					val[gg]=1000;
				}
			}
			break;
		}
	}
	if(f==0)
	{		
		min=val[0];
		ind=0;
		for(int l=1;l<m;l++)
		{
			if(min<val[l])
			{
				min=val[l];
				ind=l;
			}
		}
		res[ind]=x;
		pf2++;
		for(int gg=0;gg<m;gg++)
		{
			int c=0;
			for(int g=j+1;g<n;g++)
			{
				if(res[gg]==arr[g])
				{
					val[gg]=g;
					c=1;
					break;
				}
			}
			if(c==0)
			{
				val[gg]=1000;
			}
		}
	}
}
}