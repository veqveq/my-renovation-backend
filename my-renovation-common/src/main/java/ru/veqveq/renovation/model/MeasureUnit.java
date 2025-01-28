package ru.veqveq.renovation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MeasureUnit {
    COUNT("штука", "шт."),
    LENGTH("погонный метр", "м.п."),
    SQUARE("квадратный метр", "м²"),
    VOLUME ("кубический метр", "м³"),
    WEIGHT("килограмм", "кг"),
    PACK("упаковка", "уп.");

    private final String fullName;
    private final String shortName;
}
