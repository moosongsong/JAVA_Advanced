public class Common {
	public static final char STX = '\u0002';
	public static final char ETX = '\u0003';
	public static final char EOT = '\u0004';
	
	public static final int CODE = 10;
	public static final int PRICE = 10;
	public static final int AMOUNT = 4;
	
	public static final int BUFFER_SIZE = 128;
	
	public static boolean isEOT(String strBuffer) {
		if(strBuffer.indexOf(Common.EOT)==0) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidate(String strBuffer) {
		if((strBuffer.indexOf(Common.STX)<0) || (strBuffer.indexOf(Common.ETX)<0)) {
			return false;
		}
		return true;
	}
	
	public static void func() {
		
	}
}
