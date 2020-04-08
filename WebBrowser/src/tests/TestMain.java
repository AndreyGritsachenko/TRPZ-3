package tests;

import Services.*;

public class TestMain {
    public static void main(String[] args) {
        IDawerService drawerService = new DrawerServiceProxi("https://something/loking/like/url.com");

        drawerService.drowpage();
    }
}
