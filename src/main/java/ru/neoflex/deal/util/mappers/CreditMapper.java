package ru.neoflex.deal.util.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.neoflex.openapi.dtos.Credit;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CreditMapper {
    ru.neoflex.deal.models.Credit creditDTOToCredit(Credit dto);
}

