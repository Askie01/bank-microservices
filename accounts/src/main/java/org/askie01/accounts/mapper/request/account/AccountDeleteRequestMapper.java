package org.askie01.accounts.mapper.request.account;

import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.request.account.delete.DeleteRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountDeleteRequestMapper implements Mapper<DeleteRequest, Account> {

    @Override
    public Account map(DeleteRequest source, Account target) {
        final Account targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        return targetCopy;
    }

    private void mapId(DeleteRequest source, Account target) {
        final Long id = source.getId();
        target.setId(id);
    }
}
