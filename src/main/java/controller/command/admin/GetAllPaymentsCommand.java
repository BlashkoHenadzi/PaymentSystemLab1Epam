package controller.command.admin;

import beans.Payment;
import controller.command.ICommand;
import controller.util.constants.Attributes;
import controller.util.constants.Views;
import service.PaymentService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GetAllPaymentsCommand implements ICommand {
    private final PaymentService paymentService = ServiceFactory.getPaymentService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Payment> payments = paymentService.findAll();

        request.setAttribute(Attributes.PAYMENTS, payments);

        return Views.PAYMENTS_VIEW;
    }
}
