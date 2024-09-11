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

    private static void mapId(Account source, AccountDTO target) {
        final Long id = source.getId();
        target.setId(id);
    }

    private static void mapType(Account source, AccountDTO target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void mapAddress(Account source, AccountDTO target) {
        final String address = source.getAddress();
        target.setAddress(address);
    }

    public static Account map(AccountDTO source, Account target) {
        mapId(source, target);
        mapType(source, target);
        mapAddress(source, target);
        return target;
    }

    private static void mapId(AccountDTO source, Account target) {
        final Long id = source.getId();
        target.setId(id);
    }

    private static void mapType(AccountDTO source, Account target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void mapAddress(AccountDTO source, Account target) {
        final String address = source.getAddress();
        target.setAddress(address);
    }
}
