package com.example.javapro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "HelloServlet", value = "/HelloServlet")
public class HelloServlet extends HttpServlet {

    private Map<String, AtomicInteger> answerCounts;

    @Override
    public void init() {
        answerCounts = new HashMap<>();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String question1Answer = request.getParameter("question1");
        String question2Answer = request.getParameter("question2");

        // Update the answer counts
        updateAnswerCount(question1Answer);
        updateAnswerCount(question2Answer);

        // Display the chosen answers and the answer counts
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Answer Counts:</h2>");
        for (Map.Entry<String, AtomicInteger> entry : answerCounts.entrySet()) {
            out.println("<p>" + entry.getKey() + ": " + entry.getValue().get() + "</p>");
        }
        out.println("<a href=\"/\" style=\"text-decoration: none;\"><button class=\"button\" style=\"background-color: #007bff; color: #fff; border: none; padding: 6px 20px; border-radius: 5px; cursor: pointer;\">Go Back</button></a>");
        out.println("</body></html>");
    }

    private void updateAnswerCount(String answer) {
        if (answer != null) {
            AtomicInteger count = answerCounts.computeIfAbsent(answer, key -> new AtomicInteger());
            count.incrementAndGet();
        }
    }
}
