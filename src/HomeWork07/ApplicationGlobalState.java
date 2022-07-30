package HomeWork07;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    //private final String API_KEY = "0d1tNZJPfzzT3qGokM18FGGxAUpt7hpj"; // не мой ключ
    //private final String API_KEY = "K8PXJngX9BrnzAFNnZs8An1CRtcfN2Qs"; // мой ключ
    private final String API_KEY = "WUCUZqrFccKV6SrwF9CfG4WzWwkjJWrv"; // мой ключ 2


    private ApplicationGlobalState() {
    }

    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}
