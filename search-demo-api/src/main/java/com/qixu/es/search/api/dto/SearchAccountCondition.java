package com.qixu.es.search.api.dto;


import com.qixu.es.search.api.annotation.EsSearch;
import com.qixu.es.search.api.annotation.QueryMethod;

/**
 * @author castle
 * @date 2018/7/9
 **/
public class SearchAccountCondition extends SearchCondition {
//    @EsSearch(method = QueryMethod.TERM)
//    Long accountNumber;
//    @EsSearch(method = QueryMethod.TERM)
//    Long balance;
//    @EsSearch(method = QueryMethod.TERM)
//    String firstName;
//    @EsSearch(method = QueryMethod.TERM)
//    String lastName;
//    @EsSearch(method = QueryMethod.TERM)
//    Integer age;
//    @EsSearch(method = QueryMethod.TERM)
//    String gender;
    @EsSearch(method = QueryMethod.MATCH)
    String address;
//    @EsSearch(method = QueryMethod.TERM)
//    String employer;
//    @EsSearch(method = QueryMethod.TERM)
//    String email;
//    @EsSearch(method = QueryMethod.TERM)
//    String city;
//    @EsSearch(method = QueryMethod.TERM)
//    String state;

//    public Long getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(Long accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public Long getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Long balance) {
//        this.balance = balance;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public String getEmployer() {
//        return employer;
//    }
//
//    public void setEmployer(String employer) {
//        this.employer = employer;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }

    @Override
    public String toString() {
        return "SearchAccountCondition{" +
               /* "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +*/
                ", address='" + address + '\'' +
                /*", employer='" + employer + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +*/
                '}';
    }
}
