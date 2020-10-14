package io.github.haykam821.smallendermen.entity.render;

import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.LivingEntity;

public class TinyEndermanEntityModel<T extends LivingEntity> extends SmallEndermanEntityModel<T> {
	public TinyEndermanEntityModel() {
		super();

		this.head = new ModelPart(this, 0, 0);
		this.head.addCuboid(-4, -7, -4, 8, 8, 8);
		this.head.setPivot(0, 7, 0);

		this.helmet = new ModelPart(this, 0, 16);
		this.helmet.addCuboid(-4, -7, -4, 8, 8, 8, -0.5f);
		this.helmet.setPivot(0, 7, 0);

		this.torso = new ModelPart(this, 32, 16);
		this.torso.addCuboid(-4, 7, -2, 8, 8, 4);
		this.torso.setPivot(0, 0, 0);

		this.rightArm = new ModelPart(this, 56, 0);
		this.rightArm.addCuboid(-1, 0, -1, 2, 8, 2, 0);
		this.rightArm.setPivot(-5, 8, 0);

		this.leftArm = new ModelPart(this, 56, 0);
		this.leftArm.mirror = true;
		this.leftArm.addCuboid(-1, 0, -1, 2, 8, 2, 0);
		this.leftArm.setPivot(5, 8, 0);

		this.rightLeg = new ModelPart(this, 56, 0);
		this.rightLeg.addCuboid(-1, 0, -1, 2, 13, 2, 0);
		this.rightLeg.setPivot(-2, 12, 0);

		this.leftLeg = new ModelPart(this, 56, 0);
		this.leftLeg.mirror = true;
		this.leftLeg.addCuboid(-1, 0, -1, 2, 13, 2, 0);
		this.leftLeg.setPivot(2, 12, 0);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		super.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);

		this.head.pivotY = 8;
		this.helmet.pivotY = 8;
	}
}