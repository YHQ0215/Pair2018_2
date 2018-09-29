import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Random;
import java.util.Stack;

import java.text.SimpleDateFormat;

import java.util.Scanner;


public class MathExam6387 {

	private static Scanner in;
	private static int x,y,z,f,h,g;
	private static String[] str ;
	private static String rem;

	public static void main(String args[]) throws FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		int n ;
//		in = new Scanner(System.in);
//		n = in.nextInt();
//		g = in.nextInt();
//		����ָ������ String[] ת��Ϊ int
		int i =Integer.valueOf(args[0]).intValue();//������Ŀ
		int g =Integer.valueOf(args[1]).intValue();//�����꼶
		//����������ļ���
		File file = new File("out6387.txt");
		PrintStream ps = new PrintStream(file);
		System.setOut(ps);
		ChoiceGrade(i, g);
		
	}
	
	//һ�꼶�ӷ�����
	public static void GradeOne( int n ) {
		str = new String[n];
		for (int i = 0; i < n ; i++) {
			x = (int)(Math.random()*100);
			y = (int)(Math.random()*100);
			f = (int)(Math.random()*2);
			// �жϼӷ��ͼ��� 0Ϊ�ӷ�
			if ( f == 0) {
				System.out.println("(" + (i+1) + ")" +" " + x + "+" + y + " = " );
				str[i] = "(" + (i+1) + ")" +" " + x + "+" + y + " " + "=" + " " + (x+y);
			}
			else {
				if (x-y < 0) {
					System.out.println("(" + (i+1) + ")" +" " + y + "-" + x + " = " );
					str[i] = "(" + (i+1) + ")" +" " + y + "-" + x + " " + "=" + " " + (y-x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + "-" + y + " = " );
					str[i] = "(" + (i+1) + ")" +" " + x + "-" + y + " " + "=" + " " + (x-y);
				}
			}
		}
		System.out.println("--------��׼��---------");
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�ѧ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println("              211606387 ������Ҷ����  " +sdf.format(new Date()));
	}
	
	//���꼶�˷�����
	public static void GradeTwo( int n ) {
		str = new String[n];
		for (int i = 0; i < n; i++) {
			x = new Random().nextInt(10) + 1;
			y = new Random().nextInt(10) + 1;
			f = (int)(Math.random()*2);
			
			if ( f == 0 && y!=0 && x!=0) {
				System.out.println("(" + (i+1) + ")" +" " + x + " �� " + y + " = " );
				str[i] = "(" + (i+1) + ")" +" " + x + " �� " + y + " " + "=" + " " + (x*y);
			}
			else {
				if (x-y < 0 ) {
					System.out.println("(" + (i+1) + ")" +" " + y + " �� " + x + " = " );
					str[i] = "(" + (i+1) + ")" +" " + y + " �� " + x + " " + "=" + " " + (y/x) + JudgementRemainder(y,x);
				}
				else {
					System.out.println("(" + (i+1) + ")" +" " + x + " �� " + y + " = " );
					str[i] = "(" + (i+1) + ")" +" " + x + " �� " + y + " " + "=" + " " + (x/y) + JudgementRemainder(x,y);
				}
			}
		}
		System.out.println("--------��׼��--------");
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�����ѧ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println("              211606387 ������Ҷ����  " +sdf.format(new Date()));
	}
	
	//���꼶�������
	private static  void GradeThree( int n ) {
		// TODO �Զ����ɵķ������
		str = new String[n];
		
		for (int i = 0; i < n; i++) {
			x = new Random().nextInt(10) + 1;
			y = new Random().nextInt(10) + 1;
			z = new Random().nextInt(10) + 1;
			f = (int)(Math.random()*3);
			h = (int)(Math.random()*3);
			//int ת��Ϊ String
			String x1 = String.valueOf(x);
			String y1 = String.valueOf(y);
			String z1 = String.valueOf(z);
			
			String [] strArr = { x1,y1,z1,SymbolicJudgment(h),SymbolicJudgment(f) };
			System.out.println("(" + (i+1) + ")" +" " + z1 + " " + SymbolicJudgment(h) + " " + y1 + " " + SymbolicJudgment(f) + " " + x1 + " = " );
			str[i] = "(" + (i+1) + ")" +" " + z1 +" " + SymbolicJudgment(h) +" " + y1 +" " + SymbolicJudgment(f) +" " + x1 + " = "  + ReversePolish(strArr);
		}
		System.out.println("--------��׼��---------");
		//�����
		for(String a:str)
			System.out.println(a);
		//������ں�ѧ������
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd�� HH:mm");
		System.out.println("              211606387 ������Ҷ����  " +sdf.format(new Date()));
	}
	//ѡ���꼶
	public static int ChoiceGrade( int n , int g ) {
		int TextN = 0;
		if ( g == 1 ) {
			GradeOne(n);
			TextN = 1;
		}
		else if ( g == 2) {
			GradeTwo(n);
			TextN = 2;
		}
		else if ( g == 3) {
			GradeThree(n);
			TextN = 3;
		}
		else {
			System.out.println("����Ա�������ޣ����꼶��δ���");
			TextN = g;
		}
		return TextN;
	}
	
	//�ж�����
	public static String JudgementRemainder( int x , int y ) {
		if( (x%y) == 0) {
			
			rem = " ";
		}
		else {
			rem = "..." + (x%y) + " ";
		}
		return rem;
	}
	
	//�жϷ���
	 private static String SymbolicJudgment(int f) {
		// TODO �Զ����ɵķ������
		 if (f == 0) {
			rem = "+";
		}
		 else if (f == 1) {
			 rem = "-";
		}
		 else{
			rem = "*";
		}
		return rem;
	}
	
	//�沨�����ʽ ��׺���� ���ڻ������
    private static String ReversePolish (String[] strArr){
        String str = "+-*/";
        Stack<String> stack = new Stack<String>();
        //���������е�ÿһ��Ԫ��
        for(String s : strArr){
        	//���������,����ջ��
            if(!str.contains(s)){
                stack.push(s);
            }
            else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch(s){
                case "+" :
                	stack.push(String.valueOf(a+b));
                    break;
                case "-" :
                	stack.push(String.valueOf(a-b));
                    break ;
                case "*" :
                    stack.push(String.valueOf(a*b));
                    break;
                }
            }
        }
        return stack.pop();
    }
}