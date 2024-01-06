import java.util.*;
class grade 
{
	public static void main(String[] args) 
	{
		Scanner sc= new Scanner(System.in);
		int i,n,mark, sum=0;
		float avg=0;
		System.out.print("Enter subject : ");
		n=sc.nextInt();
		System.out.println("Enter mark of each subject");
		for(i=0;i<n;i++)
		{
		mark=sc.nextInt();
		sum=sum+mark;
		}
				avg=sum/n;
		System.out.println("Total: "+sum);

		
		System.out.println("percentage: "+avg);
		if(avg>=90)
		{
					System.out.println("Gread:A");
		}
		else if(avg>=80)
		{
							System.out.println("Gread:B");
		}
		else if(avg>=70)
		{
								System.out.println("Gread:C");
		}
         else if(avg>=60)
		{
								System.out.println("Gread:D");
		}
		else if(avg>=50)
		{
								System.out.println("Gread:E");
		}
		else if(avg<=40)
		{
								System.out.println("Gread:Fail");
		}


	}
}
