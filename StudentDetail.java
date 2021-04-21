package StudentList;

import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.Scanner;

public class StudentDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int uid, ms1 ,ms2;
	public String name;
	List<StudentDetail> list=new ArrayList<StudentDetail>();  
	
	StudentDetail it[]=new StudentDetail[10];
	int u,m1,m2,n;
	String snmae;
	public StudentDetail(int u2, String snmae2, int m12, int m22) {
		// TODO Auto-generated constructor stub
	}
	
	public StudentDetail() {
		// TODO Auto-generated constructor stub
	}

	public void StudentDetail (int uid1, String name,int m1,int m2)
	{
		this.uid=uid1;
		this.name = name;
		this.ms1=m1;
		this.ms2=m2;
	}
	public int getuid ()
	{
		return this.uid;
		
	}
	public String getname ()
	{
		return this.name;
	}
	public int getms1 ()
	{
		return this.ms1;
	}
	public int getms2 ()
	{
		return this.ms2;
	}
	public String toString() {
        return uid +"\t"+name+"\t"+ms1+"\t"+ms2;
    }
	
	
	public void add()
	{
		System.out.println("Enter the Number of Student to add");
		Scanner sc =  new Scanner(System.in);
		n = sc.nextInt();
		int i =0;
		while(n-->0)		
		{
			System.out.println("Enter  uid");
			u=sc.nextInt();
			System.out.println("Enter  name");
			snmae=sc.next();
			System.out.println("Enter  marks in S1");
			m1=sc.nextInt();
			System.out.println("Enter the  in S2");
			m2=sc.nextInt();
			it [i]=new StudentDetail(u,snmae,m1,m2);
			list.add(it[i]);
			i++;
		}
		
	}
	public void listinventory()
	{
		Iterator<StudentDetail> itr = list.iterator();
		System.out.println("UID\tName\tm1\tm2");
        while (itr.hasNext())
            System.out.println(itr.next().toString());
        
	}
	public void search() {
		Scanner sc =  new Scanner(System.in);
		    int flag =0;
			System.out.println("Enter the uid  to search ");
			int choice =sc.nextInt();
				Iterator itr = list.iterator();
		        while (itr.hasNext())
		        {
		        	StudentDetail i = (StudentDetail)itr.next();
		        	//System.out.println(i.getname());
		            if(choice==i.getuid())
		            {
		            	flag =1;
		            	int total = i.getms1()+i.getms2();
		            	System.out.println("UID\tName\tTotal");
		            	System.out.println(i.getuid()+"\t"+ i.getname()+"\t"+total);
		            }
		      
			}
		        if (flag ==0)
		        {
		        	System.out.println(" not exist");
		        }
		        else {
		        	System.out.println("");
		        }
			
			
		}
	void addtofile(String fileName)
	{
		if(fileName != null && !fileName.isEmpty()) {
			if(list.size()>0) {
				File mFile = new File (fileName);	
			try {
			FileOutputStream mFOS = new FileOutputStream(mFile);
			ObjectOutputStream mOOS = new ObjectOutputStream(mFOS);
			mOOS.writeObject(list);
			mOOS.close();
			System.out.println("Writing process completed successfully");
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
			}
		}else {
			System.out.println("No records found to write");
		}
		
	}
		




}
