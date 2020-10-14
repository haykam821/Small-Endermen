package io.github.haykam821.smallendermen;

import io.github.haykam821.smallendermen.entity.SmallEndermanEntity;
import io.github.haykam821.smallendermen.entity.TinyEndermanEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.EntityFactory;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;

public class Main implements ModInitializer {
	private static final String MOD_ID = "smallendermen";

	// Entities
	private static final Identifier SMALL_ENDERMAN_ID = new Identifier(MOD_ID, "small_enderman");
	public static final EntityType<SmallEndermanEntity> SMALL_ENDERMAN = createEndermanType(SmallEndermanEntity::new, 1.8f);

	private static final Identifier TINY_ENDERMAN_ID = new Identifier(MOD_ID, "tiny_enderman");
	public static final EntityType<TinyEndermanEntity> TINY_ENDERMAN = createEndermanType(TinyEndermanEntity::new, 1.4f);

	// Items
	private static final Identifier SMALL_ENDERMAN_SPAWN_EGG_ID = new Identifier(MOD_ID, "small_enderman_spawn_egg");
	public static final Item SMALL_ENDERMAN_SPAWN_EGG = new SpawnEggItem(SMALL_ENDERMAN, 0x2C2C2C, 0x1D1D1D, new Item.Settings().group(ItemGroup.MISC));

	private static final Identifier TINY_ENDERMAN_SPAWN_EGG_ID = new Identifier(MOD_ID, "tiny_enderman_spawn_egg");
	public static final Item TINY_ENDERMAN_SPAWN_EGG = new SpawnEggItem(TINY_ENDERMAN, 0x3C3C3C, 0x2C2C2C, new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		// Entities
		Registry.register(Registry.ENTITY_TYPE, SMALL_ENDERMAN_ID, SMALL_ENDERMAN);
		FabricDefaultAttributeRegistry.register(SMALL_ENDERMAN, EndermanEntity.createEndermanAttributes());

		Registry.register(Registry.ENTITY_TYPE, TINY_ENDERMAN_ID, TINY_ENDERMAN);
		FabricDefaultAttributeRegistry.register(TINY_ENDERMAN, EndermanEntity.createEndermanAttributes());

		// Items
		Registry.register(Registry.ITEM, SMALL_ENDERMAN_SPAWN_EGG_ID, SMALL_ENDERMAN_SPAWN_EGG);
		Registry.register(Registry.ITEM, TINY_ENDERMAN_SPAWN_EGG_ID, TINY_ENDERMAN_SPAWN_EGG);
	}

	private static <T extends EndermanEntity> EntityType<T> createEndermanType(EntityFactory<T> factory, float height) {
		return FabricEntityTypeBuilder.<T>createMob()
			.entityFactory(factory)
			.spawnGroup(SpawnGroup.MONSTER)
			.spawnRestriction(SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark)
			.dimensions(EntityDimensions.fixed(0.6f, height))
			.trackRangeChunks(8)
			.build();
	}
}