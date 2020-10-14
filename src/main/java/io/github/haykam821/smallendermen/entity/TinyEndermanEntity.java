package io.github.haykam821.smallendermen.entity;

import net.minecraft.client.util.math.MatrixStack;
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

	@Override
	public void transformBlockMatrices(MatrixStack matrices, double x) {
		matrices.scale(0.8f, 0.8f, 0.8f);
		matrices.translate(x, 1, -0.3);
	}
}