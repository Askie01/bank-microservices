package com.askie01.loans.mapper.request;

import com.askie01.loans.copier.ObjectCopier;
import com.askie01.loans.entity.Loan;
import com.askie01.loans.mapper.Mapper;
import com.askie01.loans.request.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper implements Mapper<Request, Loan> {

    @Override
    public Loan map(Request source, Loan target) {
        final Loan targetCopy = ObjectCopier.copy(target);
        mapMobileNumber(source, targetCopy);
        return targetCopy;
    }

    private void mapMobileNumber(Request source, Loan target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }
}
