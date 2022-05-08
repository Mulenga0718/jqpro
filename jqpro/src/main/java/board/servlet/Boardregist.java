package board.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.vo.BoardVO;

/**
 * Servlet implementation class Boardregist
 */
@WebServlet("/board/regist")
public class Boardregist extends HttpServlet {
	 private Board board = Board.getInstance();  
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/board/boardregist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = "dkrnq";
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formatedNow = date.format(formatter);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int max = 0;
		Map<String, BoardVO> map = board.getboardlist();
		List<Integer> list = new ArrayList<Integer>();
		for(String key : map.keySet()) {
			list.add(map.get(key).getNum());
			
		}
		for(int i : list) {
			if(max<i) {
				max = i;
			}
		}
		
		BoardVO boardvo = new BoardVO(max+1,title, content,writer, formatedNow, 0 );
		board.getboardlist().put((max+1)+"", boardvo );
		
		response.sendRedirect("list");
	}

}
