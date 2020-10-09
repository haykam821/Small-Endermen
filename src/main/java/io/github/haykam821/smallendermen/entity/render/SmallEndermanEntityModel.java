package io.github.haykam821.smallendermen.entity.render;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

public class SmallEndermanEntityModel<T extends LivingEntity> extends EndermanEntityModel<T> {
	public SmallEndermanEntityModel() {
		super(0);

		this.head = new ModelPart(this, 0, 0);
		this.head.addCuboid(-4, -7, -4, 8, 8, 8);
		this.head.setPivot(0, 0, 0);

		this.helmet = new ModelPart(this, 0, 16);
		this.helmet.addCuboid(-4, -7, -4, 8, 8, 8, -0.5f);
		this.helmet.setPivot(0, 0, 0);

		this.torso = new ModelPart(this, 32, 16);
		this.torso.addCuboid(-4, 0, -2, 8, 12, 4);
		this.torso.setPivot(0, 0, 0);

		this.rightArm = new ModelPart(this, 56, 0);
		this.rightArm.addCuboid(-1, -2, -1, 2, 12, 2, 0);
		this.rightArm.setPivot(-5, 2, 0);

		this.leftArm = new ModelPart(this, 56, 0);
		this.leftArm.mirror = true;
		this.leftArm.addCuboid(-1, -2, -1, 2, 12, 2, 0);
		this.leftArm.setPivot(5, 2, 0);

		this.rightLeg = new ModelPart(this, 56, 0);
		this.rightLeg.addCuboid(-1, -3, -1, 2, 16, 2, 0);
		this.rightLeg.setPivot(-2, 12, 0);

		this.leftLeg = new ModelPart(this, 56, 0);
		this.leftLeg.mirror = true;
		this.leftLeg.addCuboid(-1, -3, -1, 2, 16, 2, 0);
		this.leftLeg.setPivot(2, 12, 0);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		// Head
		this.head.visible = true;
		this.head.pivotY = 0;

		float limbVelocity = 1;
		this.head.yaw = (float) Math.toRadians(headYaw);
		if (entity.getRoll() > 4) {
			limbVelocity = (float) entity.getVelocity().lengthSquared() / 0.2f;
			limbVelocity *= limbVelocity * limbVelocity;

			this.head.pitch = -0.7853982f;
		} else if (this.leaningPitch > 0) {
			this.head.pitch = this.lerpAngle(this.leaningPitch, this.head.pitch, (float) Math.toRadians(headPitch));
		} else {
			this.head.pitch = (float) Math.toRadians(headPitch);
		}
		this.helmet.copyPositionAndRotation(this.head);

		if (this.angry) {
			this.head.pivotY -= 5;
		}

		if (limbVelocity < 1) {
			limbVelocity = 1;
		}

		// Arms
		if (this.carryingBlock) {
			this.rightArm.pitch = -0.5f;
			this.leftArm.pitch = -0.5f;
			this.rightArm.roll = 0.05f;
			this.leftArm.roll = -0.05f;
		} else {
			this.rightArm.pitch = MathHelper.cos(limbAngle * 0.6662f + (float) Math.PI) * 2 * limbDistance * 0.5f / limbVelocity;
			this.leftArm.pitch = MathHelper.cos(limbAngle * 0.6662f) * 2f * limbDistance * 0.5f / limbVelocity;
			this.rightArm.roll = 0;
			this.leftArm.roll = 0;
		}

		// Legs
		this.rightLeg.pitch = MathHelper.cos(limbAngle * 0.6662f) * 1.4f * limbDistance / limbVelocity;
		this.leftLeg.pitch = MathHelper.cos(limbAngle * 0.6662f + (float) Math.PI) * 1.4f * limbDistance / limbVelocity;
	}
}