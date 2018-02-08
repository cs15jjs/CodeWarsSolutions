public class Solutions {

	//count the amount of error strings
	//error strings are [n - z]
	//return or display count of erroneous strings
	public static String printerError(String s) 
	{
		int count = 0;
		String result = "";

		if (s.length() >= 1)
		{
			for (int i = 0; i < s.length(); i++)
			{
				if (s.charAt(i) > 'm')
				{
					count++;
				}
			}
			System.out.print("error_printer(s) => ");
			result = count + "/" + s.length();
		}
		else
		{
			result = "error, re-enter";
		}
		return result;
	}

	public static String duplicate(String s)
	{
		String[] returnArray = s.split("");
		String returnString = "";
		for (int i = 0; i < returnArray.length; i++)
		{
			if (i == 0)
			{
				String f = Character.toString(s.charAt(i));
				returnArray[i] = f.toUpperCase();
				returnString = returnString + returnArray[i] + "-";
			}
			else 
			{
				String f = returnArray[i].toUpperCase();;
				for (int j = 0; j < i; j++)
				{
					String h = Character.toString(s.charAt(i));
					String b = h.toLowerCase();	
					f = f + b;
				}
				returnArray[i] = f;
				returnString = returnString + returnArray[i] + "-";
			}
		}

		returnString = returnString.substring(0, returnString.length() - 1);
		return returnString;
	}
	//cut string in to sz size chunks
	//if sum of the cube its contents is divisible by 2 then reverse chunk
	//else rotate digits in the chunk one to the left 
	//return appended chunks as a string
	public static String revRot(String strng, Integer sz) 
	{
		if (sz <= 0 || sz == null)
		{
			return "";
		}
		else if (sz > strng.length())
		{
			return "";
		}
		int arraySize = (int) Math.ceil(strng.length() / sz);
		String[] returnArray = new String[arraySize];
		int index = 0;
		for(int i = 0; i < strng.length(); i = i + sz)
		{
			if(strng.length() - i >= sz)
			{
				returnArray[index++] = strng.substring(i, i + sz);
			}
		}
		//-----------

		boolean rr[] = new boolean[arraySize];
		for (int j = 0; j < returnArray.length; j++)
		{
			int result = 0;
			for (int i = 0; i < sz; i++)
			{
				int d = Character.getNumericValue(returnArray[j].charAt(i));
				int pow = d * d * d;
				result = result + pow;
			}
			if (result % 2 == 0)
			{
				rr[j] = true;
				//reverse chunk
			}
			else 
			{
				rr[j] = false;
				//rotate to the left by 1
			}
		}
		//---------
		for (int i = 0; i < arraySize; i++)
		{
			if (rr[i])
			{
				returnArray[i] = new StringBuilder(returnArray[i]).reverse().toString();
			}
			else 
			{
				returnArray[i] = returnArray[i].substring(1) + returnArray[i].substring(0, 1);
			}
		}
		StringBuilder builder = new StringBuilder();
		for(String s : returnArray) {
			builder.append(s);
		}
		String returnString = builder.toString();

		return returnString;
	}
	//return count of DISTINCT case-insensitive alphabetic characters in the string input
	//aabbc would equal 2, a and b have duplicates
	public static int duplicateCount(String nText)
	{
		String text = nText.toLowerCase();
		int cnt = 0;
		while (text.length() > 1) {
			char firstLetter = text.charAt(0);
			if (text.lastIndexOf(firstLetter) > 0) {
				cnt++;
				text = text.replaceAll(("" + firstLetter), "");
			} else {
				text = text.substring(1, text.length());
			}
		}
		return cnt;
	}
	//which repeats the given string string exactly n times.
	public static String repeatStr(final int repeat, final String string) 
	{
		String print = "";
		for (int i = 0; i < repeat; i++)
		{
			print = print + string;
		}

		return print;
	}
	//create amount of character in the string by the index + 1 of that character
	public static String accum(String s) 
	{
		String[] returnArray = s.split("");
		String returnString = "";
		for (int i = 0; i < returnArray.length; i++)
		{
			if (i == 0)
			{
				String f = Character.toString(s.charAt(i));
				returnArray[i] = f.toUpperCase();
				returnString = returnString + returnArray[i] + "-";
			}
			else 
			{
				String f = returnArray[i].toUpperCase();;
				for (int j = 0; j < i; j++)
				{
					String h = Character.toString(s.charAt(i));
					String b = h.toLowerCase();	
					f = f + b;
				}
				returnArray[i] = f;
				returnString = returnString + returnArray[i] + "-";
			}
		}

		returnString = returnString.substring(0, returnString.length() - 1);
		return returnString;
	}

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		System.out.println(revRot("123456987654", 6));
		System.out.println(revRot("123456987653", 6));
		System.out.println(revRot("66443875", 4));
		System.out.println(revRot("66443875", 8));
		System.out.println(duplicate("abcDefghi"));
		System.out.println(duplicateCount("abcdea"));
		System.out.println(duplicateCount("abcdeae"));
		System.out.println(duplicateCount("aA11"));
	}
}
