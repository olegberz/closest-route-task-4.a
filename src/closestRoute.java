import java.util.ArrayList;
import java.util.List;

public class closestRoute {

    static class City {
        String name;
        double lat;
        double lon;

        public City(String name, double lat, double lon) {
            this.name = name;
            this.lat = lat;
            this.lon = lon;
        }
    }

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Rīgas valstspilsētas pašvaldība", 56.94792874948638, 24.10642326890632));
        cities.add(new City("Aizkraukles novada pašvaldība", 56.60129434191606, 25.254100243074358));
        cities.add(new City("Alūksnes novada pašvaldība", 57.42000214123515, 27.050758455445063));
        cities.add(new City("Augšdaugavas novada pašvaldība", 55.86867076993549, 26.50986784185744));
        cities.add(new City("Ādažu novada pašvaldība", 57.08008515419249, 24.3321701525453));
        cities.add(new City("Balvu novada pašvaldība", 57.13171582665282, 27.268294740081547));
        cities.add(new City("Bauskas novada pašvaldība", 56.4059637905692, 24.18594626887255));
        cities.add(new City("Cēsu novada pašvaldība", 57.3136258778577, 25.27934956892936));
        cities.add(new City("Daugavpils valstspilsētas pašvaldība", 55.866830356067645, 26.516867368839073));
        cities.add(new City("Dienvidkurzemes novada pašvaldība", 56.53523814479826, 21.16948466702604));
        cities.add(new City("Dobeles novada pašvaldība", 56.62598516365808, 23.28046074797712));
        cities.add(new City("Gulbenes novada pašvaldība", 57.182845392724644, 26.766406514957488));
        cities.add(new City("Jelgavas novada pašvaldība", 56.65129313553139, 23.722973957251426));
        cities.add(new City("Jelgavas valstspilsētas pašvaldība", 56.6517640176851, 23.72287888423327));
        cities.add(new City("Jēkabpils novada pašvaldība", 56.50246459381352, 25.872623339189175));
        cities.add(new City("Jūrmalas valstspilsētas pašvaldība", 56.97695412078394, 23.788548844984224));
        cities.add(new City("Krāslavas novada pašvaldība", 55.89676995925988, 27.16140669767732));
        cities.add(new City("Kuldīgas novada pašvaldība", 56.96758305701526, 21.97050301308941));
        cities.add(new City("Ķekavas novada pašvaldība", 56.822736325571945, 24.231096813080313));
        cities.add(new City("Liepājas valstspilsētas pašvaldība", 56.50467081845014, 21.007600939704695));
        cities.add(new City("Limbažu novada pašvaldība", 57.511073474106205, 24.713456765232646));
        cities.add(new City("Līvānu novada pašvaldība", 56.35389269559502, 26.175409940032942));
        cities.add(new City("Ludzas novada pašvaldība", 56.54396558385414, 27.721702455390183));
        cities.add(new City("Madonas novada pašvaldība", 56.85473932873357, 26.22128772657326));
        cities.add(new City("Mārupes novada pašvaldība", 56.94436084269075, 23.909208700267087));
        cities.add(new City("Ogres novada pašvaldība", 56.82025826139168, 24.607689659116584));
        cities.add(new City("Olaines novada pašvaldība", 56.78382667320299, 23.936367684241592));
        cities.add(new City("Preiļu novada pašvaldība", 56.29008437866088, 26.727769013047148));
        cities.add(new City("Rēzeknes novada pašvaldība", 56.50759248505463, 27.33036637073344));
        cities.add(new City("Rēzeknes valstspilsētas pašvaldība", 56.50712520467888, 27.329744484224253));
        cities.add(new City("Ropažu novada pašvaldība", 56.98297349746597, 24.636640041660456));
        cities.add(new City("Salaspils novada pašvaldība", 56.85854414583987, 24.34897892420992));
        cities.add(new City("Saldus novada pašvaldība", 56.665768620389755, 22.49415660514332));
        cities.add(new City("Saulkrastu novada pašvaldība", 57.26389240691734, 24.41654309354435));
        cities.add(new City("Siguldas novada pašvaldība", 57.16539995541637, 24.851412455429077));
        cities.add(new City("Smiltenes novada pašvaldība", 57.42458906561736, 25.90675120409982));
        cities.add(new City("Talsu novada pašvaldība", 57.24710637249912, 22.5872081112524));
        cities.add(new City("Tukuma novada pašvaldība", 56.967571273746735, 23.152374258871216));
        cities.add(new City("Valkas novada pašvaldība", 57.77289965298913, 26.015696182449073));
        cities.add(new City("Valmieras novada pašvaldība", 57.53963783179519, 25.42681535670512));
        cities.add(new City("Ventspils novada pašvaldība", 57.40416599639414, 21.855934213502874));
        cities.add(new City("Ventspils valstspilsētas pašvaldība", 57.39285746732807, 21.551446969579725));

        findRoute(cities);
    }

    public static void findRoute(List<City> cities) {
        if (cities.isEmpty()) {
            return;
        }

        List<City> unvisited = new ArrayList<>(cities);
        List<City> path = new ArrayList<>();

        City current = unvisited.remove(0);
        path.add(current);
        City startCity = current;
        double totalDistance = 0;

        while (!unvisited.isEmpty()) {
            int closestIndex = 0;
            double minDist = Double.MAX_VALUE;

            for (int i = 0; i < unvisited.size(); i++) {
                double dist = calculateDistance(current, unvisited.get(i));
                if (dist < minDist) {
                    minDist = dist;
                    closestIndex = i;
                }
            }

            totalDistance += minDist;
            current = unvisited.remove(closestIndex);
            path.add(current);
        }

        totalDistance += calculateDistance(current, startCity);
        path.add(startCity);

        System.out.println("Aptuveni īsākā maršruta garums: " + Math.round(totalDistance) + " km");
        System.out.println("Pašvaldību saraksts:");
        for (int i = 0; i < path.size(); i++) {
            System.out.println((i + 1) + ". " + path.get(i).name);
        }
    }

    public static double calculateDistance(City c1, City c2) {
        final int R = 6371;
        double latDistance = Math.toRadians(c2.lat - c1.lat);
        double lonDistance = Math.toRadians(c2.lon - c1.lon);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(c1.lat)) * Math.cos(Math.toRadians(c2.lat))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}

