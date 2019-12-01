package controllers.timecards;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TimeCard;
/**
 * Servlet implementation class TimeCardsNewServlet
 */
@WebServlet("/timecards/new")
public class TimeCardsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeCardsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        TimeCard t = new TimeCard();
        request.setAttribute("timecard", t);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/timecards/new.jsp");
        rd.forward(request, response);
    }


}
