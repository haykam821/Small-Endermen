package io.github.haykam821.smallendermen.entity.render;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;

public class SmallEndermanEntityModel<T extends LivingEntity> extends EndermanEntityModel<T> {
	public SmallEndermanEntityModel(ModelPart modelPart) {
		super(modelPart);
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
		this.hat.copyTransform(this.head);

		this.applyAngryPivot();

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

	protected void applyAngryPivot() {
		if (this.angry) {
			this.head.pivotY -= 5;
		}
	}

	public void transformBlockMatrices(MatrixStack matrices, double x) {
		matrices.translate(x, 0.5, -0.4);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0);
		ModelPartData modelPartData = modelData.getRoot();

		modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(0, 16).cuboid(-4, -7, -4, 8, 8, 8, new Dilation(-0.5f)), ModelTransform.NONE);
		modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4, -7, -4, 8, 8, 8), ModelTransform.NONE);
		modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(32, 16).cuboid(-4, 0, -2, 8, 12, 4), ModelTransform.NONE);
		modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(56, 0).cuboid(-1, -2, -1, 2, 12, 2), ModelTransform.pivot(-5, 2, 0));
		modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1, -2, -1, 2, 12, 2), ModelTransform.pivot(5, 2, 0));
		modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(56, 0).cuboid(-1, -3, -1, 2, 16, 2), ModelTransform.pivot(-2, 12, 0));
		modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1, -3, -1, 2, 16, 2), ModelTransform.pivot(2, 12, 0));

		return TexturedModelData.of(modelData, 64, 32);
	}
}