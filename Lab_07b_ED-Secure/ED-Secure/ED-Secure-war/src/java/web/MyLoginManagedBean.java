/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author elau
 */
@Named(value = "myLoginManagedBean")
@SessionScoped
public class MyLoginManagedBean implements Serializable {

    private static final String LOGOUT = "logout";

    /**
     * Creates a new instance of MyLoginManagedBean
     */
    public MyLoginManagedBean() {
        System.out.println("Inside MyLoginManagedBean");

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();

        System.out.println("USERNAME: " + externalContext.getRemoteUser());
        System.out.println("USER IN ROLE: " + externalContext.isUserInRole("ED-APP-ADMIN"));
    }

    public String logoutResult() {

        System.out.println("Inside logoutResult");
        // terminate the session by invalidating the session context
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
        try {
            System.out.println("TRYING TO CHECK USER ROLL");
            request.logout();
            if (request.isUserInRole("ED-APP-ADMIN")) {
                System.out.println("Yes, user is in ED-APP-ADMIN role");
            }
        } catch (Exception ex) {
            // do nothing
            System.out.println("log out ...");
        }
        // terminate the session by invalidating the session context
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        session.invalidate();
        // terminate the user's login credentials
        return LOGOUT;
    }

}
