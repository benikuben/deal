package ru.neoflex.deal.util.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.neoflex.deal.models.Credit;
import ru.neoflex.openapi.dtos.CreditDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CreditMapper {
    Credit creditDTOToCredit(CreditDTO dto);
}

