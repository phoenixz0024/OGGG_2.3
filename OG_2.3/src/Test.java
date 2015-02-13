import java.util.Arrays;

public class Test 
{
	public static void main(String[] args)
	{
		int[] a = {1,2,3,2};
		int[] b = {4,5,2,1};
		
		System.out.println(Arrays.toString( sumArrays(a,b) ));
	}
	
	private static int[] sumArrays(int[] a, int[] b)
	{
		int[] answer;
		
		try
		{
			if(a.length!=b.length)
				throw new ArraySizeException("Array sizes are not equal");
			
			if(a.length<b.length)
				answer = new int[a.length];
			else
				answer = new int[b.length];
			
			for(int x = 0; x < answer.length; x++) 
			{
			  answer[x] = a[x] + b[x];
			}
			
			return answer;
		}
		catch(ArraySizeException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	private static class ArraySizeException extends Exception
	{
		 private ArraySizeException(String message)
		 {
		      super(message);
		 }
	}
}
