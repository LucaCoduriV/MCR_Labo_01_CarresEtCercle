package utility;

public class Singleton {
    private static Singleton instance;
    // constructeur par défaut, visibilité package
    public static Singleton getInstance()
    {
        if (instance == null)
            throw new RuntimeException("No registered singleton");
        return instance;
    }
    public static <T extends Singleton> void register(Class<T> c)
            throws Exception
    {
        if (Singleton.instance != null)
            throw new RuntimeException("Singleton alredy registered");
        Singleton.instance = c.getConstructor().newInstance();
    }
}
