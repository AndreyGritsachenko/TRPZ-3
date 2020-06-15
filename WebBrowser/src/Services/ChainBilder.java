package Services;

public class ChainBilder {

    private Loader preLoad = new PreLoad(Priority.PRELOAD);
    private Loader fullLoad = new FullLoader(Priority.FULLLOAD);

    public Loader getPreLoad() {
        return preLoad;
    }

    public Loader getFullLoad() {
        return fullLoad;
    }

    public ChainBilder(){
        preLoad.setNextLoader(fullLoad);
    }

}
