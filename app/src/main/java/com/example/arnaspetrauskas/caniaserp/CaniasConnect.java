/**
 * Created by arnaspetrauskas on 18/01/2017.
 */

package com.example.arnaspetrauskas.caniaserp;
import com.ias.webservice.LoginResponse;
import com.ias.webservice.connector.LoginParams;
import com.ias.webservice.connector.WebServiceConnector;
import com.ias.webservice.connector.WebServiceResponse;

public class CaniasConnect {

    WebServiceConnector iConnector;
    LoginResponse iLogin;
    WebServiceResponse iResponse;
    String iasWebService; // http://192.168......
    String iasClient;  // 00
    String iasLanguage; // E
    String iasDatabase; // TEST
    String iasBase; // CANIAS
    String iasUser; // ARNASDIGI
    String iasPassword; // Password

    public CaniasConnect(String iasPassword, String iasUser, String iasBase, String iasDatabase, String iasLanguage, String iasClient, String iasWebService) {
        this.iasPassword = iasPassword;
        this.iasUser = iasUser;
        this.iasBase = iasBase;
        this.iasDatabase = iasDatabase;
        this.iasLanguage = iasLanguage;
        this.iasClient = iasClient;
        this.iasWebService = iasWebService;
    }

    public LoginResponse login() {
   try {
       iConnector = new WebServiceConnector(iasWebService);
       LoginParams params = new LoginParams(this.iasClient, this.iasLanguage, this.iasDatabase, this.iasBase, this.iasWebService, this.iasUser, this.iasPassword, false, false, "", "");
       this.iLogin = iConnector.login(params);
   } catch(Exception e){e.getMessage();}

        return iLogin;
    }

    public WebServiceResponse callService(LoginResponse iLogin){

        if (iLogin.isSuccess()) {

        String parameters = "<PARAMETERS><PARAM>web service parameter</PARAM></PARAMETERS>";

           try {
               this.iResponse = iConnector.callService("RDTEST", parameters, false, false, "", 1);
           }catch (Exception e) {
               e.getMessage();
           }
        //System.out.println(iResponse.getStringResponse());
        }
        return iResponse;
    }


    public void logout() {
        try{
            iConnector.logOut();}
        catch (Exception e) {
            e.getMessage();
        }
        }

    public void setIasClient(String iasClient) {
        this.iasClient = iasClient;
    }

    public void setIasWebService(String iasWebService) {
        this.iasWebService = iasWebService;
    }

    public void setIasLanguage(String iasLanguage) {
        this.iasLanguage = iasLanguage;
    }

    public void setIasDatabase(String iasDatabase) {
        this.iasDatabase = iasDatabase;
    }

    public void setIasBase(String iasBase) {
        this.iasBase = iasBase;
    }

    public void setIasUser(String iasUser) {
        this.iasUser = iasUser;
    }

    public void setIasPassword(String iasPassword) {
        this.iasPassword = iasPassword;
    }

    public String getIasWebService() {
        return iasWebService;
    }

    public String getIasClient() {
        return iasClient;
    }

    public String getIasLanguage() {
        return iasLanguage;
    }

    public String getIasDatabase() {
        return iasDatabase;
    }

    public String getIasBase() {
        return iasBase;
    }

    public String getIasUser() {
        return iasUser;
    }

    public String getIasPassword() {
        return iasPassword;
    }
}
