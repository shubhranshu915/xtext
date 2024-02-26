package autox;

public class Strinng {

	public static void main(String[] args) {
		String s="Shardendu";
		String k="dendu";
		
		int sl=s.length();
		String su=s.toUpperCase();
		char s3=s.charAt(2);
		
		
		System.out.println(s);
		System.out.println(su);
		System.out.println("length is = " );
		System.out.println(s3 );
		System.out.println(s.equals(k) );
		System.out.println(s.contains(k) );
		System.out.println(s.equalsIgnoreCase(k) );
		System.out.println(s+" "+k);
	//....reverse..................................	
		String srev="";
		for(int i=sl-1;i>=0;i--) {
			char sn=s.charAt(i);
			srev=srev+sn;
		}
		System.out.println(srev);
		//....reverse..................................		
	}

}
