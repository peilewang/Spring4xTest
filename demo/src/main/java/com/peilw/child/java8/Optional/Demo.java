package com.peilw.child.java8.Optional;

import org.apache.catalina.LifecycleState;
import org.apache.el.stream.Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        //Optional<Person> person =Optional.empty();
        Person person = null;
        List<Person> list=new ArrayList<>();
        Optional<List<Person>> person2 = Optional.ofNullable(list);
        person2.get().stream().filter(p->p.getCar()!=null).collect(Collectors.toList());
        System.out.println(">>>>>>>>>"+person2.get());
        Optional<Person> person1 = Optional.ofNullable(person);
        System.out.println(Demo.getCarInsuranceName(person1));
       // Optional<Insurance> optInsurance = ...;
        optInsurance.filter(a ->
                "CambridgeInsurance".equals(a.getName()))
                .ifPresent(x -> System.out.println("ok"));
    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName).orElse("Unknown");
    }

   /* public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }*/

    public Insurance findCheapestInsurance(Person person, Car car) {
        return new Insurance();
    }
    public Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }
    /*public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }*/
}
