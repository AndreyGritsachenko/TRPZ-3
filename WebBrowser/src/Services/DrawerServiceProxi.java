package Services;

public class DrawerServiceProxi implements IDawerService {

    private String url;
    private String response;
    private DrawerService drawerService;

    public DrawerServiceProxi(String url){
        this.url = url;
        getServerResponse();
    }

    private void getServerResponse(){
        //response = response from server
        System.out.println("Response is got from " + url);
    }
    @Override
    public void drowpage() {
        if(drawerService == null) {
            if(response=="200") {
                drawerService = new DrawerService(url);
            }
            else{
                drawerService = new DrawerService("../src/" + response);
            }
        }
        drawerService.drowpage();
    }
}
