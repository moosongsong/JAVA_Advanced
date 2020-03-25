package Part_14_Question;

import java.util.List;
import java.util.ArrayList;

class Board{
	private String title;
	private String content;
	
	public Board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
}

class BoardDao{
	ArrayList<Board>list = new ArrayList<Board>();
	
	public BoardDao() {
		list.add(new Board("力格1", "郴侩1"));
		list.add(new Board("力格2", "郴侩2"));
		list.add(new Board("力格3", "郴侩3"));
	}

	public ArrayList<Board> getBoardList() {
		return list;
	}
	
	
}

public class Q14_7 {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		
		for (Board board : list) {
			System.out.println(board.getTitle()+"-"+board.getContent());
		}
	}

}
