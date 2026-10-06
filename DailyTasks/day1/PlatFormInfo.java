public class PlatFormInfo {
    public static void main(String[] args){
        System.out.println("java ver:"+System.getProperty("java.version"));
        System.out.println("os:"+System.getProperty("os.name"));
        System.out.println("processor"+Runtime.getRuntime().availableProcessors());
        System.out.println("max space"+Runtime.getRuntime().maxMemory());
        System.out.println("free space"+Runtime.getRuntime().freeMemory());
    }

