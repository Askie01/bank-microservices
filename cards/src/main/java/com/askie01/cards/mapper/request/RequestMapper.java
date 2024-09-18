package com.askie01.cards.mapper.request;

import com.askie01.cards.copier.ObjectCopier;
import com.askie01.cards.entity.Card;
import com.askie01.cards.mapper.Mapper;
import com.askie01.cards.request.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper implements Mapper<Request, Card> {

    @Override
    public Card map(Request source, Card target) {
        final Card targetCopy = ObjectCopier.copy(target);
        mapMobileNumber(source, targetCopy);
        return targetCopy;
    }

    private void mapMobileNumber(Request source, Card target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }
}
