package me.dio.personapi.utils;

import me.dio.personapi.dto.request.PhoneDTO;
import me.dio.personapi.entity.Phone;
import me.dio.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1188888-8888";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}
