package com.dachsbau.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dachsbau.model.Transaction;

import static com.dachsbau.context.Application.*;

public class MyBankServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/")) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print(
                    """
                            <html>
                            <body>
                            <h1>MyBank gets your money!!</h1>
                            <p>Like every bank, we take your money and charge you more money for that</p>
                            </body>
                            </html>"""
            );
        }
        else if (request.getRequestURI().equalsIgnoreCase("/transactions")) {
            response.setContentType("application/json; charset=UTF-8");
            List<Transaction> transactions = transactionService.findAll();
            response.getWriter().print(objectMapper.writeValueAsString(transactions));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equalsIgnoreCase("/transactions")) {

            Integer amount = Integer.valueOf(request.getParameter("amount"));
            String reference = request.getParameter("reference");

            Transaction transaction = transactionService.create(amount, reference);

            response.setContentType("application/json; charset=UTF-8");
            String json = objectMapper.writeValueAsString(transaction);
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
