package io.github.haykam821.smallendermen.entity.render;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;

public class TinyEndermanEntityModel<T extends LivingEntity> extends SmallEndermanEntityModel<T> {
	public TinyEndermanEntityModel(ModelPart modelPart) {
		super(modelPart);
	}

	@Override
	public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		super.setAngles(entity, limbAngle, limbDistance, animationProgress, headYaw, headPitch);

		this.head.pivotY = 8;
		this.hat.pivotY = 8;

		this.applyAngryPivot();
	}

	@Override
	public void transformBlockMatrices(MatrixStack matrices, double x) {
		matrices.scale(0.8f, 0.8f, 0.8f);
		matrices.translate(x, 1, -0.3);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = BipedEntityModel.getModelData(Dilation.NONE, 0);
		ModelPartData modelPartData = modelData.getRoot();

		modelPartData.addChild(EntityModelPartNames.HAT, ModelPartBuilder.create().uv(0, 16).cuboid(-4, -7, -4, 8, 8, 8, new Dilation(-0.5f)), ModelTransform.pivot(0, 7, 0));
		modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4, -7, -4, 8, 8, 8), ModelTransform.pivot(0, 7, 0));
		modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(32, 16).cuboid(-4, 7, -2, 8, 8, 4), ModelTransform.NONE);
		modelPartData.addChild(EntityModelPartNames.RIGHT_ARM, ModelPartBuilder.create().uv(56, 0).cuboid(-1, 0, -1, 2, 8, 2), ModelTransform.pivot(-5, 8, 0));
		modelPartData.addChild(EntityModelPartNames.LEFT_ARM, ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1, 0, -1, 2, 8, 2), ModelTransform.pivot(5, 8, 0));
		modelPartData.addChild(EntityModelPartNames.RIGHT_LEG, ModelPartBuilder.create().uv(56, 0).cuboid(-1, 0, -1, 2, 13, 2), ModelTransform.pivot(-2, 12, 0));
		modelPartData.addChild(EntityModelPartNames.LEFT_LEG, ModelPartBuilder.create().uv(56, 0).mirrored().cuboid(-1, 0, -1, 2, 13, 2), ModelTransform.pivot(2, 12, 0));

		return TexturedModelData.of(modelData, 64, 32);
	}
}