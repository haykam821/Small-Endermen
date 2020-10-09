package io.github.haykam821.smallendermen;

import io.github.haykam821.smallendermen.entity.SmallEndermanEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
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

	private static final Identifier SMALL_ENDERMAN_ID = new Identifier(MOD_ID, "small_enderman");
	public static final EntityType<SmallEndermanEntity> SMALL_ENDERMAN = FabricEntityTypeBuilder.<SmallEndermanEntity>createMob()
		.entityFactory(SmallEndermanEntity::new)
		.spawnGroup(SpawnGroup.MONSTER)
		.spawnRestriction(SpawnRestriction.Location.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark)
		.dimensions(EntityDimensions.fixed(0.6f, 1.8f))
		.trackRangeChunks(8)
		.build();

	private static final Identifier SMALL_ENDERMAN_SPAWN_EGG_ID = new Identifier(MOD_ID, "small_enderman_spawn_egg");
	public static final Item SMALL_ENDERMAN_SPAWN_EGG = new SpawnEggItem(SMALL_ENDERMAN, 0x2C2C2C, 0x1D1D1D, new Item.Settings().group(ItemGroup.MISC));

	@Override
	public void onInitialize() {
		Registry.register(Registry.ENTITY_TYPE, SMALL_ENDERMAN_ID, SMALL_ENDERMAN);
		FabricDefaultAttributeRegistry.register(SMALL_ENDERMAN, EndermanEntity.createEndermanAttributes());

		Registry.register(Registry.ITEM, SMALL_ENDERMAN_SPAWN_EGG_ID, SMALL_ENDERMAN_SPAWN_EGG);
	}
}