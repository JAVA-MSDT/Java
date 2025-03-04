package com.javamsdt.classes.regularclass;

import java.time.LocalDate;
import java.util.Objects;

public class Country {

    // Primitive variables
    short countryCode;
    int phoneNumber;
    long size;
    float longitude;
    double latitude;
    boolean hasPort;
    char countryFirstLatter;

    // Instance variable
    String countryName;
    LocalDate nationalDay;

    // Constructors
    public Country() {
    }

    public Country(short countryCode, int phoneNumber, long size, float longitude, double latitude,
                   boolean hasPort, char countryFirstLatter, String countryName, LocalDate nationalDay) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
        this.size = size;
        this.longitude = longitude;
        this.latitude = latitude;
        this.hasPort = hasPort;
        this.countryFirstLatter = countryFirstLatter;
        this.countryName = countryName;
        this.nationalDay = nationalDay;
    }

   public void printLocation() {
       System.out.println("Geo Location is :: " + this.longitude + ", " + this.latitude);
   }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryCode == country.countryCode &&
                phoneNumber == country.phoneNumber &&
                size == country.size &&
                Float.compare(country.longitude, longitude) == 0 &&
                Double.compare(country.latitude, latitude) == 0 &&
                hasPort == country.hasPort &&
                countryFirstLatter == country.countryFirstLatter &&
                countryName.equals(country.countryName) &&
                nationalDay.equals(country.nationalDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, phoneNumber, size, longitude, latitude, hasPort, countryFirstLatter, countryName, nationalDay);
    }

    // ToString
    @Override
    public String toString() {
        return "Country{" +
                "countryCode=" + countryCode +
                ", phoneNumber=" + phoneNumber +
                ", size=" + size +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", hasPort=" + hasPort +
                ", countryFirstLatter=" + countryFirstLatter +
                ", countryName='" + countryName + '\'' +
                ", nationalDay=" + nationalDay +
                '}';
    }
}
