package com.jesustyle.application.util;

import com.jesustyle.application.entidade.pagamento.Items;
import com.jesustyle.application.entidade.pagarme.Order;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EnviarEmailServiceImpl  {

    @Autowired
    private JavaMailSender mailSender;
    public boolean enviar(Order order, String response) {
        return enviarEmail(order, response);
    }

    private boolean enviarEmail(Order order, String response){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom("mailer@jesustyleoficial.com.br");
            helper.setTo(order.getCustomer().getEmail());
            helper.setSubject("Jesustyle - Parabéns! Compra aprovada");

            String body = createEmailBody(order, response);

            helper.setText(body, false);

            mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String createEmailBody(Order order, String response) {
        StringBuilder body = new StringBuilder();

        body.append("Olá ").append(order.getCustomer().getName()).append(",\n\n");
        body.append("Seu pedido foi aprovado e está sendo processado!\n");
        body.append("Aqui estão os detalhes do seu pedido:\n\n");


        body.append("Código do Pedido: ").append(order.getCode()).append("\n");
        body.append("Valor Total: R$ ").append(String.format("%.2f", order.getAmount() / 100.0)).append("\n");
        body.append("Status do Pedido: ").append(order.getStatus()).append("\n");


        if (!order.getCharges().isEmpty() && order.getCharges().get(0).getCode() != null) {
            body.append("Código de Rastreamento: ").append(order.getCharges().get(0).getCode()).append("\n");
        }

        body.append("\n");


        body.append("Informações do Cliente:\n");
        body.append("Nome: ").append(order.getCustomer().getName()).append("\n");
        body.append("Email: ").append(order.getCustomer().getEmail()).append("\n");
        body.append("CPF/CNPJ: ").append(order.getCustomer().getDocument()).append("\n");
        body.append("Telefone: +").append(order.getCustomer().getPhones().getHome_phone().getCountry_code())
                .append(" (").append(order.getCustomer().getPhones().getHome_phone().getArea_code()).append(") ")
                .append(order.getCustomer().getPhones().getHome_phone().getNumber()).append("\n");

        body.append("\n");


        body.append("Itens do seu pedido:\n");
        for (Items item : order.getItems()) {
            body.append("- ").append(item.getDescription()).append("\n");
            body.append("  Quantidade: ").append(item.getQuantity()).append("\n");
            body.append("  Valor Unitário: R$ ").append(String.format("%.2f", item.getAmount() / 100.0)).append("\n\n");
        }


        body.append("Detalhes do Pagamento:\n");
        body.append("Método de Pagamento: ").append(order.getCharges().get(0).getPayment_method()).append("\n");
        body.append("Total Pago: R$ ").append(String.format("%.2f", order.getCharges().get(0).getPaid_amount() / 100.0)).append("\n");

        body.append("\n");


        body.append("Agradecemos por sua compra e estamos à disposição para quaisquer dúvidas!\n");
        body.append("Atenciosamente,\n");
        body.append("Equipe de Atendimento Jesustyle\n");

        return body.toString();
    }
}