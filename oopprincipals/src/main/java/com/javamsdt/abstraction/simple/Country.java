package com.javamsdt.abstraction.simple;

import java.time.LocalDate;
import java.util.Objects;

public class Country {

    // Primitive variables
    private short countryCode;
    private int phoneNumber;
    private long size;
    private float longitude;
    private double latitude;
    private boolean hasPort;
    private char countryFirstLatter;

    // Instance variable
    private String countryName;
    private LocalDate nationalDay;

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

    // Getters and Setters
    public short getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(short countryCode) {
        this.countryCode = countryCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isHasPort() {
        return hasPort;
    }

    public void setHasPort(boolean hasPort) {
        this.hasPort = hasPort;
    }

    public char getCountryFirstLatter() {
        return countryFirstLatter;
    }

    public void setCountryFirstLatter(char countryFirstLatter) {
        this.countryFirstLatter = countryFirstLatter;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public LocalDate getNationalDay() {
        return nationalDay;
    }

    public void setNationalDay(LocalDate nationalDay) {
        this.nationalDay = nationalDay;
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
