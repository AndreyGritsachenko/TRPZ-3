package Services;

public class JSDrawerFactory implements IDrawerFactory {
    @Override
    public DrawerFile createDrawFile(DataFileHolder holder) {
        return new DrawerJSFile(holder);
    }
}
