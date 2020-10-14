package io.github.haykam821.smallendermen.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.haykam821.smallendermen.Main;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
	@Inject(method = "addMonsters", at = @At("TAIL"))
	private static void addSmallEndermen(SpawnSettings.Builder builder, int zombieWeight, int zombieVillagerWeight, int skeletonWeight, CallbackInfo ci) {
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(Main.SMALL_ENDERMAN, 2, 1, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(Main.TINY_ENDERMAN, 1, 1, 1));
	}

	@Inject(method = "addEndMobs", at = @At("TAIL"))
	private static void addEndSmallEndermen(SpawnSettings.Builder builder, CallbackInfo ci) {
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(Main.SMALL_ENDERMAN, 2, 4, 4));
		builder.spawn(SpawnGroup.MONSTER, new SpawnSettings.SpawnEntry(Main.TINY_ENDERMAN, 1, 1, 1));
	}
}