import java.util.Arrays;

public class Queens
{
	public static void swap(int[] Q, int i, int j)
	{
		int temp = Q[i];
		Q[i] = Q[j];
		Q[j] = temp;
	}

	public static void reverse(int[] T, int pivot)
	{
		int i = pivot + 1;
		int j = T.length - 1;
		while(i < j)
		{
			swap(T, i, j);
			i++;
			j--;
		}
	}
	
	public static void nextPermutation(int[] A)
		int pivot = -1;
		nt successor = -1;
		
		for (int i = A.length-2; i >= 0; i--)
		{
			if (A[i] < A[i+1])
			{
				pivot = i;
				break;
			}
		}
		
		if (pivot == -1)
		{
			reverse(A, -1);
			return;
		}
		
		for (int i = A.length-1; i >= 0; i--)
		{
			if (A[i] > A[pivot])
			{
				successor = i;
				break;
			}
		}
		
		swap(A, pivot, successor);
		reverse(A, pivot);
		return;
	}
	
    public static boolean isSolution(int[] A)
	{
		for (int i = 0; i < A.length; i++)
		{
			for (int n = 0; n < A.length; n++)
			{
				if (i != n)
				{
					if (Math.abs(i-n) == Math.abs(A[i]-A[n])) return false;
				}
			}
		}
		
		return true;
    }
	
	public static void main(String[] args)
	{
		int[] queens;
		boolean verbose = false;
		
		if (args[0].equals("-v")) 
		{
			queens = new int[Integer.parseInt(args[1])];
			verbose = true;
		}
		else 
		{
			queens = new int[Integer.parseInt(args[0])];
		}
		
		for (int i = 1; i <= queens.length; i++)
		{
			queens[i-1] = i;
		}
		int[] sneeuq = new int[queens.length];
		System.arraycopy(queens, 0, sneeuq, 0, queens.length);
		reverse(sneeuq, -1);
		
		int solutions = 0;
		
		while (!Arrays.equals(queens, sneeuq))
		{
			nextPermutation(queens);
			
			if(isSolution(queens)) 
			{
				solutions++;
				if (verbose)
				{
					String solution = "{";
					for (int i = 0; i < queens.length; i++)
					{
						solution += queens[i];
						
						if (i != queens.length - 1)
						{
							solution += ", ";
						}
					}
					solution += "}";
					
					System.out.println(solution);
				}
			}
		}	
		System.out.println(queens.length + "-queens has " + solutions + " solutions.");
	}

