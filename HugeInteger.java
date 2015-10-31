import java.util.Random;

public class HugeInteger 
{
	private LinkedList integerList;
	
	public HugeInteger()
	{
		this.integerList = new LinkedList();
	}
	
	//Initiate a HugeInteger from a integer string
	public HugeInteger(String integers) throws Exception
	{
		this.integerList = new LinkedList();
		String digitString = "0123456789";
		for (int i = 0; i < integers.length(); i++)
		{
			if (digitString.indexOf(integers.charAt(i)) < 0)
			{
				throw new Exception("This is not a legal integer string.");
			}
		}
		for (int i = 0; i < integers.length(); i++)
		{
				this.integerList.addEnd(Character.getNumericValue(integers.charAt(i)));
		}
		this.removeFrontZero();
	}
	
	//initiate a new random HugeInteger with given digits number
	public HugeInteger(int digits) throws Exception
	{
		this.integerList = new LinkedList();
		for (int i = 0; i < digits; i++)
		{
			this.integerList.addFront(randInt(0, 9));
		}
		this.removeFrontZero();
	}
	
	public HugeInteger addHugeInteger(HugeInteger hugeInteger) throws Exception
	{
		HugeInteger result = new HugeInteger();
		HugeInteger hugeInteger1 = new HugeInteger(this.toString());
		HugeInteger hugeInteger2 = new HugeInteger(hugeInteger.toString());
		int count = (this.integerList.length() > hugeInteger2.integerList.length()) ? this.integerList.length() : hugeInteger2.integerList.length();
		int carry = 0;
		for (int i = 0; i < count; i++)
		{
			int currDigit1 = (hugeInteger1.integerList.length() > 0) ? hugeInteger1.integerList.removeEnd() : 0;
			
			int currDigit2 = (hugeInteger2.integerList.length() > 0) ? hugeInteger2.integerList.removeEnd() : 0;
			int currDigitResult = carry + currDigit1 + currDigit2;
			if (currDigitResult >= 10)
			{
				carry = 1;
				currDigitResult = currDigitResult - 10;
				result.integerList.addFront(currDigitResult);
			} else {
				carry = 0;
				result.integerList.addFront(currDigitResult);
			}
		}
		if (carry != 0)
		{
			result.integerList.addFront(carry);
		}
		return result;
	}
	
	public void display() throws Exception
	{
		this.integerList.display();
	}
	
	public String toString()
	{
		return this.integerList.toString();
	}

	public static int randInt(int min, int max)
	{
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) +min;
		return randomNum;
	}
	
	public void removeFrontZero() throws Exception
	{
		int front = this.integerList.removeFront();
		while (front == 0)
		{
			front = this.integerList.removeFront();
		}
		this.integerList.addFront(front);
	}
}


