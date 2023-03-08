package Demo;

import Domain.Citizen;
import Domain.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class SaveDetails {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the passport Number");
        String passNo=sc.next();
        System.out.println("Enter the Country Name");
        String country=sc.next();
        System.out.println("Enter the Citizen Name");
        String  name=sc.next();
        System.out.println("Enter the Citizen Age");
        int age=sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();

        //Create object of Passport
        Passport p1=new Passport();
        p1.setPassportNo(passNo);
        p1.setCountryName(country);

        //create object of Citizen
        Citizen c1=new Citizen();
        c1.setCitizeName(name);
        c1.setCitizenAge(age);

        //asign passport details to citizen object
        c1.setPassportRef(p1);
        tx= ses.beginTransaction();
        ses.save(c1);
        tx.commit();
        System.out.println("Details Inserted Successfully.");


    }
}
