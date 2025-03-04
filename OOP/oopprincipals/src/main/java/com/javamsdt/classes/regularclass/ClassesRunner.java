package com.javamsdt.classes.regularclass;

import java.time.LocalDate;

public class ClassesRunner {

    public static void main(String[] args) {
        Country country = new Country((short) 2, 88779944, 2000000L, 40.25F, 44.40D,
        true, 'C' , "country", LocalDate.now());
        System.out.println("Constructor Country:: " + country);
        country.printLocation();

        System.out.println("==========================================");
        Country countrySetters = new Country();
        countrySetters.countryName = "CountrySetters";
        countrySetters.size = 15000;
        System.out.println("Setters Country, Name:: " + country.countryName + ", Size:: " + countrySetters.size);


    }
}
