package Demo;

import Domain.Citizen;
import Domain.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DisplayCitizenDetails {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Citizen Id");
        int id=sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        Citizen c1=ses.load(Citizen.class,id);
        String name= c1.getCitizeName();
        int age= c1.getCitizenAge();
        //get passport ref from citizen class
        Passport  ref=new Passport();
        String passNo= ref.getPassportNo();
        String country=ref.getCountryName();
        System.out.println(name+"\t"+age+"\t"+passNo+"\t"+country);
    }
}
