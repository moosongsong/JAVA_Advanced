package 입출력연습;

public class Buffered_InputStream_Pratice02_Main extends java.io.BufferedInputStream{
	public Buffered_InputStream_Pratice02_Main(java.io.BufferedInputStream stream) {
		super(stream);
	}
	
	public Buffered_InputStream_Pratice02_Main(java.io.FileInputStream stream, int size) {
		super(stream, size);
	}
	
	public byte[] getBuffer() {
		return super.buf;
	}
}
