package controllers.timecards;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TimeCard;
import utils.DBUtil;

/**
 * Servlet implementation class TimeCardsCreateServlet
 */
@WebServlet("/timecards/create")
public class TimeCardsCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeCardsCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String attendance = (String) request.getParameter("attendance");
        if (attendance.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            TimeCard t = new TimeCard();

            //  ここに氏名情報を入力する どうやってログインの名前を持ってくるのか、またはemployee_idから取得できるやり方がわからない。

            Date timecard_date = new Date(System.currentTimeMillis());
            t.setTimecard_date(timecard_date);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setAttendance_at(currentTime);

            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            request.getSession().setAttribute("flush", "登録が完了しました。");

            response.sendRedirect(request.getContextPath() + "/timecards/index");
        }

        String retirement = (String) request.getParameter("retirement");
        if (retirement.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            TimeCard t = new TimeCard();

            //          ここに氏名を入力する

            Date timecard_date = new Date(System.currentTimeMillis());
            t.setTimecard_date(timecard_date);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setAttendance_at(currentTime);

            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
            em.close();
            request.getSession().setAttribute("flush", "登録が完了しました。");

            response.sendRedirect(request.getContextPath() + "/timecards/index");
        }
    }
}
