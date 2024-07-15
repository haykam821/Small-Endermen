package io.github.haykam821.smallendermen.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.smallendermen.entity.render.SmallEndermanEntityModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EndermanBlockFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EndermanEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermanEntity;

@Mixin(EndermanBlockFeatureRenderer.class)
public abstract class EndermanBlockFeatureRendererMixin extends FeatureRenderer<EndermanEntity, EndermanEntityModel<EndermanEntity>> {
	public EndermanBlockFeatureRendererMixin(FeatureRendererContext<EndermanEntity, EndermanEntityModel<EndermanEntity>> context) {
		super(context);
	}

	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(DDD)V", ordinal = 0))
	private void offsetBlockLess(MatrixStack matrices, double x, double y, double z, MatrixStack matrices2, VertexConsumerProvider vertexConsumers, int light, EndermanEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		EndermanEntityModel<EndermanEntity> model = this.getContextModel();

		if (model instanceof SmallEndermanEntityModel) {
			((SmallEndermanEntityModel<EndermanEntity>) model).transformBlockMatrices(matrices, x);
		} else {
			matrices.translate(x, y, z);
		}
	}
}
