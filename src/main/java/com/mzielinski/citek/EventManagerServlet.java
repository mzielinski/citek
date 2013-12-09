package com.mzielinski.citek;

import com.mzielinski.citek.domain.Event;
import com.mzielinski.citek.uitl.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author mzielinski, Rule Financial
 */
public class EventManagerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
        try {
            // Begin unit of work
            HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();

            // Process request and render page...
            process(request, response, dateFormatter);

            // End unit of work
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
        } catch (Exception ex) {
            HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().rollback();
            throw new ServletException(ex);
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response, SimpleDateFormat dateFormatter) throws IOException, ParseException {
        PrintWriter out = response.getWriter();

        // Write HTML header
        out.println("<html><head><title>Event Manager</title></head><body>");

        // Handle actions
        if ( "store".equals(request.getParameter("action")) ) {

            String eventTitle = request.getParameter("eventTitle");
            String eventDate = request.getParameter("eventDate");

            if ( "".equals(eventTitle) || "".equals(eventDate) ) {
                out.println("<b><i>Please enter event title and date.</i></b>");
            }
            else {
                createAndStoreEvent(eventTitle, dateFormatter.parse(eventDate));
                out.println("<b><i>Added event.</i></b>");
            }
        }

        // Print page
        printEventForm(out);
        listEvents(out, dateFormatter);

        // Write HTML footer
        out.println("</body></html>");
        out.flush();
        out.close();
    }

    private void printEventForm(PrintWriter out) {
        out.println("<h2>Add new event:</h2>");
        out.println("<form>");
        out.println("Title: <input name='eventTitle' length='50'/><br/>");
        out.println("Date (e.g. 24.12.2009): <input name='eventDate' length='10'/><br/>");
        out.println("<input type='submit' name='action' value='store'/>");
        out.println("</form>");
    }

    @SuppressWarnings("unchecked")
    private void listEvents(PrintWriter out, SimpleDateFormat dateFormatter) {
        List<Event> result = HibernateUtil.getSessionFactory().getCurrentSession().createCriteria(Event.class).list();
        if (result.size() > 0) {
            out.println("<h2>Events in database:</h2>");
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Event title</th>");
            out.println("<th>Event date</th>");
            out.println("</tr>");
            for (Event event : result) {
                out.println("<tr>");
                out.println("<td>" + event.getTitle() + "</td>");
                out.println("<td>" + dateFormatter.format(event.getDate()) + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
    }

    protected void createAndStoreEvent(String title, Date theDate) {
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        HibernateUtil.getSessionFactory().getCurrentSession().save(theEvent);
    }

}
