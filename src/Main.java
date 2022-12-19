import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//2. Feladat
class Versenytav {
    private String rajtSzam;

    public String getTav() {
        switch (rajtSzam.charAt(0)) {
            case 'M':
                return "Mini";
            case 'R':
                return "Rövid";
            case 'K':
                return "Közép";
            case 'H':
                return "Hosszú";
            case 'E':
            default:
                return "Pedelec";
        }
    }

    public Versenytav(String rajtszam) {
        rajtSzam = rajtszam;
    }
}

// 3. Feladat
class Versenyzo {
    private String rajtszam;
    private String kategoria;
    private Versenytav versenytav;
    private String nev;
    private String egyesulet;
    private String ido;

    public String getKategoria() {
        return kategoria;
    }

    public String getRajtszam() {
        return rajtszam;
    }

    public String getNev() {
        return nev;
    }

    public String getEgyesulet() {
        return egyesulet;
    }

    public String getIdo() {
        return ido;
    }

    Versenyzo(String sor) {
        String[] darabolt = sor.split(";");
        rajtszam = darabolt[0];
        versenytav = new Versenytav(darabolt[0]);
        kategoria = darabolt[1];
        nev = darabolt[2];
        egyesulet = darabolt[3];
        ido = darabolt[4];
    }
}

class BukkMaraton2019 {
    public static void main(String[] args) {
        // 3. Feladat
        List<Versenyzo> versenyzoList = new ArrayList<>();
        File inputFile = new File("bukkm2019.txt");
        try (Scanner scanner = new Scanner(inputFile)) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String aktualisSor = scanner.nextLine();
                versenyzoList.add(new Versenyzo(aktualisSor));
            }
        } catch (FileNotFoundException exception) {
            System.err.print("Fájl nem található!");
            return;
        }
    }
}
