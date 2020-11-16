package io.github.haykam821.smallendermen.item;

import io.github.haykam821.smallendermen.Main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public enum ModItems {
	SMALL_ENDER_PEARL("small_ender_pearl", new CustomEnderPearlItem(10, 0.4f, 1, new Item.Settings().maxCount(32).group(ItemGroup.MISC))),
	TINY_ENDER_PEARL("tiny_ender_pearl", new CustomEnderPearlItem(5, 0.8f, 0.5f, new Item.Settings().group(ItemGroup.MISC))),
	SMALL_ENDERMAN_SPAWN_EGG("small_enderman_spawn_egg", new SpawnEggItem(Main.SMALL_ENDERMAN, 0x2C2C2C, 0x1D1D1D, new Item.Settings().group(ItemGroup.MISC))),
	TINY_ENDERMAN_SPAWN_EGG("tiny_enderman_spawn_egg", new SpawnEggItem(Main.TINY_ENDERMAN, 0x3C3C3C, 0x2C2C2C, new Item.Settings().group(ItemGroup.MISC)));

	private final Identifier id;
	private final Item item;

	private ModItems(String path, Item item) {
		this.id = new Identifier(Main.MOD_ID, path);
		this.item = item;
	}

	public Item getItem() {
		return this.item;
	}

	public static void register() {
		for (ModItems modItem : ModItems.values()) {
			Registry.register(Registry.ITEM, modItem.id, modItem.getItem());
		}
	}
}
