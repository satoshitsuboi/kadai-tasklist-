package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tasklist01.Tasklist;
import utils.DBUtil;

/**
 * Servlet implementation class NewServlet2
 */
@WebServlet("/new2")
public class NewServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		   EntityManager em = DBUtil.createEntityManager();
	        em.getTransaction().begin();

	        // Messageのインスタンスを生成
	        Tasklist m = new Tasklist();

	        // mの各フィールドにデータを代入


	        String content = "花の水やり";
	        m.setContent(content);

	        Timestamp currentTime = new Timestamp(System.currentTimeMillis());     // 現在の日時を取得
	        m.setCreated_at(currentTime);
	        m.setUpdated_at(currentTime);

	        // データベースに保存
	        em.persist(m);
	        em.getTransaction().commit();

	        // 自動採番されたIDの値を表示
	        response.getWriter().append(Integer.valueOf(m.getId()).toString());

	        em.close();
	     }
}
