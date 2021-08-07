package com.silicateseer.beholdersarmory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BeholdersArmory implements ModInitializer {
	
	public static final String MODID = "beholdersarmory";
	
	public static final Item SILVER_INGOT = register("silver_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
	public static final Item STEEL_INGOT = register("steel_ingot", new Item(new FabricItemSettings().group(ItemGroup.MISC)));
	
	public static final Item SILVER_HELMET = register("silver_helmet", new ArmorItem(BAArmorMaterials.SILVER, EquipmentSlot.HEAD,new FabricItemSettings().group(ItemGroup.COMBAT)));
	public static final Item SILVER_CHESTPLATE = register("silver_chestplate", new ArmorItem(BAArmorMaterials.SILVER, EquipmentSlot.CHEST,new FabricItemSettings().group(ItemGroup.COMBAT)));
	public static final Item SILVER_LEGGINGS = register("silver_leggings", new ArmorItem(BAArmorMaterials.SILVER, EquipmentSlot.LEGS,new FabricItemSettings().group(ItemGroup.COMBAT)));
	public static final Item SILVER_BOOTS = register("silver_boots", new ArmorItem(BAArmorMaterials.SILVER, EquipmentSlot.FEET,new FabricItemSettings().group(ItemGroup.COMBAT)));

	public static final Item EMERALD_HELMET = register("emerald_helmet", new ArmorItem(BAArmorMaterials.EMERALD, EquipmentSlot.HEAD,new FabricItemSettings().group(ItemGroup.COMBAT)));
	public static final Item EMERALD_CHESTPLATE = register("emerald_chestplate", new ArmorItem(BAArmorMaterials.EMERALD, EquipmentSlot.CHEST,new FabricItemSettings().group(ItemGroup.COMBAT)));
	public static final Item EMERALD_LEGGINGS = register("emerald_leggings", new ArmorItem(BAArmorMaterials.EMERALD, EquipmentSlot.LEGS,new FabricItemSettings().group(ItemGroup.COMBAT)));
	public static final Item EMERALD_BOOTS = register("emerald_boots", new ArmorItem(BAArmorMaterials.EMERALD, EquipmentSlot.FEET,new FabricItemSettings().group(ItemGroup.COMBAT)));

	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//System.out.println("Hello Fabric world!");
	}
	public static Item register(String name, Item item) {
		Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
		return item;
	}
}
