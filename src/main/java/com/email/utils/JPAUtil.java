package com.email.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 *
 * @author Manasses
 */
public class JPAUtil {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("com.email_Email_war_1.0-SNAPSHOTPU");
        }
        return emf.createEntityManager();
    }
}
