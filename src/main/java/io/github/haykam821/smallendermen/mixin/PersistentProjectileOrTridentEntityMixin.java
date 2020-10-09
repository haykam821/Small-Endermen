package io.github.haykam821.smallendermen.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.smallendermen.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.TridentEntity;

@Mixin(value = { PersistentProjectileEntity.class, TridentEntity.class })
public class PersistentProjectileOrTridentEntityMixin {
	@Redirect(method = "onEntityHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getType()Lnet/minecraft/entity/EntityType;", ordinal = 0))
	private EntityType<?> getSmallEndermanProjectileCheckType(Entity entity) {
		EntityType<?> type = entity.getType();
		return type == Main.SMALL_ENDERMAN ? EntityType.ENDERMAN : type;
	}
}