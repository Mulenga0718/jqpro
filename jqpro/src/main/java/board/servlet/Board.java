package board.servlet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.vo.BoardVO;


public class Board {
	private static Board board;
	private static Map<String, BoardVO> map = new HashMap<String,BoardVO>();
	private Board( ) {}
	public static Board getInstance() {
		if(board == null) board = new Board();
		return board;
	}
	public Map<String, BoardVO> getboardlist(){
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = date.format(formatter);

		for(int i=0; i<20; i++) {
			int num = i+1;
			String title = "mimi"+(i+1);
			String content = "mimi"+(i+1);
			String writer = "mimi"+(i+1);
			BoardVO boardvo = new BoardVO(num,title, content, writer,formatedNow, 0);
			map.put(num+"", boardvo);   
			
		}
		
		return map;
	}
	
}
