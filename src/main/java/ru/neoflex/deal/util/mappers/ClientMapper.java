package ru.neoflex.deal.util.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.neoflex.deal.models.Client;
import ru.neoflex.openapi.dtos.LoanApplicationRequest;
import ru.neoflex.openapi.dtos.Passport;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {
    @Mapping(source = ".", target = "passport", qualifiedByName = "loanApplicationRequestDTOToPassport")
    Client loanApplicationRequestDTOToClient(LoanApplicationRequest dto);

    @Named("loanApplicationRequestDTOToPassport")
    static Passport passportSeriesAndNumberToPassport(LoanApplicationRequest dto) {
        Passport passport = new Passport();
        passport.setSeries(dto.getPassportSeries());
        passport.setNumber(dto.getPassportNumber());
        return passport;
    }
}
