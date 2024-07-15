package io.github.haykam821.smallendermen.entity;

import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.world.World;

public class TinyEndermanEntity extends SmallEndermanEntity {
	public TinyEndermanEntity(EntityType<? extends EndermanEntity> type, World world) {
		super(type, world);
	}

	@Override
	public float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
		return 1.22f;
	}
}