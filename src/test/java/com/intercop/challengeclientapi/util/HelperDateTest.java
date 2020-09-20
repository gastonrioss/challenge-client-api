package com.intercop.challengeclientapi.util;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class HelperDateTest {

    @Test
    void when_envian_fecha_string_then_retorna_local_date(){
       assertThat( HelperDate.toString(LocalDate.now())).isInstanceOfAny(String.class);
    }
    @Test
    void when__fecha_local_date_then_retorna_fecha_string(){
        String fecha= "26/12/1990";
        assertThat( HelperDate.toDate(fecha)).isInstanceOfAny(LocalDate.class);

    }

}