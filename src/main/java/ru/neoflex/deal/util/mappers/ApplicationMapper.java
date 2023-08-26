package ru.neoflex.deal.util.mappers;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.neoflex.deal.models.Application;
import ru.neoflex.openapi.dtos.ApplicationDTO;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ApplicationMapper {
    ApplicationDTO applicationToApplicationDTO(Application model);
}
