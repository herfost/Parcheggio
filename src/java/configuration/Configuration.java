package configuration;

public final class Configuration {

    private static final String AES_KEY = "Dhn/m/YaROlLpUts0gK1CA==";
    private static final String RSA_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlFAXswNQVsJUAHR3Wj0dtSF5Ta+xBE1eVgsbScmWh2MQbCJItRT3+2oFWZFvYli22baMDanepEJDwBp4geJZ26H07saP4BVOzWurtKHbWm5Kcpg6lGA2lewD38OIjETaYmqUNEq9kyurQjbx4NuKK474UMMaZWBJUn4MZOdqLLml7FwpR0hdfVMvBiRGcB/i/vWt8PCiKNqn0rwCAow+wyib2nLxewqkZfuwpZ7zVHhKKPrdUfrJVuZ9YmAGVgyEYntI5iyTv2am8A+ZvPsbY+uyompprG0a23VIsf+fUz53wcxYRzCeu0MbsYYEChy27IwCmlwJ24H0sqRgBU6sGwIDAQAB";
    private static final String RSA_PRIVATE_KEY = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCUUBezA1BWwlQAdHdaPR21IXlNr7EETV5WCxtJyZaHYxBsIki1FPf7agVZkW9iWLbZtowNqd6kQkPAGniB4lnbofTuxo/gFU7Na6u0odtabkpymDqUYDaV7APfw4iMRNpiapQ0Sr2TK6tCNvHg24orjvhQwxplYElSfgxk52osuaXsXClHSF19Uy8GJEZwH+L+9a3w8KIo2qfSvAICjD7DKJvacvF7CqRl+7ClnvNUeEoo+t1R+slW5n1iYAZWDIRie0jmLJO/ZqbwD5m8+xtj67KiammsbRrbdUix/59TPnfBzFhHMJ67QxuxhgQKHLbsjAKaXAnbgfSypGAFTqwbAgMBAAECggEBAI13mCN4lbkrw1Rrwyyf/yY2t64SV5by9Xi9P1oynxKku5VpXlDbn26Awnmc79GvLTqdlRmzXlrvmhAzL580eOG2qhrX64SiznfCrBWwDbtEWF7WNYox+98lMMzPhf/F7UjSwGrgn9MxZDnUjwMcZb8GsHTYpOTt4wJ8mPXmhrABLNlrQ2elNa4XFKZEDa4WRyMNqCCqfbV8I9tT5gPkONXZjl8VjKOn3XZgknVMtiGX/U/uzxsg3bK9ds0tNi9pM9Eej6Yqe6izj7nSMSbGGMgQwZYSpYArNnZgXWGD/2NqeBDJcEFpvUoet+QFdESFr5WIOZfaoAOKRV5uccYcCgECgYEA4yE7JKL4+Pq7AUMm0P4P9pS4GIXwkBieWf44tyCsP7Pw4Q4T5ftWZOD+05FFt4+2MP0tcMA0R3Sr04+wLtOWcOdoEbCtk/RFs5rzwC73xX9xYniGT1IMEBY81cOqb0PQAZi2WWsOtsqczIIJY+UoqpzPu3sgvE/Z9NvnOW+q4rECgYEApyorlJW6iMvtrPQY1NbBZ7EeBWeETbCYuCTg2r1m7CW/ehdhKMAHlt6Q+dH6C/GEtRWbGyYOFptrC81ttwYZrMNnNqpZL0jv1sZkE8SyBdSVAdXOoR+JPw0z6ZYRK7STXqgx+ENbPovTUM/27ID5E5qpiq0jWsntSWLP9IGIdosCgYEAlqceIajv18YHcEjoYEuErxvqGGoPLKUHs82KNP25AvAJ4F2EGVHi9jq/C/oZ8i2ivU/Rai4y/wqGRmfShtzVtsHnJ4S3PaIS8ZTgBSOiOR/VR2mGPOrBEZKOe4OzcuXZ/JUcrqbyNZCi/ItsSxRfKvukVkjPZ9jXSzDpaBGHmaECgYEAi7BMnKyGJPwsj8Om4GzZT3oNeTyorXcuF2sRzxhI4nskx7Szxya48NTp1yklR0e6usvkQkqJqVCUolc3IKNjXyAmpuKxBjdv3E0Kog5TKVYccl0lfzToLp0szTxO+vO51na80xYOMHUNz9EJKVcZTM2Icc7+5UYqGJIO7uYzj8MCgYEAmd+caULp78XM/AmZDwwKFfDZ/ZZaoFgmMZ/SFtfcAIRpB10zontNwIyzpqUTWnG7/lFHVyr1+BsIdWsByic+4B3nXOv61ZNKtiwsTqvvbOX8yGFhpbPd35Fq4RCkVxQYXnIZDFkMvRqwoHOBF8wCZHMv9OIcfJJk1ZwcG9GLIBQ";

    private static final String REDIRECT_FROM_LOGIN_PAGE = "elenco-permessi.jsp";
    private static final String REDIRECT_FROM_NOT_ALLOWED_PAGE = "index.jsp";

    private static final String LOGO_URL = "https://avatars.githubusercontent.com/u/120043021?s=200&v=4";
    private static final String INDEX_PAGE = "index.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    private static final String LOGOUT_PAGE = "logout.jsp";
    private static final String REGISTER_PAGE = "register.jsp";
    private static final String PERMESSI_PAGE = "elenco-permessi.jsp";

    private Configuration() {
    }

    /**
     * @return the AES_KEY
     */
    public static String getAES_KEY() {
        return AES_KEY;
    }

    /**
     * @return the RSA_PRIVATE_KEY
     */
    public static String getRSA_PRIVATE_KEY() {
        return RSA_PRIVATE_KEY;
    }

    /**
     * @return the RSA_PUBLIC_KEY
     */
    public static String getRSA_PUBLIC_KEY() {
        return RSA_PUBLIC_KEY;
    }

    /**
     * @return the REDIRECT_FROM_LOGIN_PAGE
     */
    public static String getREDIRECT_FROM_LOGIN_PAGE() {
        return REDIRECT_FROM_LOGIN_PAGE;
    }

    /**
     * @return the REDIRECT_FROM_NOT_ALLOWED_PAGE
     */
    public static String getREDIRECT_FROM_NOT_ALLOWED_PAGE() {
        return REDIRECT_FROM_NOT_ALLOWED_PAGE;
    }

    /**
     * @return the LOGIN_PAGE
     */
    public static String getLOGIN_PAGE() {
        return LOGIN_PAGE;
    }

    /**
     * @return the PERMESSI_PAGE
     */
    public static String getPERMESSI_PAGE() {
        return PERMESSI_PAGE;
    }

    /**
     * @return the INDEX_PAGE
     */
    public static String getINDEX_PAGE() {
        return INDEX_PAGE;
    }

    /**
     * @return the REGISTER_PAGE
     */
    public static String getREGISTER_PAGE() {
        return REGISTER_PAGE;
    }

    /**
     * @return the LOGO_URL
     */
    public static String getLOGO_URL() {
        return LOGO_URL;
    }

    /**
     * @return the LOGOUT_PAGE
     */
    public static String getLOGOUT_PAGE() {
        return LOGOUT_PAGE;
    }

}
