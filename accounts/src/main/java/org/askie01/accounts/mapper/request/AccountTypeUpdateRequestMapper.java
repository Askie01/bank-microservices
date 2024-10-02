package org.askie01.accounts.mapper.request;

import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.AccountType;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.request.account.type.UpdateRequest;
import org.springframework.stereotype.Component;

/**
 * A mapper for converting {@link UpdateRequest} objects to {@link AccountType} entities.
 * <p>
 * This class implements {@link Mapper} interface and provides the necessary
 * mapping logic to transform request data into the corresponding entity representation.
 * </p>
 */
@Component
public class AccountTypeUpdateRequestMapper implements Mapper<UpdateRequest, AccountType> {

    /**
     * Maps a {@link UpdateRequest} to a new {@link AccountType} entity.
     *
     * @param updateRequest the request body containing the {@link AccountType} details to be mapped.
     * @return a new {@link AccountType} entity populated with data from the provided request.
     */
    public AccountType mapToAccountType(UpdateRequest updateRequest) {
        return map(updateRequest, new AccountType());
    }

    /**
     * Maps the fields from the provided {@link UpdateRequest} to the specified {@link AccountType} target entity.
     * Before mapping creates a copy of target object.
     *
     * @param source {@link UpdateRequest} object containing data to be mapped.
     * @param target {@link AccountType} entity to get details mapped to.
     * @return mapped copy of target object.
     */
    @Override
    public AccountType map(UpdateRequest source, AccountType target) {
        final AccountType targetCopy = ObjectCopier.copy(target);
        mapName(source, targetCopy);
        return targetCopy;
    }

    /**
     * Maps the name field from the source {@link UpdateRequest} to the target {@link AccountType}.
     *
     * @param source {@link UpdateRequest} object containing name to be mapped.
     * @param target {@link AccountType} entity to get name mapped to.
     */
    private void mapName(UpdateRequest source, AccountType target) {
        final String name = source.getName();
        target.setName(name);
    }
}
