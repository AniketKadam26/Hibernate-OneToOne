package Demo;

import Domain.Citizen;
import Domain.Passport;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class DisplayCitizenAlldetails {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the Citizen Id");
//        int id=sc.nextInt();

        Configuration cfg;
        SessionFactory factory;
        Session ses;

        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Passport.class);
        cfg=cfg.addAnnotatedClass(Citizen.class);
        factory= cfg.buildSessionFactory();
        ses=factory.openSession();
//display bothh tables.
        Criteria crt1=ses.createCriteria(Citizen.class);
        List<Citizen> productList=crt1.list();
        for (Citizen c:productList) {
            System.out.println(c);
        }
    }
}
