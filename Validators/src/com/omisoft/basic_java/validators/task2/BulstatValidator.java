package com.omisoft.basic_java.validators.task2;

public class BulstatValidator {
	
	
	public void bulstat9Dig (String in)
	{
		char ch[] = in.toCharArray();
		int conNum;
		
		if (in.length() > 9 ||in.length() < 9)
		{
			System.err.println("This Bulstat is not valid!");
		}
		else
		{
			String fn = String.valueOf(ch[0]);			
			String sn = String.valueOf(ch[1]);
			String tn = String.valueOf(ch[2]);
			String fon = String.valueOf(ch[3]);
			String fin = String.valueOf(ch[4]);
			String sin = String.valueOf(ch[5]);
			String svn = String.valueOf(ch[6]);
			String en = String.valueOf(ch[7]);
			String nn = String.valueOf(ch[8]);
			
			
			int sum = ((Integer.parseInt(fn)*1+Integer.parseInt(sn)*2+Integer.parseInt(tn)*3+Integer.parseInt(fon)*4+Integer.parseInt(fin)*5
					+ Integer.parseInt(sin)*6+Integer.parseInt(svn)*7+Integer.parseInt(en)*8) % (11));
		
		
			if (sum < 10)
			{
				conNum = sum;
			}
			else
			{
				int sum2 = ((Integer.parseInt(fn)*3+Integer.parseInt(sn)*4+Integer.parseInt(tn)*5+Integer.parseInt(fon)*6+Integer.parseInt(fin)*7
						+ Integer.parseInt(sin)*8+Integer.parseInt(svn)*9+Integer.parseInt(en)*10) % (11));
				
				if (sum2 < 10)
				{
					conNum = sum2;
				}
				else
				{
					conNum = 0;
				}
			}
			
			if (conNum == Integer.parseInt(nn))
			{
				System.out.println(in);
				System.out.println("The Bulstat is valid.");
			}
			else
			{
				System.err.println("This Bulstat is not valid!");
			}
		
		}
		
		
	}
	
	public void bulstat13Dig (String in)
	{
		char ch[] = in.toCharArray();
		int conNum = 0;
		
		if (in.length() > 13 ||in.length() < 13)
		{
			System.err.println("This Bulstat is not valid!");
		}
		else
		{
			String fn = String.valueOf(ch[0]);			
			String sn = String.valueOf(ch[1]);
			String tn = String.valueOf(ch[2]);
			String fon = String.valueOf(ch[3]);
			String fin = String.valueOf(ch[4]);
			String sin = String.valueOf(ch[5]);
			String svn = String.valueOf(ch[6]);
			String en = String.valueOf(ch[7]);
			String ten = String.valueOf(ch[9]);
			String elev = String.valueOf(ch[10]);
			String twe = String.valueOf(ch[11]);
			String thir = String.valueOf(ch[12]);
			
			int nine = ((Integer.parseInt(fn)*1+Integer.parseInt(sn)*2+Integer.parseInt(tn)*3+Integer.parseInt(fon)*4+Integer.parseInt(fin)*5
					+ Integer.parseInt(sin)*6+Integer.parseInt(svn)*7+Integer.parseInt(en)*8) % (11));
			
			
			
			int sum = ((nine*2+Integer.parseInt(ten)*7+Integer.parseInt(elev)*3+Integer.parseInt(twe)*5) % (11));
			
			System.out.println(sum);
			if (sum < 10)
			{
				conNum = sum;
			}
			else if (sum == 10)
			{
				int sum2 = ((nine*4+Integer.parseInt(ten)*9+Integer.parseInt(elev)*5+Integer.parseInt(twe)*7) % (11));
				
				if (sum2 < 10)
				{
					conNum = sum2;
				}
				else
				{
					conNum = 0;
				}	
			}
			if (conNum == Integer.parseInt(thir))
			{
				System.out.println(in);
				System.out.println("The Bulstat is valid.");
			}
			else
			{
				System.err.println("This Bulstat is not valid!");
			}
		}
	}
	
}
