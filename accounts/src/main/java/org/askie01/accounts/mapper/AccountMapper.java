package org.askie01.accounts.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.askie01.accounts.dto.AccountDTO;
import org.askie01.accounts.entity.Account;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountMapper {
    public static AccountDTO map(Account source, AccountDTO target) {
        mapId(source, target);
        mapType(source, target);
        mapAddress(source, target);
        return target;
    }

    private static void mapId(Account account, AccountDTO accountDTO) {
        final Long id = account.getId();
        accountDTO.setId(id);
    }

    private static void mapType(Account account, AccountDTO accountDTO) {
        final String type = account.getType();
        accountDTO.setType(type);
    }

    private static void mapAddress(Account account, AccountDTO accountDTO) {
        final String address = account.getAddress();
        accountDTO.setAddress(address);
    }

    public static Account map(AccountDTO source, Account target) {
        mapId(source, target);
        mapType(source, target);
        mapAddress(source, target);
        return target;
    }

    private static void mapId(AccountDTO accountDTO, Account account) {
        final Long id = accountDTO.getId();
        account.setId(id);
    }

    private static void mapType(AccountDTO accountDTO, Account account) {
        final String type = accountDTO.getType();
        account.setType(type);
    }

    private static void mapAddress(AccountDTO accountDTO, Account account) {
        final String address = accountDTO.getAddress();
        account.setAddress(address);
    }
}
