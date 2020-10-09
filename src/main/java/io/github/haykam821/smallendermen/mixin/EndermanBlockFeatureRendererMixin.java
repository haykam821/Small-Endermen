package io.github.haykam821.smallendermen.mixin;

import io.github.haykam821.smallendermen.entity.SmallEndermanEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.EndermanBlockFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EndermanBlockFeatureRenderer.class)
public class EndermanBlockFeatureRendererMixin {
	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;translate(DDD)V", ordinal = 0))
	private void offsetBlockLess(MatrixStack matrices, double x, double y, double z, MatrixStack matrices2, VertexConsumerProvider vertexConsumers, int light, EndermanEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
		if (entity instanceof SmallEndermanEntity) {
			matrices.translate(x, 0.5, -0.4);
		} else {
			matrices.translate(x, y, z);
		}
	}
}
