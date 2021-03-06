package com.silicateseer.beholdersarmory;

import java.util.function.Supplier;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public enum BAArmorMaterials implements ArmorMaterial {
	PRISMARINE("prismarine", 10, new int[]{2, 4, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 1.0F, 0.0F, () -> {
	      return Ingredient.ofItems(Items.PRISMARINE_SHARD);
	   }),
	COPPER("copper", 8, new int[]{1, 3, 5, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
	      return Ingredient.ofItems(Items.COPPER_INGOT);
	   }),
	STEEL("steel", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
	      return Ingredient.ofItems(BeholdersArmory.STEEL_INGOT);
	   }),
	AMETHYST("amethyst", 8, new int[]{2, 5, 6, 2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
	      return Ingredient.ofItems(Items.AMETHYST_SHARD);
	   }),
	QUARTZ("quartz", 10, new int[]{2, 5, 6, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F, 0.0F, () -> {
	      return Ingredient.ofItems(Items.QUARTZ);
	   }),
	SILVER("silver", 10, new int[]{2, 4, 5, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> {
	      return Ingredient.ofItems(BeholdersArmory.SILVER_INGOT);
	   }),
	EMERALD("emerald", 20, new int[]{3, 6, 8, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
	      return Ingredient.ofItems(Items.EMERALD);
	   });

	private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
	private final String name;
	private final int durabilityMultiplier;
	private final int[] protectionAmounts;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private final Lazy<Ingredient> repairIngredientSupplier;
	   
	private BAArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
		this.name = name;
	    this.durabilityMultiplier = durabilityMultiplier;
	    this.protectionAmounts = protectionAmounts;
	    this.enchantability = enchantability;
	    this.equipSound = equipSound;
	    this.toughness = toughness;
	    this.knockbackResistance = knockbackResistance;
	    this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
	}
	
	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getEquipSound() {
		return this.equipSound;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return this.protectionAmounts[slot.getEntitySlotId()];
	}

	@Override
	public Ingredient getRepairIngredient() {
		return (Ingredient)this.repairIngredientSupplier.get();
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

}
