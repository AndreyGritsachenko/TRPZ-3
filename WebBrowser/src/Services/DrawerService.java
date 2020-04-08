package Services;

public class DrawerService implements IDawerService {

    private String url;

    public DrawerService(String url){
        this.url = url;
        load();
    }

    private void load(){
        //load data for viewing page
        System.out.println("Loaded from" + url);
    }

    @Override
    public void drowpage() {
        //drowing page useing specia class
        System.out.println("page is draw");
    }
}
