package me.diego.dsmeta.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import me.diego.dsmeta.entities.Sale;
import me.diego.dsmeta.exceptions.BadRequestException;
import me.diego.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    @Autowired
    private SaleRepository saleRepository;

    public void sendSms(Long saleId) {

        Sale sale = saleRepository.findById(saleId).orElseThrow(() ->
                new BadRequestException("User not found"));

        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();

        String msg = "Vendendor %s foi destaque em %s com um total de R$ %s"
                .formatted(sale.getSellerName(), date, String.format("%.2f", sale.getAmount()));

        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, msg).create();

        System.out.println(message.getSid());
    }
}
