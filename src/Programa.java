/**
 * La interfaz Sujeto
 * @author MCUPO
 *
 */
interface Image 
{
    void displayImage();
}
 
/**
 * La clase SujetoReal
 * Puede tomarse como un "sistema a"
 * @author MCUPO
 *
 */
class RealImage implements Image 
{
    private String filename;
 
    public RealImage(String filename) { 
        this.filename = filename;
        loadImageFromDisk();
    }
 
    private void loadImageFromDisk() {
        System.out.println("Loading   " + filename);
    }
 
    public void displayImage() { 
        System.out.println("Displaying " + filename); 
    }
 
}
 
/**
 * La clase Proxy
 * Puede tomarse como un "sistema b"
 * @author MCUPO
 *
 */
class ProxyImage implements Image 
{
    private String filename;
    private RealImage image;
 
    public ProxyImage(String filename) { 
        this.filename = filename; 
    }
 
    public void displayImage() {
        if (image == null) {
           image = new RealImage(filename);
        } 
        image.displayImage();
    }
}
 
class Programa  
{
    public static void main(String[] args) {
        Image image1 = new ProxyImage("HiRes_10MB_Photo1");
        Image image2 = new ProxyImage("HiRes_10MB_Photo2");     
 
        image1.displayImage(); // carga necesaria
        image1.displayImage(); // carga innecesaria
        image2.displayImage(); // carga necesaria
        image2.displayImage(); // carga innecesaria
        image1.displayImage(); // carga innecesaria
    }
}

