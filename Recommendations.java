package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recommendations {

    public static class Sunscreen {
        String name;
        String link;
        double price;
        String type; // "chemical" or "mineral"
        String description; // "no white cast", "with white cast", "tinted"

        public Sunscreen(String name, String link, double price, String type, String description) {
            this.name = name;
            this.link = link;
            this.price = price;
            this.type = type;
            this.description = description;
        }

        @Override
        public String toString() {
            return String.format("%s (%s) - $%.2f\n%s\n%s\n", name, type, price, description, link);
        }
    }

    private static final List<Sunscreen> SUNSCREENS = new ArrayList<>();

    static {
        // Add sunscreens here
        SUNSCREENS.add(new Sunscreen(
                "Innisfree Daily UV Defense Invisible Broad Spectrum SPF 36 Sunscreen",
                "https://www.sephora.com/product/innisfree-daily-uv-defense-sunscreen-spf-36-P456392?skuId=2338325&icid2=products%20grid:p456392:product",
                29.00,
                "mineral",
                "no white cast"));
        SUNSCREENS.add(new Sunscreen(
                "Supergoop Unseen Suncreen SPF 40",
                "https://www.sephora.com/product/supergoop-unseen-sunscreen-spf-40-P454380?skuId=2315935&icid2=products%20grid:p454380:product",
                48.00,
                "chemical",
                "clear, no white cast"));
        SUNSCREENS.add(new Sunscreen(
                "Supergoop Unseen Suncreen SPF 40 with Hyaluronic Acid + Niacinamide",
                "https://www.sephora.com/product/supergoop-glowscreen-sunscreen-spf-40-P456218?skuId=2535656&icid2=products%20grid:p456218:product",
                48.00,
                "chemical",
                "clear, no white cast"));
        SUNSCREENS.add(new Sunscreen(
                "Shiseido Clear Sunscreen Stick SPF 50",
                "https://www.sephora.com/product/wetforce-clear-stick-uv-protector-broad-spectrum-50-P429242?skuId=2435261&icid2=products%20grid:p429242:product",
                30.00,
                "chemical",
                "clear, no white cast"));
        SUNSCREENS.add(new Sunscreen(
                "DR. Jart Everyday Sun Day Mineral Face Sunscreen SPF 50",
                "https://www.sephora.com/product/dr-jart-every-sun-day-mineral-sunscreen-spf-50-P457521?skuId=2344547&icid2=products%20grid:p457521:product",
                40.00,
                "mineral",
                "no white cast"));
        SUNSCREENS.add(new Sunscreen(
                "CeraVe 100% Mineral Sunscreen Stick for Face and Body SPF 50",
                "https://www.target.com/p/cerave-100-mineral-sunscreen-stick-for-face-and-body-spf-50-0-47oz/-/A-80173091#lnk=sametab",
                8.99,
                "mineral",
                "white cast"));
        SUNSCREENS.add(new Sunscreen(
                "CeraVe Hydrating 100% Mineral Sunscreen  for Face and Body SPF 50",
                "https://www.target.com/p/cerave-hydrating-100-mineral-sunscreen-for-face-spf-50-2-5-fl-oz/-/A-75563548#lnk=sametab",
                13.99,
                "mineral",
                "white cast"));
        SUNSCREENS.add(new Sunscreen(
                "Eucerin Face Oil control Sunscreen Lotion SPF 50",
                "https://www.target.com/p/eucerin-face-oil-control-sunscreen-lotion-spf-50-2-5-fl-oz/-/A-83695787#lnk=sametab",
                14.49,
                "chemical",
                "clear, no white cast"));
        SUNSCREENS.add(new Sunscreen(
                "CeraVe Hydrating Mineral Tinted Face Sunscreen Lotion SPF 30",
                "https://www.target.com/p/cerave-hydrating-mineral-tinted-face-sunscreen-lotion-spf-30-1-7-fl-oz/-/A-80173090#lnk=sametab",
                13.99,
                "mineral",
                "tinted"));
        SUNSCREENS.add(new Sunscreen(
                "La Roche Posay Antehlios Tinted Face Sunscreen SPF 50",
                " https://www.target.com/p/la-roche-posay-anthelios-tinted-face-sunscreen-spf-50-ultra-light-fluid-mineral-face-sunscreen-with-titanium-dioxide-spf-50-1-7-fl-oz/-/A-14225598#lnk=sametab ",
                37.99,
                "mineral",
                "tinted"));
        SUNSCREENS.add(new Sunscreen(
                "Beauty of Joseon Relief Sun SPF 50",
                "https://www.yesstyle.com/en/beauty-of-joseon-relief-sun-50ml/info.html/pid.1107744417",
                18.00,
                "chemical",
                "clear, no white cast"));
    }

    public static String getSunscreenRecommendations() {
        List<Sunscreen> recommendations = new ArrayList<>(SUNSCREENS);

        Collections.sort(recommendations, (a, b) -> {
            String aFirstName = a.name.split(" ")[0];
            String bFirstName = b.name.split(" ")[0];
            return aFirstName.compareToIgnoreCase(bFirstName);
        });

        StringBuilder result = new StringBuilder();
        result.append("Recommended sunscreens:\n");
        for (Sunscreen sunscreen : recommendations) {
            result.append(sunscreen.toString());
        }

        return result.toString();
    }
}
