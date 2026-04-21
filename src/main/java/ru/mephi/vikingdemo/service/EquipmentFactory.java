
package ru.mephi.vikingdemo.service;

import java.util.List;
import ru.mephi.vikingdemo.model.EquipmentItem;
import java.util.Random;

public class EquipmentFactory {
    private static final List<String> eq_names = List.of(
            "Axe", "Sword", "Shield", "Helmet", "Spear", "Chainmail", "Hammer", "Knife"
    );
    private static final List<String> eq_qual = List.of(
            "Common", "Uncommon", "Rare", "Legendary"
    );
    private static final Random ran = new Random();

    public static EquipmentItem createItem() {
        String name = eq_names.get(ran.nextInt(eq_names.size()));
        String quality = generateQuality();
        return new EquipmentItem(name, quality);
    }


    public static EquipmentItem createItemWithName(String name) {
        String quality = generateQuality();
        return new EquipmentItem(name, quality);
    }

    private static String generateQuality() {
        int roll = ran.nextInt(100);
        if (roll < 60) return "Common";
        else if (roll < 85) return "Uncommon";
        else if (roll < 97) return "Rare";
        else return "Legendary";
    }
}