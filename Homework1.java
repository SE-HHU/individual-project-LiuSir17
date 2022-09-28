package homework1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;



public class Homework1 {

	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Random r = new Random();
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();//式子数目
		HashSet<Fomula> fs = new HashSet<Fomula>(); 
		
		for(int j=0;j<n;j++)
		{			
			int n1 = r.nextInt(2)+2;//多少数			
			int n2=n1-1;//符号数
			//System.out.println(n1);
			int[] num = new int[n1];
			int[] k = new int[n2];
			char[] symbol = new char[n2];
			for(int i=0;i<n1;i++)
			{
				num[i]=r.nextInt(100)+1;//生成随机数		
			}

			
			for(int i=0;i<n2;i++)//生成符号
			{
				 k[i] = r.nextInt(2);//1->+,0->-					 
			}
			
			int result = num[0];
			for(int i=0;i<n2;i++)
			{
				
				switch(k[i])
				{
					case 1:	
						result +=  num[i+1] ;
						symbol[i] = '+';
					break;
					case 0:
						result -=  num[i+1];
						symbol[i] = '-';
					break;
				}
			}
			//加入集合，检验重复
			Fomula f;
			if(result>=0 && result <=100)
			{
				if(n1==3) 			
				 f = new Fomula(num[0], num[1], num[2], result, symbol[0], symbol[1]);			
				else 	f = new Fomula(num[0], num[1],result, symbol[0]);
				fs.add(f);
			}
				
		}
		//打印输出
		String questionName = "D:\\Exercises.txt";
		String answerName = "D:\\Answers.txt";
		BufferedWriter out1 = new BufferedWriter(new FileWriter(questionName));
		BufferedWriter out2 = new BufferedWriter(new FileWriter(answerName));
		for(Fomula i: fs)
		{
			out1.write(i.toQuestion() );
			out1.newLine();
			out2.write(i.toAnswer() );
			out2.newLine();
		}
		out1.close();
		out2.close();
		System.out.println("ok");
	}

}
class Fomula{


	
	
	int a=0,b=0,c=-1,d=0;//数
	char x,y;//符号
	public Fomula(int a, int b, int c, int d ,char x, char y) {
	super();
	this.a = a;
	this.b = b;
	this.c = c;
	this.x = x;
	this.y = y;
	this.d = d;
}
	public Fomula(int a, int b, int d, char x ) {
		super();
		this.a = a;
		this.b = b;
		this.d = d;
		this.x = x;
		
	}
	public String toQuestion()
	{
		String sa,sb,sc,sx,sy;
		sa=String.valueOf(a);
		sb=String.valueOf(b);
		sx=String.valueOf(x);
		if(c!=-1)
		{
			sc=String.valueOf(c);
			sy=String.valueOf(y);
			return sa + sx + sb + sy +sc + "=";
		}
		else	return sa + sx + sb + "=";
		 
		
	}
	public String toAnswer()
	{
		String s=String.valueOf(d);
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Fomula o = (Fomula)obj;
		if(		(o.a==this.a && o.b==this.b && o.c==this.c) ||
				(o.a==this.a && o.b==this.c && o.c==this.b) ||
				(o.a==this.b && o.b==this.a && o.c==this.c) ||
				(o.a==this.b && o.b==this.c && o.c==this.a) ||
				(o.a==this.c && o.b==this.a && o.c==this.b) ||
				(o.a==this.c && o.b==this.b && o.c==this.a) 	)
			return true;
		else return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
