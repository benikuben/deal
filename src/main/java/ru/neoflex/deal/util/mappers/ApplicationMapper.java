package ru.neoflex.deal.util.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.neoflex.openapi.dtos.Application;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ApplicationMapper {
    Application applicationToApplicationDTO(ru.neoflex.deal.models.Application model);
}
