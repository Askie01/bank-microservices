package com.askie01.loans.service;

import com.askie01.loans.entity.LoanType;
import com.askie01.loans.exception.LoanTypeAlreadyExistsException;
import com.askie01.loans.exception.ResourceNotFoundException;
import com.askie01.loans.repository.LoanTypeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DefaultLoanTypeService implements LoanTypeService {

    private final LoanTypeRepository loanTypeRepository;

    @Override
    public void createLoanType(String name) {
        try {
            getLoanType(name);
            throw new LoanTypeAlreadyExistsException("LoanType with name '" + name + "' already exists");
        } catch (ResourceNotFoundException exception) {
            final LoanType loanType = new LoanType();
            loanType.setName(name);
            loanTypeRepository.save(loanType);
        }
    }

    @Override
    public LoanType getLoanType(String name) {
        return loanTypeRepository
                .findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("LoanType", "name", name));
    }

    @Override
    public void updateLoanType(String oldName, String newName) {
        final LoanType loanType = getLoanType(oldName);
        loanType.setName(newName);
        loanTypeRepository.save(loanType);
    }

    @Override
    public void deleteLoanType(String name) {
        final LoanType loanType = getLoanType(name);
        loanTypeRepository.delete(loanType);
    }
}
